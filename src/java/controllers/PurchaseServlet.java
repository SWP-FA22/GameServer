package controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import models.ResourceModel;
import models.TransactionModel;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.GlobalConstants;

@WebServlet(name = "PurchaseServlet", urlPatterns = {"/purchase"})
public class PurchaseServlet extends BaseSerlvet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (player == null) {
            response.sendRedirect("signin?error=please, signin first");
            return;
        }

        request.getRequestDispatcher("purchase.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // secure-token to verify this transaction report
            String secureToken = request.getHeader("secure-token");
            String contentLength = request.getHeader("content-length");

            if (secureToken == null || !secureToken.equals(GlobalConstants.SECURE_TOKEN)) {
                throw new Exception("Invalid secure-token");
            }

            // collect all transactions data
            JSONArray transactions;
            try ( InputStream is = request.getInputStream()) {
                byte[] b = new byte[Integer.parseInt(contentLength)];
                is.read(b);
                JSONObject json = new JSONObject(new String(b, Charset.forName("utf-8")));

                if (json.getInt("error") != 0) {
                    throw new Exception("Transaction is error");
                }

                transactions = json.getJSONArray("data");
            }

            // for through this array to process
            int transactionCount = transactions.length();
            for (int i = 0; i < transactionCount; i++) {
                JSONObject trans = transactions.getJSONObject(i);

                // get UID from description
                String des = trans.getString("description");

                Pattern ptn = Pattern.compile("PID(\\d+)");
                Matcher mct = ptn.matcher(des);
                if (!mct.find()) {
                    throw new Exception("Cannot find PID");
                }

                int playerID = Integer.parseInt(mct.group(1));
                int amount = trans.getInt("amount");

                new TransactionModel().createNewTransaction(playerID, amount);
                new ResourceModel().addDiamondAmount(playerID, amount);
            }
        } catch (Exception e) {
            response.getWriter().print(e.getMessage());
        }
    }
}
