package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PlayerModel;
import utils.Authentication;

@WebServlet(name = "SigninServlet", urlPatterns = {"/signin"})
public class SigninServlet extends BaseSerlvet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("signin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            if (username == null || password == null) {
                throw new Exception("username or password is not provided");
            }

            Integer uid = new PlayerModel().getUserIDByUsernameAndPassword(username, password);

            if (uid != null) {
                response.addCookie(Authentication.createTokenCookie(uid, 60 * 60 * 24));
                response.sendRedirect(".");
            } else {
                throw new Exception("username or password is not correct");
            }
        } catch (Exception e) {
            response.sendRedirect("signin?error=" + e.getMessage());
        }
    }
}
