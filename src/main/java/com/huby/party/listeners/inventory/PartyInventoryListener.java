package com.huby.party.listeners.inventory;

import com.huby.party.controller.PartyController;
import com.huby.party.listeners.inventory.custom.PartyInventoryClickEvent;
import com.huby.party.objects.Party;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PartyInventoryListener implements Listener {

    @EventHandler
    void onClick(PartyInventoryClickEvent e) {
        PartyController partyController = PartyController.getController();

        if (e.getCurrentItem().getType() == Material.REDSTONE) {
            Party party = partyController.getPartyAt(e.getPlayer());

            partyController.deleteParty(party);

            e.getPlayer().sendMessage("§cVocê saiu da party, por isso ela foi deletada.");

            party.getPlayers().stream().filter(p -> p != e.getPlayer()).forEach(p ->
                p.sendMessage("§c" + e.getPlayer().getName() + " saiu da party, por isso ela foi deletada.")
            );
        }
    }
}
