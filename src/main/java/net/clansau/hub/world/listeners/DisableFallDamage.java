package net.clansau.hub.world.listeners;

import net.clansau.core.framework.modules.CoreListener;
import net.clansau.hub.world.WorldManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageEvent;

public class DisableFallDamage extends CoreListener<WorldManager> {

    public DisableFallDamage(final WorldManager manager) {
        super(manager, "Disable Fall Damage");
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onFallDamage(final EntityDamageEvent e) {
        if (!(e.getCause().equals(EntityDamageEvent.DamageCause.FALL))) {
            return;
        }
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        e.setCancelled(true);
    }
}