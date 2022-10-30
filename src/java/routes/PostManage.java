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
public class PostManage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String token = Authentication.getTokenFromCookies(request.getCookies());
            Player player = Authentication.getPlayerInformationByToken(token);

            List<Post> listbypid = new PostModel().getPostByPlayerID(player.getId());
            request.setAttribute("listbypid", listbypid);
            request.setAttribute("player", player);
            request.getRequestDispatcher("post-manage.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            //int postid = request.getParameter("postid");
            String token = Authentication.getTokenFromCookies(request.getCookies());
            Player player = Authentication.getPlayerInformationByToken(token);

            String description = request.getParameter("description").trim();
            int postid = Integer.parseInt(request.getParameter("id"));

            //List<Post> post = new PostModel().getPostByPlayerID(player.getId());
            Integer post = new Post().getId();
            PostModel pm = new PostModel();
           
            request.getRequestDispatcher("./edit-post?id=" + post).forward(request, response);

        } catch (Exception e) {
        }

    }

}
