package rexreges.Weapons;

import java.util.UUID;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import rexreges.RegionalMobs;
import rexreges.Items.RegionalItems;
import rexreges.StatusEffects.RegionalStatusEffects;

public class RegionalWeapons {
    public static final UUID BOW_MOVEMENT_SPEED = UUID.fromString("1982e8ee-0b4c-4b2d-b610-b37f0a0f7c90");

    public static final RegionalBow WOOD_BOW = new RegionalBow(ToolMaterials.WOOD,1f, new Item.Settings());
    public static final RegionalBow IRON_BOW = new RegionalBow(ToolMaterials.IRON, 1.25f,new Item.Settings());
    public static final RegionalBow DIAMOND_BOW = new RegionalBow(ToolMaterials.DIAMOND, 1.5f, new Item.Settings());
    public static final RegionalBow NETHERITE_BOW = new RegionalBow(ToolMaterials.NETHERITE, 1.75f, new Item.Settings());

    public static final RegionalBow ROSE_GOLD_BOW = new RegionalBow(ToolMaterials.DIAMOND, 1.5f,RegionalItems.ROSE_GOLD_INGOT, new Item.Settings(),false,true,RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.SUBMISSION_MORS);
    public static final RegionalBow AMBER_IRON_BOW = new RegionalBow(ToolMaterials.DIAMOND, 1.5f,RegionalItems.AMBER_IRON_INGOT, new Item.Settings(),false,true,RegionalStatusEffects.AGGRESSION_VITA, RegionalStatusEffects.SLOWNESS_MORS); 
    public static final RegionalBow GHOST_COPPER_BOW = new RegionalBow(ToolMaterials.DIAMOND, 1.5f,RegionalItems.GHOST_COPPER_INGOT, new Item.Settings(),false,true,RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.KINDNESS_MORS); 

    public static final RegionalBow FREEZING_NETHERITE_BOW = new RegionalBow(ToolMaterials.NETHERITE, 1.75f, Items.NETHERITE_INGOT, new Item.Settings(),true, false, RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.HASTE_VITA);
    public static final RegionalBow SCORCHING_NETHERITE_BOW = new RegionalBow(ToolMaterials.NETHERITE, 1.75f, Items.NETHERITE_INGOT, new Item.Settings(), true, false, RegionalStatusEffects.AGGRESSION_VITA, RegionalStatusEffects.STRENGTH_VITA);
    public static final RegionalBow BLOOMING_NETHERITE_BOW = new RegionalBow(ToolMaterials.NETHERITE, 1.75f, Items.NETHERITE_INGOT, new Item.Settings(), true, false, RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.ABSORPTION_VITA);


    public static final RegionalCrossbow WOOD_CROSSBOW = new RegionalCrossbow(ToolMaterials.WOOD, 1.2f, new Item.Settings());
    public static final RegionalCrossbow IRON_CROSSBOW = new RegionalCrossbow(ToolMaterials.IRON, 1.6f, new Item.Settings());
    public static final RegionalCrossbow DIAMOND_CROSSBOW = new RegionalCrossbow(ToolMaterials.DIAMOND, 1.6f, new Item.Settings());
    public static final RegionalCrossbow NETHERITE_CROSSBOW = new RegionalCrossbow(ToolMaterials.NETHERITE, 1.8f, new Item.Settings());

    public static final RegionalCrossbow ROSE_GOLD_CROSSBOW = new RegionalCrossbow(ToolMaterials.DIAMOND, 1.6f,RegionalItems.ROSE_GOLD_INGOT, new Item.Settings(),false,true,RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.SUBMISSION_MORS);
    public static final RegionalCrossbow AMBER_IRON_CROSSBOW = new RegionalCrossbow(ToolMaterials.DIAMOND, 1.6f,RegionalItems.AMBER_IRON_INGOT, new Item.Settings(),false,true,RegionalStatusEffects.AGGRESSION_VITA, RegionalStatusEffects.SLOWNESS_MORS); 
    public static final RegionalCrossbow GHOST_COPPER_CROSSBOW = new RegionalCrossbow(ToolMaterials.DIAMOND, 1.6f,RegionalItems.GHOST_COPPER_INGOT, new Item.Settings(),false,true,RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.KINDNESS_MORS); 
    
