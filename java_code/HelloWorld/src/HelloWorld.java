package helloworld;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class HelloWorld extends JavaPlugin {
  public static Logger log = Logger.getLogger("Minecraft");
  public void onEnable() {
    log.info("[HelloWorld] Start up.");
  }
  public void onReload() {
    log.info("[HelloWorld] Server reloaded.");
  }
  public void onDisable() {
    log.info("[HelloWorld] Server stopping.");
  }

  public boolean onCommand(CommandSender sender, Command command,
                           String commandLabel, String[] args) {
    if (commandLabel.equalsIgnoreCase("helloworld")) {
      if (sender instanceof Player) {
        Player me = (Player)sender;
        // Put your code after this line:
        String msg = "Hello there!  Let's get ready to code some plugins! ";
        sender.getServer().broadcastMessage(msg);
        // ...and finish your code before this line.
        return true;
      }
    }
    return false;
  }
}
