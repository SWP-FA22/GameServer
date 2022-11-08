package utilities;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.PlayerModel;
public class StatusCheckIn {

    public static void CheckIn() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable cancelUnpaidOrdersTask = new Runnable() {
            Date today = null, nextDay = null;

            public void init() {
                today = new Date();
                nextDay = new Date(today.getYear(), today.getMonth(), today.getDate());
                nextDay = new Date(nextDay.getTime() + 1000 * 60 * 60 * 24);
            }

            public void run() {
                if (nextDay == null) {
                    init();
                }

                today = new Date();

                if (today.after(nextDay)) {
                    try {
                        System.out.println("Reset diem danh");
                        PlayerModel pm = new PlayerModel();
                        pm.resetCheckin();
                        nextDay = new Date(today.getYear(), today.getMonth(), today.getDate());
                        nextDay = new Date(nextDay.getTime() + 1000 * 60 * 60 * 24);
                    } catch (Exception ex) {
                        Logger.getLogger(StatusCheckIn.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        };

        scheduler.scheduleAtFixedRate(cancelUnpaidOrdersTask, 0, 1, TimeUnit.SECONDS);
    }
}