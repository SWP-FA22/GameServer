/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Huu
 */
public class UserModel extends ModelBase<User>{
     public UserModel() throws Exception {
        super(User.class);
    }
     public User getUserByGmail(String email) throws SQLException
     {
         try ( PreparedStatement stmt = ModelBase.connection().prepareStatement(
                "select * from [User] where gmail=?",
                 email)) {
            ResultSet rs= stmt.executeQuery();
            if (rs.next()) {
                //User u=new User
                User u=new User(rs.getInt("userid"), rs.getString("password"), rs.getString("playername"),
                email, rs.getInt("userid"), rs.getInt("userid"), rs.getInt("userid"));
                return u;
            }
            return null;
        }
     }
     public String getPasswordById(Long id) throws SQLException
     {
         try ( PreparedStatement stmt = ModelBase.connection().prepareStatement(
                "select * from [User] where userid=?",
                 id)) {
            ResultSet rs= stmt.executeQuery();
            if (rs.next()) {
               
                return rs.getString("password");
            }
            return null;
        }
     }
}
