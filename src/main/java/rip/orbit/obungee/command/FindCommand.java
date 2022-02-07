package rip.orbit.obungee.command;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import rip.orbit.obungee.Bungee;
import rip.orbit.obungee.utils.CC;
import rip.orbit.obungee.utils.ComponentBuilderUtils;

public class FindCommand extends Command {
    public FindCommand() {
        super("find", "orbit.staff", "findplayer", "find player", "look", "lookup", "where", "whereis");
    }

    public void execute(CommandSender commandSender, String[] args) {
        if (args.length == 0) {
            commandSender.sendMessage(CC.translate("&cUsage: /find <player>"));
            return;
        }
        ProxiedPlayer player = Bungee.getInstance().getProxy().getPlayer(args[0]);
        if (player == null) {
            commandSender.sendMessage(CC.translate("&c" + args[0] + " is currently not on the network."));
            return;
        }
//        if (commandSender.hasPermission("bungee.find.admin")) {
            commandSender.sendMessage(ComponentBuilderUtils.buildHighlightedTextComponentWithClickCommand(CC.translate("&9" + player.getName() + " &eis currently on &9" + player.getServer().getInfo().getName() + "&e."), CC.translate("&9Click to jump to their server."), "/bgtp " + player.getName()));
//            commandSender.sendMessage(CC.translate("&9" + player.getName() + " &eis currently on &9" + player.getServer().getInfo().getName() + "&e."));
    }
}
