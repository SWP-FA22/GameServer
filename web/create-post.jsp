<%-- 
    Document   : create-post
    Created on : Oct 24, 2022, 9:54:57 PM
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
        <link
            rel="stylesheet"
            href="./assets/css/rte_theme_default.css"
            />
        <script
            type="text/javascript"
            src="./script/rte.js"
        ></script>
        <script
            type="text/javascript"
            src="./script/all_plugins.js"
        ></script>
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
        <title>User Post</title>

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


        <form action="post" method="POST">

            <h3 class="text-red-400 mt-6" style="text-align: center">${requestScope.error}</h3>
            <div class="flex flex-col items-center justify-center mt-4">

                <h2 class="text-lg text-gray-600 font-semibold mt-2">Create New Post</h2>

                <div class="form-group w-[50%] mb-6 mt-4">
                    <label
                        for="exampleInputEmail1"
                        class="form-label inline-block mb-2 text-gray-700"
                        >Title</label
                    >
                    <input type="text"
                           class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                           id="title"
                           aria-describedby="title"
                           placeholder="Enter Title"
                           name="title"></input>

                    <label
                        for="exampleInputEmail1"
                        class="form-label inline-block mb-2 text-gray-700"
                        >Name</label
                    >
                    <input type="text"
                           class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                           id="title"
                           aria-describedby="createdby"
                           placeholder="Enter Username"
                           name="createdby"></input>
                </div>

                <!--                <div class="form-group w-[50%] mb-6 mt-4">
                
                                </div>-->
                <!--                <div name="description" type="text" id="div_editor1" class="form-group w-[50%] mb-6 mt-4">
                                    
                                </div>-->

                <div> 
                    <input type="text" name="description" id="div_editor1">
                </div>


                <div class="flex items-center justify-center mt-4">
                    
                    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 mr-4 rounded" type="submit" name="post" onclick="formSubmit()">
                        Post 
                        <a href="post-manage">
                    </button>
                    <button class="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded">
                        <a href="." type="button" name="cancel"> Cancel</a>

                    </button>
                </div>
            </div>
            <h3 class="text-red-400 mt-6" style="text-align: center">${requestScope.success}</h3>
            <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
            <script src="./script/home.js"></script>
            <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
            <script>
                        var editor1 = new RichTextEditor("#div_editor1");
            </script>
    </body>

</form>
</html>