package net.clansau.hub.server.listeners;

import net.clansau.core.framework.modules.CoreListener;
import net.clansau.core.utility.UtilMessage;
import net.clansau.hub.config.ConfigManager;
import net.clansau.hub.server.ServerManager;
import net.clansau.hub.server.events.ServerStartEvent;
import net.clansau.hub.server.events.ServerStopEvent;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;

public class ServerListener extends CoreListener<ServerManager> {

    public ServerListener(final ServerManager manager) {
        super(manager, "Server Listener");
    }

    @EventHandler
    public void onServerStart(final ServerStartEvent e) {
        getInstance().getManager(ConfigManager.class).updateModules();
        UtilMessage.log("ClansAU-Hub", "Plugin Status: " + ChatColor.GREEN + "Enabled");
    }

    @EventHandler
    public void onServerStop(final ServerStopEvent e) {
        UtilMessage.log("ClansAU-Hub", "Plugin Status: " + ChatColor.RED + "Disabled");
    }
}