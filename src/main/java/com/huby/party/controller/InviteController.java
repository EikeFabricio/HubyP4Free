package com.huby.party.controller;

import com.huby.party.objects.PartyInvite;
import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.Map;

public class InviteController {

    //TODO: terminar essa classe
    private static final InviteController controller = new InviteController();

    private LinkedList<PartyInvite> pool;

    public static InviteController getController() {
        return controller;
    }

    private InviteController() {
        this.pool = new LinkedList<>();
    }

    public LinkedList<PartyInvite> getPool() {
        return pool;
    }

    public void create() {

    }
}
