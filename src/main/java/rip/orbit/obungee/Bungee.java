package rip.orbit.obungee;

import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.scheduler.ScheduledTask;
import rip.orbit.obungee.command.*;
import rip.orbit.obungee.command.*;
import rip.orbit.obungee.listener.BungeeListener;
import rip.orbit.obungee.task.ServerTask;

import java.util.concurrent.TimeUnit;

public class Bungee extends Plugin {

    @Getter private static Bungee instance;
    @Getter private ScheduledTask scheduledTask;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        setupListeners();
        setupCommands();
        this.scheduledTask = getProxy().getScheduler().schedule(this, new ServerTask(), 0L, 10L, TimeUnit.SECONDS);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void setupListeners() {
        getProxy().getPluginManager().registerListener(getInstance(), new BungeeListener());
    }

    public void setupCommands() {
        getProxy().getPluginManager().registerCommand(getInstance(), new SetrankCommand());
        getProxy().getPluginManager().registerCommand(getInstance(), new GlobalListCommand());
        getProxy().getPluginManager().registerCommand(getInstance(), new FindCommand());
        getProxy().getPluginManager().registerCommand(getInstance(), new ServerCommand());
//        getProxy().getPluginManager().registerCommand(getInstance(), new HubCommand());
        getProxy().getPluginManager().registerCommand(getInstance(), new BungeeTeleportCommand());
        getProxy().getPluginManager().registerCommand(getInstance(), new SaleAlertCommand());
    }
}
