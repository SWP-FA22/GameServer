/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package routes;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.nio.charset.Charset;
import models.ResourceModel;
import org.json.JSONArray;
import org.json.JSONObject;
import utilities.GlobalConstants;

/**
 *
 * @author quang
 */
public class PurchaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("purchase.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                int playerID = Integer.parseInt(trans.getString("description"));
                int amount = trans.getInt("amount");

                new ResourceModel().addDiamondAmount(playerID, amount);
            }
        } catch (Exception e) {
            response.sendError(500);
        }
    }

}
