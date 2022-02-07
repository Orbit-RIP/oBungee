package rip.orbit.obungee.task;
import java.util.HashMap;
import java.util.Map;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import rip.orbit.obungee.Bungee;
import rip.orbit.obungee.utils.CC;

public class ServerTask implements Runnable {

    private Map<ServerInfo, Boolean> servers = new HashMap<>();

    public ServerTask() {
        for (ServerInfo serverInfo : Bungee.getInstance().getProxy().getServers().values())
            this.servers.put(serverInfo, Boolean.FALSE);
    }

    public void run() {
        for (ServerInfo serverInfo : Bungee.getInstance().getProxy().getServers().values()) {
            serverInfo.ping((sp, ex) -> {
                boolean online = (ex == null);
                if (!ServerTask.this.servers.containsKey(serverInfo)) {
                    ServerTask.this.servers.put(serverInfo, online);
                } else if (ServerTask.this.servers.get(serverInfo) != online) {
                    for (ProxiedPlayer p : Bungee.getInstance().getProxy().getPlayers()) {
                        if (p.hasPermission("bungee.servertask"))
                            p.sendMessage(online ? CC.translate("&8[&eServer Monitor&8] &fAdding server " + serverInfo.getName() + "...") : CC.translate("&8[&eServer Monitor&8] &fRemoving server " + serverInfo.getName() + "..."));
                    }
                    ServerTask.this.servers.put(serverInfo, online);
                }
            });
        }
    }
}
