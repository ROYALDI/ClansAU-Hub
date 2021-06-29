package net.clansau.hub.world.listeners;

import net.clansau.core.client.Client;
import net.clansau.core.client.ClientManager;
import net.clansau.core.client.Rank;
import net.clansau.core.framework.modules.CoreListener;
import net.clansau.core.framework.updater.UpdateEvent;
import net.clansau.core.framework.updater.Updater;
import net.clansau.hub.world.WorldManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class AdventureModeOnly extends CoreListener<WorldManager> {

    public AdventureModeOnly(final WorldManager manager) {
        super(manager, "Adventure Mode Only");
    }

    @EventHandler
    public void onUpdate(final UpdateEvent e) {
        if (!(e.getType().equals(Updater.UpdateType.SEC_02))) {
            return;
        }
        for (final Player player : Bukkit.getOnlinePlayers()) {
            if (this.isBypassed(player)) {
                continue;
            }
            player.setGameMode(GameMode.ADVENTURE);
        }
    }

    private boolean isBypassed(final Player player) {
        if (player.getGameMode().equals(GameMode.ADVENTURE)) {
            return true;
        }
        if (player.isOp() || player.getGameMode().equals(GameMode.SPECTATOR)) {
            return true;
        }
        final Client client = getInstance().getManager(ClientManager.class).getOnlineClient(player.getUniqueId());
        if (client == null) {
            return false;
        }
        return client.hasRank(Rank.ADMIN, false);
    }
}