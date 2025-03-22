<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<script src="js/login.js" defer></script>
<link rel="stylesheet" type="text/css" href="css/styles.css">

</head>
<body>
    <%@ include file="fragments/navbar.jsp"%>
    <div class="login-container">
        <h2>Login Page</h2>
        <div class="login-switch-buttons">
            <button id="userButton" onclick="showUserLogin()">User</button>
            <button id="adminButton" onclick="showAdminLogin()">Admin</button>
        </div>

        <div id="userLogin" class="login-form">
            <h3>User Login</h3>
            <label for="userId">User Id:</label>
            <input type="text" id="userId" required>
            <label for="userPassword">Password:</label>
            <input type="password" id="userPassword" required>
            <button onclick="userLogin()">Login as User</button>
            <div id="userError" class="error-message"></div>
        </div>
        <div id="adminLogin" style="display:none;" class="login-form">
            <h3>Admin Login</h3>
            <label for="adminId">Admin Id:</label>
            <input type="text" id="adminId" required>
            <label for="adminPassword">Password:</label>
            <input type="password" id="adminPassword" required>
            <button onclick="adminLogin()">Login as Admin</button>
            <div id="adminError" class="error-message"></div>
        </div>
    </div>
    <%@ include file="fragments/footer.jsp"%>
    <script>
        <% if (session.getAttribute("errorMessage") != null) { %>
            var errorMessage = "<%= session.getAttribute("errorMessage") %>";
            var isAdmin = <%= session.getAttribute("isAdmin") %>;
            displayErrorMessage(errorMessage, isAdmin);
        <% } %>
    </script>
</body>
</html>