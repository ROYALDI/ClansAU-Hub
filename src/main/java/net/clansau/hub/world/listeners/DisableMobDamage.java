package net.clansau.hub.world.listeners;

import net.clansau.core.framework.modules.CoreListener;
import net.clansau.hub.world.WorldManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DisableMobDamage extends CoreListener<WorldManager> {

    public DisableMobDamage(final WorldManager manager) {
        super(manager, "Disable Mob Damage");
    }

    @EventHandler
    public void onMobDamage(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            return;
        }
        e.setCancelled(true);
    }
}