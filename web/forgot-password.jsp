<%-- 
    Document   : forgotpassword
    Created on : Sep 15, 2022, 10:26:17 AM
    Author     : Huu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/stylelogin.css"/>
    </head>
    <body>
        <div class="center">
            <h1>Forgot password</h1>
            <form action="forgot" method="POST">
                <h3 style="text-align: center">${requestScope.error}</h3>
                <div class="txt_field">
                    <input type="text" name="email" required>
                    <span></span>
                    <label>Email</label>
                </div>

                <input type="submit" value="Get password"/>
            </form>

        </div>

    </body>
</html>
