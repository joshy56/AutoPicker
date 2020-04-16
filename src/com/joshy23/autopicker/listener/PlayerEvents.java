package com.joshy23.autopicker.listener;

import com.joshy23.autopicker.AutoPicker;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerEvents implements Listener {
    private AutoPicker plugin = AutoPicker.getPlugin();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        Block b = e.getBlock();
        if(p.getInventory().firstEmpty() > 0){
            if(plugin.getWorldGuard() != null || plugin.getWorldEdit() != null){
                LocalPlayer localPlayer = plugin.getWorldGuard().wrapPlayer(p);
                RegionManager manager = plugin.getWorldGuard().getRegionManager(p.getWorld());
                ApplicableRegionSet set = manager.getApplicableRegions(localPlayer.getPosition());
                if(set.testState(localPlayer, DefaultFlag.BLOCK_BREAK)){
                    e.setCancelled(true);
                    p.getInventory().addItem(b.getDrops().toArray(new ItemStack[]{}));
                    p.setLevel(p.getLevel()+e.getExpToDrop());
                    b.setType(Material.AIR);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP,1,1);
                }else{
                    e.setCancelled(false);
                }
            }else{
                e.setCancelled(true);
                p.getInventory().addItem(b.getDrops().toArray(new ItemStack[]{}));
                p.setLevel(p.getLevel()+e.getExpToDrop());
                b.setType(Material.AIR);
                p.playSound(p.getLocation(), Sound.LEVEL_UP,1,1);
            }
        }else{
            p.sendTitle(AutoPicker.getColor("&c&lInventory full"),"");
            p.playSound(p.getLocation(),Sound.VILLAGER_NO,1,1);
        }

    }
    /*
    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent e){

    }
    */

}
