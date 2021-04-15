package me.stampler.core.events;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leaver implements Listener {
    @EventHandler
    void onPlayerLeave(PlayerQuitEvent ev){
        Player player = ev.getPlayer();
        ev.setQuitMessage(ChatColor.RED + "[" + ChatColor.LIGHT_PURPLE + "A" + ChatColor.GOLD + "N" + ChatColor.LIGHT_PURPLE + "A" + ChatColor.RED + "]" + ChatColor.AQUA + " " + player.getName() + "has left the server");

}
}
