CREATE DATABASE currencydb;

USE currencydb;

CREATE TABLE exchange_rates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    currency_code VARCHAR(3) NOT NULL,
    rate_to_bdt DOUBLE NOT NULL
);

INSERT INTO exchange_rates (currency_code, rate_to_bdt) VALUES
('USD', 109.50),
('EUR', 117.80),
('GBP', 137.40),
('INR', 1.32),
('JPY', 0.75);
