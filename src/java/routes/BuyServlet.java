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
import models.PlayerModel;
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
            } else {
                String token = Authentication.getTokenFromCookies(request.getCookies());
                if (Authentication.getPlayerInformationByToken(token) == null) {
                    response.sendRedirect("login");
                } else {
                    Player player = Authentication.getPlayerInformationByToken(token);
                    PlayerModel playerModel = new PlayerModel();
                    if (!im.check(player.getId(), id)) {
                        out.print("User already own this item");
                        return;
                    } else {
                        int rs = playerModel.getUserResource(player.getId(), 1);
                        //tru o bang playerresource
                        //them vao bang playeritem
                        if (price > rs) {
                            out.print("Your balance not enough!");
                            return;
                        } else {
                            rs -= price;
                            ResourceModel rm = new ResourceModel();
                            rm.setDiamondAmount(player.getId(), rs);
                            im.insert(player.getId(), id);
                            out.print("Purchase sucessfull!");
                            return;
                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace(out);
        }

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
