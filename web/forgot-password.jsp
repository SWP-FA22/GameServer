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
        <title>Login Page</title>

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
                    <h2 class="mt-6 text-3xl font-bold text-gray-900">Forgot password</h2>
                    <h3 class="text-red-400 mt-6" style="text-align: center">${requestScope.error}</h3>
                </div>

                <form class="mt-8 space-y-6"  action="forgot" method="POST">
                    
                    <div class="mt-8 content-center">
                        <label class="text-sm font-bold text-gray-700 tracking-wide">
                            Email
                        </label>
                        <input
                            class="w-full content-center text-base p-2 border-b rounded border-gray-300 focus:outline-none focus:border-indigo-500"
                            type="email"
                            placeholder="Enter your email"
                            value="" name="email" id="email" class="form-control"
                            required
                            />
                    </div>
                    <div>
                        <button
                            type="submit" name="submit"
                            class="w-full flex justify-center bg-indigo-500 text-gray-100 p-4 rounded-full tracking-wide font-semibold focus:outline-none focus:shadow-outline hover:bg-indigo-600 shadow-lg cursor-pointer transition ease-in duration-300"
                            >
                            Get password
                        </button>
                    </div>

                    <p class="flex flex-col items-center justify-center mt-10 text-center text-md text-gray-500">
                        <span>Remember your password?</span>
                        <a
                            href="login"
                            class="text-indigo-500 hover:text-indigo-500no-underline hover:underline cursor-pointer transition ease-in duration-300"
                            >Sign in</a
                        >
                    </p>
                </form>
            </div>

        </div>

        <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
        <script src="./script/home.js"></script>
    </body>
</html>