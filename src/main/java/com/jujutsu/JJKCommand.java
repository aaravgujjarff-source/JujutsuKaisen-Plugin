package com.jujutsu;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Arrays;

public class JJKCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("jjk.admin")) {
            sender.sendMessage("§cYou don't have permission!");
            return true;
        }
        
        if (args.length == 0) {
            sender.sendMessage("§c/jjk <give|reload>");
            return true;
        }
        
        if (args[0].equalsIgnoreCase("give")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cOnly players can use this!");
                return true;
            }
            
            Player player = (Player) sender;
            giveCursedTools(player);
            player.sendMessage("§aYou received cursed tools!");
            return true;
        }
        
        if (args[0].equalsIgnoreCase("reload")) {
            // Config reload
            Main.getInstance().reloadConfig();
            sender.sendMessage("§aPlugin configuration reloaded!");
            return true;
        }
        
        return true;
    }
    
    private void giveCursedTools(Player player) {
        // Gojo's Infinity
        ItemStack infinity = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta infinityMeta = infinity.getItemMeta();
        infinityMeta.setDisplayName("§b§lInfinity");
        infinityMeta.setLore(Arrays.asList("§7Gojo's Limitless", "§7Repels all attacks"));
        infinityMeta.addEnchant(Enchantment.SHARPNESS, 10, true);
        infinityMeta.addEnchant(Enchantment.KNOCKBACK, 5, true);
        infinityMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        infinity.setItemMeta(infinityMeta);
        
        // Sukuna's Cleave
        ItemStack cleave = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta cleaveMeta = cleave.getItemMeta();
        cleaveMeta.setDisplayName("§c§lCleave");
        cleaveMeta.setLore(Arrays.asList("§7Sukuna's Slashing Technique", "§7Adapts to cursed energy"));
        cleaveMeta.addEnchant(Enchantment.SHARPNESS, 15, true);
        cleaveMeta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
        cleaveMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        cleave.setItemMeta(cleaveMeta);
        
        player.getInventory().addItem(infinity);
        player.getInventory().addItem(cleave);
    }
}
