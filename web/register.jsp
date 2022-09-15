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
    <form action="register" method="POST" id="registerform"
          oninput="repassword.setCustomValidity(repassword.value !== password.value ? 'Confirm password does not match': '')" 
          >
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
      <input type="password" placeholder="Enter your password" name="password" id="password" required>
    </div>
      <div class="input-box">
      <span class="details">Confirm Password</span>
      <input type="password" placeholder="Confirm your password" id="repassword" required>
    </div>
  </div>
        <div class="g-recaptcha" id="grecaptcha" data-sitekey="<%= GlobalConstants.GOOGLE_RECAPTCHA_SITE_KEY%>" hidden data-callback="onSubmit"></div>
  <div class="button">
    <button type="button"   onclick="formSubmit()">Register</button>
  </div>
</form>
</body>
<script>
        function onSubmit() {
            document.getElementById('registerform').submit();
        }

        function formSubmit() {
            const form = document.getElementById('registerform');
            if (form.checkValidity()) {
                document.getElementById('grecaptcha').hidden=false;
                //grecaptcha.execute();
            } else {
                form.reportValidity();
            }
        }
    </script>
</html>
