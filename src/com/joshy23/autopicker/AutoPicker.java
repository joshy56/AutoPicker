package com.joshy23.autopicker;

import com.joshy23.autopicker.listener.PlayerEvents;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoPicker extends JavaPlugin {
    private static AutoPicker plugin;
    private final String prefix = "&8[&eAutoPicker&8]&r";

    public void onEnable(){
        plugin = this;
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+" &eEnabled."));
        setEvents();
    }

    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+" &eDisabled."));
    }

    private void setEvents(){
        getServer().getPluginManager().registerEvents(new PlayerEvents(), plugin);
    }

    public static AutoPicker getPlugin(){
        return plugin;
    }

}
