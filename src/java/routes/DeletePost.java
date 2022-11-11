/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import entities.Player;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PostModel;
import utilities.Authentication;

/**
 *
 * @author LinhThuy
 */
public class DeletePost extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String token = Authentication.getTokenFromCookies(request.getCookies());
            Player player = Authentication.getPlayerInformationByToken(token);

            int postid = Integer.parseInt(request.getParameter("postid"));

            PostModel pm = new PostModel();

           // if (player.getRole() != 1) {
                pm.deletePost(postid, player.getId());
                response.sendRedirect("post-manage");

//            } else {
//                pm.deletePost(postid);
//                response.sendRedirect("admin-post");
//            }

        } catch (Exception ex) {
ex.printStackTrace(response.getWriter());
        }
    }
}
