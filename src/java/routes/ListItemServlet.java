/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import entities.Item;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import models.ItemModel;

/**
 *
 * @author Huu
 */
public class ListItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            List<Item> list = new ItemModel().getall();
            request.setAttribute("list", list);
            request.getRequestDispatcher("listitem.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace(out);
        }
    }

}
