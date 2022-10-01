/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huu
 */
public class ItemModel extends ModelBase<Item> {

    public ItemModel() throws Exception {
        super(Item.class);
    }

    public List<Item> getItemByUserID(int ID) throws SQLException {
        List<Item> list = new ArrayList<>();
        try ( ResultSet rs = ModelBase.connection().executeQuery("SELECT * FROM [Item], [PlayerItem] WHERE [ID] = [ItemID] AND [PlayerID] = ?", ID)) {
            while (rs.next()) {
                list.add(new Item(rs.getInt("ID"), rs.getString("Description"), rs.getString("ImageURL"),
                        rs.getString("Name"), rs.getString("Addressable"),
                        rs.getInt("Type"), rs.getDouble("Price"), rs.getDouble("BonusATK"), rs.getDouble("BonusHP"),
                        rs.getDouble("BonusSpeed"), rs.getDouble("BonusRota")));

            }
            return list;
        }
    }
    public boolean check(int uid,int iid) throws SQLException
    {
        try ( ResultSet rs = ModelBase.connection().executeQuery("SELECT * FROM [PlayerItem] WHERE [PlayerID]=? AND [ItemID] = ?",uid,iid)) {
            if (rs.next()) {
                return false;

            }
            return true;
        }
    }
    public void insert(int uid,int iid) throws SQLException
    {
        connection().executeUpdate("INSERT INTO [PlayerItem] VALUES (?, ?)", uid, iid);
    }
    public double getPriceItemByID(int ID) throws SQLException
    {
        try(ResultSet rs = ModelBase.connection().executeQuery("SELECT * FROM [Item] WHERE [ID]=?", ID)){
            if (rs.next())
                return rs.getDouble("Price");
        }
        return -1;
    }
}
