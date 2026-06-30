-- ============================================
-- SCENARIO 2: Update employee salary with bonus
-- percentage for a given department
-- ============================================

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department      IN VARCHAR2,
    p_bonus_percent    IN NUMBER
) IS

    CURSOR emp_cursor IS
        SELECT employee_id, employee_name, salary
        FROM employees
        WHERE department = p_department;

    v_bonus_amount       NUMBER;
    v_new_salary         NUMBER;
    v_employees_updated  NUMBER := 0;

BEGIN
    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('  Applying Bonus to Department: ' || p_department);
    DBMS_OUTPUT.PUT_LINE('  Bonus Percentage: ' || p_bonus_percent || '%');
    DBMS_OUTPUT.PUT_LINE('========================================');

    -- Validate input parameter
    IF p_bonus_percent < 0 OR p_bonus_percent > 100 THEN
        DBMS_OUTPUT.PUT_LINE('✗ ERROR: Bonus percentage must be between 0 and 100');
        RETURN;
    END IF;

    FOR emp_rec IN emp_cursor LOOP

        v_bonus_amount := emp_rec.salary * (p_bonus_percent / 100);
        v_new_salary   := emp_rec.salary + v_bonus_amount;

        UPDATE employees
        SET salary = v_new_salary
        WHERE employee_id = emp_rec.employee_id;

        v_employees_updated := v_employees_updated + 1;

        DBMS_OUTPUT.PUT_LINE('✓ ' || emp_rec.employee_name ||
                             ' | Old Salary: $' || emp_rec.salary ||
                             ' | Bonus: $' || ROUND(v_bonus_amount, 2) ||
                             ' | New Salary: $' || ROUND(v_new_salary, 2));

    END LOOP;

    IF v_employees_updated = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_department);
    END IF;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('  Total employees updated: ' || v_employees_updated);
    DBMS_OUTPUT.PUT_LINE('========================================');

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
        ROLLBACK;
END UpdateEmployeeBonus;
/

-- ── Execute the procedure for different departments ──
SET SERVEROUTPUT ON;

BEGIN
    UpdateEmployeeBonus('Sales', 10);
END;
/

BEGIN
    UpdateEmployeeBonus('Engineering', 15);
END;
/

BEGIN
    UpdateEmployeeBonus('Marketing', 8);
END;
/

-- Verify the changes
SELECT * FROM employees ORDER BY department, employee_id;