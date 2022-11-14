<%-- 
    Document   : profile
    Created on : Nov 13, 2022, 3:25:36 PM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="shared/begin.jsp" %>
<section class="h-100 gradient-custom-2">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-lg-9 col-xl-7">
                <div class="card">
                    <div class="rounded-top text-white d-flex flex-row"
                         style="background-color: #000; height:200px;">
                        <div class="ms-4 mt-5 d-flex flex-column" style="width: 150px;">
                            <img src="assets/avatar.jpg"
                                 alt="Generic placeholder image" class="img-fluid img-thumbnail mt-4 mb-2"
                                 style="width: 150px; z-index: 1">
                        </div>
                        <div class="ms-3" style="margin-top: 130px;">
                            <h5 class="text-danger"><c:out value="${player.name}"/></h5>
                            <p><c:out value="${player.username}"/></p>
                        </div>
                    </div>
                    <div class="p-4 text-black" style="background-color: #f8f9fa;">
                        <div class="d-flex justify-content-end text-center py-1">
                            <div>
                                <p class="mb-1 h5">${ships.size()}</p>
                                <p class="small text-muted mb-0">Ships</p>
                            </div>
                            <div class="px-3">
                                <p class="mb-1 h5">${items.size()}</p>
                                <p class="small text-muted mb-0">Items</p>
                            </div>
                            <div>
                                <p class="mb-1 h5">${player.rank}</p>
                                <p class="small text-muted mb-0">Points</p>
                            </div>
                        </div>
                    </div>

                    <div class="card-body p-4 text-black">
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <p class="lead fw-normal mb-0">Ships</p>
                            <button class="navbar-toggler" type="button" data-mdb-toggle="collapse" data-mdb-target="#bs-profile--ships"
                                    aria-expanded="false" aria-label="Toggle navigation">
                                <i class="fas fa-bars"></i>
                            </button>
                        </div>
                        <div class="row g-2 collapse" id="bs-profile--ships">

                            <c:forEach var="ship" items="${ships}">
                                <div class="col-12 mb-2">
                                    <div class="card text-center">
                                        <h5 class="card-header">${ship.name}</h5>
                                        <div class="card-body">
                                            <p class="card-title text-black-50">${ship.description}</p>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                    </div>

                    <hr class="me-3 ms-3"/>

                    <div class="card-body p-4 text-black">
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <p class="lead fw-normal mb-0">Items</p>
                            <button class="navbar-toggler" type="button" data-mdb-toggle="collapse" data-mdb-target="#bs-profile--items"
                                    aria-expanded="false" aria-label="Toggle navigation">
                                <i class="fas fa-bars"></i>
                            </button>
                        </div>
                        <div class="row g-2 collapse" id="bs-profile--items">

                            <c:forEach var="item" items="${items}">
                                <div class="col-12 mb-2">
                                    <div class="card text-center">
                                        <h5 class="card-header">${item.name}</h5>
                                        <div class="card-body">
                                            <p class="card-title text-black-50">${item.description}</p>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                    </div>

                    <hr class="me-3 ms-3"/>

                    <div class="card-body p-4 text-black">
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <p class="lead fw-normal mb-0">Posts</p>
                        </div>
                        <div class="row g-2">

                            <c:forEach var="post" items="${posts}">
                                <div class="col-12 mb-2">
                                    <a class="card btn" href="view-post?id=${post.id}">
                                        <div class="card-header d-flex justify-content-between align-items-center">
                                            <h5>
                                                <c:out value="${post.title}"/>
                                                <c:choose>
                                                    <c:when test="${post.getIsApproved()}">
                                                        <span class="badge badge-success ms-3">Approved</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="badge badge-danger ms-3">Pending...</span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </h5>
                                            <p>[${post.getDateFormated()}]</p>
                                        </div>
                                        <div class="card-body d-flex">
                                            <p class="text-black-50"><c:out value="${post.description}" escapeXml="false"/></p>
                                        </div>
                                    </a>
                                </div>
                            </c:forEach>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="shared/end.jsp" %>