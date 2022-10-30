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
import models.PlayerModel;
import utilities.Authentication;

/**
 *
 * @author LinhThuy
 */
public class LoginServlet extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
 
        
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Integer uid = new PlayerModel().getUserIDByUsernameAndPassword(username, password);
           
            if (uid != null) {
                response.addCookie(Authentication.createTokenCookie(uid, 60 * 60 * 24));
                response.sendRedirect("index.jsp");
                return;             
            }else {
                 Player player = Authentication.getPlayerInformationByToken(username);
                 if (player.getRole()== 2){
//                     request.setAttribute("error", "");
                     response.sendRedirect("login.jsp");
                 }
            }

        } catch (Exception e) {
            e.printStackTrace(out);
        }
        
        request.setAttribute("error", "Username or Password invalid!");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
    