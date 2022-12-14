/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import entities.Post;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import models.PostModel;

/**
 *
 * @author Huu
 */
public class ListPostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            PostModel pm = new PostModel();
            List<Post> list = pm.getPost();
            int sl = list.size();
            int pages = sl / 10;
            if (sl % 10 != 0) {
                pages++;
            }
            request.setAttribute("pages", pages);
            int page;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            } else {
                page = 1;
            }
            list = pm.getPost(page - 1, 10);
            request.setAttribute("list", list);
            request.getRequestDispatcher("listpost.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(out);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
