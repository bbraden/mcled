package me.braden;

import io.github.cdimascio.dotenv.Dotenv;
import jssc.SerialPort;
import org.bukkit.inventory.Inventory;

public class variables {

    static Dotenv dotenv = Dotenv.configure().load();
    static SerialPort com;

    static String recentEntry;
    static String port = methods.getEnvVariable("port"); // replace com5 with port
    static boolean state;
    static boolean isDead;
    static String lookingAt;

    static boolean power;

    static boolean walk;
    static boolean sight;
    static boolean click;
    static boolean brek;
    static boolean damage;
    static boolean death;
    static boolean respawn;

    static Inventory gui;

    static boolean inwater;
}
