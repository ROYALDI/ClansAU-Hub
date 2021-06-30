package net.clansau.hub.world.listeners;

import net.clansau.core.framework.modules.CoreListener;
import net.clansau.core.framework.updater.UpdateEvent;
import net.clansau.core.framework.updater.Updater;
import net.clansau.core.teleport.Teleport;
import net.clansau.core.teleport.TeleportManager;
import net.clansau.hub.world.WorldManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class StayInSpawnZoneOnly extends CoreListener<WorldManager> {

    public StayInSpawnZoneOnly(final WorldManager manager) {
        super(manager, "Stay In Spawn Zone Only");
    }

    @EventHandler
    public void onUpdate(final UpdateEvent e) {
        if (!(e.getType().equals(Updater.UpdateType.SEC_01))) {
            return;
        }
        for (final Player player : Bukkit.getOnlinePlayers()) {
            if (getManager().getSpawnLocation().distance(player.getLocation()) <= 100.0D) {
                continue;
            }
            final Teleport teleport = new Teleport(player.getUniqueId(), getManager().getSpawnLocation(), 0L, false, true);
            getInstance().getManager(TeleportManager.class).addTeleport(teleport);
        }
    }
}