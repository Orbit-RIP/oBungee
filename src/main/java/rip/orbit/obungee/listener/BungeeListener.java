package rip.orbit.obungee.listener;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import rip.orbit.obungee.Bungee;
import rip.orbit.obungee.utils.CC;

import java.util.concurrent.TimeUnit;

public class BungeeListener implements Listener {

    @EventHandler
    public void onKick(ServerKickEvent e) {
        ProxiedPlayer p = e.getPlayer();
        ServerInfo connect = BungeeCord.getInstance().getServerInfo("Hub");
        if (e.getKickedFrom() == connect) {
            p.disconnect(CC.translate("&cKicked from &6" + e.getKickedFrom().getName() + "&c: &e" + e.getKickReason()));
            return;
        }
        e.setCancelServer(connect);
        e.setCancelled(true);
        BungeeCord.getInstance().getScheduler().schedule(Bungee.getInstance(), () -> p.sendMessage(CC.translate("&cKicked from &6" + e.getKickedFrom().getName() + "&c: &e" + e.getKickReason())), 2L, TimeUnit.SECONDS);
    }
}
