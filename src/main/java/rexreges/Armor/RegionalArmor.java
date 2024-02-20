package rexreges.Armor;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import rexreges.RegionalMobs;
import rexreges.Items.RegionalItems;
import rexreges.StatusEffects.RegionalStatusEffects;

public class RegionalArmor {
        public static final Item ROSE_GOLD_HELMET = new RegionalArmorItem(RegionalArmorMaterial.ROSE_GOLD_ARMOR_MATERIAL, ArmorItem.Type.HELMET, false, StatusEffects.SPEED,
                        RegionalStatusEffects.SUBMISSION, new Item.Settings());
        public static final Item ROSE_GOLD_CHESTPLATE = new ArmorItem(RegionalArmorMaterial.ROSE_GOLD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                        new Item.Settings());
        public static final Item ROSE_GOLD_LEGGINGS = new ArmorItem(RegionalArmorMaterial.ROSE_GOLD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                        new Item.Settings());
        public static final Item ROSE_GOLD_BOOTS = new ArmorItem(RegionalArmorMaterial.ROSE_GOLD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                        new Item.Settings());

        public static final Item AMBER_IRON_HELMET = new RegionalArmorItem(RegionalArmorMaterial.AMBER_IRON_ARMOR_MATERIAL,
                        ArmorItem.Type.HELMET, false, RegionalStatusEffects.AGGRESSION,
                        StatusEffects.SLOWNESS, new Item.Settings());
        public static final Item AMBER_IRON_CHESTPLATE = new ArmorItem(RegionalArmorMaterial.AMBER_IRON_ARMOR_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());
        public static final Item AMBER_IRON_LEGGINGS = new ArmorItem(RegionalArmorMaterial.AMBER_IRON_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                        new Item.Settings());
        public static final Item AMBER_IRON_BOOTS = new ArmorItem(RegionalArmorMaterial.AMBER_IRON_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                        new Item.Settings());

        public static final Item GHOST_COPPER_HELMET = new RegionalArmorItem(RegionalArmorMaterial.GHOST_COPPER_ARMOR_MATERIAL,
                        ArmorItem.Type.HELMET, false,
                        StatusEffects.RESISTANCE, RegionalStatusEffects.KINDNESS, new Item.Settings());
        public static final Item GHOST_COPPER_CHESTPLATE = new ArmorItem(RegionalArmorMaterial.GHOST_COPPER_ARMOR_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());
        public static final Item GHOST_COPPER_LEGGINGS = new ArmorItem(RegionalArmorMaterial.GHOST_COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                        new Item.Settings());
        public static final Item GHOST_COPPER_BOOTS = new ArmorItem(RegionalArmorMaterial.GHOST_COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                        new Item.Settings());

        public static final Item FREEZING_NETHERITE_HELMET = new RegionalArmorItem(RegionalArmorMaterial.FREEZING_ARMOR_MATERIAL,
                        ArmorItem.Type.HELMET, true, StatusEffects.SPEED,
                        StatusEffects.HASTE, new Item.Settings());
        public static final Item FREEZING_NETHERITE_CHESTPLATE = new ArmorItem(RegionalArmorMaterial.FREEZING_ARMOR_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());
        public static final Item FREEZING_NETHERITE_LEGGINGS = new ArmorItem(RegionalArmorMaterial.FREEZING_ARMOR_MATERIAL,
                        ArmorItem.Type.LEGGINGS, new Item.Settings());
        public static final Item FREEZING_NETHERITE_BOOTS = new ArmorItem(RegionalArmorMaterial.FREEZING_ARMOR_MATERIAL,
                        ArmorItem.Type.BOOTS, new Item.Settings());

        public static final Item SCORCHING_NETHERITE_HELMET = new RegionalArmorItem(RegionalArmorMaterial.SCORCHING_ARMOR_MATERIAL,
                        ArmorItem.Type.HELMET, true, RegionalStatusEffects.AGGRESSION,
                        StatusEffects.STRENGTH, new Item.Settings());
        public static final Item SCORCHING_NETHERITE_CHESTPLATE = new ArmorItem(RegionalArmorMaterial.SCORCHING_ARMOR_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());
        public static final Item SCORCHING_NETHERITE_LEGGINGS = new ArmorItem(RegionalArmorMaterial.SCORCHING_ARMOR_MATERIAL,
                        ArmorItem.Type.LEGGINGS, new Item.Settings());
        public static final Item SCORCHING_NETHERITE_BOOTS = new ArmorItem(RegionalArmorMaterial.SCORCHING_ARMOR_MATERIAL,
                        ArmorItem.Type.BOOTS, new Item.Settings());

