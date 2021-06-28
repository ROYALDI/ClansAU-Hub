package net.clansau.hub.world.listeners;

import net.clansau.core.framework.modules.CoreListener;
import net.clansau.core.teleport.Teleport;
import net.clansau.core.teleport.TeleportManager;
import net.clansau.hub.world.WorldManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;

public class TeleportToSpawnOnJoin extends CoreListener<WorldManager> {

    public TeleportToSpawnOnJoin(final WorldManager manager) {
        super(manager, "Teleport To Spawn On Join");
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(final PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        final Teleport teleport = new Teleport(player.getUniqueId(), getManager().getSpawnLocation(), 0L, false);
        getInstance().getManager(TeleportManager.class).addTeleport(teleport);
    }
}