<%-- 
    Document   : report-page
    Created on : Oct 11, 2022, 12:38:29 AM
    Author     : LinhThuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>ReportPage</title>
    </head>

    <body>  
        <%@include file="components/navbar.jsp" %>

        <form action="report" method="POST">
            <div class="container mt-6">
                <div class="row">
                    <div class="col-10" style="margin: auto">
                        <div class="card" style="position: relative;
                             display: flex;
                             flex-direction: column;
                             min-width: 0;
                             word-wrap: break-word;
                             background-color: #fff;
                             background-clip: border-box;
                             border: 0 solid rgba(0,0,0,.125);
                             border-radius: .25rem;">

                            <div class="card-header" style="line-height: 2.5;">

                                <div>
                                    <h1 style="font-size: 32px; text-align: center">Report Page</h1>
                                    <h3 class="text-red-400 mt-6" style="text-align: center">${requestScope.error}</h3>
                                </div>



                                <div class="card-body" style="flex: 1 1 auto;
                                     min-height: 2.5px;
                                     padding: 1rem;">
                                    <div class="row" >
                                        <input class="col-sm-9 text-secondary" placeholder="Your username" name="namefrom" hidden value="${player.username}">

                                        </input>
                                    </div>
                                    <hr>
                                    <div class="row" >
                                        <div class="col-sm-3" style="font-weight: bold">
                                            <div>Reported Account</div>
                                        </div>
                                        <input class="col-sm-9 text-secondary" placeholder="Username to report" name="nameto" required>

                                        </input>
                                    </div>
                                    <hr>

                                    <div class="row">
                                        <div class="col-sm-3" style="font-weight: bold">
                                            <p>Reason</p>
                                        </div>

                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3" style="font-weight: bold">
                                            <input type="checkbox" name="reason" id="A1" value="Negative attitude">Negative attitude</div>
                                        <div class="col-sm-3" style="font-weight: bold">
                                            <input type="checkbox" name="reason" id="A1" value="Hate speech">Hate speech</div>
                                        <div class="col-sm-2" style="font-weight: bold">
                                            <input type="checkbox" name="reason" id="A1" value="Cheating">Cheating</div>
                                        <div class="col-sm-4" style="font-weight: bold">
                                            <input type="checkbox" name="reason" id="A1" value="Offensive or Inappropriate Name">Offensive or Inappropriate Name</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3" style="font-weight: bold">
                                            <div>Link URL video report</div>
                                        </div>
                                        <input class="col-sm-9 text-secondary" placeholder="Link video report" name="videoURL" required>
                                        </input>
                                    </div>
                                </div>
                                <hr>


                                <hr>
                            </div>
                            <div>

                                <h3 class="text-red-400 mt-6" style="text-align: center">${requestScope.success}</h3>
                                <button class="btn btn-theme" type="submit" name="report" onclick="formSubmit()" >Submit</button>
                                <a href="." class="btn btn-theme" type="button" name="cancel">Cancel</a>



                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

    </form>





</div>


<script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
<script src="./script/home.js"></script>
</body>

</html>
