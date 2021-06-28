package net.clansau.hub.world.listeners;

import net.clansau.core.client.Client;
import net.clansau.core.client.ClientManager;
import net.clansau.core.framework.modules.CoreListener;
import net.clansau.hub.world.WorldManager;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class DisableCrafting extends CoreListener<WorldManager> {

    public DisableCrafting(final WorldManager manager) {
        super(manager, "Disable Crafting");
    }

    @EventHandler
    public void onItemCraft(final PrepareItemCraftEvent e) {
        final HumanEntity viewer = e.getViewers().get(0);
        if (!(viewer instanceof Player)) {
            return;
        }
        final Player player = (Player) viewer;
        final Client client = getInstance().getManager(ClientManager.class).getOnlineClient(player.getUniqueId());
        if (client == null) {
            return;
        }
        if (client.isAdministrating()) {
            return;
        }
        e.getInventory().setResult(new ItemStack(Material.AIR));
    }
}