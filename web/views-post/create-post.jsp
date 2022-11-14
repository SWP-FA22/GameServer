<%-- 
    Document   : create-post
    Created on : Nov 14, 2022, 1:27:58 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../shared/begin.jsp" %>
<link rel="stylesheet" href="css/rte_theme_default.css" />
<script type="text/javascript" src="js/rte.js"></script>
<script type="text/javascript" src="js/all_plugins.js"></script>

<div class="h-100 w-100 d-flex justify-content-center align-items-center flex-column p-5">
    <form class="container" method="post">
        <h2 class="text-lg text-dark mt-2">Create New Post</h2>

        <div class="form-outline mt-4">
            <input type="text"
                   class="form-control block w-full px-3 py-1.5 text-base font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                   id="title" aria-describedby="title" placeholder="Enter Title" name="title"></input>
            <label for="title" class="form-label inline-block mb-2 text-gray-700">Title</label>
        </div>

        <div class="mt-4">
            <div>
                <input type="text" name="description" id="div_editor">
            </div>
        </div>

        <div class="mt-4">
            <button class="btn btn-danger" type="submit">
                Post
            </button>
            <a class="btn btn-outline-danger" href=".">
                Cancel
            </a>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/tw-elements/dist/js/index.min.js"></script>

<script>
    new RichTextEditor("#div_editor");
</script>
<%@include file="../shared/end.jsp" %>