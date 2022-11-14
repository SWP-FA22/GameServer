/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Comment;
import entities.Player;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Huu
 */
public class CommentModel extends ModelBase<Comment> {

    public CommentModel() throws Exception {
        super(Comment.class);
    }

    public Integer getCommentCount(Integer postId) throws SQLException {
        try ( ResultSet rs = getConnection().executeQuery("SELECT COUNT(*) FROM [Comment] WHERE [PostID] = ?", postId)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return null;
    }

    public List<Map.Entry<Player, Comment>> getCommentsByPage(Integer postId, int page, int size) throws SQLException, Exception {
        String sql
                = "SELECT * FROM [Comment], [Player] \n"
                + "WHERE [Player].[ID] = [Comment].[CreatedBy] AND [Comment].[PostID] = " + postId + "\n"
                + "ORDER BY [Comment].[ID] DESC\n"
                + "OFFSET " + page * size + " ROWS\n"
                + "FETCH NEXT " + size + " ROWS ONLY";

        try ( ResultSet rs = getConnection().executeQuery(sql)) {
            List<Map.Entry<Player, Comment>> comments = new ArrayList<>();

            while (rs.next()) {
                Player player = new Player();
                player.loadProps(rs);
                Comment comment = new Comment();
                comment.setCreatedBy(rs.getInt("CreatedBy"));
                comment.setDescription(rs.getString("Description"));
                comment.setPostID(rs.getInt("PostID"));
                comment.setTimeCreate(rs.getDate("TimeCreate"));
                comments.add(new AbstractMap.SimpleEntry<>(player, comment));
            }

            return comments;
        }
    }
}
