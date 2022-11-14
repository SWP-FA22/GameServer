package controllers.post;

import controllers.BaseSerlvet;
import entities.Post;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Objects;
import models.PostModel;

@WebServlet(urlPatterns = {"/view-post"})
public class ViewPostServlet extends BaseSerlvet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _id = request.getParameter("id");

        try {
            Post post = new PostModel().get(Integer.parseInt(_id));

            if (!post.getIsApproved() && !Objects.equals(post.getCreatedBy(), player.getId()) && player.getRole() != 1) {
                throw new Exception("this post is not approved and you are not author");
            }

            request.setAttribute("post", post);
            request.getRequestDispatcher("views-post/view-post.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String id = request.getParameter("id");

        try {
            PostModel pm = new PostModel();
            if (action.equals("approve")) {
                pm.updateStatusPost(Integer.parseInt(id), true);
                response.sendRedirect("view-post?id=" + id);
            } else {
                pm.deletePost(Integer.parseInt(id));
                response.sendRedirect("admin");
            }

        } catch (Exception e) {
            response.sendError(404);
        }
    }
}
