package config;

import org.bukkit.configuration.file.FileConfiguration;
import main.DeathCoordinatesTPD;

public class MainConfigManager {

    private CustomConfig configFile;
    private DeathCoordinatesTPD plugin;
    private String tpMessage;
    private boolean enableMessage;

    public MainConfigManager(DeathCoordinatesTPD plugin) {
        this.plugin = plugin;
        configFile = new CustomConfig("config.yml", null, this.plugin);
        configFile.registerConfig();
        loadConfig();
    }

    //Load config

    public void loadConfig() {

        FileConfiguration config = configFile.getConfig();
        tpMessage = config.getString("config.message.tpMessage");
        enableMessage = config.getBoolean("config.message.enable");

    }

    //Reload config

    public void reloadConfig() {
        configFile.reloadConfig();
        loadConfig();
    }

    //Getters

    public String getTpMessage() {
        return tpMessage;
    }

    public boolean isEnableMessage() {
        return enableMessage;
    }
}
