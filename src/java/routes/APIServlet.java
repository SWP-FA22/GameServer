/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import entities.Item;
import entities.Player;
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
import java.util.ArrayList;
import java.util.List;
import models.ItemModel;
import models.PlayerModel;
import models.ResourceModel;
import org.json.JSONObject;
import utilities.Authentication;
import utilities.TokenGenerator;

/**
 *
 * @author quang
 */
public class APIServlet extends HttpServlet {

    public interface APIProcessCallback {

        public JSONObject process(HttpServletRequest request, PrintWriter response) throws Exception;
    }

    private HashMap<String, APIProcessCallback> routes;

    @Override
    public void init() throws ServletException {
        super.init();

        routes = new HashMap<>();

        routes.put("post:login", APIServlet::login);
        routes.put("post:verify", APIServlet::verify);
        routes.put("post:get-all-items", APIServlet::getAllItems);
        routes.put("post:buy-item", APIServlet::buyItem);
    }

    public static JSONObject buyItem(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String playername = request.getParameter("playername");
            int itemid = Integer.parseInt(request.getParameter("itemid"));
            ItemModel im = new ItemModel();
            int price = (int) im.getPriceItemByID(itemid);
            if (price == -1) {
                result.put("success", false);
                result.put("error", "ItemID invalid!");
            } else {
                PlayerModel pm = new PlayerModel();
                Player player = pm.getUserByName(playername);
                ResourceModel rm = new ResourceModel();

                if (!im.isPlayerOwned(player.getId(), itemid)) {
                    result.put("success", false);
                    result.put("error", "User already own item!");
                } else {
                    int diamond = rm.getDiamondAmount(player.getId());
                    if (price > diamond) {
                        result.put("success", false);
                        result.put("error", "Your balance not enough!");
                    } else {
                        diamond -= price;
                        rm.setDiamondAmount(player.getId(), diamond);
                        im.addItemToPlayer(player.getId(), itemid);
                        result.put("success", true);
                    }
                }
            }

        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    public static JSONObject getAllItems(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String token = request.getParameter("token");

            List<Item> list = new ArrayList<>();
            if (token == null || token.isEmpty()) {
                list = new ItemModel().getall();
            } else {
                Player player = Authentication.getPlayerInformationByToken(token);

                if (player == null) {
                    result.put("success", false);
                    result.put("error", "Username is not exist");
                } else {
                    list = new ItemModel().getItemsByPlayerID(player.getId());
                }
            }
            result.put("success", true);
            result.put("items", list);

        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    public static JSONObject login(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username == null || username.length() > 64) {
                throw new Exception("Arg \"username\" is not valid");
            }

            if (password == null || password.length() > 64) {
                throw new Exception("Arg \"password\" is not valid");
            }

            Integer uid = new PlayerModel().getUserIDByUsernameAndPassword(username, password);

            if (uid != null) {
                String token = Authentication.createTokenCookie(uid, 60 * 60 * 24).getValue();

                result.put("success", true);
                result.put("token", token);
            } else {
                throw new Exception("Wrong username or password");
            }

        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }

        return result;
    }

    public static JSONObject verify(HttpServletRequest request, PrintWriter response) throws Exception {
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

            if (new PlayerModel().get(uid) == null) {
                throw new Exception("Invalid token: UID is not valid");
            }

            result.put("success", true);
        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }

        return result;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json; charset=utf-8");

        try ( PrintWriter out = response.getWriter()) {
            try {
                String uri = request.getRequestURI();

                Pattern pattern = Pattern.compile("^/HttpServer/api/([^\\/]+)(\\?.*)?$");

                Matcher matcher = pattern.matcher(uri);

                if (!matcher.matches()) {
                    throw null;
                }

                JSONObject result = routes.get(request.getMethod().toLowerCase() + ":" + matcher.group(1)).process(request, out);

                if (result != null) {
                    out.append(result.toString());
                }

            } catch (Exception e) {
                out.print("Invalid request");
            }
        }
    }
}
