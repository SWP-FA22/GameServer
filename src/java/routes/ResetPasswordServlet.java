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
import models.UserModel;
import org.json.JSONObject;
import utilities.Crypto;
import utilities.TokenGenerator;

/**
 *
 * @author Huu
 */
public class ResetPasswordServlet extends HttpServlet {

    private static boolean isValidToken(String token) {
        try {
            JSONObject json = TokenGenerator.decrypt(token);

            Integer uid = json.getInt("uid");

            if (new Date().after(new Date(json.getLong("expiry")))) {
                return false;
            }
            UserModel user = new UserModel();
            String password = user.getHashedPasswordById(uid);
            return TokenGenerator.validCheck(token, password);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String token = request.getParameter("token");
        if (!isValidToken(token)) {
            out.print("Error token1");
            return;
        }
        request.getRequestDispatcher("reset-password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String password = request.getParameter("password");
            String token = request.getParameter("token");

            out.println(token);
            if (!isValidToken(token)) {
                // check token but invalid
                return;
            }

            Long uid = TokenGenerator.decrypt(token).getLong("uid");
            UserModel user = new UserModel();
            Player u = user.getUserById(uid);

            u.setPassword(Crypto.SHA256(password));
            user.updatePassword(u);
        } catch (Exception e) {
        }
        response.sendRedirect(".");
    }
}
