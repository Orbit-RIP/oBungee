package rip.orbit.obungee.command;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Command;
import rip.orbit.obungee.Bungee;
import rip.orbit.obungee.utils.CC;

public class GlobalListCommand extends Command {
    int id;

    public GlobalListCommand() {
        super("glist", "orbit.member", "glist showall");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (!commandSender.hasPermission("orbit.member")) return;

        for (ServerInfo server : Bungee.getInstance().getProxy().getServers().values()) {
            if (server.getPlayers().size() != 0) {
                String s = "";
                commandSender.sendMessage(CC.translate("&c[" + server.getName() + "] &f(" + server.getPlayers().size() + ") &c" + server.getPlayers().toString()));
            }
        }
        commandSender.sendMessage(CC.translate("&aThere are: &a" + Bungee.getInstance().getProxy().getPlayers().size() + " &aPlayers connected to orbit.rip."));

    }


//    public void execute(CommandSender commandSender, String[] strings) {
//        if (!commandSender.hasPermission("sbungee.glist"))
//            return;
//        this
//
//                .id = Bungee.getInstance().getProxy().getScheduler().schedule(Bungee.getInstance(), () -> {
//            try {
//                Bungee.getInstance().getProxy().getScheduler().cancel(this.id);
//                for (ServerInfo server : Bungee.getInstance().getProxy().getServers().values()) {
//                    if (server.getPlayers().size() != 0) {
//                        String s = "";
//                        commandSender.sendMessage(CC.translate("&c[" + server.getName() + "] &f(" + server.getPlayers().size() + ") &c" + server.getPlayers().toString()));
//                    }
//                }
//                commandSender.sendMessage(CC.translate("&fThere are: &c" + sBungee.getInstance().getProxy().getPlayers().size() + " &fplayers connected to our &cNetwork&f."));
//            } catch (NullPointerException nullPointerException) {}
//        }1L, 1L, TimeUnit.MILLISECONDS).getId();
//    }
}
