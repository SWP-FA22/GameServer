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
import java.util.List;
import models.PlayerModel;
import utilities.Authentication;

/**
 *
 * @author Huu
 */
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                    List<Player> list = pm.getall();
                    int sl = list.size();
                    int pages = sl / 10;
                    if (sl % 10 != 0) {
                        pages++;
                    }
                    request.setAttribute("pages", pages);
                    int page;
                    if (request.getParameter("page") != null) {
                        page = Integer.parseInt(request.getParameter("page"));
                    } else {
                        page = 1;
                    }
                    list =pm.getPlayer(page - 1, 10);
                    request.setAttribute("players", list);
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                }

            }

        } catch (Exception ex) {
            response.sendError(500, ex.getMessage());
        }
    }
}
