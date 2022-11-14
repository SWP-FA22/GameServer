package controllers;

import entities.Item;
import entities.Player;
import entities.Post;
import entities.Ship;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import models.ItemModel;
import models.PlayerModel;
import models.PostModel;
import models.ShipModel;

@WebServlet(name = "ProfileServlet", urlPatterns = {"/profile"})
public class ProfileServlet extends BaseSerlvet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _id = request.getParameter("id");

        try {
            if (player == null) {
                response.sendRedirect("signin");
                return;
            }

            Integer id = player.getId();
            request.setAttribute("isMe", true);
            if (_id != null) {
                id = Integer.parseInt(_id);

                Player p = new PlayerModel().get(id);

                if (p == null) {
                    throw new Exception("cannot find this player");
                }

                request.setAttribute("player", p);
                request.setAttribute("isMe", p.getId() == player.getId());

            }

            List<Ship> ships = new ShipModel().getShipsByPlayerID(id);
            List<Item> items = new ItemModel().getItemsByPlayerID(id);
            List<Post> posts = new PostModel().getPostByPlayerID(id);

            request.setAttribute("ships", ships);
            request.setAttribute("items", items);
            request.setAttribute("posts", posts);

            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
