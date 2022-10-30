/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import entities.Item;
import entities.Player;
import entities.Post;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import models.ItemModel;
import models.PlayerModel;
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
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();
        try {

            String token = Authentication.getTokenFromCookies(request.getCookies());
            Player player = Authentication.getPlayerInformationByToken(token);

            List<Post> listpost = new PostModel().getall();
            request.setAttribute("listpost", listpost);
            request.setAttribute("player", player);
            //out.println(listpost);
           
//           int postid = new Post().getId();
//            if (postid != 0) {
//                new PostModel().clearPostByID(postid);
//                response.sendRedirect("admin-post.jsp");
//            }
            
            request.getRequestDispatcher("admin-post.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace(out);
        }
    }

}
