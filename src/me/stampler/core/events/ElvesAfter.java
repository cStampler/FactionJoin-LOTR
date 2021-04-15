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

public class ElvesAfter implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("The Elves of Middle-Earth")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }else if (e.getCurrentItem().getType().equals(Material.BLUE_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.AQUA + "" + ChatColor.BOLD +  " Lindon");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " -36270 72 -1481");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add lindon");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.PURPLE_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD +  " Dorwinion");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " 124726 70 17091");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add dorwinion");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.YELLOW_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.YELLOW + "" + ChatColor.BOLD +  " Lothlórien");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " 49710 70 21031");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add lothlorien");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.LIGHT_BLUE_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.AQUA + "" + ChatColor.BOLD +  " Rivendell");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " 47065 69 -1077");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add rivendell");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.GREEN_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.GREEN + "" + ChatColor.BOLD +  " Wood-Elves");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " 78143 76 -12348");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add woodelves");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.IRON_DOOR)){
                p.performCommand("factions");
            }
        }
    }

}