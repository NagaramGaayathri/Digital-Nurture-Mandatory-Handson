-- ============================================
-- SCENARIO 1: Process Monthly Interest for
-- all SAVINGS accounts (1% interest)
-- ============================================

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS

    CURSOR savings_cursor IS
        SELECT account_id, account_holder, balance
        FROM accounts
        WHERE account_type = 'SAVINGS';

    v_interest_rate   CONSTANT NUMBER := 0.01;  -- 1% interest
    v_interest_amount NUMBER;
    v_new_balance     NUMBER;
    v_accounts_processed NUMBER := 0;

BEGIN
    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('   Processing Monthly Interest (1%)      ');
    DBMS_OUTPUT.PUT_LINE('========================================');

    FOR acc_rec IN savings_cursor LOOP

        v_interest_amount := acc_rec.balance * v_interest_rate;
        v_new_balance     := acc_rec.balance + v_interest_amount;

        UPDATE accounts
        SET balance = v_new_balance
        WHERE account_id = acc_rec.account_id;

        v_accounts_processed := v_accounts_processed + 1;

        DBMS_OUTPUT.PUT_LINE('✓ ' || acc_rec.account_holder ||
                             ' (Acc: ' || acc_rec.account_id || ')' ||
                             ' | Old Balance: $' || acc_rec.balance ||
                             ' | Interest: $' || ROUND(v_interest_amount, 2) ||
                             ' | New Balance: $' || ROUND(v_new_balance, 2));

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('  Total savings accounts processed: ' ||
                         v_accounts_processed);
    DBMS_OUTPUT.PUT_LINE('========================================');

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
        ROLLBACK;
END ProcessMonthlyInterest;
/

-- ── Execute the procedure ──────────────────
SET SERVEROUTPUT ON;
BEGIN
    ProcessMonthlyInterest;
END;
/

-- Verify the changes
SELECT * FROM accounts ORDER BY account_type, account_id;