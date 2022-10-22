<%-- 
    Document   : post
    Created on : Oct 20, 2022, 2:06:00 AM
    Author     : Huu
--%>

<%@page import="utilities.GlobalConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    try {
        String token = Authentication.getTokenFromCookies(request.getCookies());
        request.setAttribute("token", token);
    } catch (Exception e) {
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script src="https://cdn.tailwindcss.com"></script>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
            integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;600;700&display=swap" />
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/tw-elements/dist/css/index.min.css"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/fontawesome.min.css"
            integrity="sha512-8Vtie9oRR62i7vkmVUISvuwOeipGv8Jd+Sur/ORKDD5JiLgTGeBSkI3ISOhc730VGvA5VVQPwKIKlmi+zMZ71w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
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
        <title>User Post</title>

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
        <script src="script/comment-websocket.js"></script>
        <script src="script/html-encode.js"></script>
    </head>
    <body class="bg-grey-200">
        <%@include file="components/navbar.jsp" %>

        <div class="flex flex-col items-center justify-center">
            <div
                class="w-full max-w-screen-sm m-auto p-3 min-h-100 overflow-hidden shadow-lg border my-10"
                >
                <div class="wrapper bg-white flex flex-row p-3">
                    <div class="w-1/6 flex-grow-0">
                        <div
                            class="rounded-full w-full h-auto border-green-700 border-4 p-1 overflow-hidden"
                            >
                            <img
                                class="rounded-full w-full"
                                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTaXZd2-aQF4R4Vxg3jpmkz5IAIHc9Hg-Fc1Aun7XeasnVggFOvogZQ5ZrsnL2E4RpaJjY&usqp=CAU"
                                alt=""
                                />
                        </div>
                    </div>
                    <div class="w-5/6 info text-left pl-3 text-gray-500">
                        <div
                            class="written-by uppercase text-gray-600 tracking-wide text-sm mb-2"
                            >
                            ${requestScope.post.timeCreate}
                        </div>
                        <div class="name font-bold py-1">${player.name}</div>
                        <div
                            class="written-by uppercase text-gray-600 tracking-wide text-sm mb-2"
                            >
                            <h2 class="text-lg font-bold">${requestScope.post.title}</h2>
                        </div>
                        <div class="bio text-sm">
                            ${requestScope.post.description}
                        </div>
                    </div>
                </div>
                <div class="wrapper bg-white flex flex-row p-3">
                    <div class="w-5/6 info text-left pl-3 text-gray-500">
                        <form id="comment-form" autocomplete="off" class="w-full p-4">
                            <div class="mb-2">
                                <label for="comment" class="text-lg text-gray-600"
                                       >Add a comment</label
                                >
                                <textarea
                                    class="w-full h-20 p-2 border rounded focus:outline-none focus:ring-gray-300 focus:ring-1"
                                    name="comment" id="comment-input" data-mdb-showcounter="true" maxlength="100" pattern=".+"
                                    placeholder=""
                                    ></textarea>
                            </div>
                            <div>
                                <button class="px-3 py-2 text-sm text-blue-100 bg-blue-600 rounded" type="submit" >
                                    Comment
                                </button>
                            </div>
                        </form>
                        <section class="bg-white  py-8 lg:py-16">
                            <div class="max-w-2xl mx-auto px-4">
                                <div class="flex justify-between items-center mb-6">
                                    <h2
                                        class="text-lg lg:text-2xl font-bold text-gray-900 "
                                        >
                                        Discussion (20)
                                    </h2>
                                </div>
                                <div id="comments" class="container">

                                </div>
                                <a class="text-center mt-8 hover:text-gray-800 duration-200 cursor-pointer" id="load-more-comments" onclick="loadMoreComments()">
                                    Load more comments
                                </a>
                            </div>
                        </section>
                    </div>
                </div>
            </div>


        </div>

        <script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>
        <script src="./script/home.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
            var commentPage = 0;
            var ws = null;

            function loadMoreComments() {
                ws.get(commentPage);
                commentPage++;
            }
            function createComment(name, time, content) {
                return `<article class="p-6 mb-6 text-base bg-white rounded-lg blog-comment" >
                                        <footer class="flex justify-between items-center mb-2">
                                            <div class="flex items-center">
                                                <p class="inline-flex items-center mr-3 text-sm text-gray-900 "     >
                                                    <img   class="mr-2 w-6 h-6 rounded-full"   src="https://flowbite.com/docs/images/people/profile-picture-2.jpg"
                                                           />` + htmlEncode(name) + `</p>
                                                <p class="text-sm text-gray-600 text-gray-400">` + htmlEncode(time) + `</p>
                                            </div>
                                        </footer>
                                        <p class="text-gray-500 text-gray-600">` + htmlEncode(content) + `</p>
                                    </article>`;
            }
            window.addEventListener('load', () => {
                ws = new CommentWebSocket('ws://<%= GlobalConstants.HOST + GlobalConstants.CONTEXT_PATH + GlobalConstants.COMMENT_WSPATH%>', ${post.getId()}, '${token}');
                ws.onopen = loadMoreComments;
                ws.onmessage = (event) => {
                    const data = JSON.parse(event.data);
                    const commentList = document.getElementById('comments');
                    // Insert comment into list 
                    if (data.action === 'get') {
                        data.comments.forEach(([cUser, comment]) => {
                            commentList.innerHTML += createComment(cUser.name, comment.timeCreate, comment.description);
                        });
                    } else if (data.action === 'post') {
                        const [cUser, comment] = data.comment;
                        commentList.innerHTML = createComment(cUser.name, comment.timeCreate, comment.description) + commentList.innerHTML;
                    }

                    // Update comment count
                    document.getElementById('comment-count').innerHTML = data.size;
                    // Hide load-more-comments when all comments loaded
                    if (document.getElementsByClassName('blog-comment').length >= data.size)
                        document.getElementById('load-more-comments').style.display = 'none';
                };
                document.getElementById('comment-form').onsubmit = function (e) {
                    e.preventDefault();
                    ws.post(document.getElementById('comment-input').value);
                    document.getElementById('comment-input').value = "";
                };
            });
        </script>
    </body>
</html>
