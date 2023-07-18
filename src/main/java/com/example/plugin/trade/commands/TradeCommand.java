package com.example.plugin.trade.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TradeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Questo comando può essere eseguito solo da un giocatore.");
            return true;
        }

        Player player = (Player) sender;

        // Controlla se sono stati specificati gli argomenti corretti
        if (args.length != 1) {
            player.sendMessage("Utilizzo corretto: /trade <giocatore>");
            return true;
        }

        String targetPlayerName = args[0];
        Player targetPlayer = Bukkit.getPlayer(targetPlayerName);

        // Controlla se il giocatore di destinazione esiste e non è lo stesso giocatore che ha eseguito il comando
        if (targetPlayer == null || targetPlayer.equals(player)) {
            player.sendMessage("Giocatore non trovato.");
            return true;
        }

        // Apri la GUI di trade
        TradeGUI tradeGUI = new TradeGUI(player, targetPlayer);
        tradeGUI.openTradeGUI();

        return true;
    }
}
