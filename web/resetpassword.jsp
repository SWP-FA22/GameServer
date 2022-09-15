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
    </head>
    <body>
        <form action="reset" method="POST"
              oninput="repassword.setCustomValidity(repassword.value !== password.value ? 'Confirm password does not match': '')" 
              >
            <input type="password" name="password" id="password"/>Password<br/>
            <input type="password" id="repassword"/>confirm password<br/>
            <input type="hidden" name="token" value="<%= request.getParameter("token")%>"/>
            <input type="submit" value="Change password"/>
        </form>
    </body>
</html>
