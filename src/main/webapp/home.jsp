<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Picking Page</title>
</head>
<body>
<h1 align="center">Order Information</h1>
<div align="center">
<form action="/submit" method="post">
    <label for="productCode">Product Code:</label>
    <input type="text" id="productCode" name="productCode" required><br><br>

    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity" required><br><br>

    <label for="unitPrice">unitPrice:</label>
    <input type="number" id="unitPrice" name="unitPrice" required><br><br>

    <input type="submit" value="Submit">
</form>
</div>
<h2>Manage Order Information</h2>
<button onclick="window.location.href='/view'">View Orders</button>
<a href="/orders">Back to Home</a>
</body>
</html>
