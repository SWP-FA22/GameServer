<%-- 
    Document   : login
<<<<<<< HEAD
    Created on : Sep 18, 2022, 7:18:10 AM
=======
    Created on : Sep 16, 2022, 11:41:30 PM
>>>>>>> ac73f8226ad5a704f546f499f65a1ed98b5d7003
    Author     : LinhThuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<<<<<<< HEAD
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
    <!--navbar-->
    <nav
      class="bg-white border-gray-200 px-10 sm:px-4 py-2.5 rounded font-['Open-Sans'] cursor-pointer"
    >
      <div
        class="container flex flex-wrap items-center justify-between mx-auto"
      >
        <a href="https://flowbite.com/" class="flex items-center">
          <img
            src="../assets/img/logo.png"
            class="ml-20 mr-4 h-9 sm:h-9"
            alt="logo"
          />
        </a>
        <button
          id="btn-menu"
          data-collapse-toggle="navbar-default"
          type="button"
          class="inline-flex items-center p-2 ml-3 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
          aria-controls="navbar-default"
          aria-expanded="false"
        >
          <span class="sr-only">Open main menu</span>
          <svg
            class="w-6 h-6"
            aria-hidden="true"
            fill="currentColor"
            viewBox="0 0 20 20"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z"
              clip-rule="evenodd"
            ></path>
          </svg>
        </button>
        <div class="hidden w-full md:block md:w-auto" id="navbar-default">
          <ul
            class="flex flex-col p-4 mt-4 bg-gray-50 rounded-lg border border-gray-100 md:flex-row md:space-x-8 md:mt-0 md:text-md md:font-medium md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700"
          >
            <li>
              <a
                href="/pages/home.html"
                active-class="text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
                class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
              >
                Home</a
              >
            </li>
            <li>
              <a
                href="/pages/index.jsp"
                active-class="text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
                class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
              >
                Download Game</a
              >
            </li>
            <li>
              <a
                href="#about-us"
                v-smooth-scroll
                active-class="text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
                class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
              >
                About Us</a
              >
            </li>
            <li>
              <a
                href="/pages/index.jsp"
                active-class="text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
                class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
              >
                Purchase</a
              >
            </li>
            <li>
              <a
                href="/pages/home.html"
                active-class="text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
                class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
              >
                Redeem/GiftCode</a
              >
            </li>
            <li>
              <a
                href="/pages/home.html"
                class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
              >
                Game Database</a
              >
            </li>
            <li>
              <a
                href="/pages/login.html"
                active-class="text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
                class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
              >
                Login/Register</a
              >
            </li>
          </ul>
        </div>
      </div>
    </nav>

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
          <h2 class="mt-6 text-3xl font-bold text-gray-900">Welcom Back!</h2>
          <p class="mt-2 text-sm text-gray-600">
            Please sign in to your account
          </p>
        </div>

          <form class="mt-8 space-y-6" action="login" method="POST" id="login-form">
        
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
              type=""
              placeholder="Enter your username" 
              value="" name="username" id="username" class="form-control"
            />
          </div>
          
          <div class="mt-8 content-center">
            <label class="text-sm font-bold text-gray-700 tracking-wide">
              Password
            </label>
            <input
              class="w-full content-center text-base py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
              type="password"
              placeholder="Enter your password"
              value="" name="password" id="password" class="form-control"
            />
          </div>
          <div class="flex items-center justify-between">
            <div class="flex items-center">
              <input
                id="remember_me"
                name="remember_me"
                type="checkbox"
                class="h-4 w-4 bg-indigo-500 focus:ring-indigo-400 border-gray-300 rounded"
              />
              <label for="remember_me" class="ml-2 block text-sm text-gray-900">
                Remember me
              </label>
            </div>
          </div>
          <div>
            <button
                type="submit" name="submit"
              class="w-full flex justify-center bg-indigo-500 text-gray-100 p-4 rounded-full tracking-wide font-semibold focus:outline-none focus:shadow-outline hover:bg-indigo-600 shadow-lg cursor-pointer transition ease-in duration-300"
            >
              Sign in
            </button>
          </div>
          <p
            class="flex flex-col items-center justify-center mt-10 text-center text-md text-gray-500"
          >
            <span>Don't have an account?</span>
            <a
              href="/pages/signup.html"
              class="text-indigo-500 hover:text-indigo-500no-underline hover:underline cursor-pointer transition ease-in duration-300"
              >Sign up</a
            >
          </p>
        </form>
      </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
    <script src="../script/home.js"></script>
  </body>
</html>

