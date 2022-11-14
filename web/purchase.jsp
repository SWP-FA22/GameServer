<%-- 
    Document   : purchase
    Created on : Nov 13, 2022, 12:04:05 PM
    Author     : quang
--%>

<%@page import="utils.GlobalConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="shared/begin.jsp" %>

<div class="container p-5 d-flex justify-content-center align-items-center h-100">
    <div class="row shadow rounded p-2 pt-5 pb-5" style="max-width: 800px;">
        <div class="col-12 col-sm-6">
            <h1 class="text-center text-dark mb-5">Thanh Toán</h1>
            <p class="text-black-50 small pe-3 ps-3">Bạn muốn nạp tiền vào tài khoản <a href="user?id=${player.id}"><b class="text-danger"><c:out value="${player.username}"/></b> </a>. Vui lòng quét mã QR bên dưới để thực hiện thanh toán, sẽ mất khoảng
                <b>5 phút</b> để cập nhật kết quả thanh toán.</p>
        </div>

        <div class="col-12 col-sm-6 d-flex justify-content-center">
            <img src="https://img.vietqr.io/image/<%= GlobalConstants.BANK_ID%>-<%= GlobalConstants.BANK_NO%>-<%= GlobalConstants.QR_TEMPLATE%>.jpg?addInfo=PID${player.id}" class="img-fluid border rounded">
        </div>
    </div>
</div>

<%@include file="shared/end.jsp" %>