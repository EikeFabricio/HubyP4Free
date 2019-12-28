package com.huby.managers;

import org.bukkit.entity.Player;

public class MessagesUtils {

    public static void getUsage(Player p) {

        p.sendMessage(new String[]{
                "§6» §e/duelo convidar [player] - §7(Convida um jogador para duelar contra você)",
                "§6» §e/duelo aceitar - §7(Aceita o duelo contra o desafiante)",
                "§6» §e/duelo recusar - §7(Recusa o duelo contra o desafiante)"});

        if (p.hasPermission("Huby.P4Free.Admin")) {
            p.sendMessage(new String[]{
                    "§4» §c/duelo playerum - §8(Seta a entrada do player UM)",
                    "§4» §c/duelo playerdois - §8(Seta a entrada do player DOIS)"
            });
        }
    }
}
