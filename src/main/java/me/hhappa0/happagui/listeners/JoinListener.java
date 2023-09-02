package me.hhappa0.happagui.listeners;

import me.hhappa0.happagui.data.PlayerDataManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        PlayerDataManager.setData(event.getPlayer());
    }
}
