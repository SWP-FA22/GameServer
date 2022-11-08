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
import java.util.List;
import models.PlayerModel;
import utilities.Authentication;

/**
 *
 * @author Huu
 */
public class SearchAdminServlet extends HttpServlet {
   
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            try {
            String token = Authentication.getTokenFromCookies(request.getCookies());
            if (Authentication.getPlayerInformationByToken(token) == null) {
                response.sendRedirect("home");
            } else {
                Player player = Authentication.getPlayerInformationByToken(token);
                if (player.getRole() != 1) {
                    response.sendRedirect("home");
                } else {
                    String name=request.getParameter("name");List<Player> list;
                    if (name==null || name.trim()=="") list= new PlayerModel().getall();
                    else list = new PlayerModel().getallplayer(name);
                    if (list==null)
                    {
                        
                    }
                    else
                    {
                        for (int i=0;i<list.size();i++)
                        {
                            Player p=list.get(i);
                            if (p.getRole()==1) list.remove(i);
                        }
                        
                    request.setAttribute("players", list);
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                    }
                    
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace(response.getWriter());
        }
    } 



}
