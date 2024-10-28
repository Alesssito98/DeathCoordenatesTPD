package main;

import commands.Help;
import config.MainConfigManager;
import listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathCoordinatesTPD extends JavaPlugin {

    public static final String prefix = "DeathCoordinatesTPD";
    private final String version = getDescription().getVersion();
    private MainConfigManager mainConfigManager;

    //Enable/Disable voids

    public void onEnable() {

        try {

            registerCommands();
            Bukkit.getConsoleSender().sendMessage("&aCommands set successfully");

        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("&cSomething goes wrong :(");
            e.printStackTrace();
        }

        try {

            registerEvents();
            Bukkit.getConsoleSender().sendMessage("&Events set successfully");

        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("&cSomething goes wrong :(");
            e.printStackTrace();
        }

        try {

            mainConfigManager = new MainConfigManager(this);

        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("&cSomething goes wrong :(");
            e.printStackTrace();
        }

        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + " is ready enable on " + version + " version"));

    }

    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&ais disable"));

    }

    //Commands

    public void registerCommands() throws Exception {

        try {

            this.getCommand("deathcoordinatesalex").setExecutor(new Help(this));

        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("&cSomething goes wrong :(");
            e.printStackTrace();
        }

    }

    //Events

    public void registerEvents() throws Exception {

        try {

            getServer().getPluginManager().registerEvents(new PlayerListener(), this);

        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("&cSomething goes wrong :(");
            e.printStackTrace();
        }

    }

    //Getters

    public MainConfigManager getMainConfigManager() {
        return mainConfigManager;
    }
}
