package com.huby.party.listeners;

import com.huby.party.events.invite.DeclineInviteEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class DeclineInviteListener implements Listener {

    @EventHandler
    void onDecline(DeclineInviteEvent e) {
        Player p = e.getPartyInvite().getPlayer();
        Player t = e.getPartyInvite().getInvitedPlayer();

        p.sendMessage("§c" + t.getName() + " recusou em entrar na sua party.");
        t.sendMessage("§cVocê recusou entrar na party de " + p.getName() + ".");
    }
}
