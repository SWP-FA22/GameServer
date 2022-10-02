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
import models.ItemModel;
import models.ResourceModel;
import utilities.Authentication;

/**
 *
 * @author Huu
 */
public class BuyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            int id = Integer.parseInt(request.getParameter("itemid"));
            ItemModel im = new ItemModel();
            int price = (int) im.getPriceItemByID(id);
            if (price == -1) {
                out.print("ItemID invalid!");
                return;
            }

            String token = Authentication.getTokenFromCookies(request.getCookies());
            if (Authentication.getPlayerInformationByToken(token) == null) {
                response.sendRedirect("login");
                return;
            }

            Player player = Authentication.getPlayerInformationByToken(token);
            ResourceModel rm = new ResourceModel();

            if (!im.isPlayerOwned(player.getId(), id)) {
                out.print("User already own this item");
                return;
            }

            int diamond = rm.getDiamondAmount(player.getId());
            //tru o bang playerresource
            //them vao bang playeritem
            if (price > diamond) {
                out.print("Your balance not enough!");
            } else {
                diamond -= price;
                rm.setDiamondAmount(player.getId(), diamond);
                im.addItemToPlayer(player.getId(), id);
                out.print("Purchase sucessfull!");
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }

    }
}
