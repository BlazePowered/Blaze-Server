package net.glowstone.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class SpeedCommand extends BukkitCommand {

    public SpeedCommand() {
        super("gsspeed");
        this.description = "Sets the speed of a player or yourself from";
        this.usageMessage = "/speed <player> <your speed>";
        this.setPermission("glowstone.command.speed");
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (sender instanceof Player) {
            Player pl = (Player) sender;
            if (args.length <= 0) {
                sender.sendMessage(ChatColor.RED + "Usage: " + usageMessage);
                return false;
            } else {
                if (args.length == 1) {
                    if (pl.isOnGround()) {
                        float playerSpeed = 0.0F;
                        try {
                            playerSpeed = Float.parseFloat(args[0]);
                            if (playerSpeed > 1.0F) {
                                pl.sendMessage(ChatColor.RED
                                        + "Error: argument too high! (only up to 1.0F)");
                                return false;
                            }
                            if (playerSpeed < -1.0F) {
                                pl.sendMessage(ChatColor.RED
                                        + "Error: argument too low! (only up to -1.0F)");
                                return false;
                            }
                            pl.setWalkSpeed(playerSpeed);
                            pl.sendMessage(ChatColor.GREEN
                                    + "Your walkspeed has been modified to "
                                    + playerSpeed);
                        } catch (NumberFormatException e) {
                            pl.sendMessage(ChatColor.RED
                                    + "Error: argument cannot get converted to float!");
                        }

                    }
                    if (pl.isFlying()) {
                        float playerFlyingSpeed = 0.0F;
                        try {
                            playerFlyingSpeed = Float.parseFloat(args[0]);
                            if (playerFlyingSpeed > 1.0F) {
                                pl.sendMessage(ChatColor.RED
                                        + "Error: argument too high! (only up to 1.0F)");
                                return false;
                            }
                            if (playerFlyingSpeed < -1.0F) {
                                pl.sendMessage(ChatColor.RED
                                        + "Error: argument too low! (only up to -1.0F)");
                                return false;
                            }
                            pl.setFlySpeed(playerFlyingSpeed);
                            pl.sendMessage(ChatColor.GREEN
                                    + "Your flying speed is now "
                                    + playerFlyingSpeed);

                        } catch (NumberFormatException e) {
                            pl.sendMessage(ChatColor.RED
                                    + "Error: argument cannot get converted to float!");
                        }
                    }
                }
                if (args.length == 2) {
                    Player targetpl = Bukkit.getServer().getPlayer(args[0]);
                    if (targetpl.isOnGround()) {
                        if (targetpl == null) {
                            pl.sendMessage(ChatColor.RED + "Player not found!");
                        } else {
                            float pspeed = 0.0F;
                            try {
                                pspeed = Float.parseFloat(args[1]);
                                if (pspeed > 1.0F) {
                                    pl.sendMessage(ChatColor.RED
                                            + "Error: argument too high! (only up to 1.0F)");
                                    return false;
                                }
                                if (pspeed < -1.0F) {
                                    pl.sendMessage(ChatColor.RED
                                            + "Error: argument too less! (only up to -1.0F)");
                                    return false;
                                }
                                targetpl.setWalkSpeed(pspeed);
                                targetpl.sendMessage(ChatColor.GREEN
                                        + "Your walkspeed has been modified to "
                                        + pspeed);
                                pl.sendMessage(ChatColor.GREEN
                                        + targetpl.getName()
                                        + "'s walkspeed has been modified to "
                                        + pspeed);
                            } catch (Exception e) {
                                pl.sendMessage(ChatColor.RED
                                        + "Error: argument cannot get converted to float!");
                            }
                        }
                    }
                    if (targetpl.isFlying()) {
                        float flyingSpeed = 0.0F;
                        try {
                            flyingSpeed = Float.parseFloat(args[1]);
                            if (flyingSpeed > 1.0F) {
                                pl.sendMessage(ChatColor.RED
                                        + "Error: argument too high! (only up to 1.0F)");
                                return false;
                            }
                            if (flyingSpeed < -1.0F) {
                                pl.sendMessage(ChatColor.RED
                                        + "Error: argument too less! (only up to -1.0F)");
                                return false;
                            }
                            targetpl.setFlySpeed(flyingSpeed);
                            targetpl.sendMessage(ChatColor.GREEN
                                    + "Your flying speed has been modified to "
                                    + flyingSpeed);
                            pl.sendMessage(ChatColor.GREEN + targetpl.getName()
                                    + "'s flying speed has been modified to "
                                    + flyingSpeed);
                        } catch (Exception e) {
                            pl.sendMessage(ChatColor.RED
                                    + "Error: argument cannot get converted to float!");
                        }

                    }
                }
            }

        }
        return false;
    }
}
