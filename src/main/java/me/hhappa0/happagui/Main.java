package me.hhappa0.happagui;

import me.hhappa0.happagui.listeners.GuiListener;
import me.hhappa0.happagui.listeners.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onLoad() {
        instance = this;
        getLogger().info("Plugin loaded.");
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new GuiListener(), this);

        getLogger().info("Plugin enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled.");
    }

    public static Main getInstance() {
        return instance;
    }
}
