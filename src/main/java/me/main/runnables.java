package me.main;

import jssc.SerialPortException;
import org.bukkit.scheduler.BukkitRunnable;

import static com.mongodb.client.model.Filters.eq;
import static me.main.methods.*;
import static me.main.variables.*;

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
