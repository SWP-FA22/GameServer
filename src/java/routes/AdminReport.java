/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import entities.Report;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ReportModel;

/**
 *
 * @author LinhThuy
 */
public class AdminReport extends HttpServlet {

  

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ReportModel rm=new ReportModel();
            List<Report> list=rm.getall();
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
            list = rm.getPost(page - 1, 10);
            request.setAttribute("reports", list);
            request.getRequestDispatcher("report-admin.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace(response.getWriter());
        }
    }

   
}
