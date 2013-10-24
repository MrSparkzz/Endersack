package net.sparkzz.endersack.command;

import net.sparkzz.command.Register;
import net.sparkzz.util.MsgHandler;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Commands implements CommandExecutor {

	MsgHandler msg = MsgHandler.getInstance();
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String cmd = command.getName();
		
		if (cmd.equalsIgnoreCase("endersack")) {
			if (!(sender instanceof Player)) {
				msg.send(sender, msg.warn("Silly console, you don't have an enderchest!"));
				return true;
			}
			
			if (args.length > 0) {
				msg.args(sender, 1);
				return true;
			}
			
			Player player = (Player) sender;
			
			Inventory inv = player.getInventory();
			
			if (inv.contains(Material.ENDER_CHEST)) {
				if (!player.hasPermission("endersack.use")) {
					msg.deny(sender);
					return true;
				}
				
				player.openInventory(player.getEnderChest());
				return true;
			}
			
			if (player.hasPermission("endersack.bypass")) {
				player.openInventory(player.getEnderChest());
				return true;
			}
			
			msg.send(sender, msg.warn("You do not have an Ender Chest in your inventory!"));
			return true;
		}
		return false;
	}

	Register register = Register.getRegister();
	
	public void initCommands() {
		register.initCommand("endersack", this);
	}
}