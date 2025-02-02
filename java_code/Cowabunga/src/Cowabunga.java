package cowabunga;

import java.util.logging.Logger;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Cow;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Cowabunga extends JavaPlugin {
  public static Logger log = Logger.getLogger("Minecraft");
  public void onEnable() {
    log.info("[Cowabunga] Start up.");
  }
  public void onReload() {
    log.info("[Cowabunga] Server reloaded.");
  }
  public void onDisable() {
    log.info("[Cowabunga] Server stopping.");
  }

  public boolean onCommand(CommandSender sender, Command command,
                           String commandLabel, String[] args) {
    if (commandLabel.equalsIgnoreCase("cowabunga")) {
      if (sender instanceof Player) {
        Player me = (Player)sender;
        // Put your code after this line:
	Location location = me.getLocation();
        for (int i = 0; i < 10 ; i++) {
	    me.getWorld().spawn(location, Cow.class);
	}
        // ...and finish your code before this line.
        return true;
      }
    }
    return false;
  }
}
