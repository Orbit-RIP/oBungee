package rip.orbit.obungee.command;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import org.apache.commons.lang3.StringUtils;
import rip.orbit.obungee.utils.CC;

public class SaleAlertCommand extends Command {
    public SaleAlertCommand() {
        super("salealert", "orbit.headstaff");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        String toReturn = StringUtils.join(args, " ");
        BungeeCord.getInstance().getPlayers().forEach(player -> player.sendMessage(CC.toColor("&6&l[SALE] &7: " + toReturn)));
    }
}
