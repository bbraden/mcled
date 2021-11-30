package me.braden;

import jssc.SerialPortException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static me.braden.variables.*;

import static me.braden.methods.*;
import static me.braden.main.*;

public class commands implements CommandExecutor {

    void notify(String noti) {
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "] " + ChatColor.AQUA + noti + ChatColor.LIGHT_PURPLE + " switched");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args[0].equalsIgnoreCase("all")) {
                power = !power;
                walk = !walk;
                sight = !sight;
                click = !click;
                brek = !brek;
                damage = !damage;
                death = !death;
                respawn = !respawn;
                Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " All " + ChatColor.LIGHT_PURPLE + "switched");
            } else if (args[0].equalsIgnoreCase("walk")) {
                walk = !walk;
                notify("walk");
            } else if (args[0].equalsIgnoreCase("sight")) {
                sight = !sight;
                notify("sight");
            } else if (args[0].equalsIgnoreCase("click")) {
                click = !click;
                notify("click");
            } else if (args[0].equalsIgnoreCase("break")) {
                brek = !brek;
                notify("break");
            } else if (args[0].equalsIgnoreCase("death")) {
                death = !death;
                notify("death");
            } else if (args[0].equalsIgnoreCase("damage")) {
                damage = !damage;
                notify("damage");
            } else if (args[0].equalsIgnoreCase("respawn")) {
                respawn = !respawn;
                notify("respawn");
            } else if (args[0].equalsIgnoreCase("on")) {
                power = true;
                walk = true;
                sight = true;
                click = true;
                brek = true;
                damage = true;
                death = true;
                respawn = true;
                notify("all on");
            } else if (args[0].equalsIgnoreCase("off")) {
                power = false;
                walk = false;
                sight = false;
                click = false;
                brek = false;
                damage = false;
                death = false;
                respawn = false;
                notify("all off");
            } else if (args[0].equalsIgnoreCase("o")) {
                try {
                    turnOn(com);
                } catch (SerialPortException e) {
                    e.printStackTrace();
                }
                notify("on");
            } else if (args[0].equalsIgnoreCase("x")) {
                try {
                    turnOff(com);
                } catch (SerialPortException e) {
                    e.printStackTrace();
                }
                notify("off");
            }
            //
            //
            // colors
            //
            //
            else if (args[0].equalsIgnoreCase("red")) {
                try {
                    turnRed(com);
                } catch (SerialPortException e) {
                    e.printStackTrace();
                }
                notify("red");
            } else if (args[0].equalsIgnoreCase("green")) {
                try {
                    turnGreen(com);
                } catch (SerialPortException e) {
                    e.printStackTrace();
                }
                notify("green");
            } else if (args[0].equalsIgnoreCase("blue")) {
                try {
                    turnBlue(com);
                } catch (SerialPortException e) {
                    e.printStackTrace();
                }
                notify("blue");
            } else if (args[0].equalsIgnoreCase("yellow")) {
                try {
                    turnYellow(com);
                } catch (SerialPortException e) {
                    e.printStackTrace();
                }
                notify("yellow");
            } else if (args[0].equalsIgnoreCase("orange")) {
                try {
                    turnOrange(com);
                } catch (SerialPortException e) {
                    e.printStackTrace();
                }
                notify("orange");
            } else if (args[0].equalsIgnoreCase("purple")) {
                try {
                    turnPurple(com);
                } catch (SerialPortException e) {
                    e.printStackTrace();
                }
                notify("purple");
            } else if (args[0].equalsIgnoreCase("white")) {
                try {
                    turnWhite(com);
                } catch (SerialPortException e) {
                    e.printStackTrace();
                }
                notify("white");
            } else if (args[0].equalsIgnoreCase("gui")) {
                openNewGui(player);
            }

        } else {
            if (args[0].equalsIgnoreCase("all")) {
                power = !power;
                Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "console" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " All " + ChatColor.LIGHT_PURPLE + "switched");
            }
        }
        return true;
    }
}
