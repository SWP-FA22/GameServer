<%-- 
    Document   : view-post
    Created on : Nov 14, 2022, 2:20:10 AM
    Author     : quang
--%>

<%@page import="utils.GlobalConstants"%>
<%@page import="utils.Authentication"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    try {
        String token = Authentication.getTokenFromCookies(request.getCookies());
        request.setAttribute("token", token);
    } catch (Exception e) {
    }
%>

<%@include file="../shared/begin.jsp" %>
<div style="margin-top: 150px;">
    <div class="container">
        <h1 class="text-center">
            <c:out value="${post.title}" />
        </h1>
        <p class="text-center small">
            ${post.getDateFormated()}
        </p>
        <p style="text-align: left;">
            ${post.description}
        </p>
    </div>
</div>
<hr class="mx-5">
<div class="container">

    <c:choose>
        <c:when test="${post.getIsApproved()}">
            <h5>Comments (<span id="comment-count"></span>)</h5>

            <form id="comment-form" class="btn-group w-100 my-4" autocomplete="off">
                <div class="form-outline">
                    <input
                        class="form-control"
                        name="comment" id="comment-input" data-mdb-showcounter="true" maxlength="100" pattern=".+"
                        placeholder=""
                        ></input>
                    <label class="form-label">Comment</label>
                </div>
                <button class="btn btn-danger" type="submit">Send</button>
            </form>

            <div class="row" id="comments">

            </div>

            <a class="text-center my-5 btn btn-danger" id="load-more-comments" onclick="loadMoreComments()">
                Load more comments
            </a>
        </c:when>
        <c:when test="${player.role == 1}">
            <form class="container px-5" method="post">
                <input type="hidden" name="id" value="${post.id}"/>

                <div class="btn-group w-100 my-4">
                    <button class="btn btn-success" type="submit" name="action" value="approve">Approve</button>
                    <button class="btn btn-danger" type="submit" name="action" value="reject">Reject</button>
                </div>
            </form>
        </c:when>
    </c:choose>

</div>

<script src="js/html-encode.js"></script>
<script src="js/comment-websocket.js"></script>

<script>
                var commentPage = 0;
                var ws = null;
                function loadMoreComments() {
                    ws.get(commentPage);
                    commentPage++;
                }
                function createComment(name, time, content) {
                    return `<div class="card mb-2">
                    <div class="card-body">
                        <div class="d-flex align-items-center">
                            <div>
                                <img src="assets/avatar.jpg" class="img-fluid rounded-circle" alt="Responsive image"
                                     width="100" height="100">
                            </div>
                            <div class="ms-4">
                                <h5 class="card-title">` + htmlEncode(name) + `</h5>
                                <p class="card-text">` + htmlEncode(content) + `</p>
                            </div>
                        </div>
                    </div>
                </div>`;
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

<%@include file="../shared/end.jsp" %>