<template>
    <!-- component -->
    <div class="relative min-h-screen flex  justify-center  py-12 px-4 sm:px-6 lg:px-8 bg-gray-500 bg-no-repeat bg-cover items-center"
        style="background-image: url(https://wallpapercave.com/dwp1x/wp2429392.jpg);">
        <div class="absolute bg-black opacity-60 inset-0 z-0"></div>
        <div class="max-w-md w-full space-y-8 p-10 bg-white rounded-xl z-10">
            <div class="text-center">
                <h2 class="mt-6 text-3xl font-bold text-gray-900">
                    Welcom Back!
                </h2>
                <p class="mt-2 text-sm text-gray-600">Please sign in to your account</p>
            </div>
           
           
            <form class="mt-8 space-y-6" action="#" method="POST">
                <input type="hidden" name="username" value="true">
                <div class="relative">
                    <div class="absolute right-0 mt-4"><svg xmlns="http://www.w3.org/2000/svg"
                            class="h-6 w-6 text-green-500" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                        </svg>
                    </div>
                    <label class="text-sm font-bold text-gray-700 tracking-wide">Username</label>
                    <input
                        class=" w-full text-base py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
                        type="" placeholder="Enter your username" value="">
                </div>
                <div class="relative">
                    <div class="absolute right-0 mt-4"><svg xmlns="http://www.w3.org/2000/svg"
                            class="h-6 w-6 text-green-500" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                        </svg>
                    </div>
                    <label class="text-sm font-bold text-gray-700 tracking-wide">Email</label>
                    <input
                        class=" w-full text-base py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
                        type="" placeholder="mail@gmail.com" value="">
                </div>
                <div class="mt-8 content-center">
                    <label class="text-sm font-bold text-gray-700 tracking-wide">
                        Password
                    </label>
                    <input
                        class="w-full content-center text-base py-2 border-b border-gray-300 focus:outline-none focus:border-indigo-500"
                        type="" placeholder="Enter your password" value="">
                </div>
                <div class="flex items-center justify-between">
                    <div class="flex items-center">
                        <input id="remember_me" name="remember_me" type="checkbox"
                            class="h-4 w-4 bg-indigo-500 focus:ring-indigo-400 border-gray-300 rounded">
                        <label for="remember_me" class="ml-2 block text-sm text-gray-900">
                            Remember me
                        </label>
                    </div>
                </div>
                <div>
                    <button type="submit"
                        class="w-full flex justify-center bg-indigo-500 text-gray-100 p-4  rounded-full tracking-wide
                                font-semibold  focus:outline-none focus:shadow-outline hover:bg-indigo-600 shadow-lg cursor-pointer transition ease-in duration-300">
                        Sign in
                    </button>
                </div>
                <p class="flex flex-col items-center justify-center mt-10 text-center text-md text-gray-500">
                    <span>Don't have an account?</span>
                    <a href="#"
                        class="text-indigo-500 hover:text-indigo-500no-underline hover:underline cursor-pointer transition ease-in duration-300">Sign
                        up</a>
                </p>
            </form>
        </div>
    </div>
</template>

<script>
export default {


}
</script>

<style>

</style>