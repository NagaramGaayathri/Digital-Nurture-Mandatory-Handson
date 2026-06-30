-- ============================================
-- SETUP: Create Tables for Banking Exercises
-- ============================================

-- Drop tables if they already exist (for re-running)
-- Drop tables if they already exist (safe version - ignores error if not found)
BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE loans';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE customers';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/

-- Customers table
CREATE TABLE customers (
    customer_id     NUMBER PRIMARY KEY,
    customer_name   VARCHAR2(100),
    age             NUMBER,
    balance         NUMBER(12,2),
    is_vip          VARCHAR2(5) DEFAULT 'FALSE'
);

-- Loans table
CREATE TABLE loans (
    loan_id          NUMBER PRIMARY KEY,
    customer_id      NUMBER,
    interest_rate    NUMBER(5,2),
    due_date         DATE,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id)
        REFERENCES customers(customer_id)
);

-- Insert sample customers
INSERT INTO customers VALUES (1, 'Gaayathri Nagaram', 65, 15000.00, 'FALSE');
INSERT INTO customers VALUES (2, 'Ravi Kumar',        45, 8000.00,  'FALSE');
INSERT INTO customers VALUES (3, 'Priya Sharma',      72, 25000.00, 'FALSE');
INSERT INTO customers VALUES (4, 'Arjun Reddy',       38, 12000.00, 'FALSE');
INSERT INTO customers VALUES (5, 'Sneha Patel',       61, 5000.00,  'FALSE');
INSERT INTO customers VALUES (6, 'Vikram Singh',      29, 18000.00, 'FALSE');
INSERT INTO customers VALUES (7, 'Lakshmi Iyer',      68, 9500.00,  'FALSE');

-- Insert sample loans
INSERT INTO loans VALUES (101, 1, 7.50, SYSDATE + 15);  -- due in 15 days
INSERT INTO loans VALUES (102, 2, 6.00, SYSDATE + 45);  -- due in 45 days
INSERT INTO loans VALUES (103, 3, 8.25, SYSDATE + 10);  -- due in 10 days
INSERT INTO loans VALUES (104, 4, 5.75, SYSDATE + 60);  -- due in 60 days
INSERT INTO loans VALUES (105, 5, 9.00, SYSDATE + 5);   -- due in 5 days
INSERT INTO loans VALUES (106, 6, 6.50, SYSDATE + 90);  -- due in 90 days
INSERT INTO loans VALUES (107, 7, 7.00, SYSDATE + 28);  -- due in 28 days

COMMIT;

-- Verify data
SELECT * FROM customers;
SELECT * FROM loans;