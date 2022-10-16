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

/**
 *
 * @author LinhThuy
 */
public class RankingServlet extends HttpServlet {

    
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
         
            List <Player> listtop = new PlayerModel().getTopRanking();
            request.setAttribute("listtop",listtop);
            
            //out.println(listtop);
            request.getRequestDispatcher("top-ranking.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }

    
   

}
