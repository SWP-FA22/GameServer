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
    </head>
    <script>
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
<body class="bg-grey-200">
    <%@include file="components/navbar.jsp" %>

    <div class="p-3 text-center" style="position: absolute ; right: 150px; width: 200px; height: 120px;">
        <span class="text-xl font-bold block uppercase tracking-wide text-slate-700">${diamondAmount}</span>
        <span class="text-sm text-slate-400">Diamond Amount</span>
    </div>

    <h1 class="text-center text-3xl my-20 font-bold"t>${p.name}</h1>

    <div class="relative max-w-md mx-auto md:max-w-2xl min-w-0 break-words bg-white w-full mb-6 shadow-lg rounded-xl mt-36">
        <div class="px-6">
            <div class="flex flex-wrap justify-center">
                <div class="w-full flex justify-center">
                    <div class="relative">
                        <img
                            src="https://github.com/creativetimofficial/soft-ui-dashboard-tailwind/blob/main/build/assets/img/team-2.jpg?raw=true"
                            class="shadow-xl rounded-full align-middle border-none absolute -m-16 -ml-20 lg:-ml-16 max-w-[150px]"
                            />
                    </div>
                </div>


                <div class="w-full text-center mt-20">
                    <div class="flex justify-center lg:pt-4 pt-8 pb-0">
                        <div class="p-3 text-center">
                            <span
                                class="text-xl font-bold block uppercase tracking-wide text-slate-700"
                                >${numberOfShip}</span
                            >
                            <span class="text-sm text-slate-400">Number Of Ship</span>
                        </div>
                        <div class="p-3 text-center">
                            <span
                                class="text-xl font-bold block uppercase tracking-wide text-slate-700"
                                >${numberOfItem}</span>
                            <span class="text-sm text-slate-400">Number Of Item</span>
                        </div>

                        <div class="p-3 text-center">
                            <span
                                class="text-xl font-bold block uppercase tracking-wide text-slate-700"
                                >${player.rank}</span
                            >
                            <span class="text-sm text-slate-400">Ranking Point</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--                <div class="text-center mt-2 py-8">
                            <h3 class="text-2xl text-slate-700 font-bold leading-normal mb-1">
        
                            </h3>
                            <div class="text-xs mt-0 mb-2 text-slate-400 text-base"></div>
                            <i class="fa fa-user mr-2 text-slate-400 opacity-75"></i
                            ><span>Username: ${p.username}</span><span id="username" ></span>           
        -->


        <section class="vh-100" style="background-color: #eee;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-md-12 col-xl-4">

                        <div class="card" style="border-radius: 15px;">
                            <div class="card-body text-center">


                                <div class="text-center mt-2 py-8">
                                    <h3 class="text-2xl text-slate-700 font-bold leading-normal mb-1">

                                    </h3>
                                    <div class="text-xs mt-0 mb-2 text-slate-400 text-base"></div>
                                    <i class="fa fa-user mr-2 text-slate-400 opacity-75"></i
                                    ><span>Username: ${player.username}</span><span id="username" ></span>           


                                    <!-- <div class="mt-3 mb-4">
                                     <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2-bg.webp"
                                      class="rounded-circle img-fluid" style="width: 100px;" />
                                       </div>-->
                                    <h4 class="mb-2"></h4>
                                    <p class="text-muted mb-4">Name: ${player.name} <span class="mx-2"></span> <a
                                            href="#!"></a></p>

                                    <button type="button" class="btn btn-primary btn-rounded btn-lg">
                                        Email: ${player.email}
                                    </button>
                                    <!--                                <div class="d-flex justify-content-between text-center mt-5 mb-2">
                                                                        <div>
                                                                            <p class="mb-2 h5"></p>
                                                                            <p class="text-muted mb-0">Wallets Balance</p>
                                                                        </div>
                                                                        <div class="px-3">
                                                                            <p class="mb-2 h5">8512</p>
                                                                            <p class="text-muted mb-0">Income amounts</p>
                                                                        </div>
                                                                        <div>
                                                                            <p class="mb-2 h5">4751</p>
                                                                            <p class="text-muted mb-0">Total Transactions</p>
                                                                        </div>
                                                                    </div>-->
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
        <script src="../script/home.js"></script>
    </div>
</body>
</html>