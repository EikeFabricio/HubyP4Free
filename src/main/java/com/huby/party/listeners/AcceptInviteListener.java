package com.huby.party.listeners;

import com.huby.party.events.invite.AcceptInviteEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class AcceptInviteListener implements Listener {

    @EventHandler
    void onAccept(AcceptInviteEvent e) {
        Player p = e.getPartyInvite().getPlayer();
        Player t = e.getPartyInvite().getInvitedPlayer();

        p.sendMessage("§a" + t.getName() + " entrou na sua party.");
        t.sendMessage("§aVocê entrou na party de " + t.getName() + ".");
    }
}
