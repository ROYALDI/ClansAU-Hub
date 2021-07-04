package net.clansau.hub.config;

import net.clansau.core.config.framework.IConfigManager;
import net.clansau.core.config.framework.IOptionsManager;
import net.clansau.hub.Hub;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager extends IConfigManager {

    public ConfigManager(final Hub instance) {
        super(instance);
    }

    @Override
    protected void handleConfig(final String type, final YamlConfiguration yml) {
    }

    @Override
    protected final String[] getTypes() {
        return new String[0];
    }

    @Override
    public final IOptionsManager getOptionsManager() {
        return getInstance().getManager(OptionsManager.class);
    }
}