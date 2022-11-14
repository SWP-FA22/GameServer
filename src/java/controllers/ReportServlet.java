package controllers;

import entities.Player;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PlayerModel;
import models.ReportModel;

@WebServlet(name = "ReportServlet", urlPatterns = {"/report"})
public class ReportServlet extends BaseSerlvet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (player == null) {
            response.sendRedirect("signin");
            return;
        }

        request.getRequestDispatcher("report.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username").trim();
        String description = request.getParameter("description").trim();
        String videoLink = request.getParameter("video-link").trim();

        try {
            Player reportPlayer = new PlayerModel().getUserByUsername(username.trim());

            if (reportPlayer == null) {
                throw new Exception("report player is not exist");
            }

            if (description.length() < 1 || description.length() > 100) {
                throw new Exception("description is invalid!");
            }

            if (!videoLink.matches("^[a-zA-z]+://[^\\s]*")) {
                throw new Exception("URL is invalid!");
            }

            new ReportModel().createReport(player.getUsername(), reportPlayer.getUsername(), description, videoLink);
            response.sendRedirect("report");
        } catch (Exception e) {
            response.sendRedirect("report?error=" + e.getMessage());
        }
    }
}
