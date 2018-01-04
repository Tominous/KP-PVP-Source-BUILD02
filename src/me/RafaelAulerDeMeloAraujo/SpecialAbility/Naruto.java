package me.RafaelAulerDeMeloAraujo.SpecialAbility;


import org.bukkit.event.EventHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.RafaelAulerDeMeloAraujo.main.Main;



public class Naruto implements CommandExecutor, Listener {
	 private Main main;
	 /*     */   static Main plugin;
	 /*     */   
	 /*     */   public Naruto (Main main) {
	 /*  27 */     this.main = main;
	 /*  28 */     plugin = main;
	 /*     */   }		
public static HashMap<String, Long> cooldown = new HashMap();
private static final HashMap<Player, String> Armadura = null;
	 @EventHandler
	 
	  public void interact(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && 
	    		(Habilidade.getAbility(p) == "Naruto") && 
	      (p.getItemInHand().getType() == Material.NETHER_STAR))
	    {
	      if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
	      {
	        e.setCancelled(true);
	        p.updateInventory();
	        
	        p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "�") + ChatColor.RED + " �c�lKyuubi mode activate!!!!!!"));
	        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 500, 0));
	        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 1));
	        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 500, 0));
	        p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_DEATH, 1.0F, 1.0F);
	        cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L)));
	        return;
	      }
	      p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "�") +  ChatColor.RED + " You need to wait " + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - System.currentTimeMillis()) + " seconds to use your ability again."));
	    }
	  }


public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
{

  

	 Player p = (Player)sender;
  if (command.getName().equalsIgnoreCase("naruto"))
  {
	  if (!Join.game.contains(p.getName()))
      {
          p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "�")) + " �eYou are not in kitpvp to do choose this kit!");
          return true;
      }
	  if (Habilidade.ContainsAbility(p)) { 
          p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "�")) + this.main.getConfig().getString("Message.KitUse").replace("&", "�"));
          p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
         return true;
       }
  if (!p.hasPermission("kitpvp.kit.naruto")) {
	  p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "�")) + this.main.getConfig().getString("Permission").replace("&", "�").replaceAll("%permisson%", cmd));
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
  ItemStack especial = new ItemStack(Material.NETHER_STAR);
  ItemMeta especial2 = especial.getItemMeta();
  especial2.setDisplayName("�cNine Tails Mode!");
  especial.setItemMeta(especial2);
  
  ItemStack capacete0 = new ItemStack(Material.IRON_HELMET);
  
  ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
  
  ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
  
  ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
  p.getInventory().addItem(new ItemStack[] { dima });
  p.getInventory().addItem(new ItemStack[] { especial });
  p.getInventory().setHelmet(capacete0);
  p.getInventory().setChestplate(peitoral0);
  p.getInventory().setLeggings(calca0);
  p.getInventory().setBoots(Bota0);

p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "�")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Naruto").replace("&", "�"));
Habilidade.setAbility(p, "Naruto");

  
  
  for (int i = 0; i <= 34; i++) {
    p.getInventory().addItem(new ItemStack[] { sopa });
    
  }
}
  if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
	  /*  94 */         p.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "�"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Naruto").replace("&", "�"));
	  /*     */       }
	  /*  96 */       return false; }{

}


{
}
}