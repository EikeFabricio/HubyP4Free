package com.huby.party.objects;

import org.bukkit.entity.Player;

public class PartyInvite {

    private final Player invitedPlayer;
    private final Player player;

    public PartyInvite(Player invitedPlayer, Player player) {
        this.invitedPlayer = invitedPlayer;
        this.player = player;
    }

    public Player getInvitedPlayer() {
        return invitedPlayer;
    }

    public Player getPlayer() {
        return player;
    }

    public void accept() {

    }

    public void decline() {

    }

 }
