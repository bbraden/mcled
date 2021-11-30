package me.braden;

import jssc.SerialPort;
import org.bukkit.inventory.Inventory;

import java.util.Scanner;

public class variables {

    static SerialPort com;

    static String port = "COM5"; // replace com5 with port
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
