package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ItemModel;
import models.ShipModel;

@WebServlet(name = "GameDBServlet", urlPatterns = {"/database"})
public class GameDBServlet extends BaseSerlvet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("ships", new ShipModel().getall());
            request.setAttribute("items", new ItemModel().getall());
        } catch (Exception e) {
        }

        request.getRequestDispatcher("database.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
