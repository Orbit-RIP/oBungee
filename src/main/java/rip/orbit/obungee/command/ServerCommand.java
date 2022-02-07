package rip.orbit.obungee.command;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import rip.orbit.obungee.Bungee;
import rip.orbit.obungee.utils.CC;

public class ServerCommand extends Command {
    public ServerCommand() {
        super("server", "orbit.staff", "connect");
    }

    public void execute(CommandSender commandSender, String[] args) {
        if (commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer)commandSender;
            if (p.hasPermission("orbit.staff")) {
                if (args.length == 0) {
                    p.sendMessage(CC.translate("&6You are currently connected to &f" + p.getServer().getInfo().getName() + "&6."));
                    StringBuilder servers = new StringBuilder("&6Servers: &f");
                    boolean first = true;
                    for (String name : Bungee.getInstance().getProxy().getServers().keySet()) {
                        if (first) {
                            servers.append(name);
                        } else {
                            servers.append("&7, &f").append(name);
                        }
                        first = false;
                    }
                    p.sendMessage(CC.translate(servers.toString()));
                    p.sendMessage(CC.translate("&aConnect to a server with /server <name>"));
                } else if (args.length == 1) {
                    ServerInfo si = Bungee.getInstance().getProxy().getServerInfo(args[0]);
                    if (si != null) {
                        p.sendMessage(CC.translate("&aConnecting you to " + si.getName() + "&a!"));
                        p.connect(si);
                    } else {
                        p.sendMessage(CC.translate("&cNo Permission"));
                    }
                }
            } else {
                p.sendMessage(CC.translate("&cYou must have atleast the &5Trial-Mod &crank to perform this command"));
            }
        }
    }
}
