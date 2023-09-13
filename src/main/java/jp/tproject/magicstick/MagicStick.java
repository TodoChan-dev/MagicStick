package jp.tproject.magicstick;

import jp.tproject.magicstick.Commands.Setting;
import jp.tproject.magicstick.Listeners.BanStick;
import jp.tproject.magicstick.Listeners.KillStick;
import jp.tproject.magicstick.Listeners.SkyStick;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class MagicStick extends JavaPlugin  {
    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new BanStick(), this);
        getServer().getPluginManager().registerEvents(new KillStick(), this);
        getServer().getPluginManager().registerEvents(new SkyStick(), this);

        getServer().getPluginCommand("stick").setExecutor(new Setting());

    }

    @Override
    public void onDisable() {
    }




}
