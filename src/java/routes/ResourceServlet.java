/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import entities.Player;
import entities.Resource;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PlayerModel;
import models.ResourceModel;
import models.UserModel;
import utilities.Authentication;

/**
 *
 * @author LinhThuy
 */
public class ResourceServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();
            String token = Authentication.getTokenFromCookies(request.getCookies());
            if (Authentication.getUserInformationByToken(token) == null) {
                response.sendRedirect("home");
            } else {
                Player player = Authentication.getUserInformationByToken(token);

//                request.setAttribute("numberofitem", numberofitem);
//                request.setAttribute("numberofitem", numberofship);
                request.setAttribute("player", player);

                // request.setAttribute("numberofitem",numberofitem);
                request.getRequestDispatcher("resource.jsp").forward(request, response);

            }
        } catch (Exception ex) {
            System.err.println(ex);
            request.setAttribute("error", ex.getMessage());
        }
        response.sendRedirect("home");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try {
            String token = Authentication.getTokenFromCookies(request.getCookies());
            if (Authentication.getUserInformationByToken(token) == null) {
                response.sendRedirect("home");
            } else {

                Player player = Authentication.getUserInformationByToken(token);
                //Resource resource = Authentication.getUserInformationByToken(token);
                
               

             
                int numberofship = new PlayerModel().getResourceShip(player.getId());
                int numberofitem  = new PlayerModel().getResourceItem(player.getId()); 
                int diamondamount = new ResourceModel().getDiamondAmount(player.getId());
                
                
                request.setAttribute("numberofitem", numberofitem);
                request.setAttribute("numberofship", numberofship);
                request.setAttribute("player", player);
                request.setAttribute("diamondamount",diamondamount );
               
                request.getRequestDispatcher("resource.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.err.println(e);
            request.setAttribute("error", e.getMessage());
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