=======
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
        <!--navbar-->
        <nav
            class="bg-white border-gray-200 px-10 sm:px-4 py-2.5 rounded font-['Open-Sans'] cursor-pointer"
            >
            <div
                class="container flex flex-wrap items-center justify-between mx-auto"
                >
                <a href="https://flowbite.com/" class="flex items-center">
                    <img
                        src="../assets/img/logo.png"
                        class="ml-20 mr-4 h-9 sm:h-9"
                        alt="logo"
                        />
                </a>
                <button
                    id="btn-menu"
                    data-collapse-toggle="navbar-default"
                    type="button"
                    class="inline-flex items-center p-2 ml-3 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
                    aria-controls="navbar-default"
                    aria-expanded="false"
                    >
                    <span class="sr-only">Open main menu</span>
                    <svg
                        class="w-6 h-6"
                        aria-hidden="true"
                        fill="currentColor"
                        viewBox="0 0 20 20"
                        xmlns="http://www.w3.org/2000/svg"
                        >
                    <path
                        fill-rule="evenodd"
                        d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z"
                        clip-rule="evenodd"
                        ></path>
                    </svg>
                </button>
                <div class="hidden w-full md:block md:w-auto" id="navbar-default">
                    <ul
                        class="flex flex-col p-4 mt-4 bg-gray-50 rounded-lg border border-gray-100 md:flex-row md:space-x-8 md:mt-0 md:text-md md:font-medium md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700"
                        >
                        <li>
                            <a
                                href="/pages/home.html"
                                active-class="text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
                                class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
                                >
                                Home</a
                            >
                        </li>
                        <li>
                            <a
                                href="/pages/home.html"
                                active-class="text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
                                class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
                                >
                                Download Game</a
                            >
                        </li>
                        <li>
                            <a
                                href="#about-us"
                                v-smooth-scroll
                                active-class="text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
                                class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
                                >
                                About Us</a
                            >
                        </li>
                        <li>
                            <a
                                href="/pages/home.html"
                                active-class="text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
                                class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
                                >
                                Purchase</a
                            >
                        </li>
                        <li>
                            <a
                                href="/pages/home.html"
                                active-class="text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
                                class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
                                >
                                Redeem/GiftCode</a
                            >
                        </li>
                        <li>
                            <a
                                href="/pages/home.html"
                                class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
                                >
                                Game Database</a
                            >
                        </li>
                        <li>
                            <a
                                href="/pages/login.html"
                                active-class="text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
                                class="block py-2 pr-4 pl-3 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent"
                                >
                                Login/Register</a
                            >
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

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
                    <h2 class="mt-6 text-3xl font-bold text-gray-900">Welcom Back!</h2>
                    <p class="mt-2 text-sm text-gray-600">
                        Please sign in to your account
                    </p>
                </div>

                <form class="mt-8 space-y-6" action="LoginServlet" method="POST">
                    <input type="hidden" name="username" value="true" />
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
                            type=""
                            placeholder="Enter your username"
                            value=""
                            />
                    </div>

                    <div class="mt-8 content-center">
                        <label class="text-sm font-bold text-gray-700 tracking-wide">
                            Password
                        </label>
                        <input
                            class="w-full content-center text-base py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
                            type=""
                            placeholder="Enter your password"
                            value=""
                            />
                    </div>
                    <div class="flex items-center justify-between">
                        <div class="flex items-center">
                            <input
                                id="remember_me"
                                name="remember_me"
                                type="checkbox"
                                class="h-4 w-4 bg-indigo-500 focus:ring-indigo-400 border-gray-300 rounded"
                                />
                            <label for="remember_me" class="ml-2 block text-sm text-gray-900">
                                Remember me
                            </label>
                        </div>
                    </div>
                    <div>
                        <button
                            type="submit"
                            class="w-full flex justify-center bg-indigo-500 text-gray-100 p-4 rounded-full tracking-wide font-semibold focus:outline-none focus:shadow-outline hover:bg-indigo-600 shadow-lg cursor-pointer transition ease-in duration-300"
                            >
                            Sign in
                        </button>
                    </div>
                    <p
                        class="flex flex-col items-center justify-center mt-10 text-center text-md text-gray-500"
                        >
                        <span>Don't have an account?</span>
                        <a
                            href="/pages/signup.html"
                            class="text-indigo-500 hover:text-indigo-500no-underline hover:underline cursor-pointer transition ease-in duration-300"
                            >Sign up</a
                        >
                    </p>
                </form>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
        <script src="../script/home.js"></script>
    </body>
</html>
>>>>>>> ac73f8226ad5a704f546f499f65a1ed98b5d7003
