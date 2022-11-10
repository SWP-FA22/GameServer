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
import models.ReportModel;
import utilities.Authentication;

/**
 *
 * @author Huu
 */
public class CheckServlet extends HttpServlet {
   


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        Long id= Long.parseLong(request.getParameter("id"));
        try {
            String token = Authentication.getTokenFromCookies(request.getCookies());
            if (Authentication.getPlayerInformationByToken(token) == null) {
                response.sendRedirect("home");
            } else {
                Player player = Authentication.getPlayerInformationByToken(token);
                if (player.getRole() != 1) {
                    response.sendRedirect("home");
                } else {
                    PlayerModel pm=new PlayerModel();
                    Player player1=pm.getUserById(id);
                    if (action.equals("ban"))
                    {
                        //update ban account                        
                        player1.setRole(2);
                        pm.updateRole(player1);
                        response.sendRedirect("admin");
                    }
                    else if (action.equals("unban"))
                    {
                        //unban account
                        player1.setRole(0);
                        pm.updateRole(player1);
                        response.sendRedirect("admin");
                    }
                    else if (action.equals("deletereport"))
                            {
                                ReportModel rm=new ReportModel();
                                rm.deleteReport(id.intValue());
                                response.sendRedirect("admin-report");
                            }
                }

            }

        } catch (Exception ex) {
            response.sendError(500, ex.getMessage());
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }


}
