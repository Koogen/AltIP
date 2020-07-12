package us.terracraft.altip;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AltListener implements Listener {

    ArrayList<String> connected = new ArrayList<String>();

    Logger log = Bukkit.getLogger();

    @EventHandler
    public void playerConnect(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        String ip = player.getAddress().getAddress().toString();

        if (connected.contains(ip) && !player.isOp()) {
            log.info("[AltIP] Player connected from IP " + ip + ", alt detected, denying access.");
            player.kickPlayer("Duplicate accounts found at this IP address.");
        } else {
            connected.add(ip);
            log.info("[AltIP] Player connected from IP " + ip + ", no alt detected or player is opped.");
        }
    }

    @EventHandler
    public void playerDisconnect(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        String ip = player.getAddress().getAddress().toString();
        connected.remove(ip);
    }
}
