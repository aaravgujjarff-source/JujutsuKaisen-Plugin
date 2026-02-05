package com.jujutsu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;

import java.util.Arrays;

public class DomainCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cOnly players can use this command!");
            return true;
        }
        
        Player player = (Player) sender;
        openDomainMenu(player);
        return true;
    }
    
    private void openDomainMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, "§5§lDomain Expansions");
        
        ItemStack gojo = new ItemStack(Material.END_CRYSTAL);
        ItemMeta gojoMeta = gojo.getItemMeta();
        gojoMeta.setDisplayName("§b§lUnlimited Void");
        gojoMeta.setLore(Arrays.asList(
            "§7Gojo Satoru's Domain",
            "§7Overwhelms enemies with infinite information",
            "§e§lClick to activate!"
        ));
        gojoMeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
        gojoMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        gojo.setItemMeta(gojoMeta);
        
        ItemStack sukuna = new ItemStack(Material.WITHER_SKELETON_SKULL);
        ItemMeta sukunaMeta = sukuna.getItemMeta();
        sukunaMeta.setDisplayName("§c§lMalevolent Shrine");
        sukunaMeta.setLore(Arrays.asList(
            "§7Ryomen Sukuna's Domain",
            "§7Slashes everything in range",
            "§e§lClick to activate!"
        ));
        sukunaMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
        sukunaMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        sukuna.setItemMeta(sukunaMeta);
        
        ItemStack mahito = new ItemStack(Material.SOUL_SAND);
        ItemMeta mahitoMeta = mahito.getItemMeta();
        mahitoMeta.setDisplayName("§8§lSelf-Embodiment of Perfection");
        mahitoMeta.setLore(Arrays.asList(
            "§7Mahito's Domain",
            "§7Manipulates souls",
            "§e§lClick to activate!"
        ));
        mahitoMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        mahitoMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        mahito.setItemMeta(mahitoMeta);
        
        ItemStack jogo = new ItemStack(Material.MAGMA_BLOCK);
        ItemMeta jogoMeta = jogo.getItemMeta();
        jogoMeta.setDisplayName("§6§lCoffin of the Iron Mountain");
        jogoMeta.setLore(Arrays.asList(
            "§7Jogo's Domain",
            "§7Burns everything with volcanic power",
            "§e§lClick to activate!"
        ));
        jogoMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
        jogoMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        jogo.setItemMeta(jogoMeta);
        
        inv.setItem(11, gojo);
        inv.setItem(13, sukuna);
        inv.setItem(15, mahito);
        inv.setItem(22, jogo);
        
        player.openInventory(inv);
    }
}
