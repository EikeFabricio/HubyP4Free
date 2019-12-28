package com.huby.party.listeners;

import com.huby.party.events.invite.InvitePlayerEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InvitePlayerListener implements Listener {

    @EventHandler
    void onInvite(InvitePlayerEvent e) {
        Player p = e.getPartyInvite().getPlayer();
        Player t = e.getPartyInvite().getInvitedPlayer();

        p.sendMessage("§aVocê convidou " + t.getName() + " para sua party.");
        t.sendMessage("§aVocê foi convidado por " + p.getName() + " para ir a uma party.");
    }
}