    public static final RegionalCrossbow FREEZING_NETHERITE_CROSSBOW = new RegionalCrossbow(ToolMaterials.NETHERITE, 1.8f, Items.NETHERITE_INGOT, new Item.Settings(),true, false, RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.HASTE_VITA);
    public static final RegionalCrossbow SCORCHING_NETHERITE_CROSSBOW = new RegionalCrossbow(ToolMaterials.NETHERITE, 1.8f, Items.NETHERITE_INGOT, new Item.Settings(), true, false, RegionalStatusEffects.AGGRESSION_VITA, RegionalStatusEffects.STRENGTH_VITA);
    public static final RegionalCrossbow BLOOMING_NETHERITE_CROSSBOW = new RegionalCrossbow(ToolMaterials.NETHERITE, 1.8f, Items.NETHERITE_INGOT, new Item.Settings(), true, false, RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.ABSORPTION_VITA);
    
    public static final RegionalTrident PRISMARINE_TRIDENT = new RegionalTrident(ToolMaterials.STONE, -2.9f, "prismarine_trident", RegionalTridentEntityTypes.PrismarineTridentEntityType);
    public static final RegionalTrident IRON_TRIDENT = new RegionalTrident(ToolMaterials.IRON, -2.9f, "iron_trident", RegionalTridentEntityTypes.IronTridentEntityType);
    public static final RegionalTrident DIAMOND_TRIDENT = new RegionalTrident(ToolMaterials.DIAMOND, -2.9f, "diamond_trident", RegionalTridentEntityTypes.DiamondTridentEntityType);

    public static final RegionalTrident ROSE_GOLD_TRIDENT = new RegionalTrident(ToolMaterials.DIAMOND, -2.79f, Ingredient.ofItems(RegionalItems.ROSE_GOLD_INGOT), "rose_gold_trident", RegionalTridentEntityTypes.RoseGoldTridentEntityType,false, true, RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.SUBMISSION_MORS);
    public static final RegionalTrident AMBER_IRON_TRIDENT = new RegionalTrident(ToolMaterials.DIAMOND, -2.79f, Ingredient.ofItems(RegionalItems.AMBER_IRON_INGOT), "amber_iron_trident", RegionalTridentEntityTypes.AmberIronTridentEntityType,false, true, RegionalStatusEffects.AGGRESSION_VITA, RegionalStatusEffects.SLOWNESS_MORS);
    public static final RegionalTrident GHOST_COPPER_TRIDENT = new RegionalTrident(ToolMaterials.DIAMOND, -2.79f, Ingredient.ofItems(RegionalItems.GHOST_COPPER_INGOT), "ghost_copper_trident", RegionalTridentEntityTypes.GhostCopperTridentEntityType,false, true, RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.KINDNESS_MORS);


    public static final RegionalTrident NETHERITE_TRIDENT = new RegionalTrident(ToolMaterials.NETHERITE, -2.9f, "netherite_trident", RegionalTridentEntityTypes.NetheriteTridentEntityType);
    public static final RegionalTrident FREEZING_NETHERITE_TRIDENT = new RegionalTrident(ToolMaterials.NETHERITE, -2.9f, Ingredient.ofItems(Items.NETHERITE_INGOT), "freezing_netherite_trident", RegionalTridentEntityTypes.FreezingNetheriteTridentEntityType,true, false, RegionalStatusEffects.SPEED_VITA,null);
    public static final RegionalTrident SCORCHING_NETHERITE_TRIDENT = new RegionalTrident(ToolMaterials.NETHERITE, -2.9f, Ingredient.ofItems(Items.NETHERITE_INGOT), "scorching_netherite_trident", RegionalTridentEntityTypes.ScorchingNetheriteTridentEntityType,true, false, RegionalStatusEffects.AGGRESSION_VITA, null);
    public static final RegionalTrident BLOOMING_NETHERITE_TRIDENT = new RegionalTrident(ToolMaterials.NETHERITE, -2.9f, Ingredient.ofItems(Items.NETHERITE_INGOT), "blooming_netherite_trident", RegionalTridentEntityTypes.BloomingNetheriteTridentEntityType,true, false, RegionalStatusEffects.RESITANCE_VITA, null);

                    
    public static void registerRangedWeapons() {
            RegionalMobs.LOGGER.debug("Registering Bows for " + RegionalMobs.MOD_ID);
            registerBows();
            RegionalMobs.LOGGER.debug("Registering Crossbows for " + RegionalMobs.MOD_ID);
            registerCrossbows();
            RegionalMobs.LOGGER.debug("Registering Tridents for " + RegionalMobs.MOD_ID);
            registerTridents();
    }

    private static void registerBows() {
            RegionalMobs.registerItem("wood_bow", WOOD_BOW);
            RegionalMobs.registerItem("iron_bow", IRON_BOW);
            RegionalMobs.registerItem("diamond_bow", DIAMOND_BOW);
            RegionalMobs.registerItem("netherite_bow", NETHERITE_BOW);

            RegionalMobs.registerItem("rose_gold_bow", ROSE_GOLD_BOW);
            RegionalMobs.registerItem("amber_iron_bow", AMBER_IRON_BOW);
            RegionalMobs.registerItem("ghost_copper_bow", GHOST_COPPER_BOW);

            RegionalMobs.registerItem("freezing_netherite_bow", FREEZING_NETHERITE_BOW);
            RegionalMobs.registerItem("scorching_netherite_bow", SCORCHING_NETHERITE_BOW);
            RegionalMobs.registerItem("blooming_netherite_bow", BLOOMING_NETHERITE_BOW);
    }

    private static void registerCrossbows() {
            RegionalMobs.registerItem("wood_crossbow", WOOD_CROSSBOW);
            RegionalMobs.registerItem("iron_crossbow", IRON_CROSSBOW);
            RegionalMobs.registerItem("diamond_crossbow", DIAMOND_CROSSBOW);
            RegionalMobs.registerItem("netherite_crossbow", NETHERITE_CROSSBOW);

            RegionalMobs.registerItem("rose_gold_crossbow", ROSE_GOLD_CROSSBOW);
            RegionalMobs.registerItem("amber_iron_crossbow", AMBER_IRON_CROSSBOW);
            RegionalMobs.registerItem("ghost_copper_crossbow", GHOST_COPPER_CROSSBOW);

            RegionalMobs.registerItem("freezing_netherite_crossbow", FREEZING_NETHERITE_CROSSBOW);
            RegionalMobs.registerItem("scorching_netherite_crossbow", SCORCHING_NETHERITE_CROSSBOW);
            RegionalMobs.registerItem("blooming_netherite_crossbow", BLOOMING_NETHERITE_CROSSBOW);
    }

    private static void registerTridents() {
            RegionalMobs.registerItem("prismarine_trident", PRISMARINE_TRIDENT);
            RegionalMobs.registerItem("iron_trident", IRON_TRIDENT);
            RegionalMobs.registerItem("diamond_trident", DIAMOND_TRIDENT);
            RegionalMobs.registerItem("netherite_trident", NETHERITE_TRIDENT);

            RegionalMobs.registerItem("rose_gold_trident", ROSE_GOLD_TRIDENT);
            RegionalMobs.registerItem("amber_iron_trident", AMBER_IRON_TRIDENT);
            RegionalMobs.registerItem("ghost_copper_trident", GHOST_COPPER_TRIDENT);

            RegionalMobs.registerItem("freezing_netherite_trident", FREEZING_NETHERITE_TRIDENT);
            RegionalMobs.registerItem("scorching_netherite_trident", SCORCHING_NETHERITE_TRIDENT);
            RegionalMobs.registerItem("blooming_netherite_trident", BLOOMING_NETHERITE_TRIDENT);

    }
}