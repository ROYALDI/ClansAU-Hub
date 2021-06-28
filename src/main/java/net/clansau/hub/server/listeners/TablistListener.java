package net.clansau.hub.server.listeners;

import net.clansau.core.framework.modules.CoreListener;
import net.clansau.core.server.events.PlayerTablistEvent;
import net.clansau.core.utility.UtilPlayer;
import net.clansau.core.utility.UtilServer;
import net.clansau.hub.server.ServerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;

public class TablistListener extends CoreListener<ServerManager> {

    public TablistListener(final ServerManager manager) {
        super(manager, "Tablist Listener");
    }

    @EventHandler
    public void onPlayerTablist(final PlayerTablistEvent e) {
        if (e.isCancelled()) {
            return;
        }
        e.setHeader(ChatColor.GOLD.toString() + ChatColor.BOLD + "ClansAU Hub\n");
        e.setFooter(ChatColor.GOLD.toString() + ChatColor.BOLD + "\nOnline: " + ChatColor.YELLOW + Bukkit.getOnlinePlayers().size() + ChatColor.GOLD + ChatColor.BOLD + " TPS: " + ChatColor.YELLOW + UtilServer.getTPS() + ChatColor.GOLD + ChatColor.BOLD + " Ping: " + ChatColor.YELLOW + UtilPlayer.getPing(e.getPlayer()));
        e.updateTab();
    }
}