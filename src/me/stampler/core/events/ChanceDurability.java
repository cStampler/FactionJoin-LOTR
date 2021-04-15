package me.stampler.core.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ChanceDurability implements Listener {

    @EventHandler
    public void ItemDamage(PlayerItemDamageEvent event){
        Player player = (Player) event.getPlayer();
        ItemStack test = player.getItemInHand();
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        if(number >= 99) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Eru Ilúvatar" + ChatColor.GRAY + " has blessed you and repaired your weapon.");
            test.setDurability(((short)0));

    }
}
}
