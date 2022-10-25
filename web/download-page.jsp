<%-- 
    Document   : download-page
    Created on : Oct 14, 2022, 8:49:42 AM
    Author     : LinhThuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="utilities.Authentication"%>
<%@page import="entities.Player"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script src="https://cdn.tailwindcss.com"></script>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap"
            />
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
        <title>Download Page</title>

        <style>
            html {
                scroll-behavior: smooth;
            }
        </style>
    </head>
    <body>


        <%@include file="components/navbar.jsp" %>



        <style>
            .container-download{
                position: relative;
                width: 100%;

            }

            .container-download img {
                width: 80%;
                height: auto;
            }

            .container-download .btn {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                -ms-transform: translate(-50%, -50%);
                background-color: #555;
                color: white;
                font-size: 30px;
                padding: 12px 24px;
                border: none;
                cursor: pointer;
                border-radius: 5px;
                text-align: center;
            }

            .container-download .btn:hover {
                background-color: black;
            }
        </style>

        <!--game image-->
        <div class="container-download">
            <img src="./assets/img/wallpaperflare.com_wallpaper.jpg" style="height: 80%;width: 90%; margin: auto">
            <a class="link"  href="https://drive.google.com/uc?id=1-UC2f8LMbP4b8LCuycngULRf5VLzIOm0&export=download">
                <button class="btn">Download</button>
            </a>
        </div>

    </div>
    <%@include file="components/footer.jsp" %>

    <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
    <script src="./script/home.js"></script>
</body>
</html>
</body>



</html>
