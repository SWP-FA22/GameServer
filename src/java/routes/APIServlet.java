/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import entities.Item;
import entities.Player;
import entities.Ship;
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
import java.util.Objects;
import models.ItemModel;
import models.PlayerModel;
import models.ResourceModel;
import models.ShipModel;
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
        routes.put("post:logout", APIServlet::logout);
        routes.put("post:verify", APIServlet::verify);
        routes.put("post:get-all-items", APIServlet::getAllItems);
        routes.put("post:get-all-ships", APIServlet::getAllShips);
        routes.put("get:player-info", APIServlet::getPlayerInfo);
        routes.put("post:player-info", APIServlet::getPlayerExtraInfo);
        routes.put("post:player-data", APIServlet::getPlayerData);
        routes.put("post:buy-item", APIServlet::buyItem);
        routes.put("post:buy-ship", APIServlet::buyShip);
        routes.put("post:equip-ship", APIServlet::equipShip);
        routes.put("post:update-resource", APIServlet::updateresource);
        routes.put("post:update-score", APIServlet::updatescore);
        routes.put("get:top-player", APIServlet::getTopPlayers);
    }

    public static JSONObject getTopPlayers(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            List<Player> list = new PlayerModel().getTopRanking();
            result.put("success", true);
            result.put("players", list);

        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    public static JSONObject updatescore(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String token = request.getParameter("token");
            int score = Integer.parseInt(request.getParameter("score"));

            Player player = Authentication.getPlayerInformationByToken(token);

            if (player == null) {
                throw new Exception("Username is not exist");
            }

            player.setRank(score + player.getRank());
            PlayerModel pm = new PlayerModel();
            pm.updateRank(player);

            result.put("success", true);

        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    public static JSONObject updateresource(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String token = request.getParameter("token");
            int id = Integer.parseInt(request.getParameter("resourceid"));
            int amount = Integer.parseInt(request.getParameter("amount"));

            Player player = Authentication.getPlayerInformationByToken(token);

            if (player == null) {
                throw new Exception("Username is not exist");
            }

            ResourceModel rm = new ResourceModel();

            rm.addResourceAmount(player.getId(), id, amount);

            result.put("success", true);

        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    public static JSONObject equipShip(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String token = request.getParameter("token");
            int id = Integer.parseInt(request.getParameter("shipid"));

            Player player = Authentication.getPlayerInformationByToken(token);

            if (player == null) {
                throw new Exception("Username is not exist");
            }

            ShipModel sm = new ShipModel();

            if (!sm.isPlayerOwned(player.getId(), id)) {
                throw new Exception("You are not owned this ship");
            }

            sm.equipShip(player.getId(), id);
            result.put("success", true);

        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    public static JSONObject buyShip(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String token = request.getParameter("token");
            int id = Integer.parseInt(request.getParameter("shipid"));

            ShipModel sm = new ShipModel();
            Ship ship = sm.get(id);
            if (ship == null) {
                throw new Exception("Ship is not exist");
            }

            Player player = Authentication.getPlayerInformationByToken(token);

            if (player == null) {
                throw new Exception("Username is not exist");
            }

            ResourceModel rm = new ResourceModel();
            if (sm.isPlayerOwned(player.getId(), id)) {
                throw new Exception("User already own this ship");
            }

            int diamond = rm.getDiamondAmount(player.getId());
            if (ship.getPrice() > diamond) {
                throw new Exception("Your balance not enough!");
            }

            diamond -= ship.getPrice();
            rm.setDiamondAmount(player.getId(), diamond);
            sm.addShipToPlayer(player.getId(), id);

            result.put("success", true);

        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    public static JSONObject buyItem(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String token = request.getParameter("token");
            int id = Integer.parseInt(request.getParameter("itemid"));

            ItemModel im = new ItemModel();
            int price = (int) im.getPriceItemByID(id);
            if (price == -1) {
                result.put("success", false);
                result.put("error", "Item is not exist");
            } else {
                Player player = Authentication.getPlayerInformationByToken(token);

                if (player == null) {
                    result.put("success", false);
                    result.put("error", "Username is not exist");
                } else {
                    ResourceModel rm = new ResourceModel();
                    if (!im.isPlayerOwned(player.getId(), id)) {
                        result.put("success", false);
                        result.put("error", "User already own this item");
                    } else {
                        int diamond = rm.getDiamondAmount(player.getId());
                        if (price > diamond) {
                            result.put("success", false);
                            result.put("error", "Your balance not enough!");
                        } else {
                            diamond -= price;
                            rm.setDiamondAmount(player.getId(), diamond);
                            im.addItemToPlayer(player.getId(), id);
                            result.put("success", true);
                        }
                    }
                }
            }

        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    public static JSONObject getPlayerData(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String username = request.getParameter("username");

            PlayerModel pm = new PlayerModel();
            Player player = pm.getUserByUsername(username);

            if (player == null) {
                result.put("success", false);
                result.put("error", "Username is not exist");
            } else {

                int numberOfShip = new ShipModel().getShipsByPlayerID(player.getId()).size();
                int numberOfItem = new ItemModel().getItemsByPlayerID(player.getId()).size();
                int diamondAmount = new ResourceModel().getDiamondAmount(player.getId());
                result.put("success", true);
                result.put("data", player);
                result.put("numberOfShip", numberOfShip);
                result.put("numberOfItem", numberOfItem);
                result.put("diamondAmount", diamondAmount);
            }

        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    public static JSONObject getPlayerInfo(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String playerId = request.getParameter("id");
            String playerUsername = request.getParameter("username");

            Player player = null;

            if (playerId != null) {
                player = new PlayerModel().getUserById(Long.parseLong(playerId));
                if (player == null) {
                    throw new Exception("this id is not exist!");
                }
            } else if (playerUsername != null) {
                List<Player> players = new PlayerModel().getIf("[Username] = ?", playerUsername);
                if (!players.isEmpty()) {
                    player = players.get(0);
                } else {
                    throw new Exception("this username is not exist!");
                }
            } else {
                throw new Exception("id and username is missing!");
            }

            result.put("success", true);

            player.setPassword(null);
            player.setRole(null);

            result.put("player", player);
        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    public static JSONObject getPlayerExtraInfo(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String token = request.getParameter("token");

            Player player = null;

            if (token != null && !token.isEmpty()) {
                player = Authentication.getPlayerInformationByToken(token);

                if (player == null) {
                    throw new Exception("Username is not exist!");
                }
            } else {
                throw new Exception("token is missing!");
            }

            // Get Player Success
            // Then get player extra information
            ResourceModel rm = new ResourceModel();

            JSONObject extra = new JSONObject();
            extra.put("ship", new ShipModel().getPlayerEquippedShip(player.getId()));
            extra.put("gold", rm.getGoldAmount(player.getId()));
            extra.put("ruby", rm.getRubyAmount(player.getId()));
            extra.put("diamond", rm.getDiamondAmount(player.getId()));

            result.put("success", true);

            player.setPassword(null);
            player.setRole(null);
            player.put("extra", extra);

            result.put("player", player);
        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    public static JSONObject getAllShips(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String token = request.getParameter("token");

            List<Ship> list = new ArrayList<>();
            if (token == null || token.isEmpty()) {
                list = new ShipModel().getall();
            } else {
                Player player = Authentication.getPlayerInformationByToken(token);

                if (player == null) {
                    result.put("success", false);
                    result.put("error", "User is not exist");
                } else {
                    list = new ShipModel().getall();

                    Ship equipedShip = new ShipModel().getPlayerEquippedShip(player.getId());

                    List<Ship> ownerShips = new ShipModel().getShipsByPlayerID(player.getId());

                    for (Ship ship : list) {
                        if (ownerShips.stream().anyMatch(t -> Objects.equals(t.getId(), ship.getId()))) {
                            ship.put("isOwner", true);
                        }
                        ship.put("isEquipped", Objects.equals(ship.getId(), equipedShip.getId()));
                    }
                }
            }
            result.put("success", true);
            result.put("ships", list);

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
                    list = new ItemModel().getall();

                    List<Item> ownerItems = new ItemModel().getItemsByPlayerID(player.getId());

                    int[] ids = {
                        -1,
                        player.getWeaponID(),
                        player.getEngineID(),
                        player.getSailID()
                    };

                    for (Item item : list) {
                        if (ownerItems.stream().anyMatch(t -> Objects.equals(t.getId(), item.getId()))) {
                            item.put("isOwner", true);
                        }
                        item.put("isEquipped", item.getId() == ids[item.getType()]);
                    }
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

    public static JSONObject logout(HttpServletRequest request, PrintWriter response) throws Exception {
        JSONObject result = new JSONObject();

        try {
            String token = request.getParameter("token");

            if (token == null || token.isEmpty()) {
                throw new Exception("The token is invalid");
            } else {
                Player player = Authentication.getPlayerInformationByToken(token);

                if (player == null) {
                    throw new Exception("Username is not exist");
                } else {
                    player.setActive(false);
                    new PlayerModel().update(player);
                    result.put("success", true);
                }
            }

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
            Player p = new PlayerModel().getPlayerByUsernameAndPassword(username, password);
            if (p != null) {
                if (p.getRole()==2)
                {
                    throw new Exception("The account has been ban.Check your email for more detail.");
                }
                else
                if (!p.isActive()) {
                    String token = Authentication.createTokenCookie(p.getId(), 60 * 60 * 24).getValue();
                    p.setActive(true);
                    new PlayerModel().update(p);
                    result.put("success", true);
                    result.put("token", token);
                } else {
                    throw new Exception("The account has been logged in another device");
                }

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
