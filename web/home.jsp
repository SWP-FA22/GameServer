<%-- 
    Document   : index
    Created on : Nov 13, 2022, 8:45:31 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="shared/begin.jsp" %>
<!-- Carousel wrapper -->
<div id="bs-home--carousel" class="carousel slide carousel-fade mt-5" data-mdb-ride="carousel">
    <!-- Indicators -->
    <div class="carousel-indicators">
        <button type="button" data-mdb-target="#bs-home--carousel" data-mdb-slide-to="0" class="active"
                aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-mdb-target="#bs-home--carousel" data-mdb-slide-to="1"
                aria-label="Slide 2"></button>
        <button type="button" data-mdb-target="#bs-home--carousel" data-mdb-slide-to="2"
                aria-label="Slide 3"></button>
    </div>

    <!-- Inner -->
    <div class="carousel-inner">
        <!-- Single item -->
        <div class="carousel-item active">
            <img src="https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(15).webp" class="d-block w-100"
                 alt="Sunset Over the City" />
            <div class="carousel-caption d-none d-md-block">
                <h5>First slide label</h5>
                <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
            </div>
        </div>

        <!-- Single item -->
        <div class="carousel-item">
            <img src="https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(22).webp" class="d-block w-100"
                 alt="Canyon at Nigh" />
            <div class="carousel-caption d-none d-md-block">
                <h5>Second slide label</h5>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            </div>
        </div>

        <!-- Single item -->
        <div class="carousel-item">
            <img src="https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(23).webp" class="d-block w-100"
                 alt="Cliff Above a Stormy Sea" />
            <div class="carousel-caption d-none d-md-block">
                <h5>Third slide label</h5>
                <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
            </div>
        </div>
    </div>
    <!-- Inner -->

    <!-- Controls -->
    <button class="carousel-control-prev" type="button" data-mdb-target="#bs-home--carousel" data-mdb-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-mdb-target="#bs-home--carousel" data-mdb-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<!-- Carousel wrapper -->

<!-- Post list -->
<div class="container mt-5 mb-5">
    <div class="row">

        <c:forEach var="post" items="${posts}">
            <div class="col-xl-3 col-sm-6 pt-2 pb-2">
                <div class="card text-center">
                    <div class="card-header">
                        <a href="profile?id=${post.getValue().createdBy}"><c:out value="${post.getKey().name}"/></a>
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">${post.getValue().title}</h5>
                        <a href="view-post?id=${post.getValue().id}" class="btn btn-primary">Readmore</a>
                    </div>
                    <div class="card-footer text-muted">${post.getValue().getDateFormated()}</div>
                </div>
            </div>
        </c:forEach>

    </div>

    <div class="d-flex justify-content-center mt-4">
        <a href="" class="btn btn-primary">Load More</a>
    </div>
</div>
<!-- Post list -->


<!-- Footer -->
<footer class="text-center text-lg-start bg-light text-muted">
    <!-- Section: Social media -->
    <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
        <!-- Left -->
        <div class="me-5 d-none d-lg-block">
            <span>Get connected with us on social networks:</span>
        </div>
        <!-- Left -->

        <!-- Right -->
        <div>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-facebook-f"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-google"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-github"></i>
            </a>
        </div>
        <!-- Right -->
    </section>
    <!-- Section: Social media -->

    <!-- Section: Links  -->
    <section class="">
        <div class="container text-center text-md-start mt-5">
            <!-- Grid row -->
            <div class="row mt-3">
                <!-- Grid column -->
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <!-- Content -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        BattleShip
                    </h6>
                    <p>
                        Here you can use rows and columns to organize your footer content. Lorem ipsum
                        dolor sit amet, consectetur adipisicing elit.
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        Members
                    </h6>
                    <p>
                        <a href="#!" class="text-reset">Nguyễn Quang Khải</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Triệu Đình Quang</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Phạm Bằng Hữu</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Lê Thùy Linh</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Nguyễn Huy Hoàng</a>
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                    <p><i class="fas fa-home me-3"></i> New York, NY 10012, US</p>
                    <p>
                        <i class="fas fa-envelope me-3"></i>
                        info@example.com
                    </p>
                    <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
                    <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
                </div>
                <!-- Grid column -->
            </div>
            <!-- Grid row -->
        </div>
    </section>
    <!-- Section: Links  -->

    <!-- Copyright -->
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
        © 2022 Copyright:
        <a class="text-reset fw-bold" href="#">BattleShip</a>
    </div>
    <!-- Copyright -->
</footer>
<!-- Footer -->
<%@include file="shared/end.jsp" %>