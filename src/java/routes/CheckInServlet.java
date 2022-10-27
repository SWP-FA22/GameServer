/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package routes;

import entities.CheckIn;
import entities.Player;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.CheckInModel;
import models.PlayerModel;
import models.ResourceModel;
import utilities.Authentication;

/**
 *
 * @author Huu
 */
public class CheckInServlet extends HttpServlet {
   
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            String token = Authentication.getTokenFromCookies(request.getCookies());
            if (Authentication.getPlayerInformationByToken(token) == null) {
                response.sendRedirect("login");
                return;
            }
            request.getRequestDispatcher("checkin.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CheckInServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String token = Authentication.getTokenFromCookies(request.getCookies());
        PrintWriter out = response.getWriter();
        try {
            if (Authentication.getPlayerInformationByToken(token) == null) {
                response.sendRedirect("login");
                return;
            }
             Player player = Authentication.getPlayerInformationByToken(token);
             if (player.isIscheckedin()) {
                 out.print("User already checked-in today");
                return;
             }PlayerModel pm=new PlayerModel();             
             player.setIscheckin(true);
             pm.updateIscheckin(player);
             int count=0;
             if (player.getCheckincount()!=null)
             count=player.getCheckincount();
             count=count%14+1;
             player.setCheckincount(count);             
             pm.updateCheckinCount(player);
             CheckInModel cim=new CheckInModel();
             CheckIn ci=cim.getCheckInByCount(count);
             ResourceModel rm=new ResourceModel();
             rm.addResourceAmount(player.getId(), ci.getResourceid(), ci.getAmount());
             out.print("Check-in complete");
        } catch (Exception ex) {
            ex.printStackTrace(out);
        }

           
        
    }

   

}
