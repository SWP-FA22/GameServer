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
import models.PlayerModel;
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

            List<Post> listbypid = new PostModel().getPostByPlayerID(player.getId());
            request.setAttribute("listbypid", listbypid);
            request.setAttribute("player", player);
//           out.println(listbypid);
//           out.println(player);
            request.getRequestDispatcher("edit-post.jsp").forward(request, response);

            //new PostModel().updatePost(post.getId(),title, description);
//            request.setAttribute("success", "post edited");
            //request.getRequestDispatcher("edit-post.jsp").forward(request, response);
            return;
            //request.getRequestDispatcher("edit-post.jsp").forward(request, response);

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

            String description = request.getParameter("description").trim();

            PostModel pm = new PostModel();
            pm.updatePost(description, postid);

            //List<Post> post = new PostModel().getPostByPlayerID(player.getId());
           

            request.getRequestDispatcher("post-manage.jsp").forward(request, response);
        } catch (Exception e) {
        }

    }
}
