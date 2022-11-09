<%--
  Created by IntelliJ IDEA.
  User: Huu
  Date: 9/13/2022
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="utilities.GlobalConstants" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            sans: ["Inter", "sans-serif"],
                        },
                    },
                },
            };
        </script>
        <title>Sign Up Page</title>

        <style>
            html {
                scroll-behavior: smooth;
            }
        </style>
    </head>
    <body>

        <!-- component -->
        <div
            class="relative min-h-screen flex justify-center py-12 px-4 sm:px-6 lg:px-8 bg-gray-500 bg-no-repeat bg-cover items-center"
            style="
            background-image: url('./assets/img/2203_w023_n001_2016b_p1_2016.jpg')
            "
            >
            <div class="absolute bg-black opacity-60 inset-0 z-0"></div>
            <div
                style="
                background-image: url('https://img.freepik.com/premium-vector/beach-landscape-summer-day-background-illustration-with-ship-ocean-island_513217-161.jpg?w=2000');
                width: 100%;
                height: 100%;
                background-position: center;
                border-radius: 50px;
                "
                class="max-w-md w-full space-y-8 p-10 bg-white rounded-xl z-10"
                >
                <div class="text-center">
                    <h2 class="mt-6 text-3xl font-bold text-gray-900">Welcom To BattleShip!</h2>
                    
                    <p class="mt-2 text-sm text-gray-600">
                        Sign up new account
                    </p>
                    <h3 class="text-red-400 mt-6" style="text-align: center">${requestScope.error}</h3>
                </div>

                <form class="mt-8 space-y-6" action="register" method="POST" id="registerform"
                      oninput="repassword.setCustomValidity(repassword.value !== password.value ? 'Confirm password does not match': '')" 
                      >

                    <div class="relative">
                        <label class="text-sm font-bold text-gray-700 tracking-wide">Username</label>
                        <input
                            class="w-full text-base p-2 border-b rounded border-gray-300 focus:outline-none focus:border-indigo-500"
                            type="text" maxlength="64" required
                            minlength="8"
                            placeholder="Enter your username"
                            name="username"
                            />
                    </div>

                    <div class="relative">
                        <label class="text-sm font-bold text-gray-700 tracking-wide">Name</label>
                        <input
                            class="w-full text-base p-2 border-b rounded border-gray-300 focus:outline-none focus:border-indigo-500"
                            type="text"
                            required minlength="1" maxlength="64"
                            placeholder="Enter your name"
                            name="name"
                            />
                    </div>

                    <div class="relative">
                        <label class="text-sm font-bold text-gray-700 tracking-wide"
                               >Email</label
                        >
                        <input
                            class="w-full text-base p-2 border-b rounded border-gray-300 focus:outline-none focus:border-indigo-500"
                            type="email"
                            placeholder="mail@gmail.com"
                            name="email"
                            />
                    </div>

                    <div class="relative">
                        <label class="text-sm font-bold text-gray-700 tracking-wide">
                            Password
                        </label>
                        <input
                            class="w-full text-base p-2 border-b rounded border-gray-300 focus:outline-none focus:border-indigo-500"
                            type="password" id="password"
                            pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{8,16}$"
                            title="Your password must be 8 to 16 characters, contain both lowercase and uppercase"
                            placeholder="Enter your password"
                            name="password"
                            />
                    </div>

                    <div class="relative">
                        <label class="text-sm font-bold text-gray-700 tracking-wide">
                            Confirm Password
                        </label>
                        <input
                            class="w-full text-base p-2 border-b rounded border-gray-300 focus:outline-none focus:border-indigo-500"
                            type="password" id="repassword"
                            placeholder="Confirm your password"
                            />
                    </div>

                    <div>
                        <button
                            type="button" onclick="formSubmit()"
                            class="w-full flex justify-center bg-indigo-500 text-gray-100 p-4 rounded-full tracking-wide font-semibold focus:outline-none focus:shadow-outline hover:bg-indigo-600 shadow-lg cursor-pointer transition ease-in duration-300">
                            Sign Up
                        </button>
                    </div>

                    <div class="g-recaptcha" id="grecaptcha" data-sitekey="<%= GlobalConstants.GOOGLE_RECAPTCHA_SITE_KEY%>" hidden data-callback="onSubmit"></div>

                    <p class="flex flex-col items-center justify-center mt-10 text-center text-md text-gray-500"  >
                        <span>Already have an account?</span>
                        <a
                            href="login"
                            class="text-indigo-500 hover:text-indigo-500no-underline hover:underline cursor-pointer transition ease-in duration-300"
                            >Sign In</a
                        >
                    </p>
                </form>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
    </body>
    <script>
                                function onSubmit() {
                                    document.getElementById('registerform').submit();
                                }

                                function formSubmit() {
                                    const form = document.getElementById('registerform');
                                    if (form.checkValidity()) {
                                        document.getElementById('grecaptcha').hidden = false;
                                        //grecaptcha.execute();
                                    } else {
                                        form.reportValidity();
                                    }
                                }
    </script>
</html>
