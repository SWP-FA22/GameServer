package controllers.post;

import controllers.BaseSerlvet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.PostModel;

@WebServlet(name = "CreatePostServlet", urlPatterns = {"/create-post"})
public class CreatePostServlet extends BaseSerlvet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (player == null) {
            response.sendRedirect("signin");
            return;
        }

        request.getRequestDispatcher("views-post/create-post.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (player == null) {
                response.sendRedirect("signin");
                return;
            }

            String title = request.getParameter("title").trim();
            String description = request.getParameter("description").trim();

            new PostModel().createPost(player.getId(), title, description);
            response.sendRedirect("profile");
        } catch (Exception e) {
            response.sendError(404);
        }
    }
}
