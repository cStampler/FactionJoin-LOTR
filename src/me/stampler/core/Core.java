package me.stampler.core;

import me.stampler.core.commands.DwarvesAfter;
import me.stampler.core.commands.GUI;
import me.stampler.core.events.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    public static Core plugin;

    public Core() {
    }

    public void onDisable() {
    }

    public void onEnable() {
        plugin.getServer().getPluginManager();
        getCommand("factions").setExecutor(new GUI());
        getCommand("dwarvesafter").setExecutor(new DwarvesAfter());
        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
    }


    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;

            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            if (cmd.getName().equalsIgnoreCase("info")) {
                player.sendMessage(ChatColor.YELLOW + "                       Commands                       ");
                player.sendMessage(ChatColor.GREEN +  " /discord ⎯ displays discord command");
                player.sendMessage(ChatColor.GREEN +  " /faction ⎯ displays ur faction");
                player.sendMessage(ChatColor.GREEN +  " /factions ⎯ displays all factions");
                player.sendMessage(ChatColor.GREEN +  " /role ⎯ shows u all the roles");
                player.sendMessage(ChatColor.GREEN +  " /online ⎯ shows u the online players");
                player.sendMessage(ChatColor.GREEN +  " /pouch ⎯ opens up ur e-pouch");
                player.sendMessage(ChatColor.YELLOW + "∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");



            } else if (cmd.getName().equalsIgnoreCase("discord")) {
                player.sendMessage(ChatColor.YELLOW +  "Our discord link is:" + ChatColor.GREEN + "https://discord.gg/hMSFptArrQ");

            }

            return false;
        } else {
            sender.sendMessage("Goodluck running the command without perms!!");
            return true;
        }
    }
}