package rexreges.Util;

import org.apache.commons.text.WordUtils;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import rexreges.RegionalMobsDataGenerator;
import rexreges.Armor.RegionalArmor;
import rexreges.StatusEffects.RegionalStatusEffects;
import rexreges.Tools.RegionalTools;
import rexreges.Weapons.RegionalWeapons;

public class RegionalEnglishLangProvider extends FabricLanguageProvider{

    public RegionalEnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
       generateArmorTranslations(translationBuilder);
       generateStatusTranslations(translationBuilder);
       generateToolTranslations(translationBuilder);
       generateWeaponsTranslations(translationBuilder);
    }
    
    public static String generateHumanReadable(Identifier identifier) {
        String identifier_path = identifier.getPath();
        String lowercase = identifier_path.replace("_", " ");
        String capitalized = WordUtils.capitalize(lowercase);
        return capitalized;

    }

    private static void addItemToTranslationBuilder(TranslationBuilder translationBuilder, Item item) {
        try {
            translationBuilder.add(item, generateHumanReadable(RegionalMobsDataGenerator.getItemIdentifier(item)));
        } catch (RuntimeException e) {
            LOGGER.info("Duplicated entry ignored");
        }
    }

    private static void addStatusToTranslationBuilder(TranslationBuilder translationBuilder, StatusEffect effect) {
        try {
            translationBuilder.add(effect,
                    generateHumanReadable(RegionalMobsDataGenerator.getStatusIdentifier(effect)));
        } catch (RuntimeException e) {
            LOGGER.info("Duplicated entry ignored");
        }
    }

    private void generateToolTranslations(TranslationBuilder translationBuilder){
        addItemToTranslationBuilder(translationBuilder, RegionalTools.FREEZING_NETHERITE_AXE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.SCORCHING_NETHERITE_AXE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.BLOOMING_NETHERITE_AXE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.ROSE_GOLD_AXE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.AMBER_IRON_AXE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.GHOST_COPPER_AXE);

        addItemToTranslationBuilder(translationBuilder, RegionalTools.FREEZING_NETHERITE_PICKAXE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.SCORCHING_NETHERITE_PICKAXE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.BLOOMING_NETHERITE_PICKAXE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.ROSE_GOLD_PICKAXE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.AMBER_IRON_PICKAXE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.GHOST_COPPER_PICKAXE);

        addItemToTranslationBuilder(translationBuilder, RegionalTools.FREEZING_NETHERITE_SHOVEL);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.SCORCHING_NETHERITE_SHOVEL);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.BLOOMING_NETHERITE_SHOVEL);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.ROSE_GOLD_SHOVEL);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.AMBER_IRON_SHOVEL);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.GHOST_COPPER_SHOVEL);

        addItemToTranslationBuilder(translationBuilder, RegionalTools.FREEZING_NETHERITE_SWORD);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.SCORCHING_NETHERITE_SWORD);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.BLOOMING_NETHERITE_SWORD);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.ROSE_GOLD_SWORD);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.AMBER_IRON_SWORD);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.GHOST_COPPER_SWORD);

        addItemToTranslationBuilder(translationBuilder, RegionalTools.FREEZING_NETHERITE_HOE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.SCORCHING_NETHERITE_HOE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.BLOOMING_NETHERITE_HOE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.ROSE_GOLD_HOE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.AMBER_IRON_HOE);
        addItemToTranslationBuilder(translationBuilder, RegionalTools.GHOST_COPPER_HOE);
    }

    private void generateWeaponsTranslations(TranslationBuilder translationBuilder){
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.FREEZING_NETHERITE_BOW);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.SCORCHING_NETHERITE_BOW);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.BLOOMING_NETHERITE_BOW);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.ROSE_GOLD_BOW);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.AMBER_IRON_BOW);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.GHOST_COPPER_BOW);

        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.FREEZING_NETHERITE_CROSSBOW);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.SCORCHING_NETHERITE_CROSSBOW);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.BLOOMING_NETHERITE_CROSSBOW);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.ROSE_GOLD_CROSSBOW);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.AMBER_IRON_CROSSBOW);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.GHOST_COPPER_CROSSBOW);

        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.FREEZING_NETHERITE_TRIDENT);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.SCORCHING_NETHERITE_TRIDENT);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.BLOOMING_NETHERITE_TRIDENT);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.ROSE_GOLD_TRIDENT);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.AMBER_IRON_TRIDENT);
        addItemToTranslationBuilder(translationBuilder, RegionalWeapons.GHOST_COPPER_TRIDENT);
    }

    private void generateArmorTranslations(TranslationBuilder translationBuilder) {
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.ROSE_GOLD_HELMET);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.ROSE_GOLD_CHESTPLATE);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.ROSE_GOLD_LEGGINGS);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.ROSE_GOLD_BOOTS);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.ROSE_GOLD_ELYTRA);

        addItemToTranslationBuilder(translationBuilder, RegionalArmor.AMBER_IRON_HELMET);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.AMBER_IRON_CHESTPLATE);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.AMBER_IRON_LEGGINGS);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.AMBER_IRON_BOOTS);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.AMBER_IRON_ELYTRA);

        addItemToTranslationBuilder(translationBuilder, RegionalArmor.GHOST_COPPER_HELMET);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.GHOST_COPPER_CHESTPLATE);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.GHOST_COPPER_LEGGINGS);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.GHOST_COPPER_BOOTS);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.GHOST_COPPER_ELYTRA);

        addItemToTranslationBuilder(translationBuilder, RegionalArmor.FREEZING_NETHERITE_HELMET);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.FREEZING_NETHERITE_CHESTPLATE);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.FREEZING_NETHERITE_LEGGINGS);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.FREEZING_NETHERITE_BOOTS);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.FREEZING_NETHERITE_ELYTRA);

        addItemToTranslationBuilder(translationBuilder, RegionalArmor.SCORCHING_NETHERITE_HELMET);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.SCORCHING_NETHERITE_CHESTPLATE);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.SCORCHING_NETHERITE_LEGGINGS);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.SCORCHING_NETHERITE_BOOTS);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.SCORCHING_NETHERITE_ELYTRA);

        addItemToTranslationBuilder(translationBuilder, RegionalArmor.BLOOMING_NETHERITE_HELMET);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.BLOOMING_NETHERITE_CHESTPLATE);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.BLOOMING_NETHERITE_LEGGINGS);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.BLOOMING_NETHERITE_BOOTS);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.BLOOMING_NETHERITE_ELYTRA);

        addItemToTranslationBuilder(translationBuilder, RegionalArmor.LEATHER_ELYTRA);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.IRON_ELYTRA);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.DIAMOND_ELYTRA);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.NETHERITE_ELYTRA);

        addItemToTranslationBuilder(translationBuilder, RegionalArmor.WOOD_SHIELD);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.IRON_SHIELD);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.AMBER_IRON_SHIELD);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.ROSE_GOLD_SHIELD);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.GHOST_COPPER_SHIELD);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.DIAMOND_SHIELD);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.NETHERITE_SHIELD);

        addItemToTranslationBuilder(translationBuilder, RegionalArmor.FREEZING_NETHERITE_SHIELD);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.SCORCHING_NETHERITE_SHIELD);
        addItemToTranslationBuilder(translationBuilder, RegionalArmor.BLOOMING_NEHERITE_SHIELD);
    }

    private void generateStatusTranslations(TranslationBuilder translationBuilder) {
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.ABSORPTION_VITA);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.AGGRESSION);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.AGGRESSION_VITA);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.DEPLETION);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.DEPLETION_MORS);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.FATIGUE);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.FATIGUE_MORS);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.HASTE_VITA);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.KINDNESS);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.KINDNESS_MORS);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.RESITANCE_VITA);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.SLOWNESS_MORS);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.SPEED_VITA);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.STRENGTH_VITA);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.SUBMISSION);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.SUBMISSION_MORS);
        addStatusToTranslationBuilder(translationBuilder, RegionalStatusEffects.WEAKNESS_MORS);
    }
}
