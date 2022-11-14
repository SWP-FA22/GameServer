<%-- 
    Document   : admin
    Created on : Nov 14, 2022, 3:44:21 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="shared/begin.jsp" %>
<div class="row w-100" style="margin-top: 85px;">
    <div class="col-3">
        <!-- Tab navs -->
        <div class="nav flex-column nav-tabs text-center" role="tablist" aria-orientation="vertical">
            <a class="nav-link active" data-mdb-toggle="tab" href="#v-tabs-post" role="tab">Post</a>
            <a class="nav-link" data-mdb-toggle="tab" href="#v-tabs-account" role="tab">Account</a>
            <a class="nav-link" data-mdb-toggle="tab" href="#v-tabs-transaction" role="tab">Transaction</a>
        </div>
        <!-- Tab navs -->
    </div>

    <div class="col-9">
        <!-- Tab content -->
        <div class="tab-content mt-5">
            <div class="tab-pane fade show active" id="v-tabs-post" role="tabpanel">
                <div class="container">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Title</th>
                                <th scope="col">Author</th>
                                <th scope="col">Date</th>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="tab-pane fade" id="v-tabs-account" role="tabpanel">
                <div class="container">
                    <div class="col-12">
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" id="search-account" placeholder="Search">
                            <button class="btn btn-danger" type="button"
                                    onclick="searchAccounts(this.parentNode.parentNode)">Search</button>
                        </div>
                    </div>

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Username</th>
                                <th scope="col">Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="tab-pane fade" id="v-tabs-transaction" role="tabpanel">
                <div class="container">
                    <div class="col-12">
                        <input type="text" class="form-control mt-3" id="search-account" placeholder="Search">
                        <div class="input-group mt-3">
                            <span class="input-group-text">From</span>
                            <input type="date" class="form-control" id="from-date">
                            <span class="input-group-text">To</span>
                            <input type="date" class="form-control" id="to-date">
                            <button class="btn btn-danger" type="button"
                                    onclick="searchTransactions(this.parentNode.parentNode)">Search</button>
                        </div>
                    </div>

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Time</th>
                                <th scope="col">Username</th>
                                <th scope="col">Amount</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>
                                    <a href="profile?id=" class="nav-link text-warning">Username</a>
                                </td>
                                <td>Otto</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Tab content -->
    </div>
</div>

<script src="js/admin.js"></script>

<%@include file="shared/end.jsp" %>