/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Item;
import java.sql.ResultSet;
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

    public List<Item> getItemsByPlayerID(Integer ID) throws Exception {
        List<Item> list = new ArrayList<>();
        try ( ResultSet rs = ModelBase.connection().executeQuery("SELECT * FROM [Item], [PlayerItem] WHERE [ID] = [ItemID] AND [PlayerID] = ?", ID)) {
            while (rs.next()) {
                Item item = new Item();
                item.loadProps(rs);
                list.add(item);
            }
            return list;
        }
    }

    public boolean isPlayerOwned(Integer uid, Integer iid) throws Exception {
        try ( ResultSet rs = ModelBase.connection().executeQuery("SELECT * FROM [PlayerItem] WHERE [PlayerID]=? AND [ItemID] = ?", uid, iid)) {
            return rs.next();
        }
    }

    public void addItemToPlayer(Integer uid, Integer iid) throws Exception {
        connection().executeUpdate("INSERT INTO [PlayerItem] VALUES (?, ?)", uid, iid);
    }

    public double getPriceItemByID(Integer ID) throws Exception {
        Item item = get(ID);
        return item != null ? item.getPrice() : -1;
    }
}
