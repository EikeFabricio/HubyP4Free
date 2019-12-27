package com.huby.managers;

import com.huby.events.PlayerJoinArenaEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinArena implements Listener {

    @EventHandler
    public void Oopa(PlayerJoinArenaEvent e) {
        e.setEquipments(true);

    }
}
