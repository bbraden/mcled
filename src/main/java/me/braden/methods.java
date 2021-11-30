package me.braden;

import jssc.SerialPort;
import jssc.SerialPortException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static me.braden.variables.*;

public class methods {
    public static void openNewGui(Player p) {
        gui = Bukkit.createInventory(null, InventoryType.HOPPER);

        ItemStack green = new ItemStack(Material.GREEN_CONCRETE, 1);
        ItemMeta greenmeta = green.getItemMeta();
        assert greenmeta != null;
        greenmeta.setDisplayName(ChatColor.GREEN + "green");
        green.setItemMeta(greenmeta);

        ItemStack red = new ItemStack(Material.RED_CONCRETE, 1);
        ItemMeta redmeta = red.getItemMeta();
        assert redmeta != null;
        redmeta.setDisplayName(ChatColor.GREEN + "red");
        red.setItemMeta(redmeta);

        ItemStack blue = new ItemStack(Material.BLUE_CONCRETE, 1);
        ItemMeta bluemeta = blue.getItemMeta();
        assert bluemeta != null;
        bluemeta.setDisplayName(ChatColor.GREEN + "blue");
        blue.setItemMeta(bluemeta);

        gui.setItem(1, red);
        gui.setItem(2, green);
        gui.setItem(3, blue);

        p.openInventory(gui);

    }

    public static void turnOn(SerialPort port) throws SerialPortException {
        port.writeByte(Byte.parseByte("6f", 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED on");
    }

    public static void turnOff(SerialPort port) throws SerialPortException {
        port.writeByte(Byte.parseByte("78", 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED off");
    }

    public static void turnRed(SerialPort port) throws SerialPortException {
        port.writeByte(Byte.parseByte("72", 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED " + ChatColor.RED + "red"); //
    }

    public static void turnGreen(SerialPort port) throws SerialPortException {
        port.writeByte(Byte.parseByte("67", 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED " + ChatColor.GREEN + "green");
    }

    public static void turnBlue(SerialPort port) throws SerialPortException {
        port.writeByte(Byte.parseByte("62", 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED " + ChatColor.BLUE + "blue");
    }

    public static void turnWhite(SerialPort port) throws SerialPortException {
        port.writeByte(Byte.parseByte("77", 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED " + ChatColor.WHITE + "white");
    }

    public static void turnYellow(SerialPort port) throws SerialPortException {
        port.writeByte(Byte.parseByte("79", 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED " + ChatColor.YELLOW + "yellow");
    }

    public static void turnOrange(SerialPort port) throws SerialPortException {
        port.writeByte(Byte.parseByte("75", 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED " + ChatColor.GOLD + "orange");
    }

    public static void turnPurple(SerialPort port) throws SerialPortException {
        port.writeByte(Byte.parseByte("70", 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED " + ChatColor.LIGHT_PURPLE + "purple");
    }
}
