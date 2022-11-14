<%-- 
    Document   : navbar
    Created on : Nov 13, 2022, 8:45:37 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Battle Ship</title>
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
        <!-- MDB -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.0/mdb.min.css" rel="stylesheet" />

        <style>
            html, body {
                height: 100vh;
            }
        </style>
    </head>

    <body>
        <%@include file="navbar.jsp" %>

        <div class="position-fixed w-100 pe-4 d-flex flex-column" style="top: 100px;">
            <c:set var="error" value="${param.error}"></c:set>
            <c:if test="${error != null}">
                <div>
                    <div class="alert alert-danger alert-dismissible fade show d-inline float-end" role="alert" autohide>
                        <c:out value="${error}"/>
                        <button type="button" class="btn-close" onclick="this.parentNode.remove()"></button>
                    </div>
                </div>
            </c:if>

            <c:forEach var="alert" items="${alerts}">
                <div>
                    <div class="alert alert-${alert.type} alert-dismissible fade show d-inline float-end" role="alert" autohide>
                        <c:out value="${alert.message}"/>
                        <button type="button" class="btn-close" onclick="this.parentNode.remove()"></button>
                    </div>
                </div>
            </c:forEach>
        </div>