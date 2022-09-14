<%--
  Created by IntelliJ IDEA.
  User: Huu
  Date: 9/13/2022
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="utilities.GlobalConstants" %>
<html>
<head>
    <title>register</title>
  <script src="https://www.google.com/recaptcha/api.js" async defer></script>
</head>
<body>
<form action="register" method="POST">
  <div class="user-details">
    <div class="input-box">
      <span class="details">Username</span>
      <input type="text" placeholder="Enter your username" name="username" required>
    </div>
    <div class="input-box">
      <span class="details">Email</span>
      <input type="text" placeholder="Enter your email" name="email" required>
    </div>
    <div class="input-box">
      <span class="details">Password</span>
      <input type="password" placeholder="Enter your password" name="pass" required>
    </div>
  </div>
  <div class="g-recaptcha" data-sitekey="<%= GlobalConstants.GOOGLE_RECAPTCHA_SITE_KEY%>"></div>
  <div class="button">
    <input type="submit" value="Register">
  </div>
</form>
</body>
</html>
