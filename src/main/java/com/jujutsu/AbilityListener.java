package com.jujutsu;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.Particle;
import org.bukkit.Sound;

public class AbilityListener implements Listener {
    
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player player = (Player) e.getDamager();
            
            if (player.getInventory().getItemInMainHand().hasItemMeta()) {
                String name = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
                
                if (name.contains("Infinity")) {
                    e.getEntity().getWorld().spawnParticle(Particle.END_ROD, 
                        e.getEntity().getLocation(), 30, 0.5, 0.5, 0.5, 0.1);
                    player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0f, 2.0f);
                    e.setDamage(e.getDamage() * 1.5);
                }
                
                if (name.contains("Cleave")) {
                    e.getEntity().getWorld().spawnParticle(Particle.SWEEP_ATTACK, 
                        e.getEntity().getLocation(), 20, 0.5, 0.5, 0.5, 0.1);
                    e.getEntity().getWorld().spawnParticle(Particle.DAMAGE_INDICATOR, 
                        e.getEntity().getLocation(), 15, 0.5, 0.5, 0.5, 0.1);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0f, 0.5f);
                    e.setDamage(e.getDamage() * 2.0);
                }
            }
        }
    }
}
