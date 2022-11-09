/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package routes;

import entities.Comment;
import entities.Player;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.Session;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import models.CommentModel;
import org.json.JSONObject;
import utilities.Authentication;
import utilities.JSONDecoder;
import utilities.JSONEncoder;

/**
 *
 * @author Huu
 */
@jakarta.websocket.server.ServerEndpoint(value = "/comment", decoders = {JSONDecoder.class}, encoders = {JSONEncoder.class})
public class CommentWebSocket {

    private static final List<Session> clients = new ArrayList<>();

    @jakarta.websocket.OnOpen
    public void onOpen(Session client, EndpointConfig config) {
        clients.add(client);
    }

    @jakarta.websocket.OnClose
    public void onClose(Session client) {
        clients.remove(client);
    }

    @jakarta.websocket.OnMessage
    public JSONObject onMessage(JSONObject request, Session session) throws Exception {
        JSONObject response = new JSONObject();

        String action = request.getString("action");
        response.put("action", action);

        switch (action) {
            case "get":
                doGet(request, response);
                return response;
            case "post":
                doPost(request, response);
                break;
        }

        for (Session client : clients) {
            client.getAsyncRemote().sendText(new JSONEncoder().encode(response));
        }

        return null;
    }

    public void doGet(JSONObject request, JSONObject response) throws Exception {
        final int pageSize = 10;

        CommentModel commentModel = new CommentModel();

        // get params from request
        Integer postId = request.getInt("post_id");
        Integer page = request.getInt("page");

        // response comment count to client
        response.put("size", commentModel.getCommentCount(postId));

        // response comments by page to client
        response.put("comments",
                commentModel.getCommentsByPage(postId, page, pageSize)
                        .stream()
                        .map(comment -> new JSONObject[]{
                    comment.getKey(),
                    comment.getValue()
                }).toArray()
        );
    }

    public void doPost(JSONObject request, JSONObject response) throws Exception {
        CommentModel commentModel = new CommentModel();

        // get params from request
        Integer postId = request.getInt("post_id");
        String token = request.getString("token");
        String content = request.getString("content");
        java.util.Date date = new java.util.Date();
        Date time = new Date(date.getTime());
        //Date time = new Date(utilDate.getTime());
        if (content.trim().isEmpty()) {
            return;
        }

        Player player = Authentication.getPlayerInformationByToken(token);

        // insert comment to database
        Comment comment = new Comment(null, postId, player.getId(), content, time);
        commentModel.insert(comment);

        // response new comment to all client
        response.put("comment", new JSONObject[]{
            player,
            comment
        });

        // response comment count to client
        response.put("size", commentModel.getCommentCount(postId));
    }

}