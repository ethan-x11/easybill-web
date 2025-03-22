<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Consumer Registration</title>
<script src="js/registration.js" defer></script>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <%@ include file="fragments/navbar.jsp"%>
    <div class="reg-container">
        <h2 class="reg-title">Consumer Registration</h2>
        <form action="RegistrationHandlerServlet" method="post" class="reg-form">
            <label for="consumerId" class="reg-label">Consumer Id:</label>
            <input type="text" id="consumerId" name="consumerId" class="reg-input" required>
            <label for="consumerName" class="reg-label">Consumer Name:</label>
            <input type="text" id="consumerName" name="consumerName" class="reg-input" maxlength="50" required>
            <label for="email" class="reg-label">Email:</label>
            <input type="email" id="email" name="email" class="reg-input" required>
            <label for="countryCode" class="reg-label">Country Code:</label>
            <select id="countryCode" name="countryCode" class="reg-select">
                <option value="+1">+1 (USA)</option>
                <option value="+91" selected>+91 (India)</option>
                <option value="+44">+44 (UK)</option>
                <option value="+81">+81 (Japan)</option>
                <option value="+61">+61 (Australia)</option>
            </select>
            <label for="mobileNumber" class="reg-label">Mobile Number:</label>
            <input type="text" id="mobileNumber" name="mobileNumber" class="reg-input" maxlength="10" placeholder="Enter 10-digit mobile number" required>
            <label for="userId" class="reg-label">User Id:</label>
            <input type="text" id="userId" name="userId" class="reg-input" minlength="5" maxlength="20" required>
            <label for="password" class="reg-label">Password:</label>
            <input type="password" id="password" name="password" class="reg-input" required>
            <label for="confirmPassword" class="reg-label">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" class="reg-input" required>
            <button type="submit" class="reg-button">Register</button>
        </form>
    </div>
    <%@ include file="fragments/footer.jsp"%>
</body>
</html>