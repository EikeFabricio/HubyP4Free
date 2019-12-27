package com.huby.events;

import com.huby.managers.EventWrapper;
import com.huby.managers.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PlayerJoinArenaEvent extends EventWrapper {

    private Player challenger;
    private List<ItemBuilder> itens;
    private Player challenged;

    public PlayerJoinArenaEvent() {
        Bukkit.getOnlinePlayers().stream().filter(onlines -> onlines != challenger).filter(onlines -> onlines != challenged).forEach(onlines -> {
            challenged.hidePlayer(onlines);
            challenger.hidePlayer(onlines);
        });
    }

    public Player getChallenger() {
        return challenger;
    }

    public Player getChallenged() {
        return challenged;
    }

    public List<ItemBuilder> getItens() {
        return itens;
    }

    public void setItem() {
            itens.add(new ItemBuilder(Material.DIAMOND_HELMET, 5)
                    .addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                    .addUnsafeEnchantment(Enchantment.DURABILITY, 3));

            itens.add(new ItemBuilder(Material.DIAMOND_CHESTPLATE, 5)
                    .addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                    .addUnsafeEnchantment(Enchantment.DURABILITY, 3));

            itens.add(new ItemBuilder(Material.DIAMOND_LEGGINGS, 5)
                    .addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                    .addUnsafeEnchantment(Enchantment.DURABILITY, 3));

            itens.add(new ItemBuilder(Material.DIAMOND_BOOTS, 5)
                    .addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                    .addUnsafeEnchantment(Enchantment.DURABILITY, 3));

            itens.add(new ItemBuilder(Material.DIAMOND_SWORD, 5)
                    .addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5)
                    .addUnsafeEnchantment(Enchantment.DURABILITY, 3));

            this.itens = getItens();

    }

    public void setEquipments(boolean enable) {
        if (enable) {
            Player p = getChallenger();
            p.getInventory().addItem((ItemStack) getItens());
        }
    }
}