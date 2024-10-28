package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import main.DeathCoordinatesTPD;

public class Help implements CommandExecutor {

    private DeathCoordinatesTPD plugin;

    public Help(DeathCoordinatesTPD plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;

        if (!commandSender.isOp()) {
            if (strings.length != 1 || strings[0].toLowerCase().equals("help")) {
                help(commandSender);
            } else {

                switch (strings[0]) {

                    case "reload": reload(commandSender);
                        break;
                    default:    tpDeath(player, commandSender);

                }

            }
        }

        return false;
    }

    //Help message

    public void help(CommandSender commandSender) {

        commandSender.sendMessage(utils.UtilsMessages.coloredMessage(DeathCoordinatesTPD.prefix + "---- HELP ----" + "/n" +
                "&c/tpd help" + "/n" +
                "&c/tpd <player>" + "/n" +
                "&c/tpd reload"));

    }

    //Tp player to his/her last death location

    public void tpDeath(Player player, CommandSender commandSender) {

        player.teleport(player.getLastDeathLocation());

        if (plugin.getMainConfigManager().isEnableMessage()) {

            commandSender.sendMessage(utils.UtilsMessages.coloredMessage(plugin.getMainConfigManager().getTpMessage()));

        }

    }

    //Reload plugin config

    public void reload(CommandSender commandSender) {

        plugin.getMainConfigManager().reloadConfig();
        commandSender.sendMessage(utils.UtilsMessages.coloredMessage("Configuration has been reloaded"));

    }

}
