package pigsfly;

import java.util.logging.Logger;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Pig;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PigsFly extends JavaPlugin {
  public static Logger log = Logger.getLogger("Minecraft");
  public void onEnable() {
    log.info("[PigsFly] Start up.");
  }
  public void onReload() {
    log.info("[PigsFly] Server reloaded.");
  }
  public void onDisable() {
    log.info("[PigsFly] Server stopping.");
  }

  public boolean onCommand(CommandSender sender, Command command,
                           String commandLabel, String[] args) {
    if (commandLabel.equalsIgnoreCase("pigsfly")) {
      if (sender instanceof Player) {
        Player me = (Player)sender;
        // Put your code after this line:
	Location location = me.getLocation();
        location.setY(location.getY() + 5);
        Bat bat = me.getWorld().spawn(location, Bat.class);
        Pig pig = me.getWorld().spawn(location, Pig.class);
        bat.setPassenger(pig);
        PotionEffect potion = new PotionEffect(
					       PotionEffectType.INVISIBILITY,
					       Integer.MAX_VALUE,
					       1);
        bat.addPotionEffect(potion);
        // ...and finish your code before this line.
        return true;
      }
    }
    return false;
  }
}
