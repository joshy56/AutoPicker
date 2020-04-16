package com.joshy23.autopicker;

import com.joshy23.autopicker.listener.PlayerEvents;
import com.joshy23.autopicker.utils.TextHelper;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoPicker extends JavaPlugin {
    private static AutoPicker plugin;
    private final String prefix = "&8[&eAutoPicker&8]&r";

    public void onEnable(){
        plugin = this;
        if(getWorldEdit() == null || getWorldGuard() == null){
            Bukkit.getServer().getConsoleSender().sendMessage(TextHelper.getColorList(new String[]{"&7+=========="+prefix+"&7==========+","&7| Dependencies |","&7| &e"+plugin.getDescription().getSoftDepend().toString()+"&7 |","&7|   &aFound&7   |","&7+====================+"}).toArray(new String[]{}));
        }else{
            Bukkit.getServer().getConsoleSender().sendMessage(TextHelper.getColorList(new String[]{"&7+=========="+prefix+"&7==========+","&7| Dependencies |","&7| &e"+plugin.getDescription().getSoftDepend().toString()+"&7 |","&7| &cNot Found&7 |","&7+====================+"}).toArray(new String[]{}));
        }
        setEvents();
    }

    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage(getColor(prefix+" &eDisabled."));
    }

    private void setEvents(){
        getServer().getPluginManager().registerEvents(new PlayerEvents(), plugin);
    }

    public static AutoPicker getPlugin(){
        return plugin;
    }

    public WorldGuardPlugin getWorldGuard(){
        Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
        if(plugin == null || !(plugin instanceof WorldGuardPlugin)){
            return null;
        }
        return (WorldGuardPlugin) plugin;
    }

    public WorldEditPlugin getWorldEdit(){
        Plugin plugin = getServer().getPluginManager().getPlugin("WorldEdit");
        if(plugin == null || !(plugin instanceof WorldEditPlugin)){
            return null;
        }
        return (WorldEditPlugin) plugin;
    }

    public static String getColor(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
