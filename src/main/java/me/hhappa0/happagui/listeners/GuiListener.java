package me.hhappa0.happagui.listeners;

import me.hhappa0.happagui.data.PlayerData;
import me.hhappa0.happagui.data.PlayerDataManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class GuiListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        PlayerData data = PlayerDataManager.getData((Player) event.getWhoClicked());

        if (data != null && data.getOpenGui() != null) {
            if (event.getCurrentItem() != null) {
                data.getOpenGui().handleButton(event.getCurrentItem());
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        PlayerData data = PlayerDataManager.getData(event.getPlayer());

        if (data != null && data.getOpenGui() != null) {
            event.getItemDrop().getItemStack();
            data.getOpenGui().handleButton(event.getItemDrop().getItemStack());
            event.setCancelled(true);
        }
    }
}
