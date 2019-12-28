package com.huby.party.events.invite;

import com.huby.party.events.model.PartyEvent;
import com.huby.party.objects.PartyInvite;

public class DeclineInviteEvent extends PartyEvent {

    private final PartyInvite partyInvite;

    public DeclineInviteEvent(PartyInvite partyInvite) {
        this.partyInvite = partyInvite;
    }

    public PartyInvite getPartyInvite() {
        return partyInvite;
    }
}
