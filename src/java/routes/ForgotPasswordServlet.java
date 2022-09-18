/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import entities.Player;
import java.io.IOException;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("forgot-password.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String email = request.getParameter("email");
            user = new UserModel();
            Player u = user.getUserByEmail(email);
            if (u == null) {
                // could not find this email
            }
            String oldPassword = u.getPassword();
            HashMap<String, Object> data = new HashMap<>();
            data.put("uid", u.getId());
            data.put("expiry", new Date().getTime() + 1000 * 60 * 30);//30 minutes
            String text = "Hi " + u.getName() + ",\n\n"
                    + "We receive a request to reset password for your account.\n"
                    + "To reset password, click the link below (valid for 30 minutes):\n"
                    + "http://" + GlobalConstants.HOST + GlobalConstants.CONTEXT_PATH + "/reset?token=" + TokenGenerator.generate(data, oldPassword);
            smtp.sendMimeMessage("BattleShip Online (No-Reply)", u.getEmail(), "RESET YOUR PASSWORD", text);
        } catch (Exception e) {
        }

        response.sendRedirect(".");
    }
}
