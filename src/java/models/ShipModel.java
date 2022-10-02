/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Ship;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quang
 */
public class ShipModel extends ModelBase<Ship> {

    public ShipModel() throws Exception {
        super(Ship.class);
    }

    public List<Ship> getShipsByPlayerID(Integer playerID) throws SQLException {
        List<Ship> result = new ArrayList<>();
        try ( ResultSet rs = connection().executeQuery("SELECT [Ship].* FROM [PlayerShip], [Ship] WHERE [PlayerShip].[ShipID] = [Ship].[ID] AND [PlayerShip].[PlayerID] = ?", playerID)) {
            while (rs.next()) {
                result.add(new Ship(rs.getInt("ID"), rs.getNString("Name"), rs.getNString("Description"), rs.getDouble("BaseATK"), rs.getDouble("BaseHP"), rs.getDouble("BaseSpeed"), rs.getDouble("BaseRota"), rs.getDouble("Price"), rs.getString("Addressable")));
            }
        }
        return result;
    }
}
