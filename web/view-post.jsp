<%-- 
    Document   : admin-post
    Created on : Oct 25, 2022, 5:09:59 PM
    Author     : LinhThuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script src="https://cdn.tailwindcss.com"></script>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
            integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;600;700&display=swap"
            />
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/tw-elements/dist/css/index.min.css"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/fontawesome.min.css"
            integrity="sha512-8Vtie9oRR62i7vkmVUISvuwOeipGv8Jd+Sur/ORKDD5JiLgTGeBSkI3ISOhc730VGvA5VVQPwKIKlmi+zMZ71w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
            />
        <script src="https://cdn.tailwindcss.com"></script>
        <script>
            tailwind.config = {
                theme: {
                    extend: {
                        fontFamily: {
                            sans: ["Roboto", "sans-serif"],
                        },
                    },
                },
            };
        </script>
        <title>Create Post</title>

        <style>
            html {
                scroll-behavior: smooth;
            }

            .animated:hover {
                animation: hover_item 0.3s ease-out forwards;
                cursor: pointer;
            }

            @keyframes hover_item {
                from {
                    transform: translateY(0);
                }

                to {
                    transform: translateY(-20px);
                }
            }
        </style>
    </head>

    <body class="bg-grey-200">
        <!--navbar-->
        <%@include file="components/navbar.jsp" %>

        <div class="container pl-6 pr-6">
            <h1 class="text-4xl text-center">
                ${post.title}
            </h1>
            
            <div class="text-xs mt-4">
                ${post.description}
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
        <script src="../script/home.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
//            // approve or deny
//
//            const check_icons = document.querySelectorAll(".icon-check");
//            const ban_icons = document.querySelectorAll(".icon-ban");
//
//            check_icons.forEach((item) => {
//                item.addEventListener("click", () => {
//                    swal({
//                        title: "Approved!",
//                        icon: "success",
//                        button: "Close",
//                    });
//                });
//            });
//
//            ban_icons.forEach((item) => {
//                item.addEventListener("click", () => {
//                    swal({
//                        title: "Are you sure to delete this post?",
//                        icon: "warning",
//                        buttons: true,
//                        dangerMode: true,
//                    }).then((willDelete) => {
//                        if (willDelete) {
//                            swal("Delete successfully !", {
//                                icon: "success",
//                            });
//                        }
//                    });
//                });
//            });
        </script>
    </body>
</html>