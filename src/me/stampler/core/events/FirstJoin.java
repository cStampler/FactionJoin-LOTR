package me.stampler.core.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if(!p.hasPlayedBefore()) {
            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "A new player has joined the server!" + " Welcome, " + ChatColor.BOLD + p.getName());
            p.sendMessage(ChatColor.WHITE + "Use /factions to choose a faction!");
        } else {
            Bukkit.broadcastMessage(ChatColor.GRAY + "Welcome back, " + ChatColor.BOLD + p.getName());
        }


    }
}
