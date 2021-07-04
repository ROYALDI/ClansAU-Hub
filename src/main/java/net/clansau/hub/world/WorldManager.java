package net.clansau.hub.world;

import net.clansau.core.world.framework.IWorldManager;
import net.clansau.hub.Hub;
import net.clansau.hub.world.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class WorldManager extends IWorldManager {

    public WorldManager(final Hub instance) {
        super(instance);
    }

    @Override
    protected void registerModules() {
        addModule(new AdventureModeOnly(this));
        addModule(new DisableBlockBreak(this));
        addModule(new DisableBlockInteract(this));
        addModule(new DisableBlockPlace(this));
        addModule(new DisableCrafting(this));
        addModule(new DisableFallDamage(this));
        addModule(new DisableMobDamage(this));
        addModule(new DisablePvP(this));
        addModule(new StayInSpawnZoneOnly(this));
        addModule(new TeleportToSpawnOnJoin(this));
    }

    @Override
    public Location getSpawnLocation() {
        return new Location(Bukkit.getWorld("world"), 0.5D, 72.0D, 0.5D);
    }
}