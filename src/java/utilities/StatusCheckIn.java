/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.PlayerModel;

/**
 *
 * @author Huu
 */
public class StatusCheckIn {
     static {
        Thread thread1 = new Thread(() -> {
            Date today = new Date();
            Date nextDay = new Date(today.getYear(), today.getMonth(), today.getDate());
            nextDay = new Date(nextDay.getTime() + 1000 * 60 * 60 * 24);

            while (true) {
                today = new Date();

                if (today.after(nextDay)) {
                    try {
                        System.out.println("Reset diem danh");
                        PlayerModel pm=new PlayerModel();
                        pm.resetCheckin();
                        nextDay = new Date(today.getYear(), today.getMonth(), today.getDate());
                        nextDay = new Date(nextDay.getTime() + 1000 * 60 * 60 * 24);
                    } catch (Exception ex) {
                        Logger.getLogger(StatusCheckIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    
                }
            }
        });

        thread1.run();
    }
}
