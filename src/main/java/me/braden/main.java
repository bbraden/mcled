package me.braden;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;
import jssc.*;
import java.util.Objects;
import static me.braden.methods.*;
import static me.braden.variables.*;

public final class main extends JavaPlugin {

    static SerialPort com = new SerialPort(port);

    @Override
    public void onEnable() {
        try {
            com.openPort();
            Thread.sleep(1000);
            turnOff(com);

            Thread.sleep(2000);
            turnOn(com);
            Thread.sleep(1000);
            turnGreen(com);
            Thread.sleep(3000);
        } catch (InterruptedException | SerialPortException e) {
            e.printStackTrace();
        }

        state = power = walk = sight = click = brek = damage = death = respawn = true;

        Bukkit.getPluginManager().registerEvents(new listeners(), this);
        Objects.requireNonNull(this.getCommand("led")).setExecutor(new Commands());
        new runnables.MyTask().runTaskTimer(this, 0, 20);

    }
}