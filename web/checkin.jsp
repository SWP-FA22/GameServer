<%-- 
    Document   : checkin
    Created on : Nov 13, 2022, 6:44:15 PM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="shared/begin.jsp" %>

<style>
    @media only screen and (min-width: 960px) {
        .bs-checkin--items {
            width: calc(100% / 7);
        }
    }
</style>

<div class="h-100 w-100 d-flex justify-content-center align-items-center flex-column p-5">
    <div class="container card w-100">
        <div class="card-header d-flex justify-content-between">
            <div>
                <h5>Daily Attendance</h5>
                <p>This month has registered 4 days</p>
            </div>

            <div>
                <button class="btn btn-outline-danger" type="button" onclick="checkin()">Check-in</button>
            </div>
        </div>

        <div class="card-body">
            <div class="row">

                <c:set var="i" value="${1}"/>
                <c:forEach var="item" items="${checkinItems}">
                    <div class="p-1 col-sm-4 col-lg-3 bs-checkin--items">
                        <div class="card">
                            <img src="${checkinItems.get(i - 1).getValue().imageURL}" alt="" class="card-header img-fluid img-thumbnail">
                            <div class="card-body">
                                <h5 class="text-center">Days ${i}</h5>

                                <c:if test="${i < player.checkincount}">
                                    <span
                                        class="position-absolute top-0 start-100 translate-middle p-2 bg-success border border-light rounded-circle">
                                    </span>
                                </c:if>

                            </div>
                        </div>
                    </div>
                    <c:set var="i" value="${i + 1}"/>
                </c:forEach>

            </div>
        </div>
    </div>
</div>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script>
                    function checkin() {
                        fetch('check-in', {
                            method: 'post',
                            headers: {
                                'Content-Type': 'application/x-www-form-urlencoded',
                            },
                            body: 'submit='
                        })
                                .then(e => e.text())
                                .then(a => swal({
                                        title: a,
                                        icon: "warning",
                                        button: "Close"
                                    }).then(e => location.reload()));
                    }
</script>

<%@include file="shared/end.jsp" %>