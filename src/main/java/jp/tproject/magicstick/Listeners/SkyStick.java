package jp.tproject.magicstick.Listeners;

import jp.tproject.magicstick.Commands.Setting;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class SkyStick implements Listener {


    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (p.isOp() && p.getName().equalsIgnoreCase("roadhog_kun") && p.getInventory().getItemInMainHand().getType() == Material.STICK && Setting.sky) {
            Location loc = e.getPlayer().getEyeLocation();
            Vector baseVec = loc.getDirection();

            for (int i = 0; i < 100; i++) {
                Vector vec = baseVec.clone().multiply(i).add(loc.toVector());
                World world = loc.getWorld();

                if (world != null) {
                    world.spawnParticle(Particle.REDSTONE, vec.getX(), vec.getY(), vec.getZ(), 2, new Particle.DustOptions(Color.fromRGB(42, 162, 232), 1));

                    for (Entity entity : world.getNearbyEntities(vec.toLocation(world), 0.5, 0.5, 0.5)) {
                        if (entity.getUniqueId() != e.getPlayer().getUniqueId() && entity instanceof Player) {

                            entity.teleport(entity.getLocation().add(entity.getLocation().getX(), 100000.0, entity.getLocation().getZ()));
                            p.sendMessage("§8[§cMS§8]§e " + entity.getName() + "§r を上空§c100000m§rに転送しました。");
                            return;  // 一人でもBANしたらループを抜ける
                        }
                    }
                }
            }
        }


    }
}
