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

public class MenAfter implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("The Good Men of Middle-Earth")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }else if (e.getCurrentItem().getType().equals(Material.BROWN_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.GOLD + "" + ChatColor.BOLD +  " Rohan");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " 40779 79 49334");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add rohan");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.BLUE_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.GREEN + "" + ChatColor.BOLD +  " Hobbits");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " -327 70 429");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add hobbits");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.WHITE_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.WHITE + "" + ChatColor.BOLD +  " Gondor");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " 78016 72 66239");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add gondor");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.GREEN_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.DARK_GREEN + "" + ChatColor.BOLD +  " Taurethrim");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add taurethrim");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.GRAY_BANNER)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.GREEN + "" + ChatColor.BOLD +  " Rangers");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " 37560 71 3683");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add dunedain");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.SNOW_BLOCK)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(p.getName() + " has joined" + ChatColor.WHITE + "" + ChatColor.BOLD +  " Lossoth");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + p.getName() + " -3050 72 -43543");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent clear");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add lossoth");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.IRON_DOOR)){
                p.performCommand("factions");
            }
        }
    }

}