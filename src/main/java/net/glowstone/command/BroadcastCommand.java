package net.glowstone.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.Objects;

/**
 * For running or flying extremely fast!
 */
public class BroadcastCommand extends BukkitCommand {

    public BroadcastCommand() {
        super("bzbroadcast");
        this.description = "Announce preset messages server-wide!";
        this.usageMessage = "/bzbroadcast <message> ...";
        this.setPermission("glowstone.command.broadcast");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!testPermission(sender)) return true;
        if (args.length <= 0) {
            sender.sendMessage(ChatColor.RED + "Usage: " + usageMessage);
            return false;
        }

        String msg = "";
        for (String part : args) {
            if (!Objects.equals(msg, "")) msg += " ";
            msg += part;
        }

        if (!(sender instanceof Player)) {
            Bukkit.broadcastMessage(" [Console]: " + msg);
            return true;

        }

        BroadcastCommand.super.isRegistered(); {
            Bukkit.broadcastMessage(ChatColor.GRAY + " [" + ChatColor.BLUE + "Announcement" + ChatColor.GRAY + "] " + ChatColor.translateAlternateColorCodes('&', msg));
            for (Player playerNotified : Bukkit.getServer().getOnlinePlayers()) {
                playerNotified.playSound(playerNotified.getLocation(), Sound.NOTE_PIANO, 100, 100);
            }
            return true;
        }
    }
}
