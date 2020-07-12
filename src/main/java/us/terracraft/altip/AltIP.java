package us.terracraft.altip;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class AltIP extends JavaPlugin {

    Logger log = Bukkit.getLogger();



    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new AltListener(), this);
        log.info("[AltIP] Now scanning for alt accounts using the same IP address.");

    }

    @Override
    public void onDisable() {
        /* Plugin shutdown logic */
    }


}
