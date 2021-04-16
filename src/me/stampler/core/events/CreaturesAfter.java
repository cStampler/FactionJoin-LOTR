package me.stampler.core.events;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CreaturesAfter implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("The Creatures of Middle-Earth")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }else if (e.getCurrentItem().getType().equals(Material.GREEN_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.GREEN + "" + ChatColor.BOLD +  " Fangorn");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " 45251 71 38434");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add fangorn");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.GRAY_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.DARK_RED + "" + ChatColor.BOLD + " Half-Trolls");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add halftrolls");

                p.closeInventory();

            }
            else if (e.getCurrentItem().getType().equals(Material.IRON_DOOR)){
                p.performCommand("factions");

            }
        }
    }

}