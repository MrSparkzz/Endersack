package net.sparkzz.endersack.events;

import net.sparkzz.util.MsgHandler;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RightClickListener implements Listener {

	static MsgHandler msg = MsgHandler.getInstance();
	
	@EventHandler(priority = EventPriority.LOW)
	public static void onRightClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();
		
		if (action.equals(Action.RIGHT_CLICK_AIR)) {
			if (player.getItemInHand().getType() == Material.ENDER_CHEST) {
				if (player.hasPermission("endersack.use") || player.hasPermission("endersack.bypass"))
					player.openInventory(player.getEnderChest());	
				
				return;
			}
		}
	}
}