<%-- 
    Document   : checkin
    Created on : Oct 16, 2022, 5:10:20 PM
    Author     : Huu
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;600;700&display=swap" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tw-elements/dist/css/index.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
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
        <title>Daily Attendance</title>

        <style>
            html {
                scroll-behavior: smooth;
            }

            .animated:hover {
                animation: hover_item 0.3s ease-out forwards;
                cursor: pointer;
            }

            .item {
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
        <%@include file="components/navbar.jsp" %>
        <!-- data table -->
        <section
            style="
            background-image: url(https://store-images.s-microsoft.com/image/apps.48230.14636562343019557.feb6ee7f-98cf-4969-bcee-847a8699802d.1cbf4a08-f598-410a-8767-3d2732f24fb2?mode=scale&q=90&h=1080&w=1920);
            "
            class="antialiased bg-gray-100 text-gray-600 h-screen px-4 py-4"
            >
            <div class="flex flex-col justify-center h-full">
                <div   class="w-full max-w-6xl h-[550px] mx-auto bg-white shadow-lg rounded-lg border border-gray-200" >
                    <header class="px-5 py-4 border-b border-gray-100">
                        <div class="flex items-center relative">
                            <div>
                                <h2 class="font-semibold text-gray-800 text-lg">
                                    Daily Attendance
                                </h2>
                                <p class="text-sm">This month has registered ${player.checkincount} days</p>
                            </div>
                            <button
                                class="absolute -top-8 right-0 my-8 bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded" onclick="checkin()">
                                Check-in
                            </button>
                        </div>
                    </header>

                    <div class="px-4 py-4">
                        <div
                            class="container gap-7 px-2 flex items-center justify-between flex-wrap"
                            >
                            <!--item-->
                            <c:forEach var = "i" begin = "1" end = "14">

                                <c:choose>
                                    <c:when test="${i<= player.checkincount}">
                                        <div
                                            class="relative item mb-4 bg-[#CD8058] flex flex-col items-center justify-center w-32 h-32 rounded-t-md shadow-md border"
                                            >
                                            <div
                                                class="absolute w-6 h-6 rounded-full bg-white  -top-2 -right-1"
                                                >
                                                <i
                                                    class="fa-solid fa-check w-6 h-6 text-green-600 font-bold text-center"
                                                    ></i>
                                            </div>
                                            <div class="w-20 h-18 rounded-full mt-8">
                                                <img
                                                    src="https://lienquan.garena.vn/files/upload/images/Trang%20B%E1%BB%8B/N%C6%B0%E1%BB%9Bc%20M%E1%BA%AFt%20Ph%C6%B0%E1%BB%A3ng%20Ho%C3%A0ng.png"
                                                    class="w-20 h-20 mt-4 rounded-full text-center mx-auto object-cover"
                                                    />
                                                <span class="block text-center text-white text-md py-2"
                                                      >x3</span
                                                >
                                            </div>
                                            <div
                                                class="w-full h-8 bg-white text-center rounded-b-md border -mt-2 shadow-md"
                                                >
                                                <span class="text-gray-600 inline-block py-1">Day ${i}</span>
                                            </div>
                                        </div>
                                    </c:when> 

                                    <c:otherwise>
                                        <div
                                            class="relative item mb-4 bg-[#CD8058] flex flex-col items-center justify-center w-32 h-32 rounded-t-md shadow-md border"
                                            >
                                            <div
                                                class="absolute w-6 h-6 rounded-full bg-red-500 -top-2 -right-1"
                                                >
                                                <i
                                                    class="fa-solid fa-check w-6 h-6 text-green-600 font-bold text-center"
                                                    ></i>
                                            </div>
                                            <div class="w-20 h-18 rounded-full mt-8">
                                                <img
                                                    src="https://lienquan.garena.vn/files/upload/images/Trang%20B%E1%BB%8B/N%C6%B0%E1%BB%9Bc%20M%E1%BA%AFt%20Ph%C6%B0%E1%BB%A3ng%20Ho%C3%A0ng.png"
                                                    class="w-20 h-20 mt-4 rounded-full text-center mx-auto object-cover"
                                                    />
                                                <span class="block text-center text-white text-md py-2"
                                                      >x3</span
                                                >
                                            </div>
                                            <div
                                                class="w-full h-8 bg-white text-center rounded-b-md border -mt-2 shadow-md"
                                                >
                                                <span class="text-gray-600 inline-block py-1">Day ${i}</span>
                                            </div>
                                        </div>
                                    </c:otherwise>
                                </c:choose>

                            </c:forEach>

                        </div>
                    </div>


                </div>
            </div>
        </section>

        <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
        <script src="../script/home.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script type="text/javascript">
                                    function checkin()
                                    {
                                        fetch('checkin', {
                                            method: 'post',
                                            headers: {
                                                'Content-Type': 'application/x-www-form-urlencoded',
                                            },
                                            body: 'submit='
                                        }).then(e => e.text()).then(a => swal({
                                                title: a,
                                                icon: "warning",
                                                button: "Close"
                                            }));
                                    }

        </script>
    </body>
</html>