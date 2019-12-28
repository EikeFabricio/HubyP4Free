package com.huby.party.listeners.inventory.custom;

import com.huby.party.events.model.PartyEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PartyInventoryClickEvent extends PartyEvent {

    private final ItemStack currentItem;
    private final Inventory inventory;
    private final int slot;
    private final Player player;

    public PartyInventoryClickEvent(ItemStack currentItem, Inventory inventory, int slot, Player player) {
        this.currentItem = currentItem;
        this.inventory = inventory;
        this.slot = slot;
        this.player = player;
    }

    public ItemStack getCurrentItem() {
        return currentItem;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Player getPlayer() {
        return player;
    }

    public int getSlot() {
        return slot;
    }
}
