<%-- 
    Document   : resetpassword
    Created on : Sep 15, 2022, 10:47:41 AM
    Author     : Huu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./assets/css/stylelogin.css"/>
    </head>
    <body>
        <div class="center">
            <h1>Reset password</h1>
            <form action="reset" method="POST"
                  oninput="repassword.setCustomValidity(repassword.value !== password.value ? 'Confirm password does not match': '')" >
                <div class="txt_field">
                    <input type="password" name="password" id="password" required>
                    <span></span>
                    <label>Password</label>
                </div>
                <div class="txt_field">
                    <input type="password" id="repassword" required>
                    <span></span>
                    <label>Confirm your password</label>
                </div>
                <input type="hidden" name="token" value="<%= request.getParameter("token")%>"/>
                <input type="submit" value="Change password"/>
            </form>
           
        </div>

    </body>
</html>
