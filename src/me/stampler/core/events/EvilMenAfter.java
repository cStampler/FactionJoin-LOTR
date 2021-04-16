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

public class EvilMenAfter implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("The Evil-Men of Middle-Earth")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }else if (e.getCurrentItem().getType().equals(Material.RED_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.RED + "" + ChatColor.BOLD +  " Gulfings");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add gulfings");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.YELLOW_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.YELLOW + "" + ChatColor.BOLD +  " Morwaith");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add morwaith");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.BLACK_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.DARK_GRAY + "" + ChatColor.BOLD +  " Um" + ChatColor.GOLD + "bar");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add umbar");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " 51879 71 122728");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.GRAY_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.YELLOW + "" + ChatColor.BOLD +  " Khand");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add khand");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.IRON_DOOR)){
                p.performCommand("factions");
            }
        }
    }

}