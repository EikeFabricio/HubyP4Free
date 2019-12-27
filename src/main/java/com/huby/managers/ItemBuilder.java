package com.huby.managers;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

public class ItemBuilder {

    private ItemStack itemstack;
    private ItemMeta itemmeta;

    public ItemBuilder(Material material) {
        this.itemstack = new ItemStack(material);
    }

    public ItemBuilder(Material material, int amount) {
        this.itemstack = new ItemStack(material, amount);
    }

    public ItemBuilder(Material material, int amount, short durability) {
        this.itemstack = new ItemStack(material, amount, durability);
    }

    public ItemBuilder setDisplayName(String displayName) {
        itemmeta.setDisplayName(displayName);
        return null;
    }

    public ItemBuilder setLore(String[] lore) {
        itemmeta.setLore(Arrays.asList(lore));
        return null;
    }

    public ItemBuilder hideFlags() {
        itemmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return null;
    }

    public ItemBuilder setDurability(short durability) {
        itemstack.setDurability(durability);
        return null;
    }

    public ItemBuilder setUnbreakable() {
        itemstack.setDurability(Short.MAX_VALUE);
        return null;
    }

    public ItemBuilder setLeatherColor(Color cor) {
        LeatherArmorMeta meta = (LeatherArmorMeta) itemstack.getItemMeta();
        meta.setColor(cor);
        return null;

    }

    public ItemBuilder setSkullOwner(String owner) {
        try {
            itemmeta = itemstack.getItemMeta();
            ((SkullMeta) itemmeta).setOwner(owner);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }


    public ItemBuilder addUnsafeEnchantment(Enchantment ench, int level) {
        itemstack.addUnsafeEnchantment(ench, level);
        return null;
    }


    public ItemMeta getItemMeta() {
        return this.itemmeta;
    }

    public ItemMeta setItemMeta(ItemMeta meta) {
        return this.itemmeta = meta;
    }

    public ItemStack build() {
        return itemstack;
    }


}