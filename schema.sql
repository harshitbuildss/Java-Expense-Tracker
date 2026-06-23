-- 1. Create and select the database
CREATE DATABASE IF NOT EXISTS expense_db;
USE expense_db;

-- 2. Main expenses table
CREATE TABLE IF NOT EXISTS expenses (
    id           INT AUTO_INCREMENT PRIMARY KEY,
    category     VARCHAR(100)   NOT NULL,
    amount       DOUBLE         NOT NULL,
    expense_date DATE           NOT NULL
);

-- 3. Budget config table (single-row table)
CREATE TABLE IF NOT EXISTS budget_config (
    monthly_budget DOUBLE NOT NULL DEFAULT 0
);

-- 4. Seed one row into budget_config so loadBudget() always finds a row
-- (Without this, the first run returns 0 which is fine, but TRUNCATE + INSERT
--  in saveBudget works correctly only if the table already has the row pattern)
INSERT INTO budget_config (monthly_budget) VALUES (0);

-- 5. Verify everything is in place
SHOW TABLES;
SELECT * FROM expenses;
SELECT * FROM budget_config;