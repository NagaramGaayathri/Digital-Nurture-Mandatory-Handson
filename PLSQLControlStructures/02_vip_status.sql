-- ============================================
-- SCENARIO 2: Set IsVIP = TRUE for customers
-- with balance over $10,000
-- ============================================

DECLARE
    CURSOR customer_cursor IS
        SELECT customer_id, customer_name, balance, is_vip
        FROM customers;

    v_customer_id    customers.customer_id%TYPE;
    v_customer_name  customers.customer_name%TYPE;
    v_balance        customers.balance%TYPE;
    v_vip_count      NUMBER := 0;
    v_total_count    NUMBER := 0;

BEGIN
    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('     VIP Status Update Process            ');
    DBMS_OUTPUT.PUT_LINE('========================================');

    -- LOOP through all customers
    FOR cust_rec IN customer_cursor LOOP

        v_customer_id   := cust_rec.customer_id;
        v_customer_name := cust_rec.customer_name;
        v_balance       := cust_rec.balance;
        v_total_count   := v_total_count + 1;

        -- CONTROL STRUCTURE: IF condition checks balance > 10000
        IF v_balance > 10000 THEN

            UPDATE customers
            SET is_vip = 'TRUE'
            WHERE customer_id = v_customer_id;

            v_vip_count := v_vip_count + 1;

            DBMS_OUTPUT.PUT_LINE('✓ ' || v_customer_name ||
                                 ' - Balance: $' || v_balance ||
                                 ' → PROMOTED TO VIP! 🌟');

        ELSE
            -- Ensure non-qualifying customers remain non-VIP
            UPDATE customers
            SET is_vip = 'FALSE'
            WHERE customer_id = v_customer_id;

            DBMS_OUTPUT.PUT_LINE('  ' || v_customer_name ||
                                 ' - Balance: $' || v_balance ||
                                 ' - Not eligible for VIP');
        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('  Total customers processed : ' || v_total_count);
    DBMS_OUTPUT.PUT_LINE('  Customers promoted to VIP  : ' || v_vip_count);
    DBMS_OUTPUT.PUT_LINE('========================================');

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
        ROLLBACK;
END;
/

-- Verify the changes
SELECT customer_name, balance, is_vip
FROM customers
ORDER BY balance DESC;