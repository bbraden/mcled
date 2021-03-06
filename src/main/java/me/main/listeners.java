package me.main;

import jssc.SerialPortException;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.Objects;
import static me.main.methods.*;
import static me.main.methods.turnRed;
import static me.main.variables.*;

public class listeners implements Listener {
    private final main plugin;

    public listeners(main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) throws SerialPortException {
        if (!e.getInventory().equals(gui)) {
            return;
        }

        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();

        if (e.getSlot() == 1 || e.getSlot() == 10 || e.getSlot() == 19) {
            turnRed(com);
        } else if (e.getSlot() == 2 || e.getSlot() == 11 || e.getSlot() == 20) {
            turnGreen(com);
        } else if (e.getSlot() == 3 || e.getSlot() == 12 || e.getSlot() == 21) {
            turnBlue(com);
        } else if (e.getSlot() == 4 || e.getSlot() == 13 || e.getSlot() == 22) {
            turnPurple(com);
        } else if (e.getSlot() == 5 || e.getSlot() == 14 || e.getSlot() == 23) {
            turnOrange(com);
        } else if (e.getSlot() == 6 || e.getSlot() == 15 || e.getSlot() == 24) {
            turnYellow(com);
        } else if (e.getSlot() == 7 || e.getSlot() == 16 || e.getSlot() == 25) {
            turnWhite(com);
        } else if (e.getSlot() == 0 || e.getSlot() == 8 || e.getSlot() == 9 || e.getSlot() == 18 || e.getSlot() == 17 || e.getSlot() == 26) {
            p.closeInventory();
        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.getDisplayName().equalsIgnoreCase("vhs2")) {
            new BukkitRunnable() {
                public void run(){
                    if (sight) {
                        if (power) {
                            if (p.getTargetBlockExact(10, FluidCollisionMode.NEVER) != null) {
                                lookingAt = Objects.requireNonNull(Objects.requireNonNull(p.getTargetBlockExact(50, FluidCollisionMode.NEVER)).getType().toString());
                            }
                            if (Objects.equals(lookingAt, "WHITE_WOOL")) {
                                try {
                                    turnWhite(com);
                                } catch (SerialPortException e) {
                                    e.printStackTrace();
                                }
                            } else if (Objects.equals(lookingAt, "PURPLE_WOOL")) {
                                try {
                                    turnPurple(com);
                                } catch (SerialPortException e) {
                                    e.printStackTrace();
                                }
                            } else if (Objects.equals(lookingAt, "ORANGE_WOOL")) {
                                try {
                                    turnOrange(com);
                                } catch (SerialPortException e) {
                                    e.printStackTrace();
                                }
                            } else if (Objects.equals(lookingAt, "BLUE_WOOL")) {
                                try {
                                    turnBlue(com);
                                } catch (SerialPortException e) {
                                    e.printStackTrace();
                                }
                            } else if (Objects.equals(lookingAt, "GREEN_WOOL")) {
                                try {
                                    turnGreen(com);
                                } catch (SerialPortException e) {
                                    e.printStackTrace();
                                }
                            } else if (Objects.equals(lookingAt, "YELLOW_WOOL")) {
                                try {
                                    turnYellow(com);
                                } catch (SerialPortException e) {
                                    e.printStackTrace();
                                }
                            } else if (Objects.equals(lookingAt, "RED_WOOL")) {
                                try {
                                    turnRed(com);
                                } catch (SerialPortException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }.runTaskTimer(plugin, 0, 20);


        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) throws SerialPortException {
        if (brek) {
            if (power) {
                if (state) {
                    turnOff(com);
                } else {
                    turnOn(com);
                }
                state = !state;
            }
        }

    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) throws SerialPortException {
        if (damage) {
            if (power) {
                Entity entity = e.getEntity();
                if (entity instanceof Player) {
                    turnRed(com);
                    new runnables.MyTask().runTaskTimer(plugin, 0, 20);
                }
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) throws SerialPortException {
        if (death) {
            if (power) {
                Player player = e.getEntity().getPlayer();
                assert player != null;
                if (player.getDisplayName().equalsIgnoreCase("vhs2")) {

                    isDead = true;
                    turnRed(com);
                }

            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) throws SerialPortException {
        if (respawn) {
            if (power) {
                Player player = e.getPlayer();
                if (player.getDisplayName().equalsIgnoreCase("vhs2")) {
                    isDead = false;
                    if (inwater) {
                        turnBlue(com);
                    } else {
                        turnGreen(com);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) throws SerialPortException {
        if (click) {
            if (power) {
                Block block = e.getClickedBlock();
                if (block != null) {
                    if (block.getType() != Material.AIR | block.getType() != Material.CAVE_AIR) {
                        if (block.getType() == Material.WHITE_WOOL) {
                            turnWhite(com);
                        }
                        if (block.getType() == Material.PURPLE_WOOL) {
                            turnPurple(com);
                        }
                        if (block.getType() == Material.ORANGE_WOOL) {
                            turnOrange(com);
                        }
                        if (block.getType() == Material.BLUE_WOOL) {
                            turnBlue(com);
                        }
                        if (block.getType() == Material.GREEN_WOOL) {
                            turnGreen(com);
                        }
                        if (block.getType() == Material.YELLOW_WOOL) {
                            turnYellow(com);
                        }
                        if (block.getType() == Material.RED_WOOL) {
                            turnRed(com);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) throws SerialPortException {
        if (e.getPlayer().getDisplayName().equalsIgnoreCase("vhs2")) {
            Material m = e.getPlayer().getLocation().getBlock().getType();
            inwater = m == Material.WATER_CAULDRON || m == Material.WATER;
        }

        if (walk) {
            if (power) {
                Location loc = e.getPlayer().getLocation().clone().subtract(0, 1, 0);
                Block block = loc.getBlock();

                if (e.getPlayer().getDisplayName().equalsIgnoreCase("vhs2")) {
                    if (block.getType() == Material.WHITE_WOOL) {
                        turnWhite(com);
                    }
                    if (block.getType() == Material.PURPLE_WOOL) {
                        turnPurple(com);
                    }
                    if (block.getType() == Material.ORANGE_WOOL) {
                        turnOrange(com);
                    }
                    if (block.getType() == Material.BLUE_WOOL) {
                        turnBlue(com);
                    }
                    if (block.getType() == Material.GREEN_WOOL) {
                        turnGreen(com);
                    }
                    if (block.getType() == Material.YELLOW_WOOL) {
                        turnYellow(com);
                    }
                    if (block.getType() == Material.RED_WOOL) {
                        turnRed(com);
                    }
                }
            }
        }
    }
}
