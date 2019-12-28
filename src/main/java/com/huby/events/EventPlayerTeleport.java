package com.huby.events;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class EventPlayerTeleport implements Listener {

    public void onPlayerTeleport(PlayerTeleportEvent e) {

        if (e.getPlayer().getLocation().getWorld().getName().equals("Arena")) {
            PlayerJoinArenaEvent event = new PlayerJoinArenaEvent();
            Bukkit.getPluginManager().callEvent(event);

        }
    }
}
