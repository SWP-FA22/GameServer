/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PlayerModel;
import utilities.GlobalConstants;
import utilities.GoogleReCaptcha;

/**
 *
 * @author Huu
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String username = request.getParameter("username").trim();
            if (username.length() < 8 || username.length() > 64) {
                request.setAttribute("error", "username invalid!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }
            String password = request.getParameter("password").trim();
            if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,16}$")) {
                request.setAttribute("error", "password invalid!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }
            String email = request.getParameter("email").trim();
            String name = request.getParameter("name").trim();
            if (name.length() < 1 || name.length() > 64) {
                request.setAttribute("error", "name invalid!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }
            String captcha = request.getParameter("g-recaptcha-response");

            GoogleReCaptcha gcaptcha = new GoogleReCaptcha(GlobalConstants.GOOGLE_RECAPTCHA_SECRET_KEY);
            if (!gcaptcha.checkCaptcha(captcha)) {
                request.setAttribute("error", "captcha incorrect!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            if (!new PlayerModel().checkDuplicateEmail(email)) {
                new PlayerModel().createAccount(username, password, email, name);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            } else {
                request.setAttribute("error", "your email is duplicate!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }
        } catch (Exception e) {

        }

    }
}
