package com.huby.party.controller;

import com.huby.party.objects.Party;
import com.huby.party.events.PartyCreateEvent;
import com.huby.party.events.PartyDeleteEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.LinkedList;

public class PartyController {

    private static final PartyController controller = new PartyController();

    private final LinkedList<Party> pool;

    public static PartyController getController() {
        return controller;
    }

    private PartyController() {
        this.pool = new LinkedList<>();
    }

    public LinkedList<Party> getPool() {
        return pool;
    }

    public void createParty(Party party) {
        PartyCreateEvent partyCreateEvent = new PartyCreateEvent(party);

        Bukkit.getPluginManager().callEvent(partyCreateEvent);

        if (partyCreateEvent.isCancelled()) return;

        pool.add(party);
    }

    public void deleteParty(Party party) {
        PartyDeleteEvent partyDeleteEvent = new PartyDeleteEvent(party);

        Bukkit.getPluginManager().callEvent(partyDeleteEvent);

        if (!partyDeleteEvent.isCancelled()) return;

        pool.remove(party);
    }

    public boolean isOnParty(Player player) {
        return pool.stream().filter(p -> p.getOne() == player || p.getTwo() == player).findFirst().orElse(null) != null;
    }

}
