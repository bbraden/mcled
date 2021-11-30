package me.braden;

import jssc.SerialPortException;
import org.bukkit.scheduler.BukkitRunnable;

import static me.braden.main.*;
import static me.braden.methods.turnBlue;
import static me.braden.methods.turnGreen;
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
