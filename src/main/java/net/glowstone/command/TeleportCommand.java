package net.glowstone.command;

//import net.glowstone.GlowServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
//import org.bukkit.Location;
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

        if (!(sender instanceof Player) &&  args.length == 1) {
            sender.sendMessage(ChatColor.RED + "I'm sorry, but you can't teleport the console");
        } else if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + usageMessage);

        } else if (args.length == 1) {
            Player player = (Player) sender;
            Player targetPlayer = player.getServer().getPlayer(args[0]);
            //Location targetPlayerLocation = targetPlayer.getLocation();
            //player.teleport(targetPlayerLocation);
            player.teleport(targetPlayer);
            sender.sendMessage(ChatColor.GOLD + "Teleporting...");
            sender.sendMessage(ChatColor.GOLD + player.getUniqueId().toString());
            return true;
        } else if (args.length == 2) {
            Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
            Player targetPlayer1 = Bukkit.getServer().getPlayer(args[1]);
            //Location targetPlayer1Location = targetPlayer1.getLocation();
            targetPlayer.teleport(targetPlayer1);
            sender.sendMessage(ChatColor.GOLD + "Teleporting...");
            return true;
        }
        return false;
    }

}

