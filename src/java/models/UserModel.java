/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Player;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.Crypto;

/**
 *
 * @author Huu
 */
public class UserModel extends ModelBase<Player>{
     public UserModel() throws Exception {
        super(Player.class);
    }
     public Player getUserByEmail(String email) throws SQLException
     {
         try ( PreparedStatement stmt = ModelBase.connection().prepareStatement(
                "select * from Player where email=?",
                 email)) {
            ResultSet rs= stmt.executeQuery();
            if (rs.next()) {
               // User u=new Player
                Player u=new Player(rs.getInt("ID"), rs.getString("password"), rs.getString("username"),rs.getString("name"),
                email, rs.getInt("weaponid"), rs.getInt("engineID"), rs.getInt("sailid"),rs.getInt("rank"));
                return u;
            }
            return null;
        }
     }
     public void updatePassword(Player u) throws SQLException
     {
         try ( PreparedStatement stmt = ModelBase.connection().prepareStatement(
                "update  Player set [password]=? where ID=?",u.getPassword(),u.getId()
                 )) {
           stmt.executeUpdate();
            
        }
     }
      public Player getUserById(Long id) throws SQLException
     {
         try ( PreparedStatement stmt = ModelBase.connection().prepareStatement(
                "select * from Player where ID=?",
                 id)) {
            ResultSet rs= stmt.executeQuery();
            if (rs.next()) {
                //User u=new Player
                Player u=new Player(rs.getInt("ID"), rs.getString("password"), rs.getString("username"),rs.getString("name"),
                rs.getString("Email"), rs.getInt("weaponid"), rs.getInt("engineid"), rs.getInt("sailid"),rs.getInt("rank"));
                return u;
            }
            return null;
        }
     }
     public String getPasswordById(Long id) throws SQLException
     {
         try ( PreparedStatement stmt = ModelBase.connection().prepareStatement(
                "select * from Player where ID=?",
                 id)) {
            ResultSet rs= stmt.executeQuery();
            if (rs.next()) {
               
                return rs.getString("password");
            }
            return null;
        }
     }
     public static boolean checkDuplicateEmail(String email) throws SQLException {
        try ( PreparedStatement stmt = ModelBase.connection().prepareStatement(
                "select * from Player where email=?",
                 email)) {
            ResultSet rs= stmt.executeQuery();
            if (rs.next()) return false;
            return true;
        }
    }
    public static void createAccount(String username, String password, String email,String name) throws SQLException {
        try ( PreparedStatement stmt = ModelBase.connection().prepareStatement(
                "insert into Player (username,[password],email,name) values (?,?,?,?)",
                username, Crypto.SHA256(password), email,name)) {
            stmt.execute();
        }
    }
    public static void main(String[] args) throws Exception {
        UserModel u=new UserModel();
        Player a=u.getUserByEmail("banghuund99@gmail.com");
        System.out.println(a);
    }
}
