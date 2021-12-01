/*
original code by:
@bbraden on github
braden#9999 on discord
11/29/2021
*/
package me.braden;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;
import jssc.*;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;
import static me.braden.methods.*;
import static me.braden.variables.*;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("[!] If port dosent work the first time, put a space before the port [!]");
        System.out.println("[+] input desired port");

        String userName = myObj.nextLine();  // Read user input
        System.out.println("[-] port: " + userName);  // Output user input
        myObj.close();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        com = new SerialPort(userName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            try {
                com.openPort();
            } catch (SerialPortException e) {
                com = new SerialPort(getEnvVariable("port"));
                System.out.println("[-] Port Invalid, Changed To Port Listed In src/main/resources/.env At Line 2");
                Thread.sleep(500);
                com.openPort();
            }
            Thread.sleep(1000);
            turnOn(com);
            Thread.sleep(1000);
            turnRed(com);
            Thread.sleep(500);
            turnGreen(com);
            Thread.sleep(500);
            turnBlue(com);
            Thread.sleep(500);
            turnGreen(com);
            Thread.sleep(1000);
            System.out.println("[-] port active");
        } catch (InterruptedException | SerialPortException e) {
            e.printStackTrace();
            System.out.println("=============\n[!] port invalid or was unable to open, please try again or check your code.");
            return;
        }

        state = true;
        power = true;
        walk = true;
        sight = true;
        click = true;
        brek = true;
        damage = true;
        death = true;
        respawn = true;

        Bukkit.getPluginManager().registerEvents(new listeners(this), this);
        Objects.requireNonNull(this.getCommand("led")).setExecutor(new commands());

    }
}
