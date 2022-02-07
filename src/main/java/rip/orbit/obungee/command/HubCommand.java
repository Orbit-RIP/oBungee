//package rip.orbit.obungee.command;
//
//import net.md_5.bungee.api.CommandSender;
//import net.md_5.bungee.api.ProxyServer;
//import net.md_5.bungee.api.config.ServerInfo;
//import net.md_5.bungee.api.connection.ProxiedPlayer;
//import net.md_5.bungee.api.plugin.Command;
//import rip.orbit.obungee.utils.CC;
//
//public class HubCommand extends Command {
//    public HubCommand() {
//        super("hub");
//    }
//
//    public void execute(CommandSender commandSender, String[] args) {
//        if (commandSender instanceof ProxiedPlayer) {
//            ProxiedPlayer player = (ProxiedPlayer) commandSender;
//            player.sendMessage(CC.translate("&6Sending you to the Hub..."));
//            ServerInfo serverInfo = ProxyServer.getInstance().getServerInfo("Hub-2");
//            player.connect(serverInfo);
//        }
//    }
//}
