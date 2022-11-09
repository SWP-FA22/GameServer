<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                            roboto: ["Roboto", "sans-serif"],
                        },
                    },
                },
            };
        </script>
        <title>Home Page</title>

        <style>
            .dropdown:hover .dropdown-content {
  display: block;
}
            html {
                scroll-behavior: smooth;
            }
        </style>
    </head>
    <body>
        <!--navbar-->
        <%@include file="components/navbar.jsp" %>

        <!--carousel-->
        <div
            id="carouselExampleCaptions"
            class="carousel slide relative"
            data-bs-ride="carousel"
            >
            <div
                class="carousel-indicators absolute right-0 bottom-0 left-0 flex justify-center p-0 mb-4"
                >
                <button
                    type="button"
                    data-bs-target="#carouselExampleCaptions"
                    data-bs-slide-href="0"
                    class="active"
                    aria-current="true"
                    aria-label="Slide 1"
                    ></button>
                <button
                    type="button"
                    data-bs-target="#carouselExampleCaptions"
                    data-bs-slide-href="1"
                    aria-label="Slide 2"
                    ></button>
                <button
                    type="button"
                    data-bs-target="#carouselExampleCaptions"
                    data-bs-slide-href="2"
                    aria-label="Slide 3"
                    ></button>
            </div>
            <div class="carousel-inner relative w-full overflow-hidden">
                <div class="carousel-item active relative float-left w-full">
                    <img
                        src="https://mdbootstrap.com/img/Photos/Slides/img%20(15).jpg"
                        class="block w-full"
                        alt="..."
                        />
                    <div class="carousel-caption hidden md:block absolute text-center">
                        <h5 class="text-xl">First slide label</h5>
                        <p>Some representative placeholder content for the first slide.</p>
                    </div>
                </div>
                <div class="carousel-item relative float-left w-full">
                    <img
                        src="https://mdbootstrap.com/img/Photos/Slides/img%20(22).jpg"
                        class="block w-full"
                        alt="..."
                        />
                    <div class="carousel-caption hidden md:block absolute text-center">
                        <h5 class="text-xl">Second slide label</h5>
                        <p>Some representative placeholder content for the second slide.</p>
                    </div>
                </div>
                <div class="carousel-item relative float-left w-full">
                    <img
                        src="https://mdbootstrap.com/img/Photos/Slides/img%20(23).jpg"
                        class="block w-full"
                        alt="..."
                        />
                    <div class="carousel-caption hidden md:block absolute text-center">
                        <h5 class="text-xl">Third slide label</h5>
                        <p>Some representative placeholder content for the third slide.</p>
                    </div>
                </div>
            </div>
            <button
                class="carousel-control-prev absolute top-0 bottom-0 flex items-center justify-center p-0 text-center border-0 hover:outline-none hover:no-underline focus:outline-none focus:no-underline left-0"
                type="button"
                data-bs-target="#carouselExampleCaptions"
                data-bs-slide="prev"
                >
                <span
                    class="carousel-control-prev-icon inline-block bg-no-repeat"
                    aria-hidden="true"
                    ></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button
                class="carousel-control-next absolute top-0 bottom-0 flex items-center justify-center p-0 text-center border-0 hover:outline-none hover:no-underline focus:outline-none focus:no-underline right-0"
                type="button"
                data-bs-target="#carouselExampleCaptions"
                data-bs-slide="next"
                >
                <span
                    class="carousel-control-next-icon inline-block bg-no-repeat"
                    aria-hidden="true"
                    ></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

        <!--about-us-->
        <section id="about-us" class="relative w-full h-1/2 bg-gray-50">
            <div class="container mx-auto p-4 pb-24 h-auto">
                <div class="flex content-center items-center justify-center h-48">
                    <h2 class="text-4xl font-extrabold font-['Open_Sans'] my-10">
                        About Us
                    </h2>
                </div>
                <div
                    class="flex flex-wrap md:space-x-12 space-y-4 content-center items-center justify-center h-3/4"
                    >
                    <div class="flex justify-center">
                        <div
                            class="block rounded-lg shadow-lg bg-white max-w-sm max-h-md text-center"
                            >
                            <div class="p-6">
                                <img
                                    class="mx-auto mb-4"
                                    src="./assets/img/game-store.svg"
                                    width="150"
                                    alt="logo"
                                    />
                                <h5 class="text-gray-900 text-xl font-medium mb-2">
                                    Electronic Sports
                                </h5>
                                <p class="text-gray-700 text-base mb-4">
                                    Garena is the organizer of major eSports tournaments and
                                    events in Southeast Asia, aiming to develop the gaming
                                    community.
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="flex justify-center">
                        <div
                            class="block rounded-lg shadow-lg bg-white max-w-sm max-h-md text-center"
                            >
                            <div class="p-6">
                                <img
                                    class="mx-auto mb-4"
                                    src="./assets/img/game.svg"
                                    width="150"
                                    alt="logo"
                                    />
                                <h5 class="text-gray-900 text-xl font-medium mb-2">Game</h5>
                                <p class="text-gray-700 text-base mb-4">
                                    Garena is a leading game publisher in Southeast Asia. With the
                                    platform we provide, users can experience the most engaging
                                    and exciting online games on both PC and mobile.
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="flex justify-center">
                        <div
                            class="block rounded-lg shadow-lg bg-white max-w-sm max-h-md text-center"
                            >
                            <div class="p-6">
                                <img
                                    class="mx-auto mb-4"
                                    src="./assets/img/connect.svg"
                                    width="150"
                                    alt="logo"
                                    />
                                <h5 class="text-gray-900 text-xl font-medium mb-2">
                                    Community
                                </h5>
                                <p class="text-gray-700 text-base mb-4">
                                    Players can connect with each other through the Garena
                                    platform, update the latest information from the community.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--game image-->
        <img
            src="./assets/img/wallpaperflare.com_wallpaper.jpg"
            class="w-full h-auto object-cover"
            />

        <%@include file="components/footer.jsp" %>

        <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
        <script src="./script/home.js"></script>
    </body>
</html>

