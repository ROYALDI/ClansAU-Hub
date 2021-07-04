package net.clansau.hub.config;

import net.clansau.core.config.framework.IOptionsManager;
import net.clansau.hub.Hub;
import org.bukkit.configuration.file.YamlConfiguration;

public class OptionsManager extends IOptionsManager {

    public OptionsManager(final Hub instance) {
        super(instance);
    }

    @Override
    protected void handleConfig(final String type, final YamlConfiguration yml) {
    }
}