-- ============================================
-- SCENARIO 1: Apply 1% discount to loan interest
-- for customers above 60 years old
-- ============================================

DECLARE
    -- Cursor to loop through all customers
    CURSOR customer_cursor IS
        SELECT customer_id, customer_name, age
        FROM customers;

    v_customer_id     customers.customer_id%TYPE;
    v_customer_name   customers.customer_name%TYPE;
    v_age             customers.age%TYPE;
    v_rows_updated     NUMBER := 0;

BEGIN
    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('  Applying Senior Citizen Loan Discount  ');
    DBMS_OUTPUT.PUT_LINE('========================================');

    -- LOOP through all customers using the cursor
    FOR cust_rec IN customer_cursor LOOP

        v_customer_id   := cust_rec.customer_id;
        v_customer_name := cust_rec.customer_name;
        v_age           := cust_rec.age;

        -- CONTROL STRUCTURE: IF condition checks age > 60
        IF v_age > 60 THEN

            -- Apply 1% discount to ALL loans of this customer
            UPDATE loans
            SET interest_rate = interest_rate - 1.0
            WHERE customer_id = v_customer_id
              AND interest_rate > 1.0;  -- prevent negative rates

            v_rows_updated := SQL%ROWCOUNT;

            IF v_rows_updated > 0 THEN
                DBMS_OUTPUT.PUT_LINE('✓ ' || v_customer_name ||
                                     ' (Age: ' || v_age ||
                                     ') - Discount applied to ' ||
                                     v_rows_updated || ' loan(s)');
            ELSE
                DBMS_OUTPUT.PUT_LINE('- ' || v_customer_name ||
                                     ' (Age: ' || v_age ||
                                     ') - No active loans found');
            END IF;

        ELSE
            DBMS_OUTPUT.PUT_LINE('  ' || v_customer_name ||
                                 ' (Age: ' || v_age ||
                                 ') - Not eligible (under 60)');
        END IF;

    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('  Discount process completed!           ');
    DBMS_OUTPUT.PUT_LINE('========================================');

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
        ROLLBACK;
END;
/

-- Verify the changes
SELECT c.customer_name, c.age, l.loan_id, l.interest_rate
FROM customers c
JOIN loans l ON c.customer_id = l.customer_id
ORDER BY c.age DESC;