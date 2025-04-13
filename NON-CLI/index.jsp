<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Currency Exchange Portal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
            background-color: #333;
            color: white;
            padding: 15px;
            text-align: center;
        }
        h1 {
            margin: 0;
        }
        nav {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }
        nav a {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            text-decoration: none;
            margin: 0 10px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        nav a:hover {
            background-color: #45a049;
        }
        footer {
            text-align: center;
            margin-top: 20px;
            padding: 10px;
            background-color: #333;
            color: white;
        }
    </style>
</head>
<body>

<header>
    <h1>Currency Exchange Portal</h1>
    <p>Your one-stop solution for currency conversion and management</p>
</header>

<nav>
    <a href="viewExchangeRates"> View All Exchange Rates</a>
    <a href="addCurrency"> Add New Currency</a>
    <a href="updateCurrencyRate"> Update Currency Rate</a>
    <a href="deleteCurrency"> Delete Currency</a>
    <a href="currencyExchange"> Convert Currency to BDT</a>
</nav>

<footer>
    <p>&copy; 2025 Currency Exchange Portal | All Rights Reserved</p>
</footer>

</body>
</html>
