package controllers;

import entities.Player;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import models.PlayerModel;
import utils.GlobalConstants;
import utils.SMTP;
import utils.TokenGenerator;

@WebServlet(name = "ForgotPasswordServlet", urlPatterns = {"/forgot-password"})
public class ForgotPasswordServlet extends BaseSerlvet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        try {
            if (email == null) {
                throw new Exception("email is not provided");
            }

            PlayerModel pm = new PlayerModel();
            Player p = pm.getUserByEmail(email);

            if (p == null) {
                throw new Exception(email + " is not found");
            }

            String oldPassword = p.getPassword();
            HashMap<String, Object> data = new HashMap<>();
            data.put("uid", p.getId());
            data.put("expiry", new Date().getTime() + 1000 * 60 * 30); //30 minutes
            String text = "Hi " + p.getName() + ",\n\n"
                    + "We receive a request to reset password for your account.\n"
                    + "To reset password, click the link below (valid for 30 minutes):\n"
                    + "http://" + GlobalConstants.HOST + GlobalConstants.CONTEXT_PATH + "/reset?token=" + TokenGenerator.generate(data, oldPassword);

            SMTP smtp = new SMTP("smtp-mail.outlook.com", "587", GlobalConstants.SMTP_ACCOUNT_EMAIL, GlobalConstants.SMTP_ACCOUNT_PASSWORD);
            smtp.connect();
            smtp.sendMimeMessage("BattleShip Online (No-Reply)", p.getEmail(), "RESET YOUR PASSWORD", text);
        } catch (Exception e) {
            response.sendRedirect("forgot-password?error=" + e.getMessage());
        }
    }
}
