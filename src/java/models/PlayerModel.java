/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Player;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import utilities.Crypto;

/**
 *
 * @author Huu
 */
public class PlayerModel extends ModelBase<Player> {

    public PlayerModel() throws Exception {
        super(Player.class);
    }

    public Player getUserByEmail(String email) throws Exception {
        List<Player> players = getIf("[EMAIL] = ?", email);
        if (!players.isEmpty()) {
            return players.get(0);
        }
        return null;
    }

    public void updatePassword(Player u) throws Exception {
        ModelBase.connection().executeUpdate("UPDATE [Player] SET [Password] = ? WHERE [ID] = ?", u.getPassword(), u.getId());
    }

    public void updateRole(Player u) throws SQLException {
        ModelBase.connection().executeUpdate("UPDATE [Player] SET [Role] = ? WHERE [ID] = ?", u.getRole(), u.getId());
    }

    public int getIdByUsername(String username) throws SQLException {
        try ( ResultSet rs = ModelBase.connection().executeQuery("SELECT * FROM [Player] WHERE [Username] = ?", username)) {
            if (rs.next()) {
                return rs.getInt("ID");
            }
            return -1;
        }
    }

    public String getHashedPasswordById(Integer id) throws Exception {
        Player player = get(id);
        return player != null ? player.getPassword() : null;
    }

    public boolean isEmailExist(String email) throws Exception {
        return getUserByEmail(email) != null;
    }

    public boolean createAccount(String username, String password, String email, String name) throws Exception {
        return ModelBase.connection().executeUpdate("INSERT INTO [Player]([Username], [Password], [Email], [Name]) VALUES (?, ?, ?, ?)",
                username, Crypto.SHA256(password), email, name) > 0;
    }

    public Integer getUserIDByUsernameAndPassword(String username, String password) throws Exception {
        List<Player> players = getIf("[Username] = ? AND [Password] = ? COLLATE Latin1_General_CS_AS", username, Crypto.SHA256(password));
        if (!players.isEmpty()) {
            return players.get(0).getId();
        }
        return null;
    }

    public Player getUserById(Long id) throws Exception {
        List<Player> players = getIf("[ID] = ?", id);
        if (!players.isEmpty()) {
            return players.get(0);
        }
        return null;
    }

   

}
