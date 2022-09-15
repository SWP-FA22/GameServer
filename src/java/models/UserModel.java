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
                email, rs.getInt("weaponitemid"), rs.getInt("engineitemid"), rs.getInt("saillitemid"));
                return u;
            }
            return null;
        }
     }
     public void updatePassword(User u) throws SQLException
     {
         try ( PreparedStatement stmt = ModelBase.connection().prepareStatement(
                "update  [User] set [password]=? where userid=?",u.getPassword(),u.getUserid()
                 )) {
           stmt.executeUpdate();
            
        }
     }
      public User getUserById(Long id) throws SQLException
     {
         try ( PreparedStatement stmt = ModelBase.connection().prepareStatement(
                "select * from [User] where userid=?",
                 id)) {
            ResultSet rs= stmt.executeQuery();
            if (rs.next()) {
                //User u=new User
                User u=new User(rs.getInt("userid"), rs.getString("password"), rs.getString("playername"),rs.getString("gmail")
                , rs.getInt("weaponitemid"), rs.getInt("engineitemid"), rs.getInt("saillitemid"));
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
