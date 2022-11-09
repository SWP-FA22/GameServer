<%-- 
    Document   : post-manage
    Created on : Oct 25, 2022, 5:03:47 PM
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
        <title>Post Manage</title>

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


        <div class="flex flex-col items-center justify-center">

            <form action="search" method="get">
                <input type="text" placeholder="search film" name="name">
                <button type="submit">
                    Search
                </button>
            </form>

            <div style="margin-top: 30px"
                 <hr><hr>
                <c:forEach items="${requestScope.list}" var="list">
                    

                    <div class="wrapper bg-white flex flex-row p-3">
                        <div class="w-1/6 flex-grow-0">
                            <div
                                class="rounded-full w-full h-auto border-green-700 border-4 p-1 overflow-hidden"
                                >
                                <img
                                    class="rounded-full w-full"
                                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTaXZd2-aQF4R4Vxg3jpmkz5IAIHc9Hg-Fc1Aun7XeasnVggFOvogZQ5ZrsnL2E4RpaJjY&usqp=CAU"
                                    alt=""
                                    />
                            </div>
                        </div>
                        <div class="w-5/6 info text-left pl-3">
                            <div>
                                <a href="view-post?id=${list.id}"><p class="written-by font-bold tracking-wide">${list.title}</p></a>
                                

                                
                            </div>

                            <div
                                class="written-by uppercase text-gray-600 tracking-wide text-sm mb-2"
                                >
                                ${list.timeCreate}
                            </div>

                            <div class="bio text-sm">
                                ${list.description}
                            </div>
                        </div>
                    </div>
                    <hr>     

                </c:forEach> 
            </div>


        </div>




        <!--pagination-->
        <div class="my-8 flex justify-center">
            <nav aria-label="Page navigation example">
                <ul class="flex list-style-none">
                    <li class="page-item disabled">
                        <a
                            class="page-link relative block py-1.5 px-3 rounded border-0 bg-transparent outline-none transition-all duration-300 rounded text-gray-500 pointer-events-none focus:shadow-none"
                            href="#"
                            tabindex="-1"
                            aria-disabled="true"
                            >Previous</a
                        >
                    </li>
                    <li class="page-item active">
                        <a
                            class="page-link relative block py-1.5 px-3 rounded border-0 bg-blue-600 outline-none transition-all duration-300 rounded text-white hover:text-white hover:bg-blue-600 shadow-md focus:shadow-md"
                            href="#"
                            >1 <span class="visually-hidden">(current)</span></a
                        >
                    </li>
                    <li class="page-item">
                        <a
                            class="page-link relative block py-1.5 px-3 rounded border-0 bg-transparent outline-none transition-all duration-300 rounded text-gray-800 hover:text-gray-800 hover:bg-gray-200 focus:shadow-none"
                            href="#"
                            >2</a
                        >
                    </li>
                    <li class="page-item">
                        <a
                            class="page-link relative block py-1.5 px-3 rounded border-0 bg-transparent outline-none transition-all duration-300 rounded text-gray-800 hover:text-gray-800 hover:bg-gray-200 focus:shadow-none"
                            href="#"
                            >3</a
                        >
                    </li>
                    <li class="page-item">
                        <a
                            class="page-link relative block py-1.5 px-3 rounded border-0 bg-transparent outline-none transition-all duration-300 rounded text-gray-800 hover:text-gray-800 hover:bg-gray-200 focus:shadow-none"
                            href="#"
                            >Next</a
                        >
                    </li>
                </ul>
            </nav>
        </div>







        <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
        <script src="../script/home.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <!--        <script>
                    // approve or deny
        
                    const check_icons = document.querySelectorAll(".icon-check");
                    const trash_icons = document.querySelectorAll(".icon-trash");
        
                    check_icons.forEach((item) => {
                        item.addEventListener("click", () => {
                            //                    swal({
                            //                        title: "Approved!",
                            //                        icon: "success",
                            //                        button: "Close",
                            //                    });
                        });
                    });
        
                    trash_icons.forEach((item) => {
                        item.addEventListener("click", () => {
                            swal({
        
                                //             
                                title: "Are you sure to delete this post?",
                                icon: "warning",
                                buttons: true,
                                dangerMode: true,
                            }).then((willDelete) => {
                                if (willDelete) {
                                    swal("Delete successfully !", {
                                        icon: "success",
        
                                    });
                                }
                            });
                        });
                    });
        
        
                </script>-->
    </body>
</html>
