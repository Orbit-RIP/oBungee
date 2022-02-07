package rip.orbit.obungee.command;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ProxyReloadEvent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import rip.orbit.obungee.Bungee;
import rip.orbit.obungee.utils.CC;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class SetrankCommand extends Command {
    public SetrankCommand() {
        super("setrank", "orbit.headstaff", "bungee rank");
    }

    public void execute(CommandSender commandSender, String[] args) {
        if (commandSender instanceof ProxiedPlayer)
            if (commandSender.hasPermission("orbit.headstaff")) {
                if (args.length == 2) {
                    ProxiedPlayer player = Bungee.getInstance().getProxy().getPlayer(args[0]);
                    if (player != null) {
                        player.removeGroups((String[])player.getGroups().toArray((Object[])new String[player.getGroups().size()]));
                        player.addGroups(args[1]);
                        File file = new File(Bungee.getInstance().getDataFolder().getParentFile().getParent(), "config.yml");
                        try {
                            Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                            for (String group : player.getGroups())
                                config.getStringList("groups." + player.getName()).remove(group);
                            player.disconnect(CC.translate("&cYour Bungee rank has been set to " + args[1] + "\n Your permissions should be applied upon next login"));
                            config.getStringList("groups." + player.getName()).add(args[1]);
                            config.set("groups." + player.getName(), Collections.singletonList(args[1]));
                            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
                            (BungeeCord.getInstance()).config.load();
                            BungeeCord.getInstance().stopListeners();
                            BungeeCord.getInstance().startListeners();
                            BungeeCord.getInstance().getPluginManager().callEvent(new ProxyReloadEvent(commandSender));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        Bungee.getInstance().getLogger().info(CC.translate(commandSender.getName() + " &chas set " + player.getName() + "'s rank to " + args[1] + "."));
                    } else {
                        commandSender.sendMessage(CC.translate("&cThat player is not online."));
                    }
                } else {
                    commandSender.sendMessage(CC.translate("&cUsage: /setrank <player> <rank>"));
                }
            } else {
                commandSender.sendMessage(CC.translate("&cYou must have the Senior Admin rank to use this command!"));
            }
    }
}
