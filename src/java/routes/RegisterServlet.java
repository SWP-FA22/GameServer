/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.UserModel;
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
            String password = request.getParameter("password").trim();
            String email = request.getParameter("email").trim();
            String name = request.getParameter("name").trim();
            String captcha = request.getParameter("g-recaptcha-response");

            GoogleReCaptcha gcaptcha = new GoogleReCaptcha(GlobalConstants.GOOGLE_RECAPTCHA_SECRET_KEY);
            if (!gcaptcha.checkCaptcha(captcha)) {
                //out.println("sai captcha");
            }

            if (UserModel.checkDuplicateEmail(email)) {
                UserModel.createAccount(username, password, email, name);
            } else {
                //out.println("dup email");
            }
        } catch (Exception e) {

        }
        response.sendRedirect(".");
    }
}
