<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Information Form</title>
</head>
<body>
<h1>User Information</h1>
<form action="/submit" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="age">Age:</label>
    <input type="number" id="age" name="age" required><br><br>

    <input type="submit" value="Submit">
</form>

<h2>Manage User Information</h2>
<button onclick="window.location.href='/update'">Update User</button>
<button onclick="window.location.href='/delete'">Delete User</button>
<button onclick="window.location.href='/view'">View Users</button>
<a href="/hello">Back to Home</a>
</body>
</html>
