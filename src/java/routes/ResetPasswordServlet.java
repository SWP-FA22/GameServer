/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package routes;

import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import models.UserModel;
import org.json.JSONObject;
import utilities.Crypto;
import utilities.TokenGenerator;

/**
 *
 * @author Huu
 */
public class ResetPasswordServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static boolean isValidToken(String token) {
        try {
            JSONObject json = TokenGenerator.decrypt(token);

            Long uid = json.getLong("uid");

            if (new Date().after(new Date(json.getLong("expiry")))) {
                return false;
            }
            UserModel user=new UserModel();
            String password=user.getPasswordById(uid);
            return TokenGenerator.validCheck(token, password);
        } catch (Exception e) {
            return false;
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResetPasswordServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetPasswordServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String token = request.getParameter("token");
        if (!isValidToken(token)) {
            out.print("Error token1");
            return;
        }
        request.getRequestDispatcher("resetpassword.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            String password=request.getParameter("password");
        String token=request.getParameter("token");
        out.println(token);
        if (!isValidToken(token)) {
            out.print("Error token2");
            return;
        }
        out.println("done11");
        Long uid = TokenGenerator.decrypt(token).getLong("uid");
        out.println("done1111");
        UserModel user=new UserModel();
        User u=user.getUserById(uid);
        out.println("done1");
        u.setPassword(Crypto.SHA256(password));
        out.println("done2");
        user.updatePassword(u);
        out.println("done3");
        }catch(Exception e)
        {
            out.print(e);
        }
        out.print("done");
        //response.sendRedirect("index.jsp");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
