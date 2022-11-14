<%-- 
    Document   : report
    Created on : Nov 14, 2022, 6:28:13 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="shared/begin.jsp" %>
<section class="w-100 h-100 position-absolute d-flex justify-content-center align-items-center top-0">
    <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                     class="img-fluid" alt="Login">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <form method="post" action="report">
                    <h1 class="mb-4"><span class="text-danger">R</span>eport</h1>

                    <!-- Username input -->
                    <div class="form-outline mb-4">
                        <input type="text" class="form-control form-control-lg" name="username" pattern="\S{8,64}"
                               required />
                        <label class="form-label">Username</label>
                    </div>

                    <div class="form-outline mb-4">
                        <input type="text" class="form-control form-control-lg" name="description"
                               required />
                        <label class="form-label">Description</label>
                    </div>

                    <div class="form-outline mb-4">
                        <input type="text" class="form-control form-control-lg" name="video-link"
                               required />
                        <label class="form-label">Video Link</label>
                    </div>

                    <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="submit" class="btn btn-danger btn-lg"
                                style="padding-left: 2.5rem; padding-right: 2.5rem;">Report</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<%@include file="shared/end.jsp" %>
