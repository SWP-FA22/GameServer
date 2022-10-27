/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import entities.Player;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import models.PostModel;
import models.PlayerModel;
import utilities.Authentication;

/**
 *
 * @author LinhThuy
 */
public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("create-post.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try {
            String token = Authentication.getTokenFromCookies(request.getCookies());
            Player player = Authentication.getPlayerInformationByToken(token);

            String createdby = request.getParameter("createdby").trim();
            String title = request.getParameter("title").trim();
            String description = request.getParameter("description").trim();

            int uid = new PlayerModel().getIdByUsername(createdby);
           

            if (new PlayerModel().getIdByUsername(createdby) != -1) {
                new PostModel().createPost(uid, title, description);
                request.setAttribute("success", "Create post successfully!");
                request.getRequestDispatcher("create-post.jsp").forward(request, response);
                return;
            } else {
                request.setAttribute("error", "Re-enter!");
                request.getRequestDispatcher("create-post.jsp").forward(request, response);
                return;
            }
            // request.getRequestDispatcher("create-post.jsp").forward(request, response);
        } catch (Exception e) {
           e.printStackTrace(out);
        }

    }

}
