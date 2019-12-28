package com.huby.party.events;

import com.huby.party.Party;
import com.huby.party.events.model.PartyEvent;

public class PartyDeleteEvent extends PartyEvent {

    private final Party party;

    public PartyDeleteEvent(Party party) {
        this.party = party;
    }

    public Party getParty() {
        return party;
    }
}