        public static final Item BLOOMING_NETHERITE_HELMET = new RegionalArmorItem(RegionalArmorMaterial.BLOOMING_ARMOR_MATERIAL,
                        ArmorItem.Type.HELMET, true, StatusEffects.RESISTANCE,
                        StatusEffects.ABSORPTION, new Item.Settings());
        public static final Item BLOOMING_NETHERITE_CHESTPLATE = new ArmorItem(RegionalArmorMaterial.BLOOMING_ARMOR_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());
        public static final Item BLOOMING_NETHERITE_LEGGINGS = new ArmorItem(RegionalArmorMaterial.BLOOMING_ARMOR_MATERIAL,
                        ArmorItem.Type.LEGGINGS, new Item.Settings());
        public static final Item BLOOMING_NETHERITE_BOOTS = new ArmorItem(RegionalArmorMaterial.BLOOMING_ARMOR_MATERIAL,
                        ArmorItem.Type.BOOTS, new Item.Settings());

        public static final Item LEATHER_ELYTRA = new ArmorItem(RegionalArmorMaterial.LEATHER_ELYTRA_ARMOR_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());
        public static final Item IRON_ELYTRA = new ArmorItem(RegionalArmorMaterial.IRON_ELYTRA_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());
        public static final Item DIAMOND_ELYTRA = new ArmorItem(RegionalArmorMaterial.DIAMOND_ELYTRA_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());
        public static final Item NETHERITE_ELYTRA = new ArmorItem(RegionalArmorMaterial.NETHERITE_ELYTRA_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());

        public static final Item ROSE_GOLD_ELYTRA = new ArmorItem(RegionalArmorMaterial.ROSE_GOLD_ELYTRA_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());
        public static final Item AMBER_IRON_ELYTRA = new ArmorItem(RegionalArmorMaterial.AMBER_IRON_ELYTRA_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());
        public static final Item GHOST_COPPER_ELYTRA = new ArmorItem(RegionalArmorMaterial.GHOST_COPPER_ELYTRA_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());

        public static final Item FREEZING_NETHERITE_ELYTRA = new ArmorItem(RegionalArmorMaterial.FREEZING_ELYTRA_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());
        public static final Item SCORCHING_NETHERITE_ELYTRA = new ArmorItem(
                        RegionalArmorMaterial.SCORCHING_ELYTRA_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());
        public static final Item BLOOMING_NETHERITE_ELYTRA = new ArmorItem(RegionalArmorMaterial.BLOOMING_ELYTRA_MATERIAL,
                        ArmorItem.Type.CHESTPLATE, new Item.Settings());

        public static final RegionalShield WOOD_SHIELD = new RegionalShield(ToolMaterials.WOOD, "wood_shield",
                        new Item.Settings());
        public static final RegionalShield IRON_SHIELD = new RegionalShield(ToolMaterials.IRON, "iron_shield",
                        new Item.Settings());
        public static final RegionalShield DIAMOND_SHIELD = new RegionalShield(ToolMaterials.DIAMOND, "diamond_shield",
                        new Item.Settings());
        public static final RegionalShield NETHERITE_SHIELD = new RegionalShield(ToolMaterials.NETHERITE,
                        "netherite_shield", new Item.Settings());

        public static final RegionalShield ROSE_GOLD_SHIELD = new RegionalShield(ToolMaterials.DIAMOND,
                        Ingredient.ofItems(RegionalItems.ROSE_GOLD_INGOT), "rose_gold_shield",
                        new Item.Settings(), false, RegionalStatusEffects.HASTE_VITA,
                        RegionalStatusEffects.DEPLETION_MORS);
        public static final RegionalShield AMBER_IRON_SHIELD = new RegionalShield(ToolMaterials.DIAMOND,
                        Ingredient.ofItems(RegionalItems.AMBER_IRON_INGOT), "amber_iron_shield",
                        new Item.Settings(), false, RegionalStatusEffects.STRENGTH_VITA,
                        RegionalStatusEffects.FATIGUE_MORS);
        public static final RegionalShield GHOST_COPPER_SHIELD = new RegionalShield(ToolMaterials.DIAMOND,
                        Ingredient.ofItems(RegionalItems.GHOST_COPPER_INGOT), "ghost_copper_shield",
                        new Item.Settings(), false, RegionalStatusEffects.ABSORPTION_VITA,
                        RegionalStatusEffects.WEAKNESS_MORS);

        public static final RegionalShield FREEZING_NETHERITE_SHIELD = new RegionalShield(ToolMaterials.NETHERITE,
                        Ingredient.ofItems(Items.NETHERITE_INGOT), "freezing_netherite_shield",
                        new Item.Settings(), true, RegionalStatusEffects.HASTE_VITA, RegionalStatusEffects.HASTE_VITA);
        public static final RegionalShield SCORCHING_NETHERITE_SHIELD = new RegionalShield(ToolMaterials.NETHERITE,
                        Ingredient.ofItems(Items.NETHERITE_INGOT), "scorching_netherite_shield",
                        new Item.Settings(), true, RegionalStatusEffects.STRENGTH_VITA, RegionalStatusEffects.STRENGTH_VITA);
        public static final RegionalShield BLOOMING_NEHERITE_SHIELD = new RegionalShield(ToolMaterials.NETHERITE,
                        Ingredient.ofItems(Items.NETHERITE_INGOT), "blooming_netherite_shield",
                        new Item.Settings(), true, RegionalStatusEffects.ABSORPTION_VITA, RegionalStatusEffects.ABSORPTION_VITA);

        public static void registerArmor() {
                RegionalMobs.LOGGER.debug("Registering Armor for " + RegionalMobs.MOD_ID);

                RegionalMobs.registerItem("rose_gold_helmet", ROSE_GOLD_HELMET);
                RegionalMobs.registerItem("rose_gold_chestplate", ROSE_GOLD_CHESTPLATE);
                RegionalMobs.registerItem("rose_gold_leggings", ROSE_GOLD_LEGGINGS);
                RegionalMobs.registerItem("rose_gold_boots", ROSE_GOLD_BOOTS);

                RegionalMobs.registerItem("amber_iron_helmet", AMBER_IRON_HELMET);
                RegionalMobs.registerItem("amber_iron_chestplate", AMBER_IRON_CHESTPLATE);
                RegionalMobs.registerItem("amber_iron_leggings", AMBER_IRON_LEGGINGS);
                RegionalMobs.registerItem("amber_iron_boots", AMBER_IRON_BOOTS);

                RegionalMobs.registerItem("ghost_copper_helmet", GHOST_COPPER_HELMET);
                RegionalMobs.registerItem("ghost_copper_chestplate", GHOST_COPPER_CHESTPLATE);
                RegionalMobs.registerItem("ghost_copper_leggings", GHOST_COPPER_LEGGINGS);
                RegionalMobs.registerItem("ghost_copper_boots", GHOST_COPPER_BOOTS);

                RegionalMobs.registerItem("freezing_netherite_helmet", FREEZING_NETHERITE_HELMET);
                RegionalMobs.registerItem("freezing_netherite_chestplate", FREEZING_NETHERITE_CHESTPLATE);
                RegionalMobs.registerItem("freezing_netherite_leggings", FREEZING_NETHERITE_LEGGINGS);
                RegionalMobs.registerItem("freezing_netherite_boots", FREEZING_NETHERITE_BOOTS);

                RegionalMobs.registerItem("scorching_netherite_helmet", SCORCHING_NETHERITE_HELMET);
                RegionalMobs.registerItem("scorching_netherite_chestplate", SCORCHING_NETHERITE_CHESTPLATE);
                RegionalMobs.registerItem("scorching_netherite_leggings", SCORCHING_NETHERITE_LEGGINGS);
                RegionalMobs.registerItem("scorching_netherite_boots", SCORCHING_NETHERITE_BOOTS);

                RegionalMobs.registerItem("blooming_netherite_helmet", BLOOMING_NETHERITE_HELMET);
                RegionalMobs.registerItem("blooming_netherite_chestplate", BLOOMING_NETHERITE_CHESTPLATE);
                RegionalMobs.registerItem("blooming_netherite_leggings", BLOOMING_NETHERITE_LEGGINGS);
                RegionalMobs.registerItem("blooming_netherite_boots", BLOOMING_NETHERITE_BOOTS);

                RegionalMobs.registerItem("freezing_netherite_elytra", FREEZING_NETHERITE_ELYTRA);
                RegionalMobs.registerItem("scorching_netherite_elytra", SCORCHING_NETHERITE_ELYTRA);
                RegionalMobs.registerItem("blooming_netherite_elytra", BLOOMING_NETHERITE_ELYTRA);

                RegionalMobs.registerItem("rose_gold_elytra", ROSE_GOLD_ELYTRA);
                RegionalMobs.registerItem("amber_iron_elytra", AMBER_IRON_ELYTRA);
                RegionalMobs.registerItem("ghost_copper_elytra", GHOST_COPPER_ELYTRA);

                RegionalMobs.registerItem("leather_elytra", LEATHER_ELYTRA);
                RegionalMobs.registerItem("iron_elytra", IRON_ELYTRA);
                RegionalMobs.registerItem("diamond_elytra", DIAMOND_ELYTRA);
                RegionalMobs.registerItem("netherite_elytra", NETHERITE_ELYTRA);

                RegionalMobs.LOGGER.debug("Registering Shields for " + RegionalMobs.MOD_ID);
                RegionalMobs.registerItem("freezing_netherite_shield", FREEZING_NETHERITE_SHIELD);
                RegionalMobs.registerItem("scorching_netherite_shield", SCORCHING_NETHERITE_SHIELD);
                RegionalMobs.registerItem("blooming_netherite_shield", BLOOMING_NEHERITE_SHIELD);
                RegionalMobs.registerItem("iron_shield", IRON_SHIELD);
                RegionalMobs.registerItem("rose_gold_shield", ROSE_GOLD_SHIELD);
                RegionalMobs.registerItem("amber_iron_shield", AMBER_IRON_SHIELD);
                RegionalMobs.registerItem("ghost_copper_shield", GHOST_COPPER_SHIELD);
                RegionalMobs.registerItem("diamond_shield", DIAMOND_SHIELD);
                RegionalMobs.registerItem("netherite_shield", NETHERITE_SHIELD);
                RegionalMobs.registerItem("wood_shield", WOOD_SHIELD);
        }
}
