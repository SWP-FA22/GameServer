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
        try ( ResultSet rs = ModelBase.connection().executeQuery("select * from Item i join PlayerItem p on i.ID=p.ItemID where p.PlayerID=?", ID)) {
            while (rs.next()) {
                list.add(new Item(rs.getInt("ID"), rs.getString("description"), rs.getString("imageURL"),
                        rs.getString("name"), rs.getString("addressable"),
                        rs.getInt("type"), rs.getDouble("price"), rs.getDouble("bonusATK"), rs.getDouble("bonusHP"),
                        rs.getDouble("bonusSpeed"), rs.getDouble("bonusRota")));

            }
            return list;
        }
    }
}
