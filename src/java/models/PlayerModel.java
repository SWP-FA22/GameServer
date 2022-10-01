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
public class PlayerModel extends ModelBase<Player> {

    public PlayerModel() throws Exception {
        super(Player.class);
    }

    public Player getUserByEmail(String email) throws SQLException {
        try ( ResultSet rs = ModelBase.connection().executeQuery("SELECT * FROM [Player] WHERE [Email] = ?", email)) {
            if (rs.next()) {
                return new Player(rs.getInt("ID"), rs.getString("Password"), rs.getString("Username"), rs.getString("Name"),
                        email, rs.getInt("WeaponID"), rs.getInt("EngineID"), rs.getInt("SailID"), rs.getInt("Rank"));
            }
            return null;
        }
    }

    public void updatePassword(Player u) throws SQLException {
        ModelBase.connection().executeUpdate("UPDATE [Player] SET [Password] = ? WHERE [ID] = ?", u.getPassword(), u.getId());
    }

    public int getIdByUsername(String username) throws SQLException {
        try ( ResultSet rs = ModelBase.connection().executeQuery("SELECT * FROM [Player] WHERE [Username] = ?", username)) {
            if (rs.next()) {
                return rs.getInt("ID");
            }
            return -1;
        }
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
    
    
    

    public Player getByPlayername(String username) throws SQLException {
        try ( ResultSet rs = getConnection().executeQuery("SELECT * FROM Player")) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String password = rs.getString("Password");

                String name = rs.getString("name");
                String email = rs.getString("email");
                int weaponID = rs.getInt("WeaponID");
                int engineID = rs.getInt("EngineID");
                int sailID = rs.getInt("SailID");
                int rank = rs.getInt("Rank");
                
                
                return new Player(id, password, username, name, email, weaponID, engineID, sailID, rank);
            }
        }
        return null;
    }
    
    public int getResourceItem (int id )throws SQLException{
        try (ResultSet rs = getConnection().executeQuery(
                "Select ID, count(p.ID) as NumberOfItem from Player p , PlayerItem pi where p.ID = pi.PlayerID and p.ID = ? group by ID ", id
        )){
            while(rs.next()){
                return rs.getInt("NumberOfItem");
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public int getResourceShip (int id)throws SQLException{
        try (ResultSet rs = getConnection().executeQuery(
                "select ID, count(ps.PlayerID) as NumberOfShip from  [Player] p, [PlayerShip] ps   where p.ID = ps.PlayerID and ID = ? group by ID", id
        )){
            while(rs.next()){
                return rs.getInt("NumberOfShip");
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
     public Integer getResourceAmount(int uid, int rid) throws SQLException {
        try ( ResultSet rs = connection().executeQuery(
                "SELECT [Amount] FROM [PlayerResource] WHERE [PlayerID] = ? AND [ResourceID] = ?",
                uid, rid)) {
            if (rs.next()) {
                return rs.getInt("Amount");
            } else {
                connection().executeUpdate("INSERT INTO [PlayerResource] VALUES (?, ?, ?)", uid, rid, 0);
            }
            return 0;
        }
    }
 
    
    
}


