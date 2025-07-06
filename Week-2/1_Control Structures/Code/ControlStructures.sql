CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    name TEXT,
    age INT,
    balance NUMERIC(10, 2),
    isvip BOOLEAN DEFAULT FALSE
);

CREATE TABLE loans (
    id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customers(id),
    interest_rate NUMERIC(5, 2),
    due_date DATE
);

INSERT INTO customers (name, age, balance) VALUES
('Vishnu', 65, 15000.00),
('Kushvanth', 45, 8000.00),
('Yaswanth', 70, 12000.00),
('Hemanth', 30, 5000.00);

INSERT INTO loans (customer_id, interest_rate, due_date) VALUES
(1, 7.5, CURRENT_DATE + INTERVAL '10 days'),
(2, 8.0, CURRENT_DATE + INTERVAL '40 days'),
(3, 6.8, CURRENT_DATE + INTERVAL '20 days'),
(4, 7.2, CURRENT_DATE + INTERVAL '5 days');

DO $$
DECLARE
    r RECORD;
BEGIN
    FOR r IN
        SELECT l.id, l.interest_rate
        FROM loans l
        JOIN customers c ON l.customer_id = c.id
        WHERE c.age > 60
    LOOP
        UPDATE loans
        SET interest_rate = interest_rate - 1
        WHERE id = r.id;
    END LOOP;
END;
$$;

DO $$
BEGIN
    UPDATE customers
    SET isvip = TRUE
    WHERE balance > 10000;
END;
$$;

DO $$
DECLARE
    r RECORD;
BEGIN
    FOR r IN
        SELECT l.id, c.name, l.due_date
        FROM loans l
        JOIN customers c ON l.customer_id = c.id
        WHERE l.due_date <= CURRENT_DATE + INTERVAL '30 days'
    LOOP
        RAISE NOTICE 'Reminder: % has a loan due on %', r.name, r.due_date;
    END LOOP;
END;
$$;
