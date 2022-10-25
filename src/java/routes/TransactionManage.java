/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import entities.Transaction;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import models.TransactionModel;

/**
 *
 * @author quang
 */
public class TransactionManage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchRaw = request.getParameter("search");
        String pageRaw = request.getParameter("page");
        try {
            List<Transaction> list = new TransactionModel().getall();

            if (searchRaw != null && !searchRaw.trim().isEmpty()) {
                int search = Integer.parseInt(searchRaw);
                list = list.stream().filter(t -> t.getPlayerID() == search).collect(Collectors.toList());
            }

            int page = 0;

            if (pageRaw != null) {
                page = Integer.parseInt(pageRaw);
            }

            int PAGE_SIZE = 50;
            request.setAttribute("transactions", list.subList(page * PAGE_SIZE, Math.min((page + 1) * PAGE_SIZE, list.size())));
            request.setAttribute("pageCount", (int) Math.ceil(list.size() / PAGE_SIZE));
            request.getRequestDispatcher("transactions.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
