package me.RafaelAulerDeMeloAraujo.SpecialAbility;


import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import me.RafaelAulerDeMeloAraujo.main.Main;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;

public class StomperKITCOMMAND implements CommandExecutor {
	 private Main main;
	 /*     */   static Main plugin;
	 /*     */   
	 /*     */   public StomperKITCOMMAND(Main main) {
	 /*  27 */     this.main = main;
	 /*  28 */     plugin = main;
	 /*     */   }

	 public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	 /*     */   

  Player p = (Player)sender;
 
  if (cmd.getName().equalsIgnoreCase("stomper"))
  {
	  
    if (!p.hasPermission("kitpvp.kit.stomper"))
    {
    	p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "�")) + this.main.getConfig().getString("Permission").replace("&", "�").replaceAll("%permisson%", commandLabel));
      return true;
    }
    if (!Join.game.contains(p.getName()))
    {
        p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "�")) + " �eYou are not in kitpvp to choose this kit!");
        return true;
    }
         if (Habilidade.ContainsAbility(p)) { 
           p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "�")) + this.main.getConfig().getString("Message.KitUse").replace("&", "�"));
           p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
          return true;
        }
         p.getInventory().clear();
         ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
         ItemMeta souperaa = dima.getItemMeta();
         souperaa.setDisplayName("�cSword");
         dima.setItemMeta(souperaa);
         ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
         ItemMeta sopas = sopa.getItemMeta();
         sopas.setDisplayName("�6Soup");
         sopa.setItemMeta(sopas);
         ItemStack especial = new ItemStack(Material.DIAMOND);
         ItemMeta especial2 = especial.getItemMeta();
         especial2.setDisplayName("�9Boost");
         especial.setItemMeta(especial2);
         
         ItemStack capacete0 = new ItemStack(Material.IRON_HELMET);
         
         ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
         
         ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
         
         ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
         
         p.getInventory().setHelmet(capacete0);
         p.getInventory().setChestplate(peitoral0);
         p.getInventory().setLeggings(calca0);
         p.getInventory().setBoots(Bota0);
    
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "�")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Stomper").replace("&", "�"));
    Habilidade.setAbility(p, "Stomper");
    p.getInventory().addItem(new ItemStack[] { dima });
    p.getInventory().addItem(new ItemStack[] { especial });
    
    
    
    for (int i = 0; i <= 34; i++) {
      p.getInventory().addItem(new ItemStack[] { sopa });
      
    }
    
  }
  if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
	  /*  94 */         p.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "�"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Stomper").replace("&", "�"));
	  /*     */       }
	  /*  96 */       return false; }{
  
}
}

