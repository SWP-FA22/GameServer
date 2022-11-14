package controllers;

import entities.Player;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;
import models.PlayerModel;

@WebServlet(name = "RankingServlet", urlPatterns = {"/ranking"})
public class RankingServlet extends BaseSerlvet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("rankers", new PlayerModel().getTopRanking());

            if (player != null) {
                List<Player> players = new PlayerModel().getall();

                players.sort((a, b) -> b.getRank() - a.getRank());

                for (int i = 0; i < players.size(); i++) {
                    if (Objects.equals(players.get(i).getId(), player.getId())) {
                        request.setAttribute("myrank", i + 1);
                        break;
                    }
                }

            }

            request.getRequestDispatcher("ranking.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
