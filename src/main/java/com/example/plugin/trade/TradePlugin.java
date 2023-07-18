package com.example.plugin.trade;

import com.example.plugin.trade.commands.TradeCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class TradePlugin extends JavaPlugin {

    private static TradePlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        registerCommands();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static TradePlugin getInstance() {
        return instance;
    }

    private void registerCommands() {
        getCommand("trade").setExecutor(new TradeCommand());
    }
}


