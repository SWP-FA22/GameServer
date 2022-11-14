package controllers;

import entities.CheckIn;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import models.CheckInModel;
import models.PlayerModel;
import models.ResourceModel;

@WebServlet(name = "CheckinServlet", urlPatterns = {"/check-in"})
public class CheckinServlet extends BaseSerlvet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.setAttribute("checkinItems", new CheckInModel().getAllCheckinItems());

            request.getRequestDispatcher("checkin.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try ( PrintWriter pw = response.getWriter()) {
            try {
                if (player == null) {
                    throw new Exception("You are not login");
                }

                if (player.isIscheckedin()) {
                    throw new Exception("You are already check-in today");
                }

                PlayerModel pm = new PlayerModel();
                player.setIscheckin(true);
                pm.updateIscheckin(player);

                int count = 0;
                if (player.getCheckincount() != null) {
                    count = player.getCheckincount();
                }
                count = (count % 14) + 1;
                player.setCheckincount(count);
                pm.updateCheckinCount(player);

                CheckInModel cim = new CheckInModel();
                CheckIn ci = cim.getCheckInByCount(count);
                ResourceModel rm = new ResourceModel();
                rm.addResourceAmount(player.getId(), ci.getResourceid(), ci.getAmount());
                throw new Exception("Success");
            } catch (Exception e) {
                pw.print(e.getMessage());
            }
        }
    }
}
