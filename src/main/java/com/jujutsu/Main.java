package com.jujutsu;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    
    private static Main instance;
    
    @Override
    public void onEnable() {
        instance = this;
        
        // Register commands
        getCommand("domain").setExecutor(new DomainCommand());
        getCommand("jjk").setExecutor(new JJKCommand());
        
        // Register events
        getServer().getPluginManager().registerEvents(new DomainListener(), this);
        getServer().getPluginManager().registerEvents(new AbilityListener(), this);
        
        // Save default config
        saveDefaultConfig();
        
        getLogger().info("§c[JJK] §aJujutsu Kaisen Plugin Enabled!");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("§c[JJK] §cJujutsu Kaisen Plugin Disabled!");
    }
    
    public static Main getInstance() {
        return instance;
    }
}
