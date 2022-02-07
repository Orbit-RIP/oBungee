package rip.orbit.obungee.command;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import rip.orbit.obungee.Bungee;
import rip.orbit.obungee.utils.CC;

import java.util.concurrent.TimeUnit;


public class BungeeTeleportCommand extends Command {

    public BungeeTeleportCommand() { super("bgtp", "orbit.staff", "bungeetp"); }


    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (args.length != 0) {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            if (BungeeCord.getInstance().getPlayer(args[0]).isConnected()) {
                Bungee.getInstance().getProxy().getScheduler().schedule(Bungee.getInstance(), new Runnable() {
                    public void run() {
                        player.chat("/tp " + args[0]);
                    }
                }, 1, 1440, TimeUnit.SECONDS);
                player.connect(BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo());
                return;
            } else {
                commandSender.sendMessage(CC.translate("&c'" + args[0] + "' is not connected to the server!"));
            }
        } else {
            commandSender.sendMessage(CC.translate("&cUsage: /bgtp <player>"));
            return;
        }
    }
}
