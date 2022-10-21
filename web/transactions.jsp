<%-- 
    Document   : transactions
    Created on : Oct 8, 2022, 12:35:21 AM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/tw-elements/dist/css/index.min.css"
            />
        <script src="https://cdn.tailwindcss.com"></script>
        <script>
            tailwind.config = {
                theme: {
                    extend: {
                        fontFamily: {
                            roboto: ["Roboto", "sans-serif"],
                        },
                    },
                },
            };
        </script>

        <title>Transactions</title>
    </head>

    <body>
        <%@include file="components/navbar.jsp" %>

        <div class="container mt-6">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h1 style="font-size: 32px">Transactions</h1>

                            <form class="mt-3 row">
                                <div class="form-outline col-8" >
                                    <input class="form-control" name="search" type="number" value="${param.search}"/>
                                    <label class="form-label">Search by Player ID</label>
                                </div>

                                <div class="col-4">
                                    <button type="button" onclick="document.querySelector('form').submit()" class="form-control">Search</button>
                                </div>

                                <script>
                                    function onClickSubmit(target) {
                                        const i = document.querySelector('input[name="page"]');
                                        var newVal = parseInt(i.value) + (target.innerText === 'Prev' ? -1 : 1);

                                        if (newVal < 0 || newVal >= ${pageCount}) {
                                            return;
                                        }

                                        document.querySelector('input[name="page"]').value = newVal;
                                        document.querySelector('form').submit();
                                    }
                                </script>

                                <div class="mt-3">
                                    <div class="container">
                                        <div class="row">
                                            <div class="col-4">
                                                <button type="button" class="form-control" onclick="onClickSubmit(this)">Prev</button>
                                            </div>
                                            <div class="col-4">
                                                <input class="form-control" name="page" type="number" min="0" max="${pageCount - 1}" value='${param["page"] ? param["page"] : 0}' onchange="document.querySelector('form').submit()"/>
                                            </div>
                                            <div class="col-4">
                                                <button type="button" class="form-control" onclick="onClickSubmit(this)">Next</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="card-body">
                            <table class="table table-responsive table-bordered">
                                <thead>
                                    <tr >
                                        <th class="col-4">Time</th>
                                        <th class="col-4">Player ID</th>
                                        <th class="col-4">Amount</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${transactions}" var="transaction">
                                        <tr>
                                            <td>${transaction.time}</td>
                                            <td>${transaction.playerID}</td>
                                            <td>${transaction.amount} VNĐ</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- MDB -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"></script>
    </body>

</html>