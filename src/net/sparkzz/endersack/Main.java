package net.sparkzz.endersack;

import net.sparkzz.endersack.command.Commands;
import net.sparkzz.endersack.events.RightClickListener;
import net.sparkzz.event.Manager;
import net.sparkzz.util.LogHandler;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	LogHandler logger = LogHandler.getInstance();
	Manager manager = Manager.getManager();
	Commands commands = new Commands();
	
	@Override
	public void onDisable() {
		logger.info(this, "Disabled.");
	}
	
	@Override
	public void onEnable() {
		commands.initCommands();
		
		manager.registerEvent(new RightClickListener(), this);
		
		logger.info(this, "Enabled.");
	}
}