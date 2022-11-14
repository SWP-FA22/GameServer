package controllers;

import entities.Player;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PlayerModel;
import models.ResourceModel;
import utils.Authentication;

public abstract class BaseSerlvet extends HttpServlet {

    protected Player player;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String token = Authentication.getTokenFromCookies(request.getCookies());
            player = Authentication.getPlayerInformationByToken(token);

            if (player != null) {
                request.setAttribute("diamond", new ResourceModel().getDiamondAmount(player.getId()));
            }

            request.setAttribute("player", player);
        } catch (Exception e) {
            player = null;
        }
        super.service(request, response);
    }
}
