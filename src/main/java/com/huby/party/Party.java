package com.huby.party;

import com.huby.party.controller.PartyController;
import org.bukkit.entity.Player;

public class Party {

    private final Player one;
    private final Player two;

    public Party(Player one, Player two) {
        this.one = one;
        this.two = two;
    }

    public Player getOne() {
        return one;
    }

    public Player getTwo() {
        return two;
    }

    public void create() {
        PartyController.getController().createParty(this);
    }


}
