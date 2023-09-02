# HappaGUI
HappaGUI is an API based plugin to easily make GUIs in your Minecraft plugin.

## Download
Download the plugin <a href="https://github.com/hhappa0/HappaGUI/releases/download/v1.0/HappaGUI.jar">here</a>.

## How to use HappaGUI
First, you have to add the jar to the project.
Then, you have to make the plugin.yml looks like this:
```yml
name: Your plugin name
version: Your plugin version
main: Your path to the main
api-version: 1.20
depend:
  - HappaGUI
```
Now you are ready to get started with HappaGUI

## Example project
### Main.java:
```java
package com.example.plugin;

import org.bukkit.plugin.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.hhappa0.happagui.gui.CustomGui;
import me.hhappa0.happagui.gui.GuiButton;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("test").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName() == "test") {
            Player player = (Player) sender;
            CutomGui testGui = new CustomGui("Test", 1);
            ItemStack closeItem = new ItemStack(Material.BARRIER);
            ItemMeta closeMeta = closeItem.getItemMeta();
            closeMeta.setDisplayName("§cClose!");
            closeItem.setItemMeta(closeMeta);

            GuiButton closeButton = new GuiButton(closeItem);
            closeButton.setAction(() -> {
                player.closeInventory();
            });

            testGui.setItem(closeButton, 4);
            testGui.show(player);
        }
    }
}
```
### plugin.yml
```yml
name: ExamplePlugin
version: 1.0
main: com.example.plugin.Main
api-version: 1.20
depend:
  - HappaGUI
commands:
  test:
```

**If you need further help, go to my discord:**
  *https://discord.gg/M47366cR3k*
