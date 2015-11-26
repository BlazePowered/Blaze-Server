package net.glowstone.command;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class TeleportCommand extends BukkitCommand {

    public TeleportCommand() {
        super("bteleport");
        this.description = "Teleports you to another player, or a player to another player";
        this.setPermission("blaze.command.teleport");
        this.usageMessage = "/btp,bteleport <target> [target2]";
        this.setAliases(Arrays.asList("btp"));

    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {

        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + usageMessage);

        } else if (args.length == 1) {
            Player targetPlayer = player.getServer().getPlayer(args[0]);
            Location targetPlayerLocation = targetPlayer.getLocation();
            player.teleport(targetPlayerLocation);
            sender.sendMessage(ChatColor.GOLD + "Teleporting...");
            return true;
        } else if (args.length == 2) {
            Player targetPlayer = player.getServer().getPlayer(args[0]);
            Player targetPlayer1 = player.getServer().getPlayer(args[1]);
            Location targetPlayer1Location = targetPlayer1.getLocation();
            targetPlayer.teleport(targetPlayer1Location);
            sender.sendMessage(ChatColor.GOLD + "Teleporting...");
            return true;
        }
        return false;
    }

}

