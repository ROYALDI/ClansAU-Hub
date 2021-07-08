package net.clansau.hub.world.listeners;

import net.clansau.core.client.Client;
import net.clansau.core.client.events.ClientJoinEvent;
import net.clansau.core.framework.modules.CoreListener;
import net.clansau.core.gamer.Gamer;
import net.clansau.core.gamer.GamerManager;
import net.clansau.core.gamer.GamerRepository;
import net.clansau.hub.world.WorldManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class GamerJoinListener extends CoreListener<WorldManager> {

    public GamerJoinListener(final WorldManager manager) {
        super(manager, "Gamer Join Listener");
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onClientJoin(final ClientJoinEvent e) {
        final Client client = e.getClient();
        if (client.wasOnlineLastAgo(2500L)) {
            return;
        }
        final Gamer gamer = getInstance().getManager(GamerManager.class).getGamer(client.getUUID());
        if (gamer == null) {
            return;
        }
        gamer.setJoins(gamer.getJoins() + 1);
        getInstance().getManager(GamerRepository.class).updateJoins(gamer);
    }
}