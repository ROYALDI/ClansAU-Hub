package net.clansau.hub.world.listeners;

import net.clansau.core.client.Client;
import net.clansau.core.client.ClientManager;
import net.clansau.core.framework.modules.CoreListener;
import net.clansau.hub.world.WorldManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DisablePvP extends CoreListener<WorldManager> {

    public DisablePvP(final WorldManager manager) {
        super(manager, "Disable PvP");
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerDamage(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player || e.getDamager() instanceof Player)) {
            return;
        }
        final Player damager = (Player) e.getDamager();
        final Client client = getInstance().getManager(ClientManager.class).getOnlineClient(damager.getUniqueId());
        if (client == null) {
            return;
        }
        if (client.isAdministrating()) {
            return;
        }
        e.setCancelled(true);
    }
}