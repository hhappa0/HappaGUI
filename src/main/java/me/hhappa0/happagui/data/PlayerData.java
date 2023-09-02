package me.hhappa0.happagui.data;

import me.hhappa0.happagui.gui.CustomGui;
import org.bukkit.entity.Player;

public class PlayerData {
    private Player player;
    private CustomGui openGui;

    public PlayerData(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public CustomGui getOpenGui() {
        return openGui;
    }

    public void setOpenGui(CustomGui openGui) {
        this.openGui = openGui;
    }
}
