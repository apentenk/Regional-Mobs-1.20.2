package rexreges.Util;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import rexreges.RegionalMobsDataGenerator;
import rexreges.Armor.RegionalArmor;
import rexreges.Tools.RegionalTools;
import rexreges.Weapons.RegionalWeapons;

public class RegionalModelGenerator extends FabricModelProvider{

    public RegionalModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        generateArmorModels(itemModelGenerator);
        generateToolModels(itemModelGenerator);
        generateWeaponModels(itemModelGenerator);
    }

    private static void generateArmorModels(ItemModelGenerator itemModelGenerator){
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.FREEZING_NETHERITE_HELMET));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.FREEZING_NETHERITE_CHESTPLATE));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.FREEZING_NETHERITE_LEGGINGS));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.FREEZING_NETHERITE_BOOTS));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.FREEZING_NETHERITE_ELYTRA));

        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.SCORCHING_NETHERITE_HELMET));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.SCORCHING_NETHERITE_CHESTPLATE));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.SCORCHING_NETHERITE_LEGGINGS));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.SCORCHING_NETHERITE_BOOTS));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.SCORCHING_NETHERITE_ELYTRA));

        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.BLOOMING_NETHERITE_HELMET));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.BLOOMING_NETHERITE_CHESTPLATE));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.BLOOMING_NETHERITE_LEGGINGS));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.BLOOMING_NETHERITE_BOOTS));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.BLOOMING_NETHERITE_ELYTRA));

        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.ROSE_GOLD_HELMET));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.ROSE_GOLD_CHESTPLATE));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.ROSE_GOLD_LEGGINGS));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.ROSE_GOLD_BOOTS));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.ROSE_GOLD_ELYTRA));

        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.AMBER_IRON_HELMET));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.AMBER_IRON_CHESTPLATE));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.AMBER_IRON_LEGGINGS));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.AMBER_IRON_BOOTS));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.AMBER_IRON_ELYTRA));
        
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.GHOST_COPPER_HELMET));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.GHOST_COPPER_CHESTPLATE));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.GHOST_COPPER_LEGGINGS));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.GHOST_COPPER_BOOTS));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.GHOST_COPPER_ELYTRA));

        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.LEATHER_ELYTRA));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.IRON_ELYTRA));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.DIAMOND_ELYTRA));
        itemModelGenerator.registerArmor(RegionalMobsDataGenerator.getRegistryArmor(RegionalArmor.NETHERITE_ELYTRA));
    }

    private static void generateToolModels(ItemModelGenerator itemModelGenerator){
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.FREEZING_NETHERITE_AXE), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.FREEZING_NETHERITE_HOE), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.FREEZING_NETHERITE_PICKAXE), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.FREEZING_NETHERITE_SHOVEL), Models.HANDHELD);

        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.SCORCHING_NETHERITE_AXE), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.SCORCHING_NETHERITE_HOE), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.SCORCHING_NETHERITE_PICKAXE), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.SCORCHING_NETHERITE_SHOVEL), Models.HANDHELD);

        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.BLOOMING_NETHERITE_AXE), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.BLOOMING_NETHERITE_HOE), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.BLOOMING_NETHERITE_PICKAXE), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.BLOOMING_NETHERITE_SHOVEL), Models.HANDHELD);

        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.AMBER_IRON_AXE),Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.AMBER_IRON_HOE),Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.AMBER_IRON_PICKAXE),Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.AMBER_IRON_SHOVEL),Models.HANDHELD);

        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.GHOST_COPPER_AXE),Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.GHOST_COPPER_HOE),Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.GHOST_COPPER_PICKAXE),Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.GHOST_COPPER_SHOVEL),Models.HANDHELD);

        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.ROSE_GOLD_AXE),Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.ROSE_GOLD_HOE),Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.ROSE_GOLD_PICKAXE),Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.ROSE_GOLD_SHOVEL),Models.HANDHELD);

    }

    private void generateWeaponModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.ROSE_GOLD_SWORD),Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.AMBER_IRON_SWORD), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.GHOST_COPPER_SWORD), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.FREEZING_NETHERITE_SWORD), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.SCORCHING_NETHERITE_SWORD), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalTools.BLOOMING_NETHERITE_SWORD), Models.HANDHELD);

        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalWeapons.PRISMARINE_TRIDENT), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalWeapons.IRON_TRIDENT), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalWeapons.AMBER_IRON_TRIDENT), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalWeapons.GHOST_COPPER_TRIDENT), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalWeapons.ROSE_GOLD_TRIDENT), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalWeapons.DIAMOND_TRIDENT), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalWeapons.NETHERITE_TRIDENT), Models.HANDHELD);

        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalWeapons.FREEZING_NETHERITE_TRIDENT), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalWeapons.SCORCHING_NETHERITE_TRIDENT), Models.HANDHELD);
        itemModelGenerator.register(RegionalMobsDataGenerator.getRegistryItem(RegionalWeapons.BLOOMING_NETHERITE_TRIDENT), Models.HANDHELD);
    }
    
}
