package com.huby.party.events;

import com.huby.party.Party;
import com.huby.party.events.model.PartyEvent;

public class PartyCreateEvent extends PartyEvent {

    private final Party party;

    public PartyCreateEvent(Party party) {
        this.party = party;
    }

    public Party getParty() {
        return party;
    }
}
