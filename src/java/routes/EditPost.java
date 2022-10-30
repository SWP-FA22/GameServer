/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import entities.Player;
import entities.Post;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import models.PostModel;
import utilities.Authentication;

/**
 *
 * @author LinhThuy
 */
public class EditPost extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try {

            String token = Authentication.getTokenFromCookies(request.getCookies());
            Player player = Authentication.getPlayerInformationByToken(token);

            int postid = Integer.parseInt(request.getParameter("postid"));
            
            Post post = new PostModel().get(postid);
            request.setAttribute("post", post);
            request.setAttribute("player", player);
            
            request.getRequestDispatcher("edit-post.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String token = Authentication.getTokenFromCookies(request.getCookies());
            Player player = Authentication.getPlayerInformationByToken(token);

            int postid = Integer.parseInt(request.getParameter("postid"));

            String title = request.getParameter("title").trim();
            String description = request.getParameter("description").trim();

            PostModel pm = new PostModel();
            pm.updatePost(title, description, postid, player.getId());

            response.sendRedirect("post-manage");
        } catch (Exception e) {
        }

    }
}
