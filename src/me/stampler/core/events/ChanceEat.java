package me.stampler.core.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class ChanceEat implements Listener {
    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent e){
        Player player = (Player) e.getPlayer();
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        if(number >= 95) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Eru Ilúvatar" + ChatColor.GRAY + " has blessed u with full hunger.");
            player.setFoodLevel(20);
        }

    }
}

