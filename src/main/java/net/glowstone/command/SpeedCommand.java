package net.glowstone.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class SpeedCommand extends BukkitCommand {

    public SpeedCommand() {
        super("gsespeed");
        this.description = "Sets the speed of a player or yourself from";
        this.usageMessage = "/gsespeed <player> <your speed>";
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
                        int playerSpeed = 0;
                        try {
                            playerSpeed = Integer.parseInt(args[0]);
                            if (playerSpeed > 10) {
                                pl.sendMessage(ChatColor.RED
                                        + "Error: speed too high! (only up to 10)");
                                return false;
                            }
                            if (playerSpeed < 1) {
                                pl.sendMessage(ChatColor.RED
                                        + "Error: speed too low! (only down to 1)");
                                return false;
                            }
                            switch (playerSpeed) {
                                case 10:
                                    pl.setWalkSpeed(0.1F);
                                    break;
                                case 9:
                                    pl.setWalkSpeed(0.12F);
                                    break;
                                case 8:
                                    pl.setWalkSpeed(0.14F);
                                    break;
                                case 7:
                                    pl.setWalkSpeed(0.16F);
                                    break;
                                case 6:
                                    pl.setWalkSpeed(0.18F);
                                    break;
                                case 5:
                                    pl.setWalkSpeed(0.2F);
                                    break;
                                case 4:
                                    pl.setWalkSpeed(0.3F);
                                    break;
                                case 3:
                                    pl.setWalkSpeed(0.4F);
                                    break;
                                case 2:
                                    pl.setWalkSpeed(0.5F);
                                    break;
                                case 1:
                                    pl.setWalkSpeed(0.6F);
                                    break;
                            }
                            pl.sendMessage(ChatColor.GREEN
                                    + "Your walkspeed has been modified to "
                                    + playerSpeed);
                        } catch (NumberFormatException e) {
                            pl.sendMessage(ChatColor.RED
                                    + "Error: invalid speed!");
                        }

                    }
                    if (pl.isFlying()) {
                        int playerFlyingSpeed = 0;
                        try {
                            playerFlyingSpeed = Integer.parseInt(args[0]);
                            if (playerFlyingSpeed > 10) {
                                pl.sendMessage(ChatColor.RED
                                        + "Error: speed too high! (only up to 10)");
                                return false;
                            }
                            if (playerFlyingSpeed < 1) {
                                pl.sendMessage(ChatColor.RED
                                        + "Error: speed too low! (only down to 1)");
                                return false;
                            }
                            switch (playerFlyingSpeed) {
                                case 10:
                                    pl.setFlySpeed(0.5F);
                                    break;
                                case 9:
                                    pl.setFlySpeed(0.45F);
                                    break;
                                case 8:
                                    pl.setFlySpeed(0.4F);
                                    break;
                                case 7:
                                    pl.setFlySpeed(0.35F);
                                    break;
                                case 6:
                                    pl.setFlySpeed(0.25F);
                                    break;
                                case 5:
                                    pl.setFlySpeed(0.1F);
                                    break;
                                case 4:
                                    pl.setFlySpeed(0.08F);
                                    break;
                                case 3:
                                    pl.setFlySpeed(0.06F);
                                    break;
                                case 2:
                                    pl.setFlySpeed(0.04F);
                                    break;
                                case 1:
                                    pl.setFlySpeed(0.02F);
                                    break;
                            }
                            pl.sendMessage(ChatColor.GREEN
                                    + "Your flying speed is now "
                                    + playerFlyingSpeed);

                        } catch (NumberFormatException e) {
                            pl.sendMessage(ChatColor.RED
                                    + "Error: invalid speed!");
                        }
                    }
                }
                if (args.length == 2) {
                    Player targetpl = Bukkit.getServer().getPlayer(args[0]);
                    if (targetpl.isOnGround()) {
                        if (targetpl == null) {
                            pl.sendMessage(ChatColor.RED + "Player not found!");
                        } else {
                            int pspeed = 0;
                            try {
                                pspeed = Integer.parseInt(args[1]);
                                if (pspeed > 10) {
                                    pl.sendMessage(ChatColor.RED
                                            + "Error: speed too high! (only up to 10)");
                                    return false;
                                }
                                if (pspeed < 1) {
                                    pl.sendMessage(ChatColor.RED
                                            + "Error: speed too low! (only down to 1)");
                                    return false;
                                }
                                switch (pspeed) {
                                    case 10:
                                        targetpl.setWalkSpeed(0.1F);
                                        break;
                                    case 9:
                                        targetpl.setWalkSpeed(0.12F);
                                        break;
                                    case 8:
                                        targetpl.setWalkSpeed(0.14F);
                                        break;
                                    case 7:
                                        targetpl.setWalkSpeed(0.16F);
                                        break;
                                    case 6:
                                        targetpl.setWalkSpeed(0.18F);
                                        break;
                                    case 5:
                                        targetpl.setWalkSpeed(0.2F);
                                        break;
                                    case 4:
                                        targetpl.setWalkSpeed(0.3F);
                                        break;
                                    case 3:
                                        targetpl.setWalkSpeed(0.4F);
                                        break;
                                    case 2:
                                        targetpl.setWalkSpeed(0.5F);
                                        break;
                                    case 1:
                                        targetpl.setWalkSpeed(0.6F);
                                        break;
                                }
                                targetpl.sendMessage(ChatColor.GREEN
                                        + "Your walkspeed has been modified to "
                                        + pspeed);
                                pl.sendMessage(ChatColor.GREEN
                                        + targetpl.getName()
                                        + "'s walkspeed has been modified to "
                                        + pspeed);
                            } catch (Exception e) {
                                pl.sendMessage(ChatColor.RED
                                        + "Error: invalid speed!");
                            }
                        }
                    }
                    if (targetpl.isFlying()) {
                        int flyingSpeed = 0;
                        try {
                            flyingSpeed = Integer.parseInt(args[1]);
                            if (flyingSpeed > 10) {
                                pl.sendMessage(ChatColor.RED
                                        + "Error: argument too high! (only up to 10)");
                                return false;
                            }
                            if (flyingSpeed < 1) {
                                pl.sendMessage(ChatColor.RED
                                        + "Error: speed too low! (only down to 1)");
                                return false;
                            }
                            switch (flyingSpeed) {
                                case 10:
                                    targetpl.setFlySpeed(0.5F);
                                    break;
                                case 9:
                                    targetpl.setFlySpeed(0.45F);
                                    break;
                                case 8:
                                    targetpl.setFlySpeed(0.4F);
                                    break;
                                case 7:
                                    targetpl.setFlySpeed(0.35F);
                                    break;
                                case 6:
                                    targetpl.setFlySpeed(0.25F);
                                    break;
                                case 5:
                                    targetpl.setFlySpeed(0.1F);
                                    break;
                                case 4:
                                    targetpl.setFlySpeed(0.08F);
                                    break;
                                case 3:
                                    targetpl.setFlySpeed(0.06F);
                                    break;
                                case 2:
                                    targetpl.setFlySpeed(0.04F);
                                    break;
                                case 1:
                                    targetpl.setFlySpeed(0.02F);
                                    break;
                            }
                            targetpl.sendMessage(ChatColor.GREEN
                                    + "Your flying speed has been modified to "
                                    + flyingSpeed);
                            pl.sendMessage(ChatColor.GREEN + targetpl.getName()
                                    + "'s flying speed has been modified to "
                                    + flyingSpeed);
                        } catch (Exception e) {
                            pl.sendMessage(ChatColor.RED
                                    + "Error: invalid speed!");
                        }

                    }
                }
            }

        }
        return false;
    }
}
