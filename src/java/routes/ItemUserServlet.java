/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import entities.Item;
import entities.Player;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ItemModel;
import utilities.Authentication;

/**
 *
 * @author LinhThuy
 */
public class ItemUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

            String token = Authentication.getTokenFromCookies(request.getCookies());
            Player player = Authentication.getPlayerInformationByToken(token);

//            List<Item> list = new ItemModel().getall();
//            request.setAttribute("list", list);
            List<Item> listitem = new ItemModel().getItemsByPlayerID(player.getId());
            request.setAttribute("listitem", listitem);
            request.getRequestDispatcher("item-user.jsp").forward(request, response);
            out.println(listitem);
        } catch (Exception ex) {
            ex.printStackTrace(out);
        }
    }

}
