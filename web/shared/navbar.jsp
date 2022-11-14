<%-- 
    Document   : navbar
    Created on : Nov 13, 2022, 8:47:07 AM
    Author     : quang
--%>

<%@page import="utils.Authentication"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Navbar -->
<nav class="fixed-top navbar navbar-expand-lg bg-light navbar-light">
    <!-- Container wrapper -->
    <div class="container-fluid">
        <!-- Navbar brand -->
        <a class="navbar-brand" href=".">
            <h1>Battle<sub class="text-danger">Ship</sub></h1>
        </a>

        <!-- Toggle button -->
        <button class="navbar-toggler" type="button" data-mdb-toggle="collapse" data-mdb-target="#bs-navbar--menu"
                aria-expanded="false" aria-label="Toggle navigation">
            <i class="fas fa-bars"></i>
        </button>

        <!-- Collapsible wrapper -->
        <div class="collapse navbar-collapse" id="bs-navbar--menu">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <!-- Link -->
                <li class="nav-item ms-4"><a class="nav-link" href=".">Home</a></li>
                <li class="nav-item ms-4 dropdown">
                    <a class="nav-link dropdown-toggle" width="40" id="bs-navbar--avatar" role="button"
                       data-mdb-toggle="dropdown" aria-expanded="false">
                        Game
                    </a>

                    <ul class="dropdown-menu" aria-labelledby="bs-navbar--avatar">
                        <li><a class="dropdown-item" href="ranking">Ranking</a></li>
                        <li><a class="dropdown-item" href="database">Database</a></li>
                    </ul>
                </li>
                <li class="nav-item ms-4"><a class="nav-link" href="download.html">Download</a></li>
                <li class="nav-item ms-4"><a class="nav-link" href="purchase">Purchase</a></li>
                <li class="nav-item ms-4"><a class="nav-link" href="report">Report</a></li>
            </ul>

            <c:choose>
                <c:when test="${player != null}">
                    <!-- Dropdown -->
                    <div class="dropdown">
                        <a class="dropdown-toggle btn btn-danger" width="40" id="bs-navbar--avatar"
                           role="button" data-mdb-toggle="dropdown" aria-expanded="false">
                            <c:out value="${player.name}"/>
                        </a>

                        <ul class="dropdown-menu" aria-labelledby="bs-navbar--avatar">
                            <li><a class="dropdown-item text-warning" href="#">$${diamond}</a></li>
                            <li>
                                <hr class="dropdown-divider" />
                            </li>
                            <li><a class="dropdown-item" href="profile">Profile</a></li>
                            <li><a class="dropdown-item" href="check-in">Check-in</a></li>
                                <c:if test="${player.role == 1}">
                                <li><a class="dropdown-item" href="admin">Admin</a></li>
                                </c:if>
                            <li>
                                <hr class="dropdown-divider" />
                            </li>
                            <li><a class="dropdown-item" href="signout">Logout</a></li>
                        </ul>
                    </div>
                </c:when>
                <c:otherwise>
                    <!-- Login/Register -->
                    <div class="btn-group">
                        <a class="btn btn-outline-danger" type="button" href="signin">Signin</a>
                        <a class="btn btn-danger" type="button" href="signup">Signup</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <!-- Container wrapper -->
</nav>
<!-- Navbar -->