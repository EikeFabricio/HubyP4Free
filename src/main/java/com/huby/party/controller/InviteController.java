package com.huby.party.controller;

import com.huby.party.events.invite.AcceptInviteEvent;
import com.huby.party.events.invite.DeclineInviteEvent;
import com.huby.party.events.invite.InvitePlayerEvent;
import com.huby.party.objects.Party;
import com.huby.party.objects.PartyInvite;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class InviteController {

    private static final InviteController controller = new InviteController();

    private final LinkedList<PartyInvite> pool;

    public static InviteController getController() {
        return controller;
    }

    private InviteController() {
        this.pool = new LinkedList<>();
    }

    public LinkedList<PartyInvite> getPool() {
        return pool;
    }

    public void accept(PartyInvite partyInvite) {
        AcceptInviteEvent acceptInviteEvent = new AcceptInviteEvent(partyInvite);

        Bukkit.getPluginManager().callEvent(acceptInviteEvent);

        if (acceptInviteEvent.isCancelled()) return;

        this.pool.remove(partyInvite);

        new Party(partyInvite.getPlayer(), partyInvite.getInvitedPlayer()).create();
    }

    public void decline(PartyInvite partyInvite) {
        DeclineInviteEvent declineInviteEvent = new DeclineInviteEvent(partyInvite);

        Bukkit.getPluginManager().callEvent(declineInviteEvent);

        if (declineInviteEvent.isCancelled()) return;

        this.pool.remove(partyInvite);
    }

    public void create(PartyInvite partyInvite) {
        InvitePlayerEvent invitePlayerEvent = new InvitePlayerEvent(partyInvite);

        Bukkit.getPluginManager().callEvent(invitePlayerEvent);

        if (invitePlayerEvent.isCancelled()) return;

        this.pool.add(partyInvite);
    }

    public List<PartyInvite> getInvitesToPlayer(Player player) {
        return getPool().stream().filter(p -> p.getInvitedPlayer() == player).collect(Collectors.toList());
    }

}
