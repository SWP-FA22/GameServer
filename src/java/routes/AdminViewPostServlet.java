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
import java.util.Map;
import models.PostModel;
import utilities.Authentication;

/**
 *
 * @author Huu
 */
public class AdminViewPostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String token = Authentication.getTokenFromCookies(request.getCookies());
            Player player = Authentication.getPlayerInformationByToken(token);

            String postId = request.getParameter("id");
            Post post = new PostModel().get(Integer.parseInt(postId));
            
            if (player.getRole() != 1 && post.getCreatedBy() != player.getId()) {
                throw new Exception("You don't have permission");
            }
            
            request.setAttribute("post", post);
            
            request.getRequestDispatcher("view-post.jsp").forward(request, response);
        } catch (Exception ex) {
            
        }
    }

}
