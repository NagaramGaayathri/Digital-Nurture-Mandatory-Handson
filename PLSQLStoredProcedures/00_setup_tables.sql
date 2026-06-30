-- ============================================
-- SETUP: Tables for Stored Procedures Exercise
-- ============================================

-- Drop tables safely if they exist
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE accounts';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE employees';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

-- ── Accounts table (for savings interest + fund transfer) ──
CREATE TABLE accounts (
    account_id      NUMBER PRIMARY KEY,
    account_holder  VARCHAR2(100),
    account_type    VARCHAR2(20),   -- 'SAVINGS' or 'CURRENT'
    balance         NUMBER(12,2)
);

-- ── Employees table (for bonus scheme) ──────────────
CREATE TABLE employees (
    employee_id     NUMBER PRIMARY KEY,
    employee_name   VARCHAR2(100),
    department      VARCHAR2(50),
    salary          NUMBER(12,2)
);

-- Insert sample accounts
INSERT INTO accounts VALUES (1, 'Gaayathri Nagaram', 'SAVINGS', 50000.00);
INSERT INTO accounts VALUES (2, 'Ravi Kumar',        'SAVINGS', 25000.00);
INSERT INTO accounts VALUES (3, 'Priya Sharma',      'CURRENT', 75000.00);
INSERT INTO accounts VALUES (4, 'Arjun Reddy',       'SAVINGS', 30000.00);
INSERT INTO accounts VALUES (5, 'Sneha Patel',       'CURRENT', 15000.00);

-- Insert sample employees
INSERT INTO employees VALUES (101, 'Vikram Singh',  'Sales',         45000.00);
INSERT INTO employees VALUES (102, 'Lakshmi Iyer',  'Sales',         52000.00);
INSERT INTO employees VALUES (103, 'Karthik Raj',   'Engineering',   65000.00);
INSERT INTO employees VALUES (104, 'Divya Menon',   'Engineering',   70000.00);
INSERT INTO employees VALUES (105, 'Rahul Verma',   'Marketing',     48000.00);

COMMIT;

-- Verify
SELECT * FROM accounts;
SELECT * FROM employees;