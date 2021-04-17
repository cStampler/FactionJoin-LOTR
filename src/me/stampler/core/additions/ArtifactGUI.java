package me.stampler.core.additions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ArtifactGUI implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player)sender;
        if (sender instanceof Player) {
        Inventory artifacts = Bukkit.createInventory(player, 27, "Artifacts");
        // Items
            ItemStack moriapick = new ItemStack(Material.valueOf("LOTR_DWARVEN_PICKAXE"), 1);
            ItemStack belegostpick = new ItemStack(Material.valueOf("LOTR_BLUE_DWARVEN_PICKAXE"), 1);
            ItemStack back = new ItemStack(Material.IRON_DOOR, 1);
            ItemStack glass1 = new ItemStack(Material.BLUE_STAINED_GLASS_PANE,1);
            ItemStack glass2 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE,1);
            ItemStack glass3 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);

            ItemMeta moriameta = moriapick.getItemMeta();
            moriameta.setDisplayName(ChatColor.GRAY + "Pickaxe of Moria");
            ArrayList<String> morialore = new ArrayList<>();
            morialore.add(ChatColor.GRAY + "A pickaxe forged by the Dwarves of Moria.");
            moriameta.setLore(morialore);
            moriapick.setItemMeta(moriameta);

            ItemMeta belegostmeta = belegostpick.getItemMeta();
            belegostmeta.setDisplayName(ChatColor.DARK_AQUA + "Pickaxe of Belegost");
            ArrayList<String> belegostlore = new ArrayList<>();
            belegostlore.add(ChatColor.GRAY + "A pickaxe forged by the Dwarves of Belegost.");
            belegostmeta.setLore(belegostlore);
            belegostpick.setItemMeta(belegostmeta);





            ItemStack[] menu_items = {glass1,glass2,glass3,glass1,glass3,glass2,glass1, glass3,glass2,glass1,glass3,glass2,moriapick,
                    glass1,belegostpick,glass3,glass1,glass3,glass2,glass1,glass3,glass2,glass1,glass2,glass3,glass1,glass2};
            artifacts.setContents(menu_items);

            player.openInventory(artifacts);




        }
        return false;
    }
}
