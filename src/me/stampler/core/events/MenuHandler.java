package me.stampler.core.events;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuHandler implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("Factions")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null){
                return;
            }else if (e.getCurrentItem().getType().equals(Material.BLUE_STAINED_GLASS_PANE)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                p.performCommand("dwarvesafter");
            }else if (e.getCurrentItem().getType().equals(Material.WHITE_STAINED_GLASS_PANE)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                p.performCommand("menafter");
            }else if (e.getCurrentItem().getType().equals(Material.LIGHT_BLUE_STAINED_GLASS_PANE)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                p.performCommand("elvesafter");
            }else if (e.getCurrentItem().getType().equals(Material.RED_STAINED_GLASS_PANE)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                p.performCommand("evilmenafter");
            }else if (e.getCurrentItem().getType().equals(Material.BLACK_STAINED_GLASS_PANE)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                p.performCommand("orcsafter");

            }else if (e.getCurrentItem().getType().equals(Material.IRON_DOOR)){
                p.performCommand("factions");
            }
            else if (e.getCurrentItem().getType().equals(Material.GREEN_STAINED_GLASS_PANE)){
                p.playSound(p.getLocation(), Sound.BLOCK_PORTAL_TRAVEL, 0.3F, 8.0F);
                p.performCommand("creaturesafter");

            }
        }
    }

}