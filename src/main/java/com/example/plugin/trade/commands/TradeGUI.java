package com.example.plugin.trade.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class TradeGUI implements InventoryHolder {

    private Player sender;
    private Player recipient;

    public TradeGUI(Player sender, Player recipient) {
        this.sender = sender;
        this.recipient = recipient;
    }

    @Override
    public Inventory getInventory() {
        return null; // Non è necessario implementare questo metodo per la GUI di trade
    }

    public void openTradeGUI() {
        Inventory inventory = Bukkit.createInventory(this, 9, "Trade");

        // Aggiungi gli elementi all'inventario della GUI, come i bottoni di accettazione
        // Ecco un esempio di come potresti aggiungere un bottone di accettazione per il mittente:
        ItemStack acceptSenderButton = new ItemStack(Material.GREEN_WOOL);
        // Personalizza l'itemStack come preferisci, ad esempio impostando un nome o un'etichetta
        // Aggiungi il bottone all'inventario della GUI
        inventory.setItem(0, acceptSenderButton);

        // Ecco un esempio di come potresti aggiungere un bottone di accettazione per il destinatario:
        ItemStack acceptRecipientButton = new ItemStack(Material.RED_WOOL);
        // Personalizza l'itemStack come preferisci, ad esempio impostando un nome o un'etichetta
        // Aggiungi il bottone all'inventario della GUI
        inventory.setItem(8, acceptRecipientButton);

        sender.openInventory(inventory);
        recipient.openInventory(inventory);
    }
}
