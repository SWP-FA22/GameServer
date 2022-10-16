<%-- 
    Document   : top-ranking
    Created on : Oct 16, 2022, 10:46:59 AM
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;600;700&display=swap" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tw-elements/dist/css/index.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
        integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/fontawesome.min.css"
        integrity="sha512-8Vtie9oRR62i7vkmVUISvuwOeipGv8Jd+Sur/ORKDD5JiLgTGeBSkI3ISOhc730VGvA5VVQPwKIKlmi+zMZ71w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
    <title>User Ranking</title>

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

    <%@include file="components/navbar.jsp" %>
    <section id="pricing" class="bg-gray-100 py-8">
        <div class="container mx-auto px-2 pt-4 pb-12 text-gray-800">
            <h2 class="w-full my-2 text-3xl font-black leading-tight text-center text-gray-800">
                User Ranking
            </h2>
            <div class="w-full mb-4">
                <div class="h-1 mx-auto gradient w-64 opacity-25 my-0 py-0 rounded-t"></div>
            </div>

<!--            <div class="flex flex-col sm:flex-row justify-center pt-12 my-12 sm:my-4">
                <div class="flex flex-col w-5/6 lg:w-1/4 mx-auto lg:mx-0 rounded-none lg:rounded-l-lg bg-white mt-4">
                    <div class="flex-1 bg-white text-gray-600 rounded-t rounded-b-none overflow-hidden shadow">
                        <div class="p-8 text-3xl font-bold text-center ">
                            Top 2
                        </div>
                        <div>
                            <img src="https://www.fcbarcelona.com/photo-resources/2022/07/24/f47cd134-efc4-4f90-943d-41ad2443d4f1/jugador_fitxa-lewan.jpg?width=1200&height=750"
                                alt="Product" class="h-80 w-full object-contain " />
                        </div>
                    </div>
                    <div class="flex-none mt-auto bg-white rounded-b rounded-t-none overflow-hidden shadow p-6">
                        <div class="w-full pt-6 text-3xl text-gray-600 text-center">
                            <p class="text-lg"> <span class="font-bold">Username</span> : </p>
                            <p class="text-lg"> <span class="font-bold">Email</span> : ronaldo@gmail.com</p>
                        </div>
                        <div class="flex items-center justify-center">
                            <button
                                class="disabled mx-auto lg:mx-0 hover:cursor-default gradient2 text-gray-800 font-bold rounded my-6 py-4 px-8 shadow-lg">
                                Point : 680
                            </button>
                        </div>
                    </div>
                </div>

                <div
                    class="flex flex-col w-5/6 lg:w-1/3 mx-auto lg:mx-0 rounded-lg bg-white mt-4 sm:-mt-6 gradient shadow hover:shadow-lg z-10">
                    <div class="flex-1 rounded-t rounded-b-none overflow-hidden">
                        <div class="flex items-center mt-4">
                            <div class="w-full p-8 text-3xl font-bold text-center">
                                Top 1
                            </div>
                        </div>
                        <div>
                            <img src="https://www.si.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTkyODQzNDMxOTA1NjAxMjMy/lionel-messi.jpg"
                                alt="Product" class="h-80 w-full object-contain " />
                        </div>
                    </div>
                    <div class="flex-none mt-auto rounded-b rounded-t-none overflow-hidden p-6">
                        <div class="w-full pt-6 text-4xl  text-center">
                            <p class="text-lg"> <span class="font-bold">Username</span> : LionelMessi</p>
                            <p class="text-lg"> <span class="font-bold">Email</span> : messi@gmail.com</p>
                        </div>
                        <div class="flex items-center justify-center">
                            <router-link to="/register">
                                <button
                                    class="mx-auto lg:mx-0 hover:cursor-default disabled gradient2 text-gray-800 font-bold rounded my-6 py-4 px-8 shadow-lg">
                                    Point : 700
                                </button>
                            </router-link>
                        </div>
                    </div>
                </div>

                <div class="flex flex-col w-5/6 lg:w-1/4 mx-auto lg:mx-0 rounded-none lg:rounded-l-lg bg-white mt-4">
                    <div class="flex-1 bg-white text-gray-600 rounded-t rounded-b-none overflow-hidden shadow">
                        <div class="p-8 text-3xl font-bold text-center ">
                            Top 3
                        </div>
                        <div>
                            <img src="https://s.hs-data.com/bilder/spieler/gross/354576.jpg?fallback=png" alt="Product"
                                class="h-80 w-full object-contain " />
                        </div>
                    </div>
                    <div class="flex-none mt-auto bg-white rounded-b rounded-t-none overflow-hidden shadow p-6">
                        <div class="w-full pt-6 text-4xl  text-center">
                            <p class="text-lg"> <span class="font-bold">Username</span> : Haland</p>
                            <p class="text-lg"> <span class="font-bold">Email</span> : haland@gmail.com</p>
                        </div>
                        <div class="flex items-center justify-center">
                            <router-link to="/register">
                                <button
                                    class="mx-auto lg:mx-0 hover:cursor-default disabled gradient2 text-gray-800 font-bold rounded my-6 py-4 px-8 shadow-lg">
                                    Point : 650
                                </button>
                            </router-link>
                        </div>
                    </div>
                </div>-->
            </div>
        </div>
       
            
               <div class="flex flex-col justify-center h-full">
            <!-- Table -->
            <div class="w-full max-w-6xl mx-auto bg-white shadow-lg rounded-lg border border-gray-200">
                <header class="px-5 py-4 border-b border-gray-100">
                    <h2 class="font-semibold text-gray-800">Users Ranking</h2>
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
                                        <div class="font-semibold text-left">Rank</div>
                                    </th>
