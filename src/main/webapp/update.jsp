<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Users</title>
</head>
<body>
<h1>Update User Page</h1>

<!-- Form to select the user -->
<form id="userForm">
    <label for="user">Select User:</label>
    <select id="user" name="userId" required>
        <option value="">--Select a User--</option>
        <c:forEach var="user" items="${users}">
            <option value="${user.id}">${user.name}</option>
        </c:forEach>
    </select>
    <br><br>
    <button type="button" onclick="loadUser()">Load User</button>
</form>

<script>
    function loadUser() {
        const userId = document.getElementById('user').value;
        if (userId) {
            window.location.href = `/getUserDetails/${userId}`;
        } else {
            alert("Please select a user.");
        }
    }
</script>


<br>

<!-- Form to update the user -->
<c:if test="${not empty selectedUser}">
    <form action="/updateUser" method="POST">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${selectedUser.name}" required>
        <br><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" value="${selectedUser.age}" required>
        <br><br>

        <input type="hidden" name="userId" value="${selectedUser.id}"> <!-- Hidden field to hold user ID -->

        <button type="submit">Update</button>
    </form>
</c:if>

<br>
<a href="/hello">Back to Home</a>
</body>
</html>
