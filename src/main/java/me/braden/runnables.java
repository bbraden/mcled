package me.braden;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import jssc.SerialPortException;
import org.bson.Document;
import org.bukkit.FluidCollisionMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.mongodb.client.model.Filters.eq;
import static me.braden.methods.*;
import static me.braden.variables.*;

public class runnables {
    public static class MyTask extends BukkitRunnable {

        private int countdown;

        public MyTask() {
            this.countdown = 2;
        }

        @Override
        public void run() {
            if (countdown <= 0) {
                System.out.println("[-] countdown over");
                if (!isDead) {
                    try {
                        if (inwater) {
                            turnBlue(com);
                        }
                        else {
                            turnGreen(com);
                        }
                    } catch (SerialPortException e) {
                        e.printStackTrace();
                    }
                }
                this.cancel();
                return;
            }

            System.out.println("[+] " + countdown);
            countdown--;
        }
    }
}
