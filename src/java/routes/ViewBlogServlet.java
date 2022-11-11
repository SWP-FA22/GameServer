/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import entities.Posts;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PostsModel;

/**
 *
 * @author Huu
 */
public class ViewBlogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            PostsModel postmodel = new PostsModel();
            Posts post = postmodel.get(id);
            
            if (!post.isIsApproved()) {
                response.sendError(404);
                return;
            }
            
            request.setAttribute("post", post);
            request.getRequestDispatcher("post.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(response.getWriter());
        }
    }
}
