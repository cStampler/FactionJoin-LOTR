package me.stampler.core;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.HashMap;

public class Core extends JavaPlugin {

    public static Core plugin;

    public Core() {
    }

    public void onDisable() {
    }

    public void onEnable() {
        plugin.getServer().getPluginManager();
    }
    private int count;

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;


            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            if (cmd.getName().equalsIgnoreCase("info")) {
                player.sendMessage(ChatColor.YELLOW + "                       Commands                       ");
                player.sendMessage(ChatColor.GREEN +  " /discord ⎯ displays discord command");
                player.sendMessage(ChatColor.GREEN +  " /faction ⎯ displays ur faction");
                player.sendMessage(ChatColor.GREEN +  " /factions ⎯ displays all factions");
                player.sendMessage(ChatColor.GREEN +  " /joinfaction - lets u join a faction");
                player.sendMessage(ChatColor.GREEN +  " /role ⎯ shows u all the roles");
                player.sendMessage(ChatColor.GREEN +  " /online ⎯ shows u the online players");
                player.sendMessage(ChatColor.GREEN +  " /pouch ⎯ opens up ur e-pouch");
                player.sendMessage(ChatColor.YELLOW + "∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");







            } else if (cmd.getName().equalsIgnoreCase("discord")) {
            player.sendMessage(ChatColor.YELLOW +  "Our discord link is:" + ChatColor.GREEN + "https://discord.gg/hMSFptArrQ");






            } else if (cmd.getName().equalsIgnoreCase("factions")) {
                player.sendMessage(ChatColor.GREEN + "                                Factions:                                  ");
                // Texts
                TextComponent mordor = new TextComponent("Mordor");
                mordor.setBold(true);
                mordor.setColor(net.md_5.bungee.api.ChatColor.GRAY);
                mordor.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/mordor"));
                mordor.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to see Mordor Info").color(net.md_5.bungee.api.ChatColor.RED).create()));

                TextComponent hobbits = new TextComponent("Hobbits");
                hobbits.setBold(true);
                hobbits.setColor(net.md_5.bungee.api.ChatColor.GREEN);
                hobbits.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/hobbits"));
                hobbits.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to see Hobbits Info").color(net.md_5.bungee.api.ChatColor.GREEN).create()));

                TextComponent bree = new TextComponent("Bree");
                bree.setBold(true);
                bree.setColor(net.md_5.bungee.api.ChatColor.GREEN);
                bree.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/bree"));
                bree.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to see Bree Info").color(net.md_5.bungee.api.ChatColor.GREEN).create()));

                TextComponent rangers = new TextComponent("Rangers");
                rangers.setBold(true);
                rangers.setColor(net.md_5.bungee.api.ChatColor.GREEN);
                rangers.setStrikethrough(true);
                rangers.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/rangers"));
                rangers.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to see Rangers Info").color(net.md_5.bungee.api.ChatColor.GREEN).create()));

                TextComponent highelves = new TextComponent("High-Elves");
                highelves.setBold(true);
                highelves.setColor(net.md_5.bungee.api.ChatColor.AQUA);
                highelves.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/highelves"));
                highelves.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to see High-Elves Info").color(net.md_5.bungee.api.ChatColor.AQUA).create()));

                TextComponent bluemount = new TextComponent("Blue-Mountains");
                bluemount.setBold(true);
                bluemount.setColor(net.md_5.bungee.api.ChatColor.BLUE);
                bluemount.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/bluemount"));
                bluemount.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to see Blue-Mountains Info").color(net.md_5.bungee.api.ChatColor.BLUE).create()));
                // Execution
                // Execution


                player.spigot().sendMessage(hobbits);
                player.sendMessage(StringUtils.repeat(" \n", 1));
                player.spigot().sendMessage(bree);
                player.sendMessage(StringUtils.repeat(" \n", 1));
                player.spigot().sendMessage(rangers);
                player.sendMessage(StringUtils.repeat(" \n", 1));
                player.spigot().sendMessage(highelves);
                player.sendMessage(StringUtils.repeat(" \n", 1));
                player.spigot().sendMessage(bluemount);
                // Join




            } else if (cmd.getName().equalsIgnoreCase("online")) {
                player.sendMessage(ChatColor.YELLOW + "Online Players:" + ChatColor.GREEN + Bukkit.getOnlinePlayers());

            }
            else if (cmd.getName().equalsIgnoreCase("joinhobbits")) {
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(sender.getName() + ChatColor.GRAY + " has joined " + ChatColor.GREEN + "Hobbits");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + sender.getName() + " parent set " + "hobbits");

            }
            else if (cmd.getName().equalsIgnoreCase("joinhighelves")) {
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(sender.getName() + ChatColor.GRAY + " has joined " + ChatColor.AQUA + "High-Elves");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + sender.getName() + " parent set " + "high-elves");
            }
            else if (cmd.getName().equalsIgnoreCase("joinbree")) {
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(sender.getName() + ChatColor.GRAY + " has joined " + ChatColor.GREEN + "Hobbits");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + sender.getName() + " parent set " + "bree");

            }
            else if (cmd.getName().equalsIgnoreCase("joinbluemount")) {
                Bukkit.broadcastMessage(StringUtils.repeat(" \n", 5));
                Bukkit.broadcastMessage(sender.getName() + ChatColor.GRAY + " has joined " + ChatColor.BLUE + "Blue Mountains");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + sender.getName() + " parent set " + "blue-mountains");


            }
            else if (cmd.getName().equalsIgnoreCase("hobbits")) {

                TextComponent joinHobbits = new TextComponent("Join");
                joinHobbits.setBold(true);
                joinHobbits.setColor(net.md_5.bungee.api.ChatColor.GOLD);
                joinHobbits.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/joinhobbits"));
                joinHobbits.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to join Hobbits").color(net.md_5.bungee.api.ChatColor.GREEN).create()));

                player.sendMessage(StringUtils.repeat(" \n", 3));
                player.sendMessage(ChatColor.GREEN + "Capital:" + ChatColor.GOLD + "" + ChatColor.BOLD + " Hobbiton");
                player.sendMessage(StringUtils.repeat(" \n", 1));
                player.spigot().sendMessage(joinHobbits);


            }
            else if (cmd.getName().equalsIgnoreCase("bree")) {

                TextComponent joinBree = new TextComponent("Join");
                joinBree.setBold(true);
                joinBree.setColor(net.md_5.bungee.api.ChatColor.GOLD);
                joinBree.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/joinbree"));
                joinBree.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to join Bree").color(net.md_5.bungee.api.ChatColor.GREEN).create()));


                player.sendMessage(StringUtils.repeat(" \n", 3));
                player.sendMessage(ChatColor.GREEN + "Capital:" + ChatColor.GOLD + "" + ChatColor.BOLD + " Bree");
                player.sendMessage(StringUtils.repeat(" \n", 1));
                player.spigot().sendMessage(joinBree);


            }

            else if (cmd.getName().equalsIgnoreCase("rangers")) {
                player.sendMessage(ChatColor.GRAY + "This faction was decimated, and no longer exists.");



            }

            else if (cmd.getName().equalsIgnoreCase("bluemount")) {
                TextComponent joinBlueMount = new TextComponent("Join");
                joinBlueMount.setBold(true);
                joinBlueMount.setColor(net.md_5.bungee.api.ChatColor.GOLD);
                joinBlueMount.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/joinbluemount"));
                joinBlueMount.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to join Blue-Mountains").color(net.md_5.bungee.api.ChatColor.BLUE).create()));

                player.sendMessage(StringUtils.repeat(" \n", 3));
                player.sendMessage(ChatColor.BLUE + "Capital:" + ChatColor.GOLD + "" + ChatColor.BOLD + " Belegost");
                player.sendMessage(StringUtils.repeat(" \n", 1));
                player.spigot().sendMessage(joinBlueMount);


            }


             else if (cmd.getName().equalsIgnoreCase("highelves")) {
                TextComponent joinHighElves = new TextComponent("Join");
                joinHighElves.setBold(true);
                joinHighElves.setColor(net.md_5.bungee.api.ChatColor.GOLD);
                joinHighElves.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/joinhighelves"));
                joinHighElves.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to join High-Elves").color(net.md_5.bungee.api.ChatColor.AQUA).create()));

            player.sendMessage(StringUtils.repeat(" \n", 3));
            player.sendMessage(ChatColor.AQUA + "Capital:" + ChatColor.GOLD + "" + ChatColor.BOLD + " Forlond");
            player.sendMessage(StringUtils.repeat(" \n", 1));
            player.spigot().sendMessage(joinHighElves);



        }


            return false;
        } else {
            sender.sendMessage("Goodluck running the command without perms!!");
            return true;
        }
    }
}
