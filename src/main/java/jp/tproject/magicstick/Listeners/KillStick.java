package jp.tproject.magicstick.Listeners;

import jp.tproject.magicstick.Commands.Setting;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class KillStick implements Listener {


    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (p.isOp() && p.getName().equalsIgnoreCase("roadhog_kun") && p.getInventory().getItemInMainHand().getType() == Material.STICK && Setting.kill) {
            Location loc = e.getPlayer().getEyeLocation();
            Vector baseVec = loc.getDirection();

            for (int i = 0; i < 100; i++) {
                Vector vec = baseVec.clone().multiply(i).add(loc.toVector());
                World world = loc.getWorld();

                if (world != null) {
                    world.spawnParticle(Particle.COMPOSTER, vec.getX(), vec.getY(), vec.getZ(), 5);
                    world.spawnParticle(Particle.REDSTONE, vec.getX(), vec.getY(), vec.getZ(), 2, new Particle.DustOptions(Color.fromRGB(42, 232, 45), 1));

                    for (Entity entity : world.getNearbyEntities(vec.toLocation(world), 0.5, 0.5, 0.5)) {
                        if (entity.getUniqueId() != e.getPlayer().getUniqueId() && entity instanceof Player) {
                            ((Player) entity).setHealth(0);
                            p.sendMessage("§8[§cMS§8]§e " + entity.getName() + "§r を§c粛清§rしました。");
                            return;  // 一人でもBANしたらループを抜ける
                        }
                    }
                }
            }
        }


    }
}
