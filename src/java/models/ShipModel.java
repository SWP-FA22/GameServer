/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Ship;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author quang
 */
public class ShipModel extends ModelBase<Ship> {

    public ShipModel() throws Exception {
        super(Ship.class);
    }

    public boolean isPlayerOwned(Integer playerID, Integer shipID) throws Exception {
        return getShipsByPlayerID(playerID).stream().anyMatch(t -> Objects.equals(t.getId(), shipID));
    }

    public void addShipToPlayer(Integer playerID, Integer shipID) throws Exception {
        connection().executeUpdate("INSERT INTO [PlayerShip]([PlayerID], [ShipID], [IsEquipped]) VALUES (?, ?, ?)", playerID, shipID, false);
    }

    public void equipShip(Integer playerID, Integer shipID) throws Exception {
        connection().executeUpdate("UPDATE [PlayerShip] SET [IsEquipped] = (CASE WHEN [ShipID] = ? THEN 1 ELSE 0 END) WHERE [PlayerID] = ?", shipID, playerID);
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
