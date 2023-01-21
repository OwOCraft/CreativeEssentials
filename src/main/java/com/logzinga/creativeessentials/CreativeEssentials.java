package com.logzinga.creativeessentials;

import org.bukkit.block.Block;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.EventListener;

import static org.bukkit.GameMode.CREATIVE;
import static org.bukkit.GameMode.SURVIVAL;

public final class CreativeEssentials extends JavaPlugin implements Listener, EventListener {

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

        return true;
    }
}
