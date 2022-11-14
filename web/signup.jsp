<%-- 
    Document   : signup
    Created on : Nov 13, 2022, 9:25:58 AM
    Author     : quang
--%>

<%@page import="utils.GlobalConstants"%>
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
                <form method="post" action="signup" id="registerform"
                      oninput="repassword.setCustomValidity(repassword.value !== password.value ? 'Confirm password does not match': '')"
                      >
                    <h1 class="mb-4"><span class="text-danger">S</span>ignup</h1>

                    <!-- Name input -->
                    <div class="form-outline mb-4">
                        <input type="text" class="form-control form-control-lg" name="name" required />
                        <label class="form-label">Name</label>
                    </div>

                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <input type="email" class="form-control form-control-lg" name="email" required />
                        <label class="form-label">Email</label>
                    </div>

                    <!-- Username input -->
                    <div class="form-outline mb-4">
                        <input type="text" class="form-control form-control-lg" name="username" pattern="\S{8,64}" required />
                        <label class="form-label">Username</label>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-3">
                        <input type="password" class="form-control form-control-lg" name="password" pattern="\S{8,16}" required id="password"/>
                        <label class="form-label">Password</label>
                    </div>

                    <!-- Confirm Password input -->
                    <div class="form-outline mb-3">
                        <input type="password" class="form-control form-control-lg" pattern="\S{8,16}" required id="repassword"/>
                        <label class="form-label">Confirm Password</label>
                    </div>

                    <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="button" class="btn btn-danger btn-lg" onclick="formSubmit()"
                                style="padding-left: 2.5rem; padding-right: 2.5rem;">Sign-up</button>
                        <p class="small fw-bold mt-2 pt-1 mb-0">Already have an account? <a href="signin"
                                                                                            class="link-danger">Signin</a> here!</p>
                    </div>

                    <div class="g-recaptcha" id="grecaptcha" data-sitekey="<%= GlobalConstants.GOOGLE_RECAPTCHA_SITE_KEY%>" hidden data-callback="onSubmit"></div>
                </form>
            </div>
        </div>
    </div>
</section>


<script>
    function onSubmit() {
        document.getElementById('registerform').submit();
    }

    function formSubmit() {
        const form = document.getElementById('registerform');
        if (form.checkValidity()) {
            document.getElementById('grecaptcha').hidden = false;
            //grecaptcha.execute();
        } else {
            form.reportValidity();
        }
    }
</script>
<script async src="https://www.google.com/recaptcha/api.js"/>
<%@include file="shared/end.jsp" %>