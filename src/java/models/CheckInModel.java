/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.CheckIn;
import entities.Resource;
import java.sql.ResultSet;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Huu
 */
public class CheckInModel extends ModelBase<CheckIn> {

    public CheckInModel() throws Exception {
        super(CheckIn.class);
    }

    public CheckIn getCheckInByCount(int count) throws Exception {
        List<CheckIn> checkin = getIf("[CheckinCount] = ?", count);
        if (!checkin.isEmpty()) {
            return checkin.get(0);
        }
        return null;
    }

    public List<Map.Entry<CheckIn, Resource>> getAllCheckinItems() throws Exception {
        List<Map.Entry<CheckIn, Resource>> result = new ArrayList<>();

        try ( ResultSet rs = getConnection().executeQuery("SELECT * FROM [CheckIn], [Resource] WHERE [CheckIn].[ResourceID] = [Resource].[ID]")) {
            while (rs.next()) {
                CheckIn checkIn = new CheckIn();
                Resource resource = new Resource();

                checkIn.loadProps(rs);
                resource.loadProps(rs);

                result.add(new AbstractMap.SimpleEntry<>(checkIn, resource));
            }
        }
        
        return result;
    }
}
