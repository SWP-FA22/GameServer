/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.CheckIn;
import java.util.List;

/**
 *
 * @author Huu
 */
public class CheckInModel extends ModelBase<CheckIn>{
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
}
