package me.stampler.core.additions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class ChanceSpeed implements Listener {
    @EventHandler
    public void onPlayerWalk(PlayerToggleSprintEvent even){
        Player player = (Player) even.getPlayer();
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        if(number >= 99) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Eru Ilúvatar" + ChatColor.GRAY + " has blessed you with a sudden rush of speed.");
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5,10));
        }
    }


}
