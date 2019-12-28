package com.huby;

import com.huby.party.listeners.AcceptInviteListener;
import com.huby.party.listeners.DeclineInviteListener;
import com.huby.party.listeners.InvitePlayerListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class HubyP4Free extends JavaPlugin {

    @Override
    public void onEnable() {
        register(new InvitePlayerListener(), new AcceptInviteListener(), new DeclineInviteListener());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    void register(Listener... listeners) {
        for (Listener l : listeners) {
            getServer().getPluginManager().registerEvents(l, this);
        }
    }
}
