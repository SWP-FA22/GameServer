package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PlayerModel;
import utils.GlobalConstants;
import utils.GoogleReCaptcha;

@WebServlet(name = "SignupServlet", urlPatterns = {"/signup"})
public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String captcha = request.getParameter("g-recaptcha-response");

        try {
            if (captcha == null || name == null || email == null || username == null || password == null) {
                throw new Exception("captcha, name, email, username or password is not provided");
            }

            name = name.trim();
            email = email.trim();
            username = username.trim();
            password = password.trim();

            if (username.length() < 8 || username.length() > 64) {
                throw new Exception("username length is not valid");
            }
            if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,16}$")) {
                throw new Exception("password format is not valid");
            }

            GoogleReCaptcha gcaptcha = new GoogleReCaptcha(GlobalConstants.GOOGLE_RECAPTCHA_SECRET_KEY);
            if (!gcaptcha.checkCaptcha(captcha)) {
                throw new Exception("captcha incorrect");
            }

            if (!new PlayerModel().isEmailExist(email)) {
                new PlayerModel().createAccount(username, password, email, name);
                response.sendRedirect(".");
            } else {
                throw new Exception("your email is duplicate!");
            }

        } catch (Exception e) {
            response.sendRedirect("signup?error=" + e.getMessage());
        }
    }
}
