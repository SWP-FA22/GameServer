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
import models.PlayerModel;
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
            PlayerModel user = new PlayerModel();
            String password = user.getHashedPasswordById(uid);
            return TokenGenerator.validCheck(token, password);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String token = request.getParameter("token");
        if (!isValidToken(token)) {
            response.sendError(403, "Invalid Token");
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
                response.sendError(403, "Invalid Token");
                return;
            }

            Long uid = TokenGenerator.decrypt(token).getLong("uid");
            PlayerModel user = new PlayerModel();
            Player u = user.get(uid);

            u.setPassword(Crypto.SHA256(password));
            user.updatePassword(u);
        } catch (Exception e) {
            response.sendError(500, e.getMessage());
        }
        response.sendRedirect(".");
    }
}
