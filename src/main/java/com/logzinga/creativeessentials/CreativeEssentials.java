package com.logzinga.creativeessentials;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.EventListener;

import static org.bukkit.GameMode.*;

public final class CreativeEssentials extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("survival")) { // these lines set the Player to survival
            if (sender instanceof Player) {
                Player p = (Player)  sender;
                p.setGameMode(SURVIVAL);
            }else if(sender instanceof ConsoleCommandSender) {
                System.out.println("The console cannot be in survival, you can try this in-game");
            }else if(sender instanceof BlockCommandSender) {
                System.out.println("You cannot change your game mode to survival via command block, try in chat");
            }
        }

        if (command.getName().equalsIgnoreCase("creative")) { // These lines set the Player to creative
            if(sender instanceof  Player) {
                Player p = (Player)  sender;
                p.setGameMode(CREATIVE);
            }else if(sender instanceof  ConsoleCommandSender) {
                System.out.println("The console cannot be in creative, you can try this in-game");
            }else if(sender instanceof BlockCommandSender) {
                System.out.println("You cannot change your game mode to creative via command block, try in chat");
            }
        }

        if(command.getName().equalsIgnoreCase("spawn")) { // sends player to the worlds spawn point
            if(sender instanceof  Player) {
                Player p = (Player)  sender;
                World w = p.getWorld();
                p.getLocation();
                Location destination = w.getSpawnLocation();
                p.teleport(destination);
            }
        }

        if(command.getName().equalsIgnoreCase("spectator")) { // SPECTATOR WOOOOO
            if(sender instanceof  Player) {
                Player p = (Player)  sender;
                p.setGameMode(SPECTATOR);
            }else if(sender instanceof  ConsoleCommandSender) {
                System.out.println("You cannot set your game mode to spectator, try in-game");
            }else if(sender instanceof  BlockCommandSender) {
                System.out.println("You cannot set your game mode to spectator, try the chat box");
            }
        }

        if(command.getName().equalsIgnoreCase("creativeessentialsabout")) {
            if(sender instanceof  Player) {
                Player p = (Player) sender;
                p.sendMessage("CreativeEssentials");
                p.sendMessage("Developed by OwOCraft (logzinga), for use in OwOCraft Servers.");
            }
        }
        return true;
        }
    }
