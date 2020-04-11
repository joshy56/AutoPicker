package com.joshy23.autopicker.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerEvents implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onBlockBreak(BlockBreakEvent e){
        e.setCancelled(true);
        e.getPlayer().getInventory().addItem(e.getBlock().getDrops().toArray(new ItemStack[]{}));
        e.getBlock().getDrops().removeAll(e.getBlock().getDrops());
        e.getPlayer().setLevel(e.getPlayer().getLevel()+e.getExpToDrop());
        e.getBlock().setType(Material.AIR);
    }

}
