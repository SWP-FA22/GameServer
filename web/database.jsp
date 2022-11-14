<%-- 
    Document   : database
    Created on : Nov 13, 2022, 5:07:29 PM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="shared/begin.jsp" %>
<style>
    #bs-database--container {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;

        background-image: url("assets/bg.webp");
        background-position: center;
    }

    #bs-database--container > div {
        background-color: #ffffffc0;
        backdrop-filter: blur(10px);
    }
</style>

<div id="bs-database--container">
    <div class="container rounded">
        <!-- Tabs navs -->
        <ul class="nav nav-tabs nav-justified mb-3" id="ex1" role="tablist">
            <li class="nav-item" role="presentation">
                <a class="nav-link active" id="ex3-tab-1" data-mdb-toggle="tab" href="#ex3-tabs-1" role="tab"
                   aria-controls="ex3-tabs-1" aria-selected="true">Ships</a>
            </li>
            <li class="nav-item" role="presentation">
                <a class="nav-link" id="ex3-tab-2" data-mdb-toggle="tab" href="#ex3-tabs-2" role="tab"
                   aria-controls="ex3-tabs-2" aria-selected="false">Items</a>
            </li>
        </ul>
        <!-- Tabs navs -->

        <!-- Tabs content -->
        <div class="tab-content" id="ex2-content">
            <div class="tab-pane fade show active" id="ex3-tabs-1" role="tabpanel" aria-labelledby="ex3-tab-1">
                <div class="container-fluid">
                    <div class="row overflow-auto" style="height: 400px;">

                        <c:forEach var="ship" items="${ships}">
                            <div class="col-4 col-lg-3 p-2">
                                <div class="card" data-mdb-toggle="modal" data-mdb-target="#bs-database--ships-${ship.id}">
                                    <div class="card-body">
                                        <p class="card-text">
                                            <c:out value="${ship.name}"/>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="ex3-tabs-2" role="tabpanel" aria-labelledby="ex3-tab-2">
                <div class="container-fluid">
                    <div class="row overflow-auto" style="height: 400px;">

                        <c:forEach var="item" items="${items}">
                            <div class="col-4 col-lg-2 p-2">
                                <div class="card" data-mdb-toggle="modal" data-mdb-target="#bs-database--items-${item.id}">
                                    <img src="${item.imageURL}"
                                         class="card-img-top p-4" height="120" style="object-fit: contain"/>
                                    <div class="card-body">
                                        <p class="card-text text-truncate">
                                            <c:out value="${item.name}"/>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>
        </div>
        <!-- Tabs content -->
    </div>
</div>

<c:forEach var="ship" items="${ships}">

    <!-- Modal -->
    <div class="modal fade" id="bs-database--ships-${ship.id}" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">
                        <c:out value="${ship.name}"/>
                    </h5>
                    <button type="button" class="btn-close" data-mdb-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p class="text-muted">
                        <c:out value="${ship.description}"/>
                    </p>

                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ATK</th>
                                <th>HP</th>
                                <th>SPEED</th>
                                <th>ROTA</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${ship.baseATK}</td>
                                <td>${ship.baseHP}</td>
                                <td>${ship.baseSpeed}</td>
                                <td>${ship.baseRota}</td>
                            </tr>
                        </tbody>
                    </table>

                    <p class="text-body">Price: <span class="text-warning">${ship.price}</span></p>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

<c:forEach var="item" items="${items}">
    <!-- Modal -->
    <div class="modal fade" id="bs-database--items-${item.id}" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title"><c:out value="${item.name}"/></h5>
                    <button type="button" class="btn-close" data-mdb-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p class="text-muted"><c:out value="${item.description}"/></p>

                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ATK</th>
                                <th>HP</th>
                                <th>SPEED</th>
                                <th>ROTA</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${item.bonusATK}</td>
                                <td>${item.bonusHP}</td>
                                <td>${item.bonusSpeed}</td>
                                <td>${item.bonusRota}</td>
                            </tr>
                        </tbody>
                    </table>

                    <p class="text-body">Price: <span class="text-warning">${item.price}</span></p>

                    <img src="${item.imageURL}" alt="" class="img-fluid img-thumbnail">
                </div>
            </div>
        </div>
    </div>
</c:forEach>
<%@include file="shared/end.jsp" %>