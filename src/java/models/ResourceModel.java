/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author quang
 */
public class ResourceModel extends ModelBase<Resource> {

    public ResourceModel() throws Exception {
        super(Resource.class);
    }

    public Integer getResourceAmount(Integer uid, Integer rid) throws SQLException {
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

    public void setResourceAmount(Integer uid, Integer rid, Integer amount) throws SQLException {
        int result = connection().executeUpdate("UPDATE [PlayerResource] SET [Amount] = ? WHERE [PlayerID] = ? AND [ResourceID] = ?", amount, uid, rid);

        if (result == 0) {
            connection().executeUpdate("INSERT INTO [PlayerResource] VALUES (?, ?, ?)", uid, rid, amount);
        }
    }

    public void addResourceAmount(Integer uid, Integer rid, Integer amount) throws SQLException {
        int result = connection().executeUpdate("UPDATE [PlayerResource] SET [Amount] = [Amount] + ? WHERE [PlayerID] = ? AND [ResourceID] = ?", amount, uid, rid);

        if (result == 0) {
            connection().executeUpdate("INSERT INTO [PlayerResource] VALUES (?, ?, ?)", uid, rid, amount);
        }
    }

    public Integer getDiamondAmount(Integer uid) throws SQLException {
        return getResourceAmount(uid, 1);
    }

    public void setDiamondAmount(Integer uid, Integer amount) throws SQLException {
        setResourceAmount(uid, 1, amount);
    }

    public void addDiamondAmount(Integer uid, Integer amount) throws SQLException {
        addResourceAmount(uid, 1, amount);
    }

    public Integer getGoldAmount(Integer uid) throws SQLException {
        return getResourceAmount(uid, 2);
    }

    public void setGoldAmount(Integer uid, Integer amount) throws SQLException {
        setResourceAmount(uid, 2, amount);
    }

    public void addGoldAmount(Integer uid, Integer amount) throws SQLException {
        addResourceAmount(uid, 2, amount);
    }

    public Integer getRubyAmount(Integer uid) throws SQLException {
        return getResourceAmount(uid, 3);
    }

    public void setRubyAmount(Integer uid, Integer amount) throws SQLException {
        setResourceAmount(uid, 3, amount);
    }

    public void addRubyAmount(Integer uid, Integer amount) throws SQLException {
        addResourceAmount(uid, 3, amount);
    }
}
