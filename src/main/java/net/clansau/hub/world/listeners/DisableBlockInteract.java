package net.clansau.hub.world.listeners;

import net.clansau.core.client.Client;
import net.clansau.core.client.ClientManager;
import net.clansau.core.framework.modules.CoreListener;
import net.clansau.core.utility.UtilBlock;
import net.clansau.hub.world.WorldManager;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

public class DisableBlockInteract extends CoreListener<WorldManager> {

    public DisableBlockInteract(final WorldManager manager) {
        super(manager, "Disable Block Interact");
    }

    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent e) {
        final Block block = e.getClickedBlock();
        if (block == null) {
            return;
        }
        if (!(UtilBlock.isContainer(block.getType()) || UtilBlock.isUsable(block.getType()))) {
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
    }
}