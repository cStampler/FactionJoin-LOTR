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

public class ArtifactAfter implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("Artifacts")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }else if (e.getCurrentItem().getType().equals(Material.valueOf("LOTR_DWARVEN_PICKAXE"))){
                p.sendMessage(StringUtils.repeat(" \n", 5));
                p.sendMessage(ChatColor.DARK_GRAY + "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                p.sendMessage(ChatColor.DARK_GRAY + " ");
                p.sendMessage(ChatColor.GRAY + "Rarity: " + ChatColor.BLUE + "Uncommon");
                p.sendMessage(ChatColor.GRAY + "This item is currently hidden!");
                p.sendMessage(ChatColor.GRAY + "Look in the: " + ChatColor.BOLD + "Trollshaws");
                p.sendMessage(ChatColor.DARK_GRAY + " ");
                p.sendMessage(ChatColor.DARK_GRAY + "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.valueOf("LOTR_BLUE_DWARVEN_PICKAXE"))){
                p.sendMessage(StringUtils.repeat(" \n", 5));
                p.sendMessage(ChatColor.DARK_GRAY + "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                p.sendMessage(ChatColor.DARK_GRAY + " ");
                p.sendMessage(ChatColor.GRAY + "Rarity: " + ChatColor.GOLD + "Legendary");
                p.sendMessage(ChatColor.GRAY + "This item is currently owned by: " + ChatColor.GOLD + "" + ChatColor.BOLD + "orcbane");
                p.sendMessage(ChatColor.DARK_GRAY + " ");
                p.sendMessage(ChatColor.DARK_GRAY + "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                p.closeInventory();

            }
            else if (e.getCurrentItem().getType().equals(Material.IRON_DOOR)){
                p.performCommand("factions");

            }
        }
    }

}

