package me.itzbogged.forbiddencolor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class ForbiddenColor extends JavaPlugin implements Listener {

    private final Set<Material> forbiddenMaterials = new HashSet<>();
    private final Map<String, Set<Material>> colorMaterialMap = new HashMap<>();
    private String currentForbiddenColor = null;

    @Override
    public void onEnable() {
        initializeColorMaterials();
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("ForbiddenColor plugin by ItzBogged has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ForbiddenColor plugin by ItzBogged has been disabled!");
    }

    private void initializeColorMaterials() {
        // White materials
        Set<Material> whiteMaterials = new HashSet<>();
        whiteMaterials.add(Material.WHITE_WOOL);
        whiteMaterials.add(Material.WHITE_CONCRETE);
        whiteMaterials.add(Material.WHITE_CONCRETE_POWDER);
        whiteMaterials.add(Material.WHITE_TERRACOTTA);
        whiteMaterials.add(Material.WHITE_GLAZED_TERRACOTTA);
        whiteMaterials.add(Material.WHITE_CARPET);
        whiteMaterials.add(Material.WHITE_BED);
        whiteMaterials.add(Material.WHITE_BANNER);
        whiteMaterials.add(Material.WHITE_SHULKER_BOX);
        whiteMaterials.add(Material.WHITE_STAINED_GLASS);
        whiteMaterials.add(Material.WHITE_STAINED_GLASS_PANE);
        whiteMaterials.add(Material.BONE_BLOCK);
        whiteMaterials.add(Material.QUARTZ_BLOCK);
        whiteMaterials.add(Material.QUARTZ_STAIRS);
        whiteMaterials.add(Material.QUARTZ_SLAB);
        colorMaterialMap.put("white", whiteMaterials);

        // Orange materials
        Set<Material> orangeMaterials = new HashSet<>();
        orangeMaterials.add(Material.ORANGE_WOOL);
        orangeMaterials.add(Material.ORANGE_CONCRETE);
        orangeMaterials.add(Material.ORANGE_CONCRETE_POWDER);
        orangeMaterials.add(Material.ORANGE_TERRACOTTA);
        orangeMaterials.add(Material.ORANGE_GLAZED_TERRACOTTA);
        orangeMaterials.add(Material.ORANGE_CARPET);
        orangeMaterials.add(Material.ORANGE_BED);
        orangeMaterials.add(Material.ORANGE_BANNER);
        orangeMaterials.add(Material.ORANGE_SHULKER_BOX);
        orangeMaterials.add(Material.ORANGE_STAINED_GLASS);
        orangeMaterials.add(Material.ORANGE_STAINED_GLASS_PANE);
        orangeMaterials.add(Material.PUMPKIN);
        orangeMaterials.add(Material.CARVED_PUMPKIN);
        orangeMaterials.add(Material.JACK_O_LANTERN);
        colorMaterialMap.put("orange", orangeMaterials);

        // Magenta materials
        Set<Material> magentaMaterials = new HashSet<>();
        magentaMaterials.add(Material.MAGENTA_WOOL);
        magentaMaterials.add(Material.MAGENTA_CONCRETE);
        magentaMaterials.add(Material.MAGENTA_CONCRETE_POWDER);
        magentaMaterials.add(Material.MAGENTA_TERRACOTTA);
        magentaMaterials.add(Material.MAGENTA_GLAZED_TERRACOTTA);
        magentaMaterials.add(Material.MAGENTA_CARPET);
        magentaMaterials.add(Material.MAGENTA_BED);
        magentaMaterials.add(Material.MAGENTA_BANNER);
        magentaMaterials.add(Material.MAGENTA_SHULKER_BOX);
        magentaMaterials.add(Material.MAGENTA_STAINED_GLASS);
        magentaMaterials.add(Material.MAGENTA_STAINED_GLASS_PANE);
        colorMaterialMap.put("magenta", magentaMaterials);

        // Light Blue materials
        Set<Material> lightBlueMaterials = new HashSet<>();
        lightBlueMaterials.add(Material.LIGHT_BLUE_WOOL);
        lightBlueMaterials.add(Material.LIGHT_BLUE_CONCRETE);
        lightBlueMaterials.add(Material.LIGHT_BLUE_CONCRETE_POWDER);
        lightBlueMaterials.add(Material.LIGHT_BLUE_TERRACOTTA);
        lightBlueMaterials.add(Material.LIGHT_BLUE_GLAZED_TERRACOTTA);
        lightBlueMaterials.add(Material.LIGHT_BLUE_CARPET);
        lightBlueMaterials.add(Material.LIGHT_BLUE_BED);
        lightBlueMaterials.add(Material.LIGHT_BLUE_BANNER);
        lightBlueMaterials.add(Material.LIGHT_BLUE_SHULKER_BOX);
        lightBlueMaterials.add(Material.LIGHT_BLUE_STAINED_GLASS);
        lightBlueMaterials.add(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        colorMaterialMap.put("lightblue", lightBlueMaterials);
        colorMaterialMap.put("light_blue", lightBlueMaterials);

        // Yellow materials
        Set<Material> yellowMaterials = new HashSet<>();
        yellowMaterials.add(Material.YELLOW_WOOL);
        yellowMaterials.add(Material.YELLOW_CONCRETE);
        yellowMaterials.add(Material.YELLOW_CONCRETE_POWDER);
        yellowMaterials.add(Material.YELLOW_TERRACOTTA);
        yellowMaterials.add(Material.YELLOW_GLAZED_TERRACOTTA);
        yellowMaterials.add(Material.YELLOW_CARPET);
        yellowMaterials.add(Material.YELLOW_BED);
        yellowMaterials.add(Material.YELLOW_BANNER);
        yellowMaterials.add(Material.YELLOW_SHULKER_BOX);
        yellowMaterials.add(Material.YELLOW_STAINED_GLASS);
        yellowMaterials.add(Material.YELLOW_STAINED_GLASS_PANE);
        yellowMaterials.add(Material.GOLD_BLOCK);
        yellowMaterials.add(Material.HAY_BLOCK);
        yellowMaterials.add(Material.SPONGE);
        yellowMaterials.add(Material.WET_SPONGE);
        colorMaterialMap.put("yellow", yellowMaterials);

        // Lime materials
        Set<Material> limeMaterials = new HashSet<>();
        limeMaterials.add(Material.LIME_WOOL);
        limeMaterials.add(Material.LIME_CONCRETE);
        limeMaterials.add(Material.LIME_CONCRETE_POWDER);
        limeMaterials.add(Material.LIME_TERRACOTTA);
        limeMaterials.add(Material.LIME_GLAZED_TERRACOTTA);
        limeMaterials.add(Material.LIME_CARPET);
        limeMaterials.add(Material.LIME_BED);
        limeMaterials.add(Material.LIME_BANNER);
        limeMaterials.add(Material.LIME_SHULKER_BOX);
        limeMaterials.add(Material.LIME_STAINED_GLASS);
        limeMaterials.add(Material.LIME_STAINED_GLASS_PANE);
        colorMaterialMap.put("lime", limeMaterials);

        // Pink materials
        Set<Material> pinkMaterials = new HashSet<>();
        pinkMaterials.add(Material.PINK_WOOL);
        pinkMaterials.add(Material.PINK_CONCRETE);
        pinkMaterials.add(Material.PINK_CONCRETE_POWDER);
        pinkMaterials.add(Material.PINK_TERRACOTTA);
        pinkMaterials.add(Material.PINK_GLAZED_TERRACOTTA);
        pinkMaterials.add(Material.PINK_CARPET);
        pinkMaterials.add(Material.PINK_BED);
        pinkMaterials.add(Material.PINK_BANNER);
        pinkMaterials.add(Material.PINK_SHULKER_BOX);
        pinkMaterials.add(Material.PINK_STAINED_GLASS);
        pinkMaterials.add(Material.PINK_STAINED_GLASS_PANE);
        colorMaterialMap.put("pink", pinkMaterials);

        // Gray materials
        Set<Material> grayMaterials = new HashSet<>();
        grayMaterials.add(Material.GRAY_WOOL);
        grayMaterials.add(Material.GRAY_CONCRETE);
        grayMaterials.add(Material.GRAY_CONCRETE_POWDER);
        grayMaterials.add(Material.GRAY_TERRACOTTA);
        grayMaterials.add(Material.GRAY_GLAZED_TERRACOTTA);
        grayMaterials.add(Material.GRAY_CARPET);
        grayMaterials.add(Material.GRAY_BED);
        grayMaterials.add(Material.GRAY_BANNER);
        grayMaterials.add(Material.GRAY_SHULKER_BOX);
        grayMaterials.add(Material.GRAY_STAINED_GLASS);
        grayMaterials.add(Material.GRAY_STAINED_GLASS_PANE);
        colorMaterialMap.put("gray", grayMaterials);
        colorMaterialMap.put("grey", grayMaterials);

        // Light Gray materials
        Set<Material> lightGrayMaterials = new HashSet<>();
        lightGrayMaterials.add(Material.LIGHT_GRAY_WOOL);
        lightGrayMaterials.add(Material.LIGHT_GRAY_CONCRETE);
        lightGrayMaterials.add(Material.LIGHT_GRAY_CONCRETE_POWDER);
        lightGrayMaterials.add(Material.LIGHT_GRAY_TERRACOTTA);
        lightGrayMaterials.add(Material.LIGHT_GRAY_GLAZED_TERRACOTTA);
        lightGrayMaterials.add(Material.LIGHT_GRAY_CARPET);
        lightGrayMaterials.add(Material.LIGHT_GRAY_BED);
        lightGrayMaterials.add(Material.LIGHT_GRAY_BANNER);
        lightGrayMaterials.add(Material.LIGHT_GRAY_SHULKER_BOX);
        lightGrayMaterials.add(Material.LIGHT_GRAY_STAINED_GLASS);
        lightGrayMaterials.add(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
        colorMaterialMap.put("lightgray", lightGrayMaterials);
        colorMaterialMap.put("light_gray", lightGrayMaterials);
        colorMaterialMap.put("lightgrey", lightGrayMaterials);
        colorMaterialMap.put("light_grey", lightGrayMaterials);

        // Cyan materials
        Set<Material> cyanMaterials = new HashSet<>();
        cyanMaterials.add(Material.CYAN_WOOL);
        cyanMaterials.add(Material.CYAN_CONCRETE);
        cyanMaterials.add(Material.CYAN_CONCRETE_POWDER);
        cyanMaterials.add(Material.CYAN_TERRACOTTA);
        cyanMaterials.add(Material.CYAN_GLAZED_TERRACOTTA);
        cyanMaterials.add(Material.CYAN_CARPET);
        cyanMaterials.add(Material.CYAN_BED);
        cyanMaterials.add(Material.CYAN_BANNER);
        cyanMaterials.add(Material.CYAN_SHULKER_BOX);
        cyanMaterials.add(Material.CYAN_STAINED_GLASS);
        cyanMaterials.add(Material.CYAN_STAINED_GLASS_PANE);
        cyanMaterials.add(Material.PRISMARINE);
        cyanMaterials.add(Material.PRISMARINE_BRICKS);
        cyanMaterials.add(Material.DARK_PRISMARINE);
        colorMaterialMap.put("cyan", cyanMaterials);

        // Purple materials
        Set<Material> purpleMaterials = new HashSet<>();
        purpleMaterials.add(Material.PURPLE_WOOL);
        purpleMaterials.add(Material.PURPLE_CONCRETE);
        purpleMaterials.add(Material.PURPLE_CONCRETE_POWDER);
        purpleMaterials.add(Material.PURPLE_TERRACOTTA);
        purpleMaterials.add(Material.PURPLE_GLAZED_TERRACOTTA);
        purpleMaterials.add(Material.PURPLE_CARPET);
        purpleMaterials.add(Material.PURPLE_BED);
        purpleMaterials.add(Material.PURPLE_BANNER);
        purpleMaterials.add(Material.PURPLE_SHULKER_BOX);
        purpleMaterials.add(Material.PURPLE_STAINED_GLASS);
        purpleMaterials.add(Material.PURPLE_STAINED_GLASS_PANE);
        purpleMaterials.add(Material.PURPUR_BLOCK);
        purpleMaterials.add(Material.PURPUR_PILLAR);
        purpleMaterials.add(Material.PURPUR_STAIRS);
        purpleMaterials.add(Material.PURPUR_SLAB);
        colorMaterialMap.put("purple", purpleMaterials);

        // Blue materials
        Set<Material> blueMaterials = new HashSet<>();
        blueMaterials.add(Material.BLUE_WOOL);
        blueMaterials.add(Material.BLUE_CONCRETE);
        blueMaterials.add(Material.BLUE_CONCRETE_POWDER);
        blueMaterials.add(Material.BLUE_TERRACOTTA);
        blueMaterials.add(Material.BLUE_GLAZED_TERRACOTTA);
        blueMaterials.add(Material.BLUE_CARPET);
        blueMaterials.add(Material.BLUE_BED);
        blueMaterials.add(Material.BLUE_BANNER);
        blueMaterials.add(Material.BLUE_SHULKER_BOX);
        blueMaterials.add(Material.BLUE_STAINED_GLASS);
        blueMaterials.add(Material.BLUE_STAINED_GLASS_PANE);
        blueMaterials.add(Material.LAPIS_BLOCK);
        colorMaterialMap.put("blue", blueMaterials);

        // Brown materials
        Set<Material> brownMaterials = new HashSet<>();
        brownMaterials.add(Material.BROWN_WOOL);
        brownMaterials.add(Material.BROWN_CONCRETE);
        brownMaterials.add(Material.BROWN_CONCRETE_POWDER);
        brownMaterials.add(Material.BROWN_TERRACOTTA);
        brownMaterials.add(Material.BROWN_GLAZED_TERRACOTTA);
        brownMaterials.add(Material.BROWN_CARPET);
        brownMaterials.add(Material.BROWN_BED);
        brownMaterials.add(Material.BROWN_BANNER);
        brownMaterials.add(Material.BROWN_SHULKER_BOX);
        brownMaterials.add(Material.BROWN_STAINED_GLASS);
        brownMaterials.add(Material.BROWN_STAINED_GLASS_PANE);
        brownMaterials.add(Material.DIRT);
        brownMaterials.add(Material.COARSE_DIRT);
        brownMaterials.add(Material.PODZOL);
        colorMaterialMap.put("brown", brownMaterials);

        // Green materials
        Set<Material> greenMaterials = new HashSet<>();
        greenMaterials.add(Material.GREEN_WOOL);
        greenMaterials.add(Material.GREEN_CONCRETE);
        greenMaterials.add(Material.GREEN_CONCRETE_POWDER);
        greenMaterials.add(Material.GREEN_TERRACOTTA);
        greenMaterials.add(Material.GREEN_GLAZED_TERRACOTTA);
        greenMaterials.add(Material.GREEN_CARPET);
        greenMaterials.add(Material.GREEN_BED);
        greenMaterials.add(Material.GREEN_BANNER);
        greenMaterials.add(Material.GREEN_SHULKER_BOX);
        greenMaterials.add(Material.GREEN_STAINED_GLASS);
        greenMaterials.add(Material.GREEN_STAINED_GLASS_PANE);
        greenMaterials.add(Material.EMERALD_BLOCK);
        colorMaterialMap.put("green", greenMaterials);

        // Red materials
        Set<Material> redMaterials = new HashSet<>();
        redMaterials.add(Material.RED_WOOL);
        redMaterials.add(Material.RED_CONCRETE);
        redMaterials.add(Material.RED_CONCRETE_POWDER);
        redMaterials.add(Material.RED_TERRACOTTA);
        redMaterials.add(Material.RED_GLAZED_TERRACOTTA);
        redMaterials.add(Material.RED_CARPET);
        redMaterials.add(Material.RED_BED);
        redMaterials.add(Material.RED_BANNER);
        redMaterials.add(Material.RED_SHULKER_BOX);
        redMaterials.add(Material.RED_STAINED_GLASS);
        redMaterials.add(Material.RED_STAINED_GLASS_PANE);
        redMaterials.add(Material.REDSTONE_BLOCK);
        redMaterials.add(Material.RED_NETHER_BRICKS);
        colorMaterialMap.put("red", redMaterials);

        // Black materials
        Set<Material> blackMaterials = new HashSet<>();
        blackMaterials.add(Material.BLACK_WOOL);
        blackMaterials.add(Material.BLACK_CONCRETE);
        blackMaterials.add(Material.BLACK_CONCRETE_POWDER);
        blackMaterials.add(Material.BLACK_TERRACOTTA);
        blackMaterials.add(Material.BLACK_GLAZED_TERRACOTTA);
        blackMaterials.add(Material.BLACK_CARPET);
        blackMaterials.add(Material.BLACK_BED);
        blackMaterials.add(Material.BLACK_BANNER);
        blackMaterials.add(Material.BLACK_SHULKER_BOX);
        blackMaterials.add(Material.BLACK_STAINED_GLASS);
        blackMaterials.add(Material.BLACK_STAINED_GLASS_PANE);
        blackMaterials.add(Material.OBSIDIAN);
        blackMaterials.add(Material.COAL_BLOCK);
        colorMaterialMap.put("black", blackMaterials);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("forbiddencolor")) {
            return false;
        }

        if (!sender.hasPermission("forbiddencolor.admin")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.YELLOW + "Usage: /forbiddencolor <color|clear>");
            sender.sendMessage(ChatColor.YELLOW + "Available colors: " + String.join(", ", colorMaterialMap.keySet()));
            if (currentForbiddenColor != null) {
                sender.sendMessage(ChatColor.YELLOW + "Current forbidden color: " + ChatColor.RED + currentForbiddenColor);
            } else {
                sender.sendMessage(ChatColor.YELLOW + "No color is currently forbidden.");
            }
            return true;
        }

        String color = args[0].toLowerCase();

        if (color.equals("clear") || color.equals("none") || color.equals("remove")) {
            forbiddenMaterials.clear();
            currentForbiddenColor = null;
            sender.sendMessage(ChatColor.GREEN + "Forbidden color cleared! No color is now forbidden.");
            return true;
        }

        if (!colorMaterialMap.containsKey(color)) {
            sender.sendMessage(ChatColor.RED + "Unknown color: " + color);
            sender.sendMessage(ChatColor.YELLOW + "Available colors: " + String.join(", ", colorMaterialMap.keySet()));
            return true;
        }

        forbiddenMaterials.clear();
        forbiddenMaterials.addAll(colorMaterialMap.get(color));
        currentForbiddenColor = color;

        sender.sendMessage(ChatColor.GREEN + "Successfully set " + ChatColor.RED + color + ChatColor.GREEN + " as the forbidden color!");
        sender.sendMessage(ChatColor.YELLOW + "Players will now die instantly when touching " + color + " blocks.");

        return true;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (forbiddenMaterials.isEmpty()) {
            return;
        }

        Player player = event.getPlayer();
        Block blockUnder = player.getLocation().getBlock().getRelative(0, -1, 0);
        Block blockAt = player.getLocation().getBlock();

        // Check if player is standing on or inside a forbidden block
        if (forbiddenMaterials.contains(blockUnder.getType()) || forbiddenMaterials.contains(blockAt.getType())) {
            // Use a delayed task to prevent spam and ensure smooth execution
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (player.isOnline()) {
                        player.setHealth(0.0);
                        Bukkit.broadcastMessage(ChatColor.DARK_RED + player.getName() + ChatColor.RED + " was killed by touching the forbidden color: " + currentForbiddenColor + "!");
                    }
                }
            }.runTask(this);
        }
    }
}