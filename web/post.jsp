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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <title>Post Page</title>

        <style>
            html {
                scroll-behavior: smooth;
            }
        </style>
        <script src="script/comment-websocket.js"></script>
        <script src="script/html-encode.js"></script>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>
        <h1>${requestScope.post.title}</h1><h6>${requestScope.post.timeCreate}</h6>
        <p>${requestScope.post.description}</p>
        <h5>Comments - <span class="text-white-50" id="comment-count"></span></h5>
        <form  id="comment-form" autocomplete="off">
            <h4>${player.name}</h4>
            <div >
                <input type="text" id="comment-input" data-mdb-showcounter="true" maxlength="100" pattern=".+"/>
                <label>Your comment here</label>
            </div>

            <button  type="submit">Comment</button>
        </form>
        <div id="comments">

        </div>

        <a  id="load-more-comments" onclick="loadMoreComments()">
            Load more comments
        </a>
    </body>
    <script>
        var commentPage = 0;
        var ws = null;

        function loadMoreComments() {
            ws.get(commentPage);
            commentPage++;
        }
        function createComment( name, time, content) {
            return `<div class="blog-comment"><div class="d-flex align-items-center"><strong>` + htmlEncode(name) + `</strong><div > `+htmlEncode(time)+`</div></div><p  style="font-size: 14px; margin-left: 45px;">` + htmlEncode(content) + `</p></div>`;
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
                                                    commentList.innerHTML += createComment(cUser.name , comment.timeCreate, comment.description);
                                                });
                                            } else if (data.action === 'post') {
                                                const [cUser, comment] = data.comment;
                                                commentList.innerHTML = createComment(cUser.name , comment.timeCreate, comment.description) + commentList.innerHTML;
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
</html>
