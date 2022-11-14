<%-- 
    Document   : ranking
    Created on : Nov 13, 2022, 5:59:00 PM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="shared/begin.jsp" %>
<style>
    #bs-ranking--container {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;

        background-image: url("assets/bg.webp");
        background-position: center;
    }

    #bs-ranking--container > div {
        background-color: #ffffffc0;
        backdrop-filter: blur(10px);
    }
</style>

<div class="h-100 p-5" id="bs-ranking--container">
    <h1 class="text-center mb-5">Ranking</h1>

    <div class="card w-100" style="max-width: 1024px;">
        <div class="card-header">
            <h5>Top 5 Rankers</h5>
        </div>

        <div class="card-body table-responsive">
            <table class="table table-bordered table-hover table-auto">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Username</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Score</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="i" value="${1}"/>
                    <c:forEach var="ranker" items="${rankers}">
                        <tr>
                            <th scope="row">${i}</th>
                            <td>
                                <a class="nav-link text-warning" href="profile?id=${ranker.id}"><c:out value="${ranker.username}"/></a>
                            </td>
                            <td><c:out value="${ranker.name}"/></td>
                            <td><c:out value="${ranker.email}"/></td>
                            <td><c:out value="${ranker.rank}"/></td>
                        </tr>
                        <c:set var="i" value="${i + 1}"/>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <c:if test="${player != null}">
            <div class="card-footer">
                <h5>My current rank is <span class="text-danger">${myrank}</span> with <span class="text-danger">${player.rank}</span> ranking points</h5>
            </div>
        </c:if>
    </div>
</div>
<%@include file="shared/end.jsp" %>