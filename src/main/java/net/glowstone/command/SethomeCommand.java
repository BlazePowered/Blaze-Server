package net.glowstone.command;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import net.glowstone.GlowServer;

public class SethomeCommand extends BukkitCommand {

	
	public SethomeCommand() {
		super("gsesethome");
		this.description = "Sets the location you're on to your home.";
		this.usageMessage = "/gsesethome <home name>";
		this.setPermission("glowstone.command.sethome");
	}
	
	@Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (sender instanceof Player) {
        	Player player = (Player) sender;
        	Location loc = player.getLocation();
        	GlowServer.getConfig.add(player.getName() + ".home", loc);
        	player.sendMessage("You're home has been set.");
        }
		return false;
	}
}

