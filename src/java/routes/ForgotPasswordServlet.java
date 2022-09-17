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
import java.util.Date;
import java.util.HashMap;
import models.UserModel;
import utilities.GlobalConstants;
import utilities.SMTP;
import utilities.TokenGenerator;

/**
 *
 * @author Huu
 */
public class ForgotPasswordServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private UserModel user;
    private SMTP smtp;

    @Override
    public void init() throws ServletException {
        try {
            smtp = new SMTP("smtp-mail.outlook.com", "587", GlobalConstants.SMTP_ACCOUNT_EMAIL, GlobalConstants.SMTP_ACCOUNT_PASSWORD);
            smtp.connect();
        } catch (Exception e) {
            System.err.println(e);
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
            out.println("<title>Servlet ForgotPasswordServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgotPasswordServlet at " + request.getContextPath () + "</h1>");
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
        request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
      
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
        out.print("oke");
        try{
            
            String email=request.getParameter("email");
          user=new UserModel();
          Player u=user.getUserByEmail(email);
          if (u== null)
              out.println("null");
             // doGet(request, response);
          String oldPassword=u.getPassword();
          out.println("23");
          HashMap<String, Object> data = new HashMap<>();
            data.put("uid", u.getId());
            data.put("expiry", new Date().getTime() + 1000 * 60 * 30);//30 minutes
            String text="Hi " + u.getName()+",\n\n"
                    + "We receive a request to reset password for your account.\n"
                    + "To reset password, click the link below (valid for 30 minutes):\n"
                    + "http://" + GlobalConstants.HOST + GlobalConstants.CONTEXT_PATH + "/reset?token=" + TokenGenerator.generate(data, oldPassword);
            smtp.sendMimeMessage("BattleShip Online (No-Reply)", u.getEmail(), "RESET YOUR PASSWORD", text);
        }catch( Exception e)
        {
            e.printStackTrace(out);
            //doGet(request, response);
        }
        
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
