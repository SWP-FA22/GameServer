<%-- 
    Document   : purchase
    Created on : Sep 30, 2022, 9:09:18 PM
    Author     : quang
--%>

<%@page import="models.ResourceModel"%>
<%@page import="entities.Player"%>
<%@page import="utilities.Authentication"%>
<%@page import="utilities.GlobalConstants"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    try {
        String token = Authentication.getTokenFromCookies(request.getCookies());
        Player player = Authentication.getPlayerInformationByToken(token);

        request.setAttribute("player", player);
        request.setAttribute("diamond", new ResourceModel().getDiamondAmount(player.getId()));
    } catch (Exception e) {
    }
%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet" />
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
        <!-- MDB -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.css" rel="stylesheet" />
        <title>Purchase Page</title>

        <style>
            html {
                scroll-behavior: smooth;
            }
        </style>
    </head>

    <body>
        <div class="d-md-block d-none">
            <div class="sticky-top d-flex justify-content-between align-items-center pe-4 ps-4 p-2">
                <a href="." class="text-black-50">Quay lại</a>

                <a href=".">
                    <img src="https://dl.dir.freefiremobile.com/common/web_event/official2/dist/client/img/garena_logo.b28b2b6.png"
                         height="50" alt="">
                </a>

                <div class="dropdown">
                    <div class="d-flex align-items-center justify-content-center" data-mdb-toggle="dropdown"
                         id="dropdownMenuButton" data-mdb-offset="0,20">
                        <div class="pe-2 d-flex flex-column align-items-end">
                            <p class="m-0">${player.name}</p>
                            <p class="m-0 p-0 text-warning">$${diamond}</p>
                        </div>


                        <img class="rounded rounded-circle"
                             src="https://i.pinimg.com/236x/c4/b4/cc/c4b4cc95595b96257a0ff25b76265171.jpg" height="50"
                             alt="">
                    </div>

                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <li><a class="dropdown-item" href="user-profile">User Profile</a></li>
                        <hr class="m-0">
                        <li><a class="dropdown-item" href="logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="d-md-none">
            <div class="sticky-top d-flex justify-content-between align-items-center pe-4 ps-4 p-2">
                <a href=".">
                    <img src="https://dl.dir.freefiremobile.com/common/web_event/official2/dist/client/img/garena_logo.b28b2b6.png"
                         height="50" alt="">
                </a>

                <div class="dropdown">
                    <div class="d-flex align-items-center justify-content-center" data-mdb-toggle="dropdown"
                         id="dropdownMenuButton" data-mdb-offset="0,20">
                        <div class="pe-2 d-flex flex-column align-items-end">
                            <img class="rounded rounded-circle"
                                 src="https://i.pinimg.com/236x/c4/b4/cc/c4b4cc95595b96257a0ff25b76265171.jpg" height="50"
                                 alt="">

                            <p class="m-0 p-0 text-warning">$${diamond}</p>
                        </div>
                    </div>

                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <li><a class="dropdown-item" href="user-profile">User Profile</a></li>
                        <hr class="m-0">
                        <li><a class="dropdown-item" href="logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <hr class="m-0">

        <div class="container p-5">
            <div class="container-fluid shadow rounded p-2 pb-5" style="max-width: 800px;">
                <h1 class="text-center text-dark mb-5">Thanh Toán</h1>
                <p class="text-black-50 small pe-3 ps-3">Bạn muốn nạp tiền vào tài khoản <a href="user?id=${player.id}"><b class="text-danger"><c:out value="${player.username}"/></b> </a>. Vui lòng quét mã QR bên dưới để thực hiện thanh toán, sẽ mất khoảng
                    <b>5 phút</b> để cập nhật kết quả thanh toán.</p>

                <div class="d-flex justify-content-center">
                    <img src="https://img.vietqr.io/image/<%= GlobalConstants.BANK_ID%>-<%= GlobalConstants.BANK_NO%>-<%= GlobalConstants.QR_TEMPLATE%>.jpg?addInfo=PID${player.id}" class="img-fluid border rounded">
                </div>
            </div>
        </div>

        <!-- MDB -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"></script>
    </body>

</html>