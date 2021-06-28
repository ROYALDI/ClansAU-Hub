package net.clansau.hub;

import net.clansau.core.config.IOptionsManager;
import net.clansau.core.framework.Plugin;
import net.clansau.hub.config.ConfigManager;
import net.clansau.hub.config.OptionsManager;
import net.clansau.hub.server.ServerManager;
import net.clansau.hub.server.events.ServerStartEvent;
import net.clansau.hub.server.events.ServerStopEvent;
import net.clansau.hub.world.WorldManager;
import org.bukkit.Bukkit;

public class Hub extends Plugin {

    @Override
    protected void onPluginEnable() {
        Bukkit.getServer().getPluginManager().callEvent(new ServerStartEvent());
    }

    @Override
    protected void onPluginDisable() {
        Bukkit.getServer().getPluginManager().callEvent(new ServerStopEvent());
    }

    @Override
    protected void registerManagers() {
        addManager(new ConfigManager(this));
        addManager(new OptionsManager(this));
        addManager(new ServerManager(this));
        addManager(new WorldManager(this));
    }

    @Override
    public IOptionsManager getOptionsManager() {
        return getManager(OptionsManager.class);
    }
}