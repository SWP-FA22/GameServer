<%-- 
    Document   : admin
    Created on : Sep 23, 2022, 10:51:26 AM
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
              integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
              integrity="sha512-SfTiTlX6kk+qitfevl/7LibUOeJWlt9rbyDn92a1DqWOw9vWG2MFoays0sgObmWazO5BQPiFucnnEAjpAB+/Sw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;600;700&display=swap" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tw-elements/dist/css/index.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
        <title>Home Page</title>

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
    <%@include file="components/navbar.jsp" %>

    <body class="bg-grey-200">
        <!-- data table -->
        <section style="
                 background-image: url('./assets/img/2203_w023_n001_2016b_p1_2016.jpg');
                 width: 100%;
                 height : 95vh;
                 background-position: contain;
                 " class=" antialiased bg-gray-100 text-gray-600 h-screen px-4">
            <div class="flex flex-col justify-center h-full">
                <div class="flex justify-center">
                    <div class="mb-3 xl:w-96">
                        <div class="input-group relative flex flex-wrap items-stretch w-full mb-4">
                            <form action="searchadmin" method="get">
                                <input type="search"
                                       class="form-control relative flex-auto min-w-0 block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                       placeholder="Search User" name="name" aria-label="Search" aria-describedby="button-addon2">
                                <button
                                    class="btn inline-block px-6 py-2.5 bg-blue-600 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700  focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out flex items-center"
                                    type="submit" id="button-addon2">
                                    <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="search" class="w-4"
                                         role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                                    <path fill="currentColor"
                                          d="M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z">
                                    </path>
                                    </svg>
                                </button>
                            </form>

                        </div>
                    </div>
                </div>
                <!-- Table -->
                <div style=" background-image: url('./assets/img/button.png');
                     width: 100%;
                     max-height: 40%;
                     height : 38%;
                     background-position: center;
                     border-radius: 50px" class="w-full max-w-6xl mx-auto shadow-lg rounded-lg border border-gray-200">
                    <header class="px-5 py-4 border-b border-gray-100">
                        <h2 class="text-xl font-semibold text-white">Users Data</h2>
                    </header>
                    <div class="p-3">
                        <div class="overflow-x-auto">
                            <table class="table-auto w-full">
                                <thead class="text-xs font-semibold uppercase text-gray-400 bg-gray-50">
                                    <tr>
                                        <th class="p-2 whitespace-nowrap">
                                            <div class="font-semibold text-left">Id</div>
                                        </th>
                                        <th class="p-2 whitespace-nowrap">
                                            <div class="font-semibold text-left">Username</div>
                                        </th>
                                        <th class="p-2 whitespace-nowrap">
                                            <div class="font-semibold text-left">Name</div>
                                        </th>
                                        <th class="p-2 whitespace-nowrap">
                                            <div class="font-semibold text-left">Email</div>
                                        </th>
                                        <th class="p-2 whitespace-nowrap">
                                            <div class="font-semibold text-center">Action</div>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody class="text-sm divide-y divide-gray-100  text-white">
                                    <c:forEach items="${requestScope.players}" var="p">
                                        <tr>
                                            <td class="p-2 whitespace-nowrap">${p.id}</td>
                                            <td class="p-2 whitespace-nowrap">
                                                <div class="flex items-center">
                                                    <div class="font-medium text-white">${p.username}</div>
                                                </div>
                                            </td>
                                            <td class="p-2 whitespace-nowrap">
                                                <div class="text-left">${p.name}</div>
                                            </td>
                                            <td class="p-2 whitespace-nowrap">
                                                <div class="text-left font-medium text-white">
                                                    ${p.email}
                                                </div>
                                            </td>
                                            <td class="p-2 whitespace-nowrap">
                                                <div class="text-lg text-center">
                                                    <div class="flex item-center justify-center">
                                                        <div
                                                            class="cursor-pointer w-5 mr-2 transform hover:text-purple-500 hover:scale-110">
                                                            <svg class="eye-icon${p.id}" xmlns="http://www.w3.org/2000/svg"
                                                                 fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                                            <path stroke-linecap="round" stroke-linejoin="round"
                                                                  stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z" />
                                                            <path stroke-linecap="round" stroke-linejoin="round"
                                                                  stroke-width="2"
                                                                  d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z" />
                                                            </svg>

                                                        </div>
                                                        <c:if test="${p.role==0}">
                                                            <div
                                                                class="cursor-pointer w-5 mr-2 transform hover:text-purple-500 hover:scale-110">
                                                                <i class="lock-icon${p.id} fa-solid fa-lock"></i>
                                                            </div>
                                                        </c:if>
                                                        <c:if test="${p.role==2}">
                                                            <div
                                                                class="cursor-pointer w-5 mr-2 transform hover:text-purple-500 hover:scale-110">
                                                                <i class="fa-solid fa-lock-open fa-lock-open${p.id}"></i>
                                                            </div>
                                                        </c:if>

                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                            <!--pagination-->
                            <div class="mt-8 flex justify-center">
                                <nav aria-label="Page navigation example">
                                    <ul class="flex list-style-none">
                                        <c:forEach var = "i" begin = "1" end = "${requestScope.pages}">
                                            <li class="page-item active">
                                                <a
                                                    class="page-link relative block py-1.5 px-3 rounded border-0 bg-blue-600 outline-none transition-all duration-300 rounded text-white hover:text-white hover:bg-blue-600 shadow-md focus:shadow-md"
                                                    href="admin?page=${i}"
                                                    >${i} <span class="visually-hidden">(current)</span></a
                                                >
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <!-- modal -->
        <c:forEach items="${requestScope.players}" var="p">
            <div id="modal${p.id}" class="hidden flex modal fixed inset-0">
                <div class="modal-overlay absolute w-full h-full bg-[rgba(0,0,0,0.3)]">
                    <div class="mt-20 max-w-md mx-auto bg-white rounded-xl shadow-md overflow-hidden md:max-w-md">
                        <div class="md:flex relative">
                            <span class="absolute top-4 right-4">
                                <button id="btn-close${p.id}" type="button"
                                        class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white"
                                        data-modal-toggle="defaultModal">
                                    <i class="fa-solid fa-xmark"></i>
                                    <span class="sr-only">Close modal</span>
                                </button>
                            </span>
                            <div class="w-full p-2 py-10">
                                <div class="flex justify-center">
                                    <div class="relative">
                                        <img src="https://upload.wikimedia.org/wikipedia/en/8/86/Avatar_Aang.png"
                                             class="rounded-full" width="80" alt=""/>
                                    </div>
                                </div>

                                <div class="flex flex-col text-center mt-3 mb-4">
                                    <span class="text-2xl font-medium">${p.username}</span>
                                </div>

                                <div class="mt-5 md:mt-0 md:col-span-2 px-4">
                                    <div class="shadow overflow-hidden sm:rounded-md">
                                        <div class="px-4 py-5 bg-white sm:p-6">
                                            <div class="grid grid-cols-6 gap-6">
                                                <div class="col-span-6 sm:col-span-3">
                                                    <label for=""
                                                           class="block text-sm font-medium text-gray-700">Name</label>
                                                    <input value="${p.name}"
                                                           class="mt-2 shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                                           id="numOfShip" type="text" placeholder="enter name user">
                                                </div>

                                                <div class="col-span-6 sm:col-span-3">
                                                    <label for="last_name"
                                                           class="block text-sm font-medium text-gray-700">Email</label>
                                                    <input value="${p.email}"
                                                           class="mt-2 shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                                           id="numOfItem" type="text" placeholder="enter email user">
                                                </div>
                                                <div class="col-span-6 sm:col-span-3">
                                                    <label for="" class="block text-sm font-medium text-gray-700">Number
                                                        of Ships</label>
                                                    <input value="8"
                                                           class="mt-2 shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                                           id="numOfShip" type="number" placeholder="number of ships">
                                                </div>

                                                <div class="col-span-6 sm:col-span-3">
                                                    <label for="last_name"
                                                           class="block text-sm font-medium text-gray-700">Number Of
                                                        Items</label>
                                                    <input value="8"
                                                           class="mt-2 shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                                           id="numOfItem" type="number" placeholder="number of items">
                                                </div>

                                                <div class="col-span-6 sm:col-span-3">
                                                    <label for=""
                                                           class="block text-sm font-medium text-gray-700">Current
                                                        Rank</label>
                                                    <input value="${p.rank}"
                                                           class="bg-gray-100 mt-2 shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                                           disabled id="numOfShip" type="text"
                                                           placeholder="enter name user">
                                                </div>


                                            </div>

                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div> </div>
            </c:forEach>


        <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
        <script src="./script/home.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
    const btn_close = document.getElementById('btn-close');
            <c:forEach items="${requestScope.players}" var="p">
    const lock_icons${p.id} = document.querySelectorAll('.lock-icon${p.id}');
    lock_icons${p.id}.forEach((icon) => {
        icon.addEventListener('click', () => {
            swal({
                title: "Are you sure to ban this user?",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            })
                    .then((willDelete) => {
                        if (willDelete) {
                            window.location = "check?action=ban&id=" +${p.id}
                        }
                    });
        })
    })
    const unlock_icons${p.id} = document.querySelectorAll('.fa-lock-open${p.id}');
    unlock_icons${p.id}.forEach((icon) => {
        icon.addEventListener('click', () => {
            swal({
                title: "Are you sure to unban this user?",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            })
                    .then((willDelete) => {
                        if (willDelete) {
                            window.location = "check?action=unban&id=" +${p.id}
                        }
                    });
        })
    })

            </c:forEach>
    btn_close.addEventListener('click', () => {
        const modal = document.querySelector('#modal');
        modal.classList.toggle('hidden');
    })
    const eye_icons = document.querySelectorAll('.fa-eye');
    eye_icons.forEach((icon) => {
        icon.addEventListener('click', () => {
            const modal = document.querySelector('#modal');
            modal.classList.toggle('hidden');
        })
    })
        </script>



    </body>

</html>