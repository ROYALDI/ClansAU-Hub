package net.clansau.hub.world.listeners;

import net.clansau.core.client.Client;
import net.clansau.core.client.ClientManager;
import net.clansau.core.framework.modules.CoreListener;
import net.clansau.core.utility.UtilMessage;
import net.clansau.hub.world.WorldManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

public class DisableBlockPlace extends CoreListener<WorldManager> {

    public DisableBlockPlace(final WorldManager manager) {
        super(manager, "Disable Block Place");
    }

    @EventHandler
    public void onBlockPlace(final BlockPlaceEvent e) {
        if (e.getBlock() == null) {
            return;
        }
        final Player player = e.getPlayer();
        final Client client = getInstance().getManager(ClientManager.class).getOnlineClient(player.getUniqueId());
        if (client == null) {
            return;
        }
        if (client.isAdministrating()) {
            return;
        }
        e.setCancelled(true);
        UtilMessage.message(player, "Game", "You are not allowed to place blocks!");
    }
}