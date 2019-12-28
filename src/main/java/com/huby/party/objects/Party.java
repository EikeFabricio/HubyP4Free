package com.huby.party.objects;

import com.huby.party.controller.PartyController;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.LinkedList;

public class Party {

    private final LinkedList<Player> players;

    public Party(Player... players) {
        this.players = new LinkedList<>();
        this.players.addAll(Arrays.asList(players));
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public void create() {
        PartyController.getController().createParty(this);
    }

}
