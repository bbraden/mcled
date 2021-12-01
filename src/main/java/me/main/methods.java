package me.main;

import jssc.SerialPort;
import jssc.SerialPortException;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.math.BigInteger;

import static me.main.variables.*;

public class methods {
    public static void openNewGui(Player p) {
        gui = Bukkit.createInventory(null, InventoryType.CHEST, "led remote");

        ItemStack green = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        ItemMeta greenmeta = green.getItemMeta();
        assert greenmeta != null;
        greenmeta.setDisplayName(ChatColor.GREEN + "green");
        green.setItemMeta(greenmeta);

        ItemStack red = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
        ItemMeta redmeta = red.getItemMeta();
        assert redmeta != null;
        redmeta.setDisplayName(ChatColor.RED + "red");
        red.setItemMeta(redmeta);

        ItemStack blue = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta bluemeta = blue.getItemMeta();
        assert bluemeta != null;
        bluemeta.setDisplayName(ChatColor.BLUE + "blue");
        blue.setItemMeta(bluemeta);

        ItemStack purple = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
        ItemMeta purplemeta = purple.getItemMeta();
        assert purplemeta != null;
        purplemeta.setDisplayName(ChatColor.LIGHT_PURPLE + "purple");
        purple.setItemMeta(purplemeta);

        ItemStack orange = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE, 1);
        ItemMeta orangemeta = orange.getItemMeta();
        assert orangemeta != null;
        orangemeta.setDisplayName(ChatColor.GOLD + "orange");
        orange.setItemMeta(orangemeta);

        ItemStack yellow = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE, 1);
        ItemMeta yellowmeta = yellow.getItemMeta();
        assert yellowmeta != null;
        yellowmeta.setDisplayName(ChatColor.YELLOW + "yellow");
        yellow.setItemMeta(yellowmeta);

        ItemStack white = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta whitemeta = white.getItemMeta();
        assert whitemeta != null;
        whitemeta.setDisplayName(ChatColor.WHITE + "white");
        white.setItemMeta(whitemeta);

        ItemStack close = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta closemeta = close.getItemMeta();
        assert closemeta != null;
        closemeta.setDisplayName(ChatColor.DARK_RED + "close");
        close.setItemMeta(closemeta);

        gui.setItem(1, red);
        gui.setItem(10, red);
        gui.setItem(19, red);

        gui.setItem(2, green);
        gui.setItem(11, green);
        gui.setItem(20, green);

        gui.setItem(3, blue);
        gui.setItem(12, blue);
        gui.setItem(21, blue);

        gui.setItem(4, purple);
        gui.setItem(13, purple);
        gui.setItem(22, purple);

        gui.setItem(5, orange);
        gui.setItem(14, orange);
        gui.setItem(23, orange);

        gui.setItem(6, yellow);
        gui.setItem(15, yellow);
        gui.setItem(24, yellow);

        gui.setItem(7, white);
        gui.setItem(16, white);
        gui.setItem(25, white);

        gui.setItem(0, close);
        gui.setItem(9, close);
        gui.setItem(18, close);

        gui.setItem(8, close);
        gui.setItem(17, close);
        gui.setItem(26, close);

        p.openInventory(gui);

    }

    public static void send(String request) {
        collection.insertOne(new Document()
                .append("_id", new ObjectId())
                .append("message", request));
    }

    public static String getEnvVariable(String envVariable) {
        return dotenv.get(envVariable);
    }

    public static String toHex(String arg) {
        return String.format("%040x", new BigInteger(1, arg.getBytes(/*YOUR_CHARSET?*/)));
    }

    public static void turnOn(SerialPort port) throws SerialPortException {
        send("on");
        //port.writeByte(Byte.parseByte(toHex(getEnvVariable("on")), 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED on");
    }

    public static void turnOff(SerialPort port) throws SerialPortException {
        send("off");
        //port.writeByte(Byte.parseByte(toHex(getEnvVariable("off")), 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED off");
    }

    public static void turnRed(SerialPort port) throws SerialPortException {
        send("red");
        //port.writeByte(Byte.parseByte(toHex(getEnvVariable("red")), 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED " + ChatColor.RED + "red"); //
    }

    public static void turnGreen(SerialPort port) throws SerialPortException {
        send("green");
        //port.writeByte(Byte.parseByte(toHex(getEnvVariable("green")), 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED " + ChatColor.GREEN + "green");
    }

    public static void turnBlue(SerialPort port) throws SerialPortException {
        send("blue");
        //port.writeByte(Byte.parseByte(toHex(getEnvVariable("blue")), 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED " + ChatColor.BLUE + "blue");
    }

    public static void turnWhite(SerialPort port) throws SerialPortException {
        send("white");
        //port.writeByte(Byte.parseByte(toHex(getEnvVariable("white")), 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED " + ChatColor.WHITE + "white");
    }

    public static void turnYellow(SerialPort port) throws SerialPortException {
        send("yellow");
        //port.writeByte(Byte.parseByte(toHex(getEnvVariable("yellow")), 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED " + ChatColor.YELLOW + "yellow");
    }

    public static void turnOrange(SerialPort port) throws SerialPortException {
        send("orange");
        //port.writeByte(Byte.parseByte(toHex(getEnvVariable("orange")), 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED " + ChatColor.GOLD + "orange");
    }

    public static void turnPurple(SerialPort port) throws SerialPortException {
        send("purple");
        //port.writeByte(Byte.parseByte(toHex(getEnvVariable("purple")), 16));
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "-" + ChatColor.DARK_GREEN + "]" + ChatColor.AQUA + " LED " + ChatColor.LIGHT_PURPLE + "purple");
    }
}
