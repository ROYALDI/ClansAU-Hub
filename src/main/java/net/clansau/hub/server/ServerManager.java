package net.clansau.hub.server;

import net.clansau.core.framework.Manager;
import net.clansau.hub.Hub;
import net.clansau.hub.server.listeners.ServerListener;
import net.clansau.hub.server.listeners.TablistListener;

public class ServerManager extends Manager {

    public ServerManager(final Hub instance) {
        super(instance, "Server Manager");
    }

    @Override
    protected void registerModules() {
        addModule(new ServerListener(this));
        addModule(new TablistListener(this));
    }
}