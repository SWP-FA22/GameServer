package controllers;

import entities.Player;
import entities.Post;
import entities.Transaction;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import models.PlayerModel;
import models.PostModel;
import models.TransactionModel;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends BaseSerlvet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (player == null || player.getRole() != 1) {
            response.sendError(403);
            return;
        }

        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (player == null || player.getRole() != 1) {
            response.sendError(403);
            return;
        }

        String action = request.getParameter("action");

        try ( PrintWriter out = response.getWriter()) {
            switch (action) {
                case "get-posts":
                    out.print(getPosts(request).toString());
                    break;
                case "get-accounts":
                    out.print(getAccounts(request).toString());
                    break;
                case "get-transactions":
                    out.print(getTransactions(request).toString());
                    break;
                case "ban-player":
                    out.print(banPlayer(request).toString());
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
        }
    }

    public static JSONObject banPlayer(HttpServletRequest request) throws Exception {
        JSONObject result = new JSONObject();

        String id = request.getParameter("id");

        try {
            Player p = new PlayerModel().get(Integer.parseInt(id));

            if (p == null) {
                throw new Exception("cannot find player");
            }

            if (p.getRole() == -1) {
                p.setRole(0);
            } else {
                p.setRole(-1);
            }

            new PlayerModel().updateRole(p);

            result.put("success", true);
            result.put("isBanned", p.getRole());
        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    public static JSONObject getTransactions(HttpServletRequest request) throws Exception {
        JSONObject result = new JSONObject();

        String _page = request.getParameter("page");
        String _size = request.getParameter("size");

        String _from = request.getParameter("from");
        String _to = request.getParameter("to");
        String username = request.getParameter("username");

        try {
            List<Map.Entry<Transaction, Player>> data = new TransactionModel().getAllTransactionWithPlayer();

            if (username != null) {
                data = data.stream().filter(e -> e.getValue().getUsername().contains(username)).collect(Collectors.toList());
            }

            if (_from != null && _to != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                Date from = sdf.parse(_from);
                Date to = sdf.parse(_to);

                if (from.after(to)) {
                    throw new Exception("from is after to");
                }

                data = data.stream().filter(e -> {
                    Timestamp ts = e.getKey().getTime();
                    return ts.after(from) && ts.before(to);
                }).collect(Collectors.toList());
            }

            if (_page != null && _size != null) {
                int page = Integer.parseInt(_page);
                int size = Integer.parseInt(_size);

                int from = page * size;
                int to = from + size;
                // from <= x < to
                if (0 <= from && from < to && to <= data.size()) {
                    data = data.subList(from, to);
                }
            }

            JSONArray transactions = new JSONArray();

            for (Map.Entry<Transaction, Player> entry : data) {
                Transaction t = entry.getKey();
                transactions.put(new JSONObject() {
                    {
                        put("playerName", entry.getValue().getUsername());
                        put("time", t.getTime());
                        put("playerID", t.getPlayerID());
                        put("amount", t.getAmount());
                    }
                });
            }

            result.put("success", true);
            result.put("transactions", transactions);
        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    public static JSONObject getAccounts(HttpServletRequest request) throws Exception {
        JSONObject result = new JSONObject();

        String _page = request.getParameter("page");
        String _size = request.getParameter("size");

        String q = request.getParameter("q");

        try {
            List<Player> data = new PlayerModel().getall();

            if (q != null) {
                data = data.stream().filter(e -> (e.getName() + "|" + e.getEmail() + "|" + e.getUsername()).contains(q)).collect(Collectors.toList());
            }

            if (_page != null && _size != null) {
                int page = Integer.parseInt(_page);
                int size = Integer.parseInt(_size);

                int from = page * size;
                int to = from + size;
                // from <= x < to
                if (0 <= from && from < to && to <= data.size()) {
                    data = data.subList(from, to);
                }
            }

            result.put("success", true);
            result.put("players", data);
        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }

    public static JSONObject getPosts(HttpServletRequest request) throws Exception {
        JSONObject result = new JSONObject();
        String _approve = request.getParameter("approve");

        String _page = request.getParameter("page");
        String _size = request.getParameter("size");

        try {
            List<Map.Entry<Player, Post>> data = new PostModel().getAllPostWithPlayer();

            if (_approve != null) {
                boolean approve = Boolean.parseBoolean(_approve);
                data = data.stream().filter(e -> e.getValue().getIsApproved() == approve).collect(Collectors.toList());
            }

            if (_page != null && _size != null) {
                int page = Integer.parseInt(_page);
                int size = Integer.parseInt(_size);

                int from = page * size;
                int to = from + size;
                // from <= x < to
                if (0 <= from && from < to && to <= data.size()) {
                    data = data.subList(from, to);
                }
            }

            JSONArray posts = new JSONArray();

            for (Map.Entry<Player, Post> entry : data) {
                posts.put(new JSONObject(new HashMap() {
                    {
                        Player player = entry.getKey();
                        Post post = entry.getValue();

                        put("id", post.getId());
                        put("title", post.getTitle());
                        put("date", post.getTimeCreate());
                        put("player-name", player.getUsername());
                        put("player-id", post.getCreatedBy());
                    }
                }));
            }

            result.put("success", true);
            result.put("posts", posts);
        } catch (Exception e) {
            result.put("success", false);
            result.put("error", e.getMessage());
        }
        return result;
    }
}
