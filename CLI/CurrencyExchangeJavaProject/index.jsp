<!DOCTYPE html>
<html>
<head>
    <title>Currency Exchange</title>
</head>
<body>
    <h1>Currency Exchange to BDT</h1>
    <form action="CurrencyExchangeServlet" method="POST">
        Currency Code (e.g. USD): <input type="text" name="currencyCode" required><br>
        Amount: <input type="number" name="amount" required><br>
        <input type="submit" value="Convert">
    </form>
</body>
</html>
