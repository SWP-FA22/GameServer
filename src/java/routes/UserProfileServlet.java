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
import models.ItemModel;
import models.ResourceModel;
import models.ShipModel;
import utilities.Authentication;

public class UserProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String token = Authentication.getTokenFromCookies(request.getCookies());
            Player player = Authentication.getPlayerInformationByToken(token);

            int numberOfShip = new ShipModel().getShipsByPlayerID(player.getId()).size();
            int numberOfItem = new ItemModel().getItemsByPlayerID(player.getId()).size();
            int diamondAmount = new ResourceModel().getDiamondAmount(player.getId());
            
            request.setAttribute("numberOfItem", numberOfItem);
            request.setAttribute("numberOfShip", numberOfShip);
            request.setAttribute("diamondAmount",diamondAmount );
            request.setAttribute("player", player);

            request.getRequestDispatcher("user-profile.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect(".");
        }
    }
}
