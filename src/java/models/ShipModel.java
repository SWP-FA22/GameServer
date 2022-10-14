/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Ship;
import java.sql.ResultSet;
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

    public List<Ship> getShipsByPlayerID(Integer playerID) throws Exception {
        List<Ship> result = new ArrayList<>();
        try ( ResultSet rs = connection().executeQuery("SELECT [Ship].* FROM [PlayerShip], [Ship] WHERE [PlayerShip].[ShipID] = [Ship].[ID] AND [PlayerShip].[PlayerID] = ?", playerID)) {
            while (rs.next()) {
                Ship ship = new Ship();
                ship.loadProps(rs);
                result.add(ship);
            }
        }
        return result;
    }

    public Ship getPlayerEquippedShip(Integer playerID) throws Exception {
        try ( ResultSet rs = connection().executeQuery("SELECT [Ship].* FROM [PlayerShip], [Ship] WHERE [PlayerShip].[ShipID] = [Ship].[ID] AND [PlayerShip].[PlayerID] = ? AND [PlayerShip].[IsEquipped] = 1", playerID)) {
            if (rs.next()) {
                Ship ship = new Ship();
                ship.loadProps(rs);
                return ship;
            }
        }
        return null;
    }
}
