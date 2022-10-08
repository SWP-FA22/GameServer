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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha512-SfTiTlX6kk+qitfevl/7LibUOeJWlt9rbyDn92a1DqWOw9vWG2MFoays0sgObmWazO5BQPiFucnnEAjpAB+/Sw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;600;700&display=swap" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tw-elements/dist/css/index.min.css" />
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                 background-image: url(https://store-images.s-microsoft.com/image/apps.48230.14636562343019557.feb6ee7f-98cf-4969-bcee-847a8699802d.1cbf4a08-f598-410a-8767-3d2732f24fb2?mode=scale&q=90&h=1080&w=1920);

                 " class="antialiased bg-gray-100 text-gray-600 h-screen px-4">
            <div class="flex flex-col justify-center h-full">
                <!-- Table -->
                <div class="w-full max-w-6xl mx-auto bg-white shadow-lg rounded-lg border border-gray-200">
                    <header class="px-5 py-4 border-b border-gray-100">
                        <h2 class="font-semibold text-gray-800">Users Data</h2>
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
                                <tbody class="text-sm divide-y divide-gray-100">
                                    <c:forEach items="${requestScope.players}" var="p">
                                        <tr>
                                            <td class="p-2 whitespace-nowrap">${p.id}</td>
                                            <td class="p-2 whitespace-nowrap">
                                                <div class="flex items-center">
                                                    <div class="font-medium text-gray-800">${p.username}</div>
                                                </div>
                                            </td>
                                            <td class="p-2 whitespace-nowrap">
                                                <div class="text-left">${p.name}</div>
                                            </td>
                                            <td class="p-2 whitespace-nowrap">
                                                <div class="text-left font-medium text-green-500">
                                                    ${p.email}
                                                </div>
                                            </td>
                                            <td class="p-2 whitespace-nowrap">
                                                <div class="text-lg text-center">
                                                    <div class="flex item-center justify-center">
                                                        <div
                                                            class="cursor-pointer w-5 mr-2 transform hover:text-purple-500 hover:scale-110">
                                                            <i class="eye-icon fa-solid fa-eye"></i>
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
                                        <li class="page-item disabled"><a
                                                class="page-link relative block py-1.5 px-3 rounded border-0 bg-transparent outline-none transition-all duration-300 rounded text-gray-500 pointer-events-none focus:shadow-none"
                                                href="#" tabindex="-1" aria-disabled="true">Previous</a></li>
                                        <li class="page-item active"><a
                                                class="page-link relative block py-1.5 px-3 rounded border-0 bg-blue-600 outline-none transition-all duration-300 rounded text-white hover:text-white hover:bg-blue-600 shadow-md focus:shadow-md"
                                                href="#">1 <span class="visually-hidden">(current)</span></a></li>
                                        <li class="page-item"><a
                                                class="page-link relative block py-1.5 px-3 rounded border-0 bg-transparent outline-none transition-all duration-300 rounded text-gray-800 hover:text-gray-800 hover:bg-gray-200 focus:shadow-none"
                                                href="#">2</a></li>
                                        <li class="page-item"><a
                                                class="page-link relative block py-1.5 px-3 rounded border-0 bg-transparent outline-none transition-all duration-300 rounded text-gray-800 hover:text-gray-800 hover:bg-gray-200 focus:shadow-none"
                                                href="#">3</a></li>
                                        <li class="page-item"><a
                                                class="page-link relative block py-1.5 px-3 rounded border-0 bg-transparent outline-none transition-all duration-300 rounded text-gray-800 hover:text-gray-800 hover:bg-gray-200 focus:shadow-none"
                                                href="#">Next</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <!-- modal -->
        <div id="modal" class="hidden flex modal fixed inset-0">
            <div class="modal-overlay absolute w-full h-full bg-[rgba(0,0,0,0.3)]">
                <div class="mt-20 max-w-md mx-auto bg-white rounded-xl shadow-md overflow-hidden md:max-w-md">
                    <div class="md:flex relative">
                        <span class="absolute top-4 right-4">
                            <button id="btn-close" type="button"
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
                                <span class="text-2xl font-medium">Lindsey James</span>
                                <span class="text-md text-gray-400">@lindsey_jam3s</span>
                            </div>

                            <div class="mt-5 md:mt-0 md:col-span-2 px-4">
                                <form action="#" method="POST">
                                    <div class="shadow overflow-hidden sm:rounded-md">
                                        <div class="px-4 py-5 bg-white sm:p-6">
                                            <div class="grid grid-cols-6 gap-6">
                                                <div class="col-span-6 sm:col-span-3">
                                                    <label for=""
                                                           class="block text-sm font-medium text-gray-700">Name</label>
                                                    <input value="Tarik Novak"
                                                           class="mt-2 shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                                           id="numOfShip" type="text" placeholder="enter name user">
                                                </div>

                                                <div class="col-span-6 sm:col-span-3">
                                                    <label for="last_name"
                                                           class="block text-sm font-medium text-gray-700">Email</label>
                                                    <input value="alexshatov@gmail.com"
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
                                                    <input value="Silver"
                                                           class="bg-gray-100 mt-2 shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                                           disabled id="numOfShip" type="text"
                                                           placeholder="enter name user">
                                                </div>

                                                <div class="col-span-6 sm:col-span-3">
                                                    <label for="last_name"
                                                           class="block text-sm font-medium text-gray-700">Status</label>
                                                    <select id="countries_disabled"
                                                            class="focus:outline-none mt-2 py-2  border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                                                        <option value="US">Active</option>
                                                        <option value="CA">DeActive</option>
                                                    </select>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="px-4 py-3 bg-gray-50 text-right sm:px-6">
                                            <button type="submit"
                                                    class="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
                                                Update
                                            </button>
                                        </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
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