package com.jujutsu;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class DomainListener implements Listener {
    
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("§5§lDomain Expansions")) {
            e.setCancelled(true);
            
            if (e.getCurrentItem() == null) return;
            
            Player player = (Player) e.getWhoClicked();
            String displayName = e.getCurrentItem().getItemMeta().getDisplayName();
            
            player.closeInventory();
            
            if (displayName.contains("Unlimited Void")) {
                activateUnlimitedVoid(player);
            } else if (displayName.contains("Malevolent Shrine")) {
                activateMalevolentShrine(player);
            } else if (displayName.contains("Self-Embodiment")) {
                activateMahitoDomain(player);
            } else if (displayName.contains("Coffin of the Iron Mountain")) {
                activateJogoDomain(player);
            }
        }
    }
    
    private void activateUnlimitedVoid(Player player) {
        player.sendMessage("§b§lDOMAIN EXPANSION: UNLIMITED VOID!");
        player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 2.0f, 0.5f);
        
        Location center = player.getLocation();
        int radius = 15;
        
        new BukkitRunnable() {
            int ticks = 0;
            
            @Override
            public void run() {
                if (ticks >= 200) {
                    cancel();
                    return;
                }
                
                for (double i = 0; i < Math.PI * 2; i += 0.1) {
                    for (double j = 0; j < Math.PI; j += 0.1) {
                        double x = radius * Math.sin(j) * Math.cos(i);
                        double y = radius * Math.sin(j) * Math.sin(i);
                        double z = radius * Math.cos(j);
                        
                        Location particleLoc = center.clone().add(x, y, z);
                        center.getWorld().spawnParticle(Particle.END_ROD, particleLoc, 1, 0, 0, 0, 0);
                    }
                }
                
                for (Entity entity : center.getWorld().getNearbyEntities(center, radius, radius, radius)) {
                    if (entity instanceof LivingEntity && entity != player) {
                        LivingEntity living = (LivingEntity) entity;
                        living.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 60, 10));
                        living.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1));
                        living.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 60, 1));
                        living.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 60, 5));
                    }
                }
                
                ticks++;
            }
        }.runTaskTimer(Main.getInstance(), 0, 1);
    }
    
    private void activateMalevolentShrine(Player player) {
        player.sendMessage("§c§lDOMAIN EXPANSION: MALEVOLENT SHRINE!");
        player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 2.0f, 0.5f);
        
        Location center = player.getLocation();
        int radius = 20;
        
        new BukkitRunnable() {
            int ticks = 0;
            
            @Override
            public void run() {
                if (ticks >= 200) {
                    cancel();
                    return;
                }
                
                for (double i = 0; i < Math.PI * 2; i += 0.05) {
                    double x = radius * Math.cos(i);
                    double z = radius * Math.sin(i);
                    Location particleLoc = center.clone().add(x, 0, z);
                    center.getWorld().spawnParticle(Particle.FLAME, particleLoc, 3, 0.5, 2, 0.5, 0.01);
                    center.getWorld().spawnParticle(Particle.CRIMSON_SPORE, particleLoc, 2);
                }
                
                if (ticks % 10 == 0) {
                    for (Entity entity : center.getWorld().getNearbyEntities(center, radius, radius, radius)) {
                        if (entity instanceof LivingEntity && entity != player) {
                            LivingEntity living = (LivingEntity) entity;
                            living.damage(4.0, player);
                            
                            for (int i = 0; i < 10; i++) {
                                living.getWorld().spawnParticle(Particle.SWEEP_ATTACK, 
                                    living.getLocation().add(0, 1, 0), 5, 0.5, 0.5, 0.5, 0.1);
                                living.getWorld().spawnParticle(Particle.DAMAGE_INDICATOR, 
                                    living.getLocation().add(0, 1, 0), 3, 0.3, 0.3, 0.3, 0.1);
                            }
                            
                            living.getWorld().playSound(living.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0f, 0.8f);
                        }
                    }
                }
                
                ticks++;
            }
        }.runTaskTimer(Main.getInstance(), 0, 1);
    }
    
    private void activateMahitoDomain(Player player) {
        player.sendMessage("§8§lDOMAIN EXPANSION: SELF-EMBODIMENT OF PERFECTION!");
        player.playSound(player.getLocation(), Sound.ENTITY_GHAST_SCREAM, 2.0f, 0.7f);
        
        Location center = player.getLocation();
        int radius = 12;
        
        new BukkitRunnable() {
            int ticks = 0;
            
            @Override
            public void run() {
                if (ticks >= 150) {
                    cancel();
                    return;
                }
                
                for (double i = 0; i < Math.PI * 2; i += 0.1) {
                    for (double j = 0; j < Math.PI; j += 0.1) {
                        double x = radius * Math.sin(j) * Math.cos(i);
                        double y = radius * Math.sin(j) * Math.sin(i);
                        double z = radius * Math.cos(j);
                        
                        Location particleLoc = center.clone().add(x, y, z);
                        center.getWorld().spawnParticle(Particle.SOUL, particleLoc, 1, 0, 0, 0, 0);
                    }
                }
                
                for (Entity entity : center.getWorld().getNearbyEntities(center, radius, radius, radius)) {
                    if (entity instanceof LivingEntity && entity != player) {
                        LivingEntity living = (LivingEntity) entity;
                        living.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 40, 2));
                        living.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 40, 3));
                        living.damage(2.0, player);
                    }
                }
                
                ticks++;
            }
        }.runTaskTimer(Main.getInstance(), 0, 1);
    }
    
    private void activateJogoDomain(Player player) {
        player.sendMessage("§6§lDOMAIN EXPANSION: COFFIN OF THE IRON MOUNTAIN!");
        player.playSound(player.getLocation(), Sound.ITEM_FIRECHARGE_USE, 2.0f, 0.5f);
        
        Location center = player.getLocation();
        int radius = 15;
        
        new BukkitRunnable() {
            int ticks = 0;
            
            @Override
            public void run() {
                if (ticks >= 180) {
                    cancel();
                    return;
                }
                
                for (double i = 0; i < Math.PI * 2; i += 0.08) {
                    for (double j = 0; j < Math.PI; j += 0.08) {
                        double x = radius * Math.sin(j) * Math.cos(i);
                        double y = radius * Math.sin(j) * Math.sin(i);
                        double z = radius * Math.cos(j);
                        
                        Location particleLoc = center.clone().add(x, y, z);
                        center.getWorld().spawnParticle(Particle.LAVA, particleLoc, 1);
                        center.getWorld().spawnParticle(Particle.FLAME, particleLoc, 1);
                    }
                }
                
                for (Entity entity : center.getWorld().getNearbyEntities(center, radius, radius, radius)) {
                    if (entity instanceof LivingEntity && entity != player) {
                        LivingEntity living = (LivingEntity) entity;
                        living.setFireTicks(100);
                        living.damage(3.0, player);
                        living.getWorld().spawnParticle(Particle.FLAME, living.getLocation(), 20, 0.5, 0.5, 0.5, 0.1);
                    }
                }
                
                ticks++;
            }
        }.runTaskTimer(Main.getInstance(), 0, 1);
    }
}
