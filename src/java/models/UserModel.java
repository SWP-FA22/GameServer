/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Player;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilities.Crypto;

/**
 *
 * @author Huu
 */
public class UserModel extends ModelBase<Player> {

    public UserModel() throws Exception {
        super(Player.class);
    }

    public Player getUserByEmail(String email) throws SQLException {
        try ( ResultSet rs = ModelBase.connection().executeQuery("SELECT * FROM [Player] WHERE Email = ?", email)) {
            if (rs.next()) {
                return new Player(rs.getInt("ID"), rs.getString("password"), rs.getString("username"), rs.getString("name"),
                        email, rs.getInt("weaponid"), rs.getInt("engineID"), rs.getInt("sailid"), rs.getInt("rank"));
            }
            return null;
        }
    }

    public void updatePassword(Player u) throws SQLException {
        ModelBase.connection().executeUpdate("UPDATE [Player] SET [Password] = ? WHERE [ID] = ?", u.getPassword(), u.getId());
    }

    public Player getUserById(Long id) throws SQLException {
        try ( ResultSet rs = ModelBase.connection().executeQuery("SELECT * FROM [Player] WHERE [ID] = ?", id)) {
            if (rs.next()) {
                return new Player(rs.getInt("ID"), rs.getString("Password"), rs.getString("Username"), rs.getString("Name"),
                        rs.getString("Email"), rs.getInt("WeaponID"), rs.getInt("EngineID"), rs.getInt("SailID"), rs.getInt("Rank"));
            }
            return null;
        }
    }

    public String getHashedPasswordById(Integer id) throws SQLException {
        try ( ResultSet rs = ModelBase.connection().executeQuery("SELECT * FROM [Player] WHERE [ID] = ?", id)) {
            if (rs.next()) {
                return rs.getString("password");
            }
            return null;
        }
    }

    public static boolean checkDuplicateEmail(String email) throws SQLException {
        try ( ResultSet rs = ModelBase.connection().executeQuery("SELECT * FROM [Player] WHERE [Email] = ?", email)) {
            return rs.next();
        }
    }

    public static boolean createAccount(String username, String password, String email, String name) throws SQLException {
        return ModelBase.connection().executeUpdate("INSERT INTO [Player]([Username], [Password], [Email], [Name]) VALUES (?, ?, ?, ?)",
                username, Crypto.SHA256(password), email, name) > 0;
    }

    public static Integer checkAuth(String username, String password) throws SQLException {
        try ( ResultSet rs = ModelBase.connection().executeQuery(
                "Select [ID] FROM [Player] WHERE [Username] = ? AND [Password] = ? COLLATE Latin1_General_CS_AS",
                username, Crypto.SHA256(password))) {
            if (rs.next()) {
                return rs.getInt("ID");
            }
            return null;
        }
    }
}
