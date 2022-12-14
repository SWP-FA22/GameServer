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
import models.PlayerModel;
import models.ReportModel;
import utilities.Authentication;

/**
 *
 * @author LinhThuy
 */
public class ReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("report-page.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String namereporting = request.getParameter("namefrom").trim();

            String namereported = request.getParameter("nameto").trim();
            String[] descriptions = request.getParameterValues("reason");
            String description = "";
            for (String i : descriptions) {
                description += i + ", ";
            }

            String videoURL = request.getParameter("videoURL").trim();
            if (!videoURL.matches("^[a-zA-z]+://[^\\s]*")) {
                request.setAttribute("error", "URL invalid!");
                request.getRequestDispatcher("report-page.jsp").forward(request, response);
                return;
            }
            new ReportModel().createReport(namereporting, namereported, description, videoURL);
            request.setAttribute("success", "Send report successfully!");
            request.getRequestDispatcher("report-page.jsp").forward(request, response);
            return;

        } catch (Exception e) {
            e.printStackTrace(response.getWriter());
        }

    }

}
