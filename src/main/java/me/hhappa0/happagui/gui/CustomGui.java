package me.hhappa0.happagui.gui;

import me.hhappa0.happagui.Main;
import me.hhappa0.happagui.data.PlayerDataManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class CustomGui {
    private int rows;
    private Inventory inventory;
    private List<GuiButton> buttons = new ArrayList<>();

    public CustomGui(String title, int rows) {
        if (rows > 6) {
            Main.getInstance().getLogger().severe("The maximum row count is 6!");
            return;
        }

        this.rows = rows;
        this.inventory = Bukkit.createInventory(null, rows * 9, title);
    }

    public void setItem(GuiButton button, int slot) {
        buttons.add(button);
        inventory.setItem(slot, button.getStack());
    }

    public void handleButton(ItemStack stack) {
        GuiButton button = buttons.stream().filter(p -> p.getStack().isSimilar(stack)).findAny().orElse(null);

        if (button != null) {
            button.getAction().run();
        }
    }

    public void show(Player player) {
        PlayerDataManager.getData(player).setOpenGui(this);
        player.openInventory(inventory);
    }
}
