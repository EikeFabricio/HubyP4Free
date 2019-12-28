package com.huby.party.commands;

import com.huby.managers.ItemBuilder;
import com.huby.party.controller.InviteController;
import com.huby.party.controller.PartyController;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PartyCommand implements CommandExecutor {

    //TODO: Esse comando e todos os subscomandos

    @Override
    public boolean onCommand(CommandSender s, Command command, String lb, String[] args) {
        if (!(s instanceof Player)) return true;

        Player p = (Player) s;

        Inventory i = Bukkit.createInventory(null, 3 * 9, "Party");

        if (!PartyController.getController().isOnParty(p)) {
            i.setItem(11, ItemBuilder.of(Material.FLINT)
                    .setDisplayName("§eCriar uma party")
                    .setLore(new String[] {"§7Ninguém te convidou?", "§7Então crie a sua!"})
                    .build());

            i.setItem(15, ItemBuilder.of(Material.PAPER)
                    .setDisplayName("§eConvites")
                    .setAmount(InviteController.getController().getInvitesToPlayer(p).size())
                    .build());
        } else {
            i.setItem(13, ItemBuilder.of(Material.REDSTONE)
                    .setDisplayName("§cSair")
                    .setLore(new String[] {"§7Clique para sair", "§7da sua atual party."})
                    .build());
        }

        p.openInventory(i);
        return false;
    }
}
