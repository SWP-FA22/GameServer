/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Player;
import entities.Post;
import java.sql.ResultSet;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LinhThuy
 */
public class PostModel extends ModelBase<Post> {

    public PostModel() throws Exception {
        super(Post.class);
    }

    public PostModel(Class<Post> entityClass) throws Exception {
        super(entityClass);
    }

    public boolean createPost(int createdby, String title, String description) throws Exception {
        return ModelBase.connection().executeUpdate("INSERT INTO [Post] ([CreatedBy], [Title], [Description]) VALUES ( ?, ?, ?)", createdby, title, description) > 0;
    }

    public List<Post> getPostByPlayerID(Integer id) throws Exception {
        List<Post> listbypid = new ArrayList<>();
        try ( ResultSet rs = ModelBase.connection().executeQuery(" SELECT * FROM [Post] WHERE [CreatedBy] = ? ORDER BY [TimeCreate] DESC", id)) {
            while (rs.next()) {
                Post post = new Post();
                post.loadProps(rs);
                listbypid.add(post);
            }
            return listbypid;
        }
    }

    public List<Post> getPost() throws Exception {
        List<Post> listbypid = new ArrayList<>();
        try ( ResultSet rs = ModelBase.connection().executeQuery(" SELECT * FROM [Post] WHERE [isApproved] = 1")) {
            while (rs.next()) {
                Post post = new Post();
                post.loadProps(rs);
                listbypid.add(post);
            }
            return listbypid;
        }
    }

    public List<Post> getPost(int page, int size) throws Exception {
        List<Post> listbypid = new ArrayList<>();
        try ( ResultSet rs = ModelBase.connection().executeQuery("select * from Post where  isApproved=1 order by TimeCreate DESC offset ? rows fetch next ? rows only", page * size, size)) {
            while (rs.next()) {
                Post post = new Post();
                post.loadProps(rs);
                listbypid.add(post);
            }
            return listbypid;
        }
    }

    public List<Post> getPost(String name) throws Exception {
        List<Post> listbypid = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [Post] WHERE [isApproved] = 1 ";
            if (name != null && !name.equals("")) {
                sql += " and Title like '%" + name + "%' or Description like '%" + name + "%'";
                ResultSet rs = ModelBase.connection().executeQuery(sql);
                while (rs.next()) {
                    Post post = new Post();
                    post.loadProps(rs);
                    listbypid.add(post);
                }
                return listbypid;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Map.Entry<Player, Post>> getAllPostWithPlayer() throws Exception {
        List<Map.Entry<Player, Post>> result = new ArrayList<>();
        try ( ResultSet rs = ModelBase.connection().executeQuery(" SELECT * FROM [Post], [Player] WHERE [Post].[CreatedBy] = [Player].[ID]")) {
            while (rs.next()) {
                Post post = new Post();
                Player player = new Player();
                post.loadProps(rs);
                player.loadProps(rs);
                result.add(new AbstractMap.SimpleEntry<>(player, post));
            }
            return result;
        }
    }

    public void updateStatusPost(int postid, boolean isApprove) throws Exception {
        ModelBase.connection().executeUpdate("UPDATE [Post] SET [isApproved] = ? WHERE [ID] = ?", isApprove, postid);

    }

    public boolean deletePost(int id, int createdBy) throws Exception {
        return getConnection().executeUpdate("DELETE FROM [POST] WHERE [ID] = ? AND [CreatedBy] = ?", id, createdBy) > 0;
    }

    public boolean deletePost(int id) throws Exception {
        return getConnection().executeUpdate("DELETE FROM [POST] WHERE [ID] = ?", id) > 0;
    }

    public void updatePost(String title, String description, Integer id, int createdBy) throws Exception {
        ModelBase.connection().executeUpdate("update [Post] set [Title] = ?, [Description] = ? where [ID] = ? AND [CreatedBy] = ?", title, description, id, createdBy);
    }

}
