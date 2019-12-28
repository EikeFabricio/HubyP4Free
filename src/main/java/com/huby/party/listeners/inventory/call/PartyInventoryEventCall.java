package com.huby.party.listeners.inventory.call;

import com.huby.party.listeners.inventory.custom.PartyInventoryClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PartyInventoryEventCall implements Listener {

    @EventHandler
    void onClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getType() == null) return;
        if (e.getCurrentItem().getType() == Material.AIR) return;

        if (e.getInventory().getName().equals("Party")) {
            e.setCancelled(true);

            PartyInventoryClickEvent partyInventoryClickEvent = new PartyInventoryClickEvent(e.getCurrentItem(),
                    e.getInventory(), e.getSlot(), (Player) e.getWhoClicked());

            Bukkit.getPluginManager().callEvent(partyInventoryClickEvent);
        }

    }
}
