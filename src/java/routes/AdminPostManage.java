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
 * @author LinhThuy
 */
public class AdminPostManage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            String token = Authentication.getTokenFromCookies(request.getCookies());
            Player player = Authentication.getPlayerInformationByToken(token);

            if (player.getRole() != 1) {
                throw new Exception("You are not admin");
            }
            
            List<Map.Entry<Player, Post>> listpost = new PostModel().getAllPostWithPlayer();
            
            request.setAttribute("listpost", 
                    listpost.stream().filter(e -> 
                            e.getValue().getIsApproved() == null || e.getValue().getIsApproved() == false
                    ).toArray()
            );
            request.getRequestDispatcher("admin-post.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace(out);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String token = Authentication.getTokenFromCookies(request.getCookies());
            Player player = Authentication.getPlayerInformationByToken(token);

            if (player.getRole() != 1) {
                throw new Exception("You are not admin");
            }
            
            new PostModel().updateStatusPost(Integer.parseInt(request.getParameter("postid")), true);
            
            response.sendRedirect("admin-post");
        } catch (Exception ex) {
            ex.printStackTrace(out);
        }
    }

}
