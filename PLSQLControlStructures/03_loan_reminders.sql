-- ============================================
-- SCENARIO 3: Send reminders for loans due
-- within the next 30 days
-- ============================================

DECLARE
    -- Cursor fetches loans due within 30 days, joined with customer info
    CURSOR loan_due_cursor IS
        SELECT c.customer_name, l.loan_id, l.due_date,
               l.interest_rate,
               (l.due_date - SYSDATE) AS days_remaining
        FROM loans l
        JOIN customers c ON l.customer_id = c.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30
        ORDER BY l.due_date ASC;

    v_customer_name   customers.customer_name%TYPE;
    v_loan_id          loans.loan_id%TYPE;
    v_due_date         loans.due_date%TYPE;
    v_interest_rate    loans.interest_rate%TYPE;
    v_days_remaining   NUMBER;
    v_reminder_count   NUMBER := 0;

BEGIN
    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('   Loan Due Reminder Notifications        ');
    DBMS_OUTPUT.PUT_LINE('   (Loans due within next 30 days)        ');
    DBMS_OUTPUT.PUT_LINE('========================================');

    -- LOOP through all loans due within 30 days
    FOR loan_rec IN loan_due_cursor LOOP

        v_customer_name  := loan_rec.customer_name;
        v_loan_id         := loan_rec.loan_id;
        v_due_date        := loan_rec.due_date;
        v_interest_rate   := loan_rec.interest_rate;
        v_days_remaining  := ROUND(loan_rec.days_remaining);

        v_reminder_count := v_reminder_count + 1;

        -- CONTROL STRUCTURE: nested IF for urgency level
        DBMS_OUTPUT.PUT_LINE('');
        DBMS_OUTPUT.PUT_LINE('--- Reminder #' || v_reminder_count || ' ---');
        DBMS_OUTPUT.PUT_LINE('Dear ' || v_customer_name || ',');
        DBMS_OUTPUT.PUT_LINE('Your loan (ID: ' || v_loan_id ||
                             ') of interest rate ' || v_interest_rate ||
                             '% is due on ' ||
                             TO_CHAR(v_due_date, 'DD-MON-YYYY') || '.');

        IF v_days_remaining <= 7 THEN
            DBMS_OUTPUT.PUT_LINE('⚠ URGENT: Only ' || v_days_remaining ||
                                 ' day(s) remaining! Please pay immediately.');
        ELSIF v_days_remaining <= 15 THEN
            DBMS_OUTPUT.PUT_LINE('⚡ REMINDER: ' || v_days_remaining ||
                                 ' day(s) remaining. Please plan your payment.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('ℹ NOTICE: ' || v_days_remaining ||
                                 ' day(s) remaining until due date.');
        END IF;

    END LOOP;

    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('========================================');

    IF v_reminder_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No loans due within the next 30 days.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Total reminders sent: ' || v_reminder_count);
    END IF;

    DBMS_OUTPUT.PUT_LINE('========================================');

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
END;
/