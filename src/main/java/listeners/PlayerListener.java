package listeners;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerSpawnChangeEvent;

public class PlayerListener implements Listener {

    private Location playerCoords;

    //Change Spawn Location event

    @EventHandler
    public void dead(PlayerSpawnChangeEvent event) {

        Player player = event.getPlayer();
        playerCoords = player.getLocation();

    }

    //Tp player when he/she is dead

    @EventHandler
    public void dead(PlayerDeathEvent event) {

        Player player = event.getEntity();
        player.teleport(playerCoords);


    }

}
