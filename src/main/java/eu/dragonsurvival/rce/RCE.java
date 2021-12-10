package eu.dragonsurvival.rce;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class RCE extends JavaPlugin {
    public static final Pattern PATTERN = Pattern.compile("\\$\\{(.*?)\\}");

    public static String fix(String msg) {
        while (true) {
            Matcher m = PATTERN.matcher(msg);
            if (!m.find()) {
                return msg;
            }
            msg = m.replaceAll("$1");
        }
    }
    
    @Override
    public void onEnable() {
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void event(AsyncPlayerChatEvent e) {
        if (PATTERN.matcher(e.getMessage()).find()) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void event(PlayerCommandPreprocessEvent e) {
        if (PATTERN.matcher(e.getMessage()).find()) {
            e.setCancelled(true);
        }
    }
}
