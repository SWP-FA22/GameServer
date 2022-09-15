/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.Crypto;

/**
 *
 * @author Huu
 */
public class UserProcedure {
    public static boolean checkDuplicateEmail(String email) throws SQLException {
        try ( PreparedStatement stmt = ModelBase.connection().prepareStatement(
                "select * from [User] where gmail=?",
                 email)) {
            ResultSet rs= stmt.executeQuery();
            if (rs.next()) return false;
            return true;
        }
    }
    public static void createAccount(String username, String password, String email) throws SQLException {
        try ( PreparedStatement stmt = ModelBase.connection().prepareStatement(
                "insert into [User] (playername,[password],gmail) values (?,?,?)",
                username, Crypto.SHA256(password), email)) {
            stmt.execute();
        }
    }
    public static void main(String[] args) throws SQLException {
        System.out.println(UserProcedure.checkDuplicateEmail("huu@gmail.com"));
    }
}
