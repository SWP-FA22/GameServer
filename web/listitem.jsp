<%-- 
    Document   : listitem
    Created on : Sep 27, 2022, 10:37:14 AM
    Author     : Huu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;600;700&display=swap"
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
        animation: hover_item .3s ease-out forwards;
        cursor: pointer;
      }

      @keyframes hover_item {
        from {
          transform : translateY(0);
        }

        to {
          transform : translateY(-20px);
        }
      }
    </style>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>

        <div class="relative">
            <img
                src="https://images5.alphacoders.com/106/1066686.jpg"
                class="object-fit w-full h-[25rem]"
                />
        </div>

        <form method="get">
            <div class="flex justify-center mt-8 ">
                <div class="mb-3 xl:w-96">
                    <div class="input-group relative flex flex-wrap items-stretch w-full mb-4">
                        <input type="search" class="form-control relative flex-auto min-w-0 block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none" placeholder="Search Item" aria-label="Search" aria-describedby="button-addon2">
                        <button class="btn inline-block px-6 py-2.5 bg-blue-600 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-blue-700 hover:shadow-lg focus:bg-blue-700  focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out flex items-center" type="button" id="button-addon2">
                            <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="search" class="w-4" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                            <path fill="currentColor" d="M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z"></path>
                            </svg>
                        </button>
                    </div>
                </div>



            </div>

            <div class="flex items-center mx-auto justify-center">
                <div class="flex justify-center mx-8">
                    <div class="mb-3 xl:w-96">
                        <select class="form-select appearance-none
                                block
                                w-full
                                px-3
                                py-1.5
                                text-base
                                font-normal
                                text-gray-700
                                bg-white bg-clip-padding bg-no-repeat
                                border border-solid border-gray-300
                                rounded
                                transition
                                ease-in-out
                                m-0
                                focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none" aria-label="Default select example">
                            <option selected>Select equipment properties</option>
                            <option value="1">Attack</option>
                            <option value="2">Defense</option>
                        </select>
                    </div>
                </div>
                <div class="flex justify-center">
                    <div class="mb-3 xl:w-96">
                        <select class="form-select appearance-none
                                block
                                w-full
                                px-3
                                py-1.5
                                text-base
                                font-normal
                                text-gray-700
                                bg-white bg-clip-padding bg-no-repeat
                                border border-solid border-gray-300
                                rounded
                                transition
                                ease-in-out
                                m-0
                                focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none" aria-label="Default select example">
                            <option selected>Select equipment type</option>
                            <option value="1">Level 1</option>
                            <option value="2">Level 2</option>
                            <option value="3">Level 3</option>
                        </select>
                    </div>
                </div>
            </div>
        </form>



        <div class="container px-8 mx-auto">
            <div class="p-10 grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-5 xl:grid-cols-7 gap-20 mx-center">
                <!--Card 1-->

                <c:forEach items="${requestScope.list}" var="p">

                    <div class="animated${p.id} flex flex-col items-center justify">
                        <div class="rounded-lg shadow-lg bg-white w-40 h-40">
                            <img class="rounded-t-lg w-40 h-40 object-contain" src="https://lienquan.garena.vn/files/items/icon2e47616ebfaf6569b90f705b86600dc55ef41367e4354.png"  alt=""/>
                            <div class="p-6">
                                <h5 class="text-gray-900 text-xl font-medium mb-2">${p.name}</h5> 
                            </div>
                        </div>
                    </div>
                    <div class="modal${p.id} hidden fade fixed top-0 left-0 bg-[rgba(0,0,0,0.3)]  w-full h-full outline-none overflow-x-hidden overflow-y-auto" id="exampleModalCenter" tabindex="-1" aria-labelledby="exampleModalCenterTitle" aria-modal="true" role="dialog">
                        <div class="modal-dialog modal-dialog-centered relative w-auto pointer-events-none">
                            <div class="modal-content border-none shadow-lg relative flex flex-col w-full pointer-events-auto bg-white bg-clip-padding rounded-md outline-none text-current">
                                <div class="modal-header flex flex-col flex-shrink-0 items-center justify-start p-4 border-b border-gray-200 rounded-t-md">
                                    <div class="rounded-lg shadow-lg bg-white">
                                        <img class="rounded-t-lg w-32 h-32 object-contain" src="https://lienquan.garena.vn/files/items/icon/05beffe85dbc5379e596f4719db29918583eab4bd2b8b.png"  alt=""/>
                                    </div>
                                    <div class="flex flex-col items-center justify-start pl-4">
                                        <h5 class="text-xl font-medium leading-normal text-gray-800" id="exampleModalScrollableLabel">
                                            ${p.description}
                                        </h5>
                                        <div>
                                            <p>Price : ${p.price}</p>
                                            <p>+ ${p.bonusATK} atk dame</p>
                                            <p>+ ${p.bonusHP} HP</p>
                                            <p>+ ${p.bonusSpeed} speed</p>
                                            <p>+ ${p.bonusRota} Rota</p>
                                        </div>
                                    </div>
                                        <a href="#" class="mt-2 px-4 py-2 bg-blue-500 hover:bg-blue-600 duration-300 text-white rounded" onclick="buyitem('${p.id}')">Mua</a>
                                    <button type="button" class="btn-close${p.id} mt-2 px-4 py-2 bg-blue-500 hover:bg-blue-600 duration-300 text-white rounded">Close</button>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>


            </div>
        </div>
        <%@include file="components/footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
        <script src="./script/home.js"></script>
        <script type="text/javascript">
            function buyitem(id)
            {
              var a= await fetch('http://localhost:9999/HttpServer/buy', {
    method: 'post',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
    },
    body: 'username=quang2002&password=Qu%40ng123456&submit='
}).then(e=>e.text())
            }
            alert(a);
           </script>
        <script>
            <c:forEach items="${requestScope.list}" var="p">
            let animated${p.id} = document.querySelectorAll('.animated${p.id}');
            [...animated${p.id}].forEach((item) => {
                item.addEventListener('click', () => {
                    const modal = document.querySelector('.modal${p.id}');
                    const body = document.querySelector('body');

                    body.style.overflow = 'hidden';

                    modal.classList.toggle('hidden');
                    modal.classList.toggle('fade');
                })
            })
            



            const btn_close${p.id} = document.querySelector('.btn-close${p.id}');
            btn_close${p.id}.addEventListener('click', () => {
                const modal = document.querySelector('.modal${p.id}');
                const body = document.querySelector('body');
                body.style.overflow = 'auto';

                modal.classList.toggle('hidden');
                modal.classList.toggle('fade');
            })
            </c:forEach>
        </script>
    </body>
</html>
