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
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
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
        <%@include file="components/navbar.jsp" %>

        <!-- component -->
        <div
            class="relative min-h-screen flex justify-center py-12 px-4 sm:px-6 lg:px-8 bg-gray-500 bg-no-repeat bg-cover items-center"
            style="
            background-image: url(https://wallpapercave.com/dwp1x/wp2429392.jpg);
            "
            >
            <div class="absolute bg-black opacity-60 inset-0 z-0"></div>
            <div class="max-w-md w-full space-y-8 p-10 bg-white rounded-xl z-10">
                <div class="text-center">
                    <h2 class="mt-6 text-3xl font-bold text-gray-900">Sign Up</h2>
                    <p class="mt-2 text-sm text-gray-600">
                        Enter your information to register
                    </p>
                    <label class="text-sm font-bold text-gray-700 tracking-wide">
                            ${requestScope.error}
                        </label>
                </div>

                <form class="mt-8 space-y-6" action="register" method="POST" id="registerform"
                      oninput="repassword.setCustomValidity(repassword.value !== password.value ? 'Confirm password does not match': '')" 
                      >

                    <div class="relative">
                        <div class="absolute right-0 mt-4">
                            <svg
                                xmlns="http://www.w3.org/2000/svg"
                                class="h-6 w-6 text-green-500"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke="currentColor"
                                >
                                <path
                                    stroke-linecap="round"
                                    stroke-linejoin="round"
                                    stroke-width="2"
                                    d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"
                                    ></path>
                            </svg>
                        </div>
                        <label class="text-sm font-bold text-gray-700 tracking-wide"
                               >Username</label
                        >
                        <input
                            class="w-full text-base py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
                            type="text"
                            placeholder="Enter your username"
                            name="username"
                            />
                        <label class="text-sm font-bold text-gray-700 tracking-wide"
                               >Name</label
                        >
                        <input
                            class="w-full text-base py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
                            type="text"
                            placeholder="Enter your name"
                            name="name"
                            />
                    </div>
                    <div class="relative">
                        <div class="absolute right-0 mt-4">
                            <svg
                                xmlns="http://www.w3.org/2000/svg"
                                class="h-6 w-6 text-green-500"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke="currentColor"
                                >
                                <path
                                    stroke-linecap="round"
                                    stroke-linejoin="round"
                                    stroke-width="2"
                                    d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"
                                    ></path>
                            </svg>
                        </div>
                        <label class="text-sm font-bold text-gray-700 tracking-wide"
                               >Email</label
                        >
                        <input
                            class="w-full text-base py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
                            type="email"
                            placeholder="mail@gmail.com"
                            name="email"
                            />
                    </div>
                    <div class="mt-8 content-center">
                        <label class="text-sm font-bold text-gray-700 tracking-wide">
                            Password
                        </label>
                        <input
                            class="w-full content-center text-base py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
                            type="password" id="password"
                            placeholder="Enter your password"
                            name="password"
                            />
                    </div>
                    <div class="mt-8 content-center">
                        <label class="text-sm font-bold text-gray-700 tracking-wide">
                            Confirm Password
                        </label>
                        <input
                            class="w-full content-center text-base py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
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
