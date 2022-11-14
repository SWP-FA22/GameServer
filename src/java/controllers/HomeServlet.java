package controllers;

import entities.Player;
import entities.Post;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import models.PostModel;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends BaseSerlvet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PostModel pm = new PostModel();

            List<Map.Entry<Player, Post>> allPosts = pm.getAllPostWithPlayer();

            if (allPosts.size() > 8) {
                allPosts.sort((a, b) -> b.getValue().getTimeCreate().getNanos() - a.getValue().getTimeCreate().getNanos());
                allPosts = allPosts.subList(0, 8).stream().filter(e -> e.getValue().getIsApproved()).collect(Collectors.toList());
            }

            request.setAttribute("posts", allPosts);

            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
