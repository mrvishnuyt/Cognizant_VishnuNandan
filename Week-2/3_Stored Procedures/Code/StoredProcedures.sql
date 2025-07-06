CREATE TABLE accounts (
    account_id SERIAL PRIMARY KEY,
    customer_name VARCHAR(100),
    balance NUMERIC(15,2),
    account_type VARCHAR(20)
);

CREATE TABLE employees (
    employee_id SERIAL PRIMARY KEY,
    employee_name VARCHAR(100),
    department VARCHAR(50),
    salary NUMERIC(10,2)
);

INSERT INTO accounts (customer_name, balance, account_type) VALUES
('Kushvanth', 1000.00, 'savings'),
('Vishnu', 2000.00, 'savings'),
('Yaswanth', 1500.00, 'current');

INSERT INTO employees (employee_name, department, salary) VALUES
('Hemanth', 'IT', 50000),
('Teja', 'HR', 45000),
('Harsha', 'IT', 55000);


CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest()
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'savings';
END;
$$;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(dept TEXT, bonus_percent NUMERIC)
LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE employees
    SET salary = salary + (salary * bonus_percent / 100)
    WHERE department = dept;
END;
$$;
CALL UpdateEmployeeBonus('IT', 10);

CREATE OR REPLACE PROCEDURE TransferFunds(source_id INT, target_id INT, amt NUMERIC)
LANGUAGE plpgsql
AS $$
DECLARE
    src_balance NUMERIC;
BEGIN
    SELECT balance INTO src_balance FROM accounts WHERE account_id = source_id FOR UPDATE;

    IF src_balance IS NULL THEN
        RAISE EXCEPTION 'Source account does not exist';
    ELSIF src_balance < amt THEN
        RAISE EXCEPTION 'Insufficient balance in source account';
    END IF;

    UPDATE accounts SET balance = balance - amt WHERE account_id = source_id;

    UPDATE accounts SET balance = balance + amt WHERE account_id = target_id;
END;
$$;
CALL TransferFunds(2, 1, 500.00);

SELECT * FROM accounts;