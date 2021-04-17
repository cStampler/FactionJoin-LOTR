package me.stampler.core;

import me.stampler.core.additions.*;
import me.stampler.core.events.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Optional;

public class Core extends JavaPlugin {
    public Permission heal = new Permission("core.heal");
    public Permission feed = new Permission("core.feed");
    public Permission fly = new Permission("core.fly");

    public void onDisable() {
    }

    public void onEnable() {
        // Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        // Events
        getServer().getPluginManager().registerEvents(new MenuHandler(), this);
        getServer().getPluginManager().registerEvents(new DwarvesAfter(), this);
        getServer().getPluginManager().registerEvents(new ArtifactAfter(), this);
        getServer().getPluginManager().registerEvents(new ElvesAfter(), this);
        getServer().getPluginManager().registerEvents(new MenAfter(), this);
        getServer().getPluginManager().registerEvents(new EvilMenAfter(), this);
        getServer().getPluginManager().registerEvents(new OrcsAfter(), this);
        getServer().getPluginManager().registerEvents(new CreaturesAfter(), this);
        getServer().getPluginManager().registerEvents(new Welcomer(), this);
        getServer().getPluginManager().registerEvents(new Leaver(), this);
        getServer().getPluginManager().registerEvents(new ChanceEat(), this);
        getServer().getPluginManager().registerEvents(new ChanceSpeed(), this);
        getServer().getPluginManager().registerEvents(new ChanceDurability(), this);
        getServer().getPluginManager().registerEvents(new FirstJoin(), this);
        getCommand("artifacts").setExecutor(new ArtifactGUI());
    }


    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            Inventory gui = Bukkit.createInventory(player, 9, "Factions");
            Inventory dwarvesafter = Bukkit.createInventory(player, 27, "The Dwarves of Middle-Earth");
            Inventory orcsafter = Bukkit.createInventory(player, 27, "The Orcs & Uruk-Hai of Middle-Earth");
            Inventory menafter = Bukkit.createInventory(player, 27, "The Good Men of Middle-Earth");
            Inventory elvesafter = Bukkit.createInventory(player, 27, "The Elves of Middle-Earth");
            Inventory evilmenafter = Bukkit.createInventory(player, 27, "The Evil-Men of Middle-Earth");
            Inventory creaturesafter = Bukkit.createInventory(player, 27, "The Creatures of Middle-Earth");

            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            if (cmd.getName().equalsIgnoreCase("info")) {
                player.sendMessage(ChatColor.YELLOW + "                       Commands                       ");
                player.sendMessage(ChatColor.GREEN +  " /discord ⎯ displays discord command");
                player.sendMessage(ChatColor.GREEN +  " /factions ⎯ displays all factions");
                player.sendMessage(ChatColor.GREEN +  " /spawn ⎯ brings u to spawn");
                player.sendMessage(ChatColor.GREEN +  " /online ⎯ shows u the online players");



            }
                else if (cmd.getName().equalsIgnoreCase("discord")) {
                player.sendMessage(ChatColor.YELLOW +  "Our discord link is:" + ChatColor.GREEN + " https://discord.gg/hMSFptArrQ");
            }

            else if (cmd.getName().equalsIgnoreCase("spawn")) {
                player.sendMessage(ChatColor.WHITE + "You have been brought to spawn.");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "execute in lotr:middle_earth run tp " + player.getName() + " -92481 70 -4022");
            }
            else if (cmd.getName().equalsIgnoreCase("feed") && player.hasPermission(feed)) {
                player.sendMessage(ChatColor.WHITE + "Your appetite has been sated.");
                player.setFoodLevel(20);
            }
            else if (cmd.getName().equalsIgnoreCase("fly") && player.hasPermission(fly)) {
                if(args.length == 0){
                    player.sendMessage(ChatColor.GRAY + "You may now fly.");
                    player.setAllowFlight(true);

                }
                else if(args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    target.sendMessage(ChatColor.GRAY + "You may now fly.");
                    player.sendMessage(ChatColor.GRAY + "Enabled Fly for Player: " + target.getName());
                    target.setAllowFlight(true);
                }

            }
            else if (cmd.getName().equalsIgnoreCase("heal") && player.hasPermission(heal)) {
                player.sendMessage(ChatColor.WHITE + "You have been healed.");
                player.setHealth(20);
            }
            else if (cmd.getName().equalsIgnoreCase("unfly") && player.hasPermission(fly)) {
                if(args.length == 0){
                    player.sendMessage(ChatColor.GRAY + "You may no longer fly.");
                    player.setAllowFlight(false);

                }
                else if (args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    target.sendMessage(ChatColor.GRAY + "You may no longer fly.");
                    player.sendMessage(ChatColor.GRAY + "You Disabled Fly for Player: " + target.getName());
                    target.setAllowFlight(false);
                }
            }
            else if (cmd.getName().equalsIgnoreCase("factions")) {
                //Options
                ItemStack elves = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1);
                ItemStack men = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
                ItemStack evilmen = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
                ItemStack dwarves = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
                ItemStack creatures = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
                ItemStack orcs = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);


                ItemMeta creaturesmeta = creatures.getItemMeta();
                creaturesmeta.setDisplayName(ChatColor.DARK_GREEN + "Creatures");
                ArrayList<String> creatureslore = new ArrayList<>();
                creatureslore.add(ChatColor.DARK_GREEN + "The Creatures of Middle-Earth.");
                creaturesmeta.setLore(creatureslore);
                creatures.setItemMeta(creaturesmeta);


                ItemMeta elvesmeta = elves.getItemMeta();
                elvesmeta.setDisplayName(ChatColor.AQUA + "Elves");
                ArrayList<String> elveslore = new ArrayList<>();
                elveslore.add(ChatColor.AQUA + "The Fair Elves of Middle-Earth.");
                elvesmeta.setLore(elveslore);
                elves.setItemMeta(elvesmeta);

                ItemMeta menmeta = men.getItemMeta();
                menmeta.setDisplayName(ChatColor.WHITE + "Men");
                ArrayList<String> menlore = new ArrayList<>();
                menlore.add(ChatColor.WHITE + "The Good Men of Middle-Earth.");
                menmeta.setLore(menlore);
                men.setItemMeta(menmeta);

                ItemMeta dwarvesmeta = dwarves.getItemMeta();
                dwarvesmeta.setDisplayName(ChatColor.DARK_AQUA + "Dwarves");
                ArrayList<String> dwarveslore = new ArrayList<>();
                dwarveslore.add(ChatColor.DARK_AQUA + "The Dwarves of Middle-Earth.");
                dwarvesmeta.setLore(dwarveslore);
                dwarves.setItemMeta(dwarvesmeta);

                ItemMeta evilmenmeta = evilmen.getItemMeta();
                evilmenmeta.setDisplayName(ChatColor.RED + "Evil-Men");
                ArrayList<String> evilmenlore = new ArrayList<>();
                evilmenlore.add(ChatColor.RED + "The Evil Men of Middle-Earth.");
                evilmenmeta.setLore(evilmenlore);
                evilmen.setItemMeta(evilmenmeta);

                ItemMeta orcsmeta = orcs.getItemMeta();
                orcsmeta.setDisplayName(ChatColor.DARK_GRAY + "Orcs");
                ArrayList<String> orcslore = new ArrayList<>();
                orcslore.add(ChatColor.RED + "The foul creations of Morgoth.");
                orcsmeta.setLore(orcslore);
                orcs.setItemMeta(orcsmeta);




                ItemStack[] menu_items = {elves, men, evilmen, dwarves, creatures, orcs};
                gui.setContents(menu_items);
                player.openInventory(gui);
                //
            }
            else if (cmd.getName().equalsIgnoreCase("dwarvesafter")) {
                //Options
                ItemStack bluedwarves = new ItemStack(Material.LIGHT_BLUE_BANNER, 1);
                ItemStack dwarves = new ItemStack(Material.BLUE_BANNER, 1);
                ItemStack back = new ItemStack(Material.IRON_DOOR, 1);
                ItemStack glass1 = new ItemStack(Material.BLUE_STAINED_GLASS_PANE,1);
                ItemStack glass2 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE,1);
                ItemStack glass3 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);

                ItemMeta dwarvesmeta = dwarves.getItemMeta();
                dwarvesmeta.setDisplayName(ChatColor.DARK_AQUA + "Durin's Folk");
                ArrayList<String> dwarveslore = new ArrayList<>();
                dwarveslore.add(ChatColor.GRAY + "The Dwarves of Durin's Folk.");
                dwarvesmeta.setLore(dwarveslore);
                dwarves.setItemMeta(dwarvesmeta);

                ItemMeta backmeta = back.getItemMeta();
                backmeta.setDisplayName(ChatColor.DARK_PURPLE + "Back");
                back.setItemMeta(backmeta);

                ItemMeta bluedwarvesmeta = bluedwarves.getItemMeta();
                bluedwarvesmeta.setDisplayName(ChatColor.AQUA + "Blue-Dwarves");
                ArrayList<String> bluedwarveslore = new ArrayList<>();
                bluedwarveslore.add(ChatColor.GRAY + "The Dwarves of Ered Luin");
                bluedwarvesmeta.setLore(bluedwarveslore);
                bluedwarves.setItemMeta(bluedwarvesmeta);





                ItemStack[] menu_items = {glass1,glass2,glass3,glass1,glass3,glass2,glass1, glass3,glass2,glass1,glass3,glass2,dwarves,
                        glass1,bluedwarves,glass3,glass1,glass3,glass2,glass1,glass3,glass2,glass1,glass2,glass3,glass1,back};
                dwarvesafter.setContents(menu_items);

                player.openInventory(dwarvesafter);


            }
            else if (cmd.getName().equalsIgnoreCase("orcsafter")) {
                //Options
                ItemStack mordor = new ItemStack(Material.valueOf("LOTR_MORDOR_HELMET"), 1);
                ItemStack dolguldur = new ItemStack(Material.PURPLE_BANNER, 1);
                ItemStack gundabad = new ItemStack(Material.BROWN_BANNER, 1);
                ItemStack isengard = new ItemStack(Material.valueOf("LOTR_URUK_BERSERKER_HELMET"), 1);
                ItemStack angmar = new ItemStack(Material.GRAY_BANNER, 1);
                ItemStack back = new ItemStack(Material.IRON_DOOR, 1);
                ItemStack glass1 = new ItemStack(Material.GRAY_STAINED_GLASS_PANE,1);
                ItemStack glass2 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
                ItemStack glass3 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);

                ItemMeta mordormeta = mordor.getItemMeta();
                mordormeta.setDisplayName(ChatColor.DARK_GRAY + "Mordor");
                ArrayList<String> mordorlore = new ArrayList<>();
                mordorlore.add(ChatColor.GRAY + "The Orcs of Mordor");
                mordormeta.setLore(mordorlore);
                mordor.setItemMeta(mordormeta);

                ItemMeta backmeta = back.getItemMeta();
                backmeta.setDisplayName(ChatColor.DARK_PURPLE + "Back");
                back.setItemMeta(backmeta);

                ItemMeta dolguldurmeta = dolguldur.getItemMeta();
                dolguldurmeta.setDisplayName(ChatColor.DARK_PURPLE + "Dol-Guldur");
                ArrayList<String> dolguldurlore = new ArrayList<>();
                dolguldurlore.add(ChatColor.GRAY + "The Orcs of Dol Guldur");
                dolguldurmeta.setLore(dolguldurlore);
                dolguldur.setItemMeta(dolguldurmeta);

                ItemMeta gundabadmeta = gundabad.getItemMeta();
                gundabadmeta.setDisplayName(ChatColor.GOLD + "Gundabad");
                ArrayList<String> gundabadlore = new ArrayList<>();
                gundabadlore.add(ChatColor.GRAY + "The Orcs of Gundabad");
                gundabadmeta.setLore(gundabadlore);
                gundabad.setItemMeta(gundabadmeta);

                ItemMeta isengardmeta = isengard.getItemMeta();
                isengardmeta.setDisplayName(ChatColor.WHITE + "Isen" + ChatColor.DARK_GRAY + "gard");
                ArrayList<String> isengardlore = new ArrayList<>();
                isengardlore.add(ChatColor.GRAY + "The Uruk-Hai of Isengard, commanded by Saruman");
                isengardmeta.setLore(isengardlore);
                isengard.setItemMeta(isengardmeta);

                ItemMeta angmarmeta = angmar.getItemMeta();
                angmarmeta.setDisplayName(ChatColor.GRAY + "Angmar");
                ArrayList<String> angmarlore = new ArrayList<>();
                angmarlore.add(ChatColor.GRAY + "The Orcs of Angmar, commanded by the Witch-King");
                angmarmeta.setLore(angmarlore);
                angmar.setItemMeta(angmarmeta);





                ItemStack[] menu_items = {glass1,glass2,glass3,glass1,glass3,glass2,glass1, glass3,glass2,glass1,isengard,glass2,mordor,
                        glass1,dolguldur,glass3,gundabad,glass3,angmar,glass1,glass3,glass2,glass1,glass2,glass3,glass1,back};
                orcsafter.setContents(menu_items);

                player.openInventory(orcsafter);


            }
            else if (cmd.getName().equalsIgnoreCase("menafter")) {
                //Options
                ItemStack rohan = new ItemStack(Material.BROWN_BANNER, 1);
                ItemStack gondor = new ItemStack(Material.WHITE_BANNER, 1);
                ItemStack rangers = new ItemStack(Material.GRAY_BANNER, 1);
                ItemStack taurethrim = new ItemStack(Material.GREEN_BANNER, 1);
                ItemStack lossoth = new ItemStack(Material.SNOW_BLOCK, 1);
                ItemStack back = new ItemStack(Material.IRON_DOOR, 1);
                ItemStack hobbits = new ItemStack(Material.BLUE_BANNER, 1);

                ItemStack glass1 = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE,1);
                ItemStack glass2 = new ItemStack(Material.BROWN_STAINED_GLASS_PANE,1);
                ItemStack glass3 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);

                ItemMeta rohanmeta = rohan.getItemMeta();
                rohanmeta.setDisplayName(ChatColor.GOLD + "Rohan");
                ArrayList<String> rohanlore = new ArrayList<>();
                rohanlore.add(ChatColor.GRAY + "The Rohirrim of Rohan");
                rohanmeta.setLore(rohanlore);
                rohan.setItemMeta(rohanmeta);

                ItemMeta backmeta = back.getItemMeta();
                backmeta.setDisplayName(ChatColor.DARK_PURPLE + "Back");
                back.setItemMeta(backmeta);

                ItemMeta gondormeta = gondor.getItemMeta();
                gondormeta.setDisplayName(ChatColor.WHITE + "Gondor");
                ArrayList<String> gondorlore = new ArrayList<>();
                gondorlore.add(ChatColor.GRAY + "The Men of Gondor");
                gondormeta.setLore(gondorlore);
                gondor.setItemMeta(gondormeta);

                ItemMeta rangersmeta = rangers.getItemMeta();
                rangersmeta.setDisplayName(ChatColor.GREEN + "Rangers");
                ArrayList<String> rangerlore = new ArrayList<>();
                rangerlore.add(ChatColor.GRAY + "The Remnants of the Dunedain of Arnor.");
                rangersmeta.setLore(rangerlore);
                rangers.setItemMeta(rangersmeta);

                ItemMeta taurmeta = taurethrim.getItemMeta();
                taurmeta.setDisplayName(ChatColor.DARK_GREEN + "Taurethrim");
                ArrayList<String> taurlore = new ArrayList<>();
                taurlore.add(ChatColor.GRAY + "The Jungle-Men of Far-Harad");
                taurmeta.setLore(taurlore);
                taurethrim.setItemMeta(taurmeta);

                ItemMeta hobbitmeta = hobbits.getItemMeta();
                hobbitmeta.setDisplayName(ChatColor.GREEN + "Hobbits");
                ArrayList<String> hobbitlore = new ArrayList<>();
                hobbitlore.add(ChatColor.GRAY + "The Small Folk of the Shire.");
                hobbitmeta.setLore(hobbitlore);
                hobbits.setItemMeta(hobbitmeta);

                ItemMeta lossothmeta = lossoth.getItemMeta();
                lossothmeta.setDisplayName(ChatColor.WHITE + "Lossoth");
                ArrayList<String> lossothlore = new ArrayList<>();
                lossothlore.add(ChatColor.WHITE + "The Snow Men of Forochel");
                lossothmeta.setLore(lossothlore);
                lossoth.setItemMeta(lossothmeta);









                ItemStack[] menu_items = {glass1,glass2,glass3,glass1,glass3,glass2,glass1, glass3,glass2,glass1,rohan,glass2,gondor,
                        glass1,rangers,glass3,taurethrim,glass3,hobbits,glass1,lossoth,glass2,glass1,glass2,glass3,glass1,back};
                menafter.setContents(menu_items);

                player.openInventory(menafter);


            }
            else if (cmd.getName().equalsIgnoreCase("elvesafter")) {
                //Options
                ItemStack lindon = new ItemStack(Material.BLUE_BANNER, 1);
                ItemStack rivendell = new ItemStack(Material.LIGHT_BLUE_BANNER, 1);
                ItemStack lothlorien = new ItemStack(Material.YELLOW_BANNER, 1);
                ItemStack dorwinion = new ItemStack(Material.PURPLE_BANNER, 1);
                ItemStack woodelves = new ItemStack(Material.GREEN_BANNER, 1);
                ItemStack back = new ItemStack(Material.IRON_DOOR, 1);
                ItemStack glass1 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE,1);
                ItemStack glass2 = new ItemStack(Material.BLUE_STAINED_GLASS_PANE,1);
                ItemStack glass3 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);

                ItemMeta lindonmeta = lindon.getItemMeta();
                lindonmeta.setDisplayName(ChatColor.AQUA + "Lindon");
                ArrayList<String> lindonlore = new ArrayList<>();
                lindonlore.add(ChatColor.GRAY + "The Fair Elves of Lindon");
                lindonmeta.setLore(lindonlore);
                lindon.setItemMeta(lindonmeta);

                ItemMeta backmeta = back.getItemMeta();
                backmeta.setDisplayName(ChatColor.DARK_PURPLE + "Back");
                back.setItemMeta(backmeta);

                ItemMeta rivendellmeta = rivendell.getItemMeta();
                rivendellmeta.setDisplayName(ChatColor.AQUA + "Rivendell");
                ArrayList<String> rivendelllore = new ArrayList<>();
                rivendelllore.add(ChatColor.GRAY + "The Fair Elves of Rivendell");
                rivendellmeta.setLore(rivendelllore);
                rivendell.setItemMeta(rivendellmeta);

                ItemMeta lothlorienmeta = lothlorien.getItemMeta();
                lothlorienmeta.setDisplayName(ChatColor.YELLOW + "Lothlórien");
                ArrayList<String> lothlorienlore = new ArrayList<>();
                lothlorienlore.add(ChatColor.GRAY + "The Elves of Lothlórien");
                lothlorienmeta.setLore(lothlorienlore);
                lothlorien.setItemMeta(lothlorienmeta);

                ItemMeta dorwinionmeta = dorwinion.getItemMeta();
                dorwinionmeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Dorwinion");
                ArrayList<String> dorwinionlore = new ArrayList<>();
                dorwinionlore.add(ChatColor.GRAY + "The Elves & Men of Dorwinion.");
                dorwinionmeta.setLore(dorwinionlore);
                dorwinion.setItemMeta(dorwinionmeta);

                ItemMeta woodelvesmeta = woodelves.getItemMeta();
                woodelvesmeta.setDisplayName(ChatColor.DARK_GREEN + "Wood-Elves");
                ArrayList<String> woodelveslore = new ArrayList<>();
                woodelveslore.add(ChatColor.GRAY + "The Silvan Elves of Mirkwood & Woodland-Realm");
                woodelvesmeta.setLore(woodelveslore);
                woodelves.setItemMeta(woodelvesmeta);





                ItemStack[] menu_items = {glass1,glass2,glass3,glass1,glass3,glass2,glass1, glass3,glass2,glass1,lindon,glass2,rivendell,
                        glass1,lothlorien,glass3,dorwinion,glass3,woodelves,glass1,glass3,glass2,glass1,glass2,glass3,glass1,back};
                elvesafter.setContents(menu_items);

                player.openInventory(elvesafter);


            }
            else if (cmd.getName().equalsIgnoreCase("evilmenafter")) {
                //Options
                ItemStack umbar = new ItemStack(Material.BLACK_BANNER, 1);
                ItemStack gulfing = new ItemStack(Material.RED_BANNER, 1);
                ItemStack morwaith = new ItemStack(Material.YELLOW_BANNER, 1);
                ItemStack khand = new ItemStack(Material.GRAY_BANNER, 1);
                ItemStack back = new ItemStack(Material.IRON_DOOR, 1);

                ItemStack glass1 = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE,1);
                ItemStack glass2 = new ItemStack(Material.BROWN_STAINED_GLASS_PANE,1);
                ItemStack glass3 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);

                ItemMeta umbarmeta = umbar.getItemMeta();
                umbarmeta.setDisplayName(ChatColor.GOLD + "Um" + ChatColor.DARK_GRAY + "bar");
                ArrayList<String> umbarlore = new ArrayList<>();
                umbarlore.add(ChatColor.GRAY + "The Coastal-Men of Umbar");
                umbarmeta.setLore(umbarlore);
                umbar.setItemMeta(umbarmeta);

                ItemMeta backmeta = back.getItemMeta();
                backmeta.setDisplayName(ChatColor.DARK_PURPLE + "Back");
                back.setItemMeta(backmeta);

                ItemMeta gulfingmeta = gulfing.getItemMeta();
                gulfingmeta.setDisplayName(ChatColor.RED + "Gulfings");
                ArrayList<String> gulfinglore = new ArrayList<>();
                gulfinglore.add(ChatColor.GRAY + "The Men of the Gulf of Harad");
                gulfingmeta.setLore(gulfinglore);
                gulfing.setItemMeta(gulfingmeta);

                ItemMeta morwaithmeta = morwaith.getItemMeta();
                morwaithmeta.setDisplayName(ChatColor.YELLOW + "Morwaith");
                ArrayList<String> morwaithlore = new ArrayList<>();
                morwaithlore.add(ChatColor.GRAY + "The Men of the Far Harad Grasslands");
                morwaithmeta.setLore(morwaithlore);
                morwaith.setItemMeta(morwaithmeta);


                ItemMeta khandmeta = khand.getItemMeta();
                khandmeta.setDisplayName(ChatColor.YELLOW + "Khand");
                ArrayList<String> khandlore = new ArrayList<>();
                khandlore.add(ChatColor.GRAY + "The Men of Khand");
                khandmeta.setLore(khandlore);
                khand.setItemMeta(khandmeta);









                ItemStack[] menu_items = {glass1,glass2,glass3,glass1,glass3,glass2,glass1, glass3,glass2,glass1,umbar,glass2,gulfing,
                        glass1,morwaith,glass3,khand,glass3,glass1,glass1,glass3,glass2,glass1,glass2,glass3,glass1,back};
                evilmenafter.setContents(menu_items);

                player.openInventory(evilmenafter);


            }
            else if (cmd.getName().equalsIgnoreCase("creaturesafter")) {
                //Options
                ItemStack fangorn = new ItemStack(Material.GREEN_BANNER, 1);
                ItemStack halftroll = new ItemStack(Material.GRAY_BANNER, 1);
                ItemStack back = new ItemStack(Material.IRON_DOOR, 1);
                ItemStack glass1 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE,1);
                ItemStack glass2 = new ItemStack(Material.GRAY_STAINED_GLASS_PANE,1);
                ItemStack glass3 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);

                ItemMeta halftrollmeta = halftroll.getItemMeta();
                halftrollmeta.setDisplayName(ChatColor.DARK_RED + "Half-Troll");
                ArrayList<String> halftrolllore = new ArrayList<>();
                halftrolllore.add(ChatColor.GRAY + "The Half-Trolls of Pertorogowaith.");
                halftrollmeta.setLore(halftrolllore);
                halftroll.setItemMeta(halftrollmeta);

                ItemMeta backmeta = back.getItemMeta();
                backmeta.setDisplayName(ChatColor.DARK_PURPLE + "Back");
                back.setItemMeta(backmeta);

                ItemMeta fangornmeta = fangorn.getItemMeta();
                fangornmeta.setDisplayName(ChatColor.DARK_GREEN + "Fangorn");
                ArrayList<String> fangornlore = new ArrayList<>();
                fangornlore.add(ChatColor.GRAY + "The Trees of Fangorn");
                fangornmeta.setLore(fangornlore);
                fangorn.setItemMeta(fangornmeta);





                ItemStack[] menu_items = {glass1,glass2,glass3,glass1,glass3,glass2,glass1, glass3,glass2,glass1,glass3,glass2,fangorn,
                        glass1,halftroll,glass3,glass1,glass3,glass2,glass1,glass3,glass2,glass1,glass2,glass3,glass1,back};
                creaturesafter.setContents(menu_items);

                player.openInventory(creaturesafter);


            }

            return false;
        } else {
            sender.sendMessage("Goodluck running the command without perms!!");
            return true;
        }
    }
}