-- Create and select the database
CREATE DATABASE IF NOT EXISTS expense_db;
USE expense_db;

-- Main transactions table. Still named `expenses` to keep existing data intact -
-- it now holds both EXPENSE and INCOME rows, distinguished by the `type` column.
CREATE TABLE IF NOT EXISTS expenses (
    id           INT AUTO_INCREMENT PRIMARY KEY,
    category     VARCHAR(100)   NOT NULL,
    amount       DOUBLE         NOT NULL,
    expense_date DATE           NOT NULL,
    description  VARCHAR(255),
    type         VARCHAR(20)    NOT NULL DEFAULT 'EXPENSE'
);

-- If you already had this table before this upgrade, you don't need to run
-- anything manually: spring.jpa.hibernate.ddl-auto=update adds the two new
-- columns automatically on the next app startup, and MySQL backfills existing
-- rows with type='EXPENSE' via the column default. Equivalent manual SQL:
-- ALTER TABLE expenses ADD COLUMN description VARCHAR(255);
-- ALTER TABLE expenses ADD COLUMN type VARCHAR(20) NOT NULL DEFAULT 'EXPENSE';

-- Budget config table 
CREATE TABLE IF NOT EXISTS budget_config (
    monthly_budget DOUBLE NOT NULL DEFAULT 0
);

-- Seed one row into budget_config so loadBudget() always finds a row

INSERT INTO budget_config (monthly_budget) VALUES (0);


SHOW TABLES;
SELECT * FROM expenses;
SELECT * FROM budget_config;