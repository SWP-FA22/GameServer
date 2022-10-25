/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Posts;
import java.sql.ResultSet;

/**
 *
 * @author Huu
 */
public class PostsModel extends ModelBase<Posts> {

    public PostsModel() throws Exception {
        super(Posts.class);
    }

    public Posts get(int id) throws Exception {
        try ( ResultSet rs = connection().executeQuery("SELECT * FROM [dbo].[Post] WHERE [ID] = ?",id)) {
            if (rs.next()) {
                Posts post=new Posts();
                post.setId(rs.getInt("ID"));
                post.setCreatedBy(rs.getInt("CreatedBy"));
                post.setDescription(rs.getString("Description"));
                post.setIsApproved(rs.getBoolean("isApproved"));
                post.setTimeCreate(rs.getDate("TimeCreate"));
                post.setTitle(rs.getString("Title"));
              //  post.loadProps(rs);
                return post;
            }
        }
        return null;
    }
}