<!--                                    <th class="p-2 whitespace-nowrap">
                                        <div class="font-semibold text-left">Point</div>
                                    </th>-->
                                </tr>
                            </thead>
                            
                            <c:forEach items ="${requestScope.listtop}" var = "listtop">   
                      
                            <tbody class="text-sm divide-y divide-gray-100">
                                <tr>
                                    <td class="p-2 whitespace-nowrap">${listtop.id}</td>
                                    <td class="p-2 whitespace-nowrap">
                                        <div class="flex items-center">
<!--                                            <div class="w-10 h-10 flex-shrink-0 mr-2 sm:mr-3">
                                                <img class="rounded-full"
                                                    src="https://raw.githubusercontent.com/cruip/vuejs-admin-dashboard-template/main/src/images/user-36-05.jpg"
                                                    width="40" height="40" alt="Alex Shatov" />
                                            </div>-->
                                            <div class="font-medium text-gray-800">${listtop.username}</div>
                                        </div>
                                    </td>
                                    <td class="p-2 whitespace-nowrap">
                                        <div class="text-left">${listtop.name}</div>
                                    </td>
                                    <td class="p-2 whitespace-nowrap">
                                        <div class="text-left font-medium text-green-500">
                                            ${listtop.email}
                                        </div>
                                    </td>
                                    <td class="p-2 whitespace-nowrap">
                                        <div class="text-left">${listtop.rank}</div>
                                    </td>
<!--                                    <td class="p-2 whitespace-nowrap">
                                        <div class="text-left">620</div>
                                    </td>-->
                                </tr>
                                
                                 </c:forEach>

                            </tbody>
                        </table>
                        
                        
                        <!--pagination-->
<!--                        <div class="mt-8 flex justify-center">
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
                        </div>-->
                    </div>
                </div>
            </div>
        </div>
       
     
        <!--footer-->
        <%@include file="components/footer.jsp" %>
    </section>





    <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
    <script src="../script/home.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
        const btn_profile = document.querySelectorAll('.btn-profile');
        const body = document.querySelector('body');
        const btn_close = document.querySelector('#btn-close');

        btn_profile.forEach((item) => {
            {
                item.addEventListener('click', () => {
                    const modal = document.querySelector('#modal');
                    modal.classList.toggle('hidden');
                    body.classList.toggle('overflow-hidden');
                })
            }
        })


        btn_close.addEventListener('click', () => {
            const modal = document.querySelector('#modal');
            modal.classList.toggle('hidden');
            body.classList.toggle('overflow-hidden');
        })


    </script>
</body>

</html>