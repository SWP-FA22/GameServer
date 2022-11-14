<%-- 
    Document   : end
    Created on : Nov 13, 2022, 8:46:38 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- MDB -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.0.0/mdb.min.js"></script>

<script>
    document.addEventListener("DOMContentLoaded", () => {
        setInterval(() => {
            document.querySelector(".alert[autohide]")?.remove();
        }, 3000);
    });
</script>
</body>

</html>