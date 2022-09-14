/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import utilities.Crypto;

/**
 *
 * @author Huu
 */
public class UserProcedure {

    public static void createAccount(String username, String password, String email) throws SQLException {
        try ( PreparedStatement stmt = ModelBase.connection().prepareStatement(
                "insert into [User] (playername,[password],gmail) values (?,?,?)",
                username, Crypto.SHA256(password), email)) {
            stmt.execute();
        }
    }
    public static void main(String[] args) throws SQLException {
        UserProcedure.createAccount("123", "123", "123");
    }
}
