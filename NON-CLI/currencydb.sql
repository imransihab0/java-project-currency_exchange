-- Create the database
CREATE DATABASE IF NOT EXISTS currencydb;
USE currencydb;

-- Create the exchange_rates table
CREATE TABLE IF NOT EXISTS exchange_rates (
    currency_code VARCHAR(10) PRIMARY KEY,
    rate_to_bdt DOUBLE NOT NULL
);

-- Insert some sample data for top 5 currencies to BDT
INSERT INTO exchange_rates (currency_code, rate_to_bdt)
VALUES
    ('USD', 108.75),    -- Example rate: 1 USD = 108.75 BDT
    ('EUR', 118.22),    -- Example rate: 1 EUR = 118.22 BDT
    ('GBP', 130.90),    -- Example rate: 1 GBP = 130.90 BDT
    ('INR', 1.48),      -- Example rate: 1 INR = 1.48 BDT
    ('JPY', 0.77);      -- Example rate: 1 JPY = 0.77 BDT

-- Verify the data
SELECT * FROM exchange_rates;
