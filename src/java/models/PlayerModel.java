/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Player;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public void updateRank(Player u) throws Exception {
        ModelBase.connection().executeUpdate("UPDATE [Player] SET [Rank] = ? WHERE [ID] = ?", u.getRank(), u.getId());
    }

    public Player getUserByEmail(String email) throws Exception {
        List<Player> players = getIf("[EMAIL] = ?", email);
        if (!players.isEmpty()) {
            return players.get(0);
        }
        return null;
    }

    public void resetCheckin() throws Exception {
        ModelBase.connection().executeUpdate("UPDATE [dbo].[Player]\n"
                + "   SET [IsCheckIn] = 0");
    }

    public void updateCheckinCount(Player u) throws Exception {
        ModelBase.connection().executeUpdate("UPDATE [Player] SET [CheckInCount] = ? WHERE [ID] = ?", u.getCheckincount(), u.getId());
    }

    public void updateIscheckin(Player u) throws Exception {
        ModelBase.connection().executeUpdate("UPDATE [Player] SET [IsCheckIn] = ? WHERE [ID] = ?", u.isIscheckedin(), u.getId());
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

    public List<Player> getPlayer(int page, int size) throws Exception {
        List<Player> listbypid = new ArrayList<>();
        try ( ResultSet rs = ModelBase.connection().executeQuery("select * from Player where  Role!=1 order by ID DESC offset ? rows fetch next ? rows only", page * size, size)) {
            while (rs.next()) {
                Player post = new Player();
                post.loadProps(rs);
                listbypid.add(post);
            }
            return listbypid;
        }
    }

    public List<Player> getallplayer(String name) throws Exception {
        List<Player> listbypid = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [Player] WHERE [Role] = 0 ";
            if (name != null && !name.equals("")) {
                sql += " and Name like '%" + name + "%' or Username like '%" + name + "%'";
                ResultSet rs = ModelBase.connection().executeQuery(sql);
                while (rs.next()) {
                    Player player = new Player();
                    player.loadProps(rs);
                    listbypid.add(player);
                }
                return listbypid;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
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

    public Player getPlayerByUsernameAndPassword(String username, String password) throws Exception {
        List<Player> players = getIf("[Username] = ? AND [Password] = ? COLLATE Latin1_General_CS_AS", username, Crypto.SHA256(password));
        if (!players.isEmpty()) {
            return players.get(0);
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

    public Player getUserByUsername(String username) throws Exception {
        List<Player> players = getIf("[Username] = ?", username);
        if (!players.isEmpty()) {
            return players.get(0);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        PlayerModel pm = new PlayerModel();
        List<Player> list = new PlayerModel().getallplayer("a");
        for (Player p : list) {
            System.out.println(p.getRole());
        }
    }

    public List<Player> getTopRanking() throws Exception {
        List<Player> list = new ArrayList<>();
        try ( ResultSet rs = ModelBase.connection().executeQuery("select top 5 * from [Player] order by Rank DESC")) {
            while (rs.next()) {
                Player player = new Player();
                player.loadProps(rs);
                list.add(player);
            }
            return list;
        }
    }

    public Player getUserById(Integer id) throws Exception {
        List<Player> players = getIf("[ID] = ?", id);
        if (!players.isEmpty()) {
            return players.get(0);
        }
        return null;
    }

}
