<%-- 
    Document   : details-profile
    Created on : Oct 15, 2022, 1:52:39 AM
    Author     : LinhThuy
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="utilities.GlobalConstants" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entities.Player"%>
<%@page import="java.util.ArrayList"%>

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
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script>
            </head>
                    tailwind.config = {
                        theme: {
                            extend: {
                                fontFamily: {
                                    sans: ["Inter", "sans-serif"],
                                },
                            },
                        },
                    };
        </script>

        <title>Details Profile</title>

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
    <body>
        <%@include file="components/navbar.jsp" %>

        <div class="relative">
            <img
                src="https://images5.alphacoders.com/106/1066686.jpg"
                class="object-fit w-full h-[25rem]"
                />
        </div>

        <form method="get">
            <div class="flex justify-center mt-8 ">
                <div class="mb-3 xl:w-96">
                    <div class="input-group relative flex flex-wrap items-stretch w-full mb-4">
                        <input type="search" class="form-control relative flex-auto min-w-0 block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none" placeholder="Search Item" aria-label="Search" aria-describedby="button-addon2">
                            <button class="btn inline-block px-6 py-2.5 bg-blue-600 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700  focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out flex items-center" type="button" id="button-addon2">
                                <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="search" class="w-4" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                                    <path fill="currentColor" d="M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z"></path>
                                </svg>
                            </button>
                    </div>
                </div>



            </div>

        </form>



        <div class="container px-8 mx-auto">
            <div class="p-10 grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-5 xl:grid-cols-7 gap-20 mx-center">
                <!--Card 1-->

                <c:forEach items="${requestScope.listitem}" var="listitem" >

                    <div class="animated${listitem.id} flex flex-col items-center justify">
                        <div class="rounded-lg shadow-lg bg-white w-40 h-40">
                            <img class="rounded-t-lg w-40 h-40 object-contain" src="${listitem.imageURL}"  alt=""/>
                            <div class="p-6">
                                <h5 class="text-gray-900 text-xl font-medium mb-2">${listitem.name}</h5> 
                            </div>
                        </div>
                    </div>
             
                </c:forEach>


            </div>
        </div>


    </body>

</html>
