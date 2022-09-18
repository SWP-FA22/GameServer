/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.UserModel;
import org.json.JSONObject;
import utilities.Authentication;
import utilities.TokenGenerator;

/**
 *
 * @author quang
 */
public class APIServlet extends HttpServlet {

    public interface APIProcessCallback {

        public void process(HttpServletRequest request, PrintWriter response) throws Exception;
    }

    private HashMap<String, APIProcessCallback> routes;

    private void initRoutes() {
        routes = new HashMap<>();

        routes.put("post:login", APIServlet::login);
        routes.put("post:verify", APIServlet::verify);
    }

    public static void login(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Integer uid = UserModel.checkAuth(username, password);

            if (uid != null) {
                String token = Authentication.createTokenCookie(uid, 60 * 60 * 24).getValue();

                result.put("success", true);
                result.put("token", token);
            }

        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }

        response.write(result.toString());
    }

    public static void verify(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String token = request.getParameter("token");

            JSONObject json = TokenGenerator.decrypt(token);

            Long expiry = json.getLong("expiry");
            Long current = new Date().getTime();

            if (expiry < current) {
                throw new Exception("Invalid token: Token is expired");
            }

            Long uid = json.getLong("uid");

            if (new UserModel().getUserById(uid) == null) {
                throw new Exception("Invalid token: UID is not valid");
            }

            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }

        response.write(result.toString());
    }

    @Override
    public void init() throws ServletException {
        super.init();
        initRoutes();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain; charset=utf-8");

        try ( PrintWriter out = response.getWriter()) {
            try {
                String uri = request.getRequestURI();

                Pattern pattern = Pattern.compile("^/HttpServer/api/([^\\/]+)(\\?.*)?$");

                Matcher matcher = pattern.matcher(uri);

                if (!matcher.matches()) {
                    throw null;
                }

                routes.get(request.getMethod().toLowerCase() + ":" + matcher.group(1)).process(request, out);
            } catch (Exception e) {
                out.print("Invalid request");
            }
        }
    }
}
