package com.huby.commands;

import com.huby.managers.MessagesUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class DuelX1 implements CommandExecutor {

    public static HashMap<Player, Player> x1 = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if (sender instanceof ConsoleCommandSender) Bukkit.getConsoleSender().sendMessage("Somente jogadores");
        if (args.length == 0) MessagesUtils.getUsage(p);
        if (x1.size() > 2) p.sendMessage("A zona de x1 está ocupada");

        if (args[0].equalsIgnoreCase("duelo")) {
            if (args[1].equalsIgnoreCase("convidar")) {

                String targetName = args[2];
                Player target = Bukkit.getPlayer(targetName);

                if (target == null) p.sendMessage("§cEste usuário está offline");

                Bukkit.broadcastMessage(String.format("§6%s §efoi desafiado por §6%s", target.getName(), p.getName()));
                x1.put(target, p);

                target.playSound(target.getLocation(), Sound.ANVIL_BREAK, 1F, 1F);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);

            }
        }
        return false;
    }
}
