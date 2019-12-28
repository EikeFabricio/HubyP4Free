package com.huby.party.controller;

import com.huby.HubyP4Free;
import com.huby.party.Party;
import com.huby.party.events.PartyCreateEvent;
import com.huby.party.events.PartyDeleteEvent;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PartyController {

    private static final PartyController controller = new PartyController();

    private final Map<Player, Player> pool;

    public static PartyController getController() {
        return controller;
    }

    private PartyController() {
        this.pool = new HashMap<>();
    }

    public Map<Player, Player> getPool() {
        return pool;
    }

    public void createParty(Party party) {
        PartyCreateEvent partyCreateEvent = new PartyCreateEvent(party);

        HubyP4Free.getPlugin(HubyP4Free.class).getServer().getPluginManager().callEvent(partyCreateEvent);

        if (partyCreateEvent.isCancelled()) return;

        pool.put(party.getOne(), party.getTwo());
        pool.put(party.getTwo(), party.getOne());
    }

    public void deleteParty(Party party) {
        PartyDeleteEvent partyDeleteEvent = new PartyDeleteEvent(party);

        HubyP4Free.getPlugin(HubyP4Free.class).getServer().getPluginManager().callEvent(partyDeleteEvent);

        if (!partyDeleteEvent.isCancelled()) return;

        pool.remove(party.getOne());
        pool.remove(party.getTwo());
    }

    public boolean isOnParty(Player player) {
        return pool.containsKey(player);
    }






}
