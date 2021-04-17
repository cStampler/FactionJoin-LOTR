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

public class OrcsAfter implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("The Orcs & Uruk-Hai of Middle-Earth")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }else if (e.getCurrentItem().getType().equals(Material.PURPLE_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD +  " Dol-Guldur");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " 67768 71 21057");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add dol-guldur");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.valueOf("LOTR_MORDOR_HELMET"))){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.BLACK + "" + ChatColor.BOLD +  " Mordor");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " 97722 80 59710");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add mordor");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.valueOf("LOTR_URUK_BERSERKER_HELMET"))){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.WHITE + "" + ChatColor.BOLD +  " Isen" + ChatColor.DARK_GRAY + "gard");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " 37440 72 42498");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add isengard");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.BROWN_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.GOLD + "" + ChatColor.BOLD +  " Gundabad");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " 49321 91 -17579");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add gundabad");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.GRAY_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.GRAY + "" + ChatColor.BOLD +  " Angmar");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " 25646 92 -29011");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add angmar");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.IRON_DOOR)){
                p.performCommand("factions");
            }
        }
    }

}