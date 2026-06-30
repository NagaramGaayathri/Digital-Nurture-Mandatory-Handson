-- ============================================
-- SCENARIO 3: Transfer funds between accounts,
-- checking sufficient balance first
-- ============================================

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account    IN NUMBER,
    p_to_account      IN NUMBER,
    p_amount          IN NUMBER
) IS

    v_from_balance     NUMBER;
    v_from_holder      VARCHAR2(100);
    v_to_holder        VARCHAR2(100);
    v_account_exists    NUMBER;

BEGIN
    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('  Fund Transfer Request                  ');
    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('From Account : ' || p_from_account);
    DBMS_OUTPUT.PUT_LINE('To Account   : ' || p_to_account);
    DBMS_OUTPUT.PUT_LINE('Amount       : $' || p_amount);

    -- Validate amount
    IF p_amount <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('✗ FAILED: Transfer amount must be positive!');
        RETURN;
    END IF;

    -- Validate same account
    IF p_from_account = p_to_account THEN
        DBMS_OUTPUT.PUT_LINE('✗ FAILED: Cannot transfer to the same account!');
        RETURN;
    END IF;

    -- Check if destination account exists
    SELECT COUNT(*) INTO v_account_exists
    FROM accounts
    WHERE account_id = p_to_account;

    IF v_account_exists = 0 THEN
        DBMS_OUTPUT.PUT_LINE('✗ FAILED: Destination account does not exist!');
        RETURN;
    END IF;

    -- Get source account balance (with error handling for missing account)
    BEGIN
        SELECT balance, account_holder
        INTO v_from_balance, v_from_holder
        FROM accounts
        WHERE account_id = p_from_account;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('✗ FAILED: Source account does not exist!');
            RETURN;
    END;

    -- CHECK SUFFICIENT BALANCE before transferring
    IF v_from_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('✗ FAILED: Insufficient balance!');
        DBMS_OUTPUT.PUT_LINE('  Available: $' || v_from_balance ||
                             ' | Requested: $' || p_amount);
        RETURN;
    END IF;

    -- Get destination account holder name (for display)
    SELECT account_holder INTO v_to_holder
    FROM accounts WHERE account_id = p_to_account;

    -- ── Perform the transfer (debit + credit) ──
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account;

    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('✓ SUCCESS: Transfer completed!');
    DBMS_OUTPUT.PUT_LINE('  ' || v_from_holder || ' → ' || v_to_holder ||
                         ' : $' || p_amount);
    DBMS_OUTPUT.PUT_LINE('========================================');

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
        ROLLBACK;
END TransferFunds;
/

-- ── Test Cases ──────────────────────────────
SET SERVEROUTPUT ON;

-- Test 1: Valid transfer
BEGIN
    TransferFunds(1, 2, 5000);
END;
/

-- Test 2: Insufficient balance (should fail)
BEGIN
    TransferFunds(5, 1, 100000);
END;
/

-- Test 3: Same account (should fail)
BEGIN
    TransferFunds(3, 3, 1000);
END;
/

-- Test 4: Non-existent destination account (should fail)
BEGIN
    TransferFunds(1, 999, 500);
END;
/

-- Test 5: Negative amount (should fail)
BEGIN
    TransferFunds(2, 3, -500);
END;
/

-- Verify final account balances
SELECT * FROM accounts ORDER BY account_id;