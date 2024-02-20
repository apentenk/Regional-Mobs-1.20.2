package rexreges;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import rexreges.Armor.RegionalArmor;
import rexreges.Tools.RegionalTools;
import rexreges.Weapons.RegionalWeapons;

public class RegionalItemGroups {
        public static final ItemGroup REGIONAL_TOOLS = Registry.register(Registries.ITEM_GROUP,
                        new Identifier(RegionalMobs.MOD_ID, "regional_tool_group"), FabricItemGroup.builder()
                                        .icon(() -> new ItemStack(RegionalArmor.NETHERITE_ELYTRA))
                                        .displayName(Text.translatable("Regional Tools and Armor"))
                                        .build());

        public static void addRegionalItemGroups() {
                addRegionalToolsItemGroup();
        }

        public static void addRegionalToolsItemGroup() {
                ItemGroupEvents.modifyEntriesEvent(Registries.ITEM_GROUP.getKey(REGIONAL_TOOLS).get())
                                .register(content -> {
                                        content.add(RegionalArmor.IRON_ELYTRA);
                                        content.add(RegionalArmor.DIAMOND_ELYTRA);
                                        content.add(RegionalArmor.NETHERITE_ELYTRA);

                                        content.add(RegionalArmor.ROSE_GOLD_HELMET);
                                        content.add(RegionalArmor.ROSE_GOLD_CHESTPLATE);
                                        content.add(RegionalArmor.ROSE_GOLD_ELYTRA);
                                        content.add(RegionalArmor.ROSE_GOLD_LEGGINGS);
                                        content.add(RegionalArmor.ROSE_GOLD_BOOTS);

                                        content.add(RegionalArmor.AMBER_IRON_HELMET);
                                        content.add(RegionalArmor.AMBER_IRON_CHESTPLATE);
                                        content.add(RegionalArmor.AMBER_IRON_ELYTRA);
                                        content.add(RegionalArmor.AMBER_IRON_LEGGINGS);
                                        content.add(RegionalArmor.AMBER_IRON_BOOTS);

                                        content.add(RegionalArmor.GHOST_COPPER_HELMET);
                                        content.add(RegionalArmor.GHOST_COPPER_CHESTPLATE);
                                        content.add(RegionalArmor.GHOST_COPPER_ELYTRA);
                                        content.add(RegionalArmor.GHOST_COPPER_LEGGINGS);
                                        content.add(RegionalArmor.GHOST_COPPER_BOOTS);

                                        content.add(RegionalArmor.FREEZING_NETHERITE_HELMET);
                                        content.add(RegionalArmor.FREEZING_NETHERITE_CHESTPLATE);
                                        content.add(RegionalArmor.FREEZING_NETHERITE_ELYTRA);
                                        content.add(RegionalArmor.FREEZING_NETHERITE_LEGGINGS);
                                        content.add(RegionalArmor.FREEZING_NETHERITE_BOOTS);

                                        content.add(RegionalArmor.SCORCHING_NETHERITE_HELMET);
                                        content.add(RegionalArmor.SCORCHING_NETHERITE_CHESTPLATE);
                                        content.add(RegionalArmor.SCORCHING_NETHERITE_ELYTRA);
                                        content.add(RegionalArmor.SCORCHING_NETHERITE_LEGGINGS);
                                        content.add(RegionalArmor.SCORCHING_NETHERITE_BOOTS);

                                        content.add(RegionalArmor.BLOOMING_NETHERITE_HELMET);
                                        content.add(RegionalArmor.BLOOMING_NETHERITE_CHESTPLATE);
                                        content.add(RegionalArmor.BLOOMING_NETHERITE_ELYTRA);
                                        content.add(RegionalArmor.BLOOMING_NETHERITE_LEGGINGS);
                                        content.add(RegionalArmor.BLOOMING_NETHERITE_BOOTS);

                                        content.add(RegionalTools.ROSE_GOLD_SHOVEL);
                                        content.add(RegionalTools.ROSE_GOLD_PICKAXE);
                                        content.add(RegionalTools.ROSE_GOLD_AXE);
                                        content.add(RegionalTools.ROSE_GOLD_HOE);
                                        content.add(RegionalTools.ROSE_GOLD_SWORD);

                                        content.add(RegionalTools.AMBER_IRON_SHOVEL);
                                        content.add(RegionalTools.AMBER_IRON_PICKAXE);
                                        content.add(RegionalTools.AMBER_IRON_AXE);
                                        content.add(RegionalTools.AMBER_IRON_HOE);
                                        content.add(RegionalTools.AMBER_IRON_SWORD);

                                        content.add(RegionalTools.GHOST_COPPER_SHOVEL);
                                        content.add(RegionalTools.GHOST_COPPER_PICKAXE);
                                        content.add(RegionalTools.GHOST_COPPER_AXE);
                                        content.add(RegionalTools.GHOST_COPPER_HOE);
                                        content.add(RegionalTools.GHOST_COPPER_SWORD);

                                        content.add(RegionalTools.FREEZING_NETHERITE_SHOVEL);
                                        content.add(RegionalTools.FREEZING_NETHERITE_PICKAXE);
                                        content.add(RegionalTools.FREEZING_NETHERITE_AXE);
                                        content.add(RegionalTools.FREEZING_NETHERITE_HOE);

                                        content.add(RegionalTools.SCORCHING_NETHERITE_SHOVEL);
                                        content.add(RegionalTools.SCORCHING_NETHERITE_PICKAXE);
                                        content.add(RegionalTools.SCORCHING_NETHERITE_AXE);
                                        content.add(RegionalTools.SCORCHING_NETHERITE_HOE);

                                        content.add(RegionalTools.BLOOMING_NETHERITE_HOE);
                                        content.add(RegionalTools.BLOOMING_NETHERITE_AXE);
                                        content.add(RegionalTools.BLOOMING_NETHERITE_PICKAXE);
                                        content.add(RegionalTools.BLOOMING_NETHERITE_SHOVEL);

                                        content.add(RegionalWeapons.WOOD_BOW);
                                        content.add(RegionalWeapons.IRON_BOW);
                                        content.add(RegionalWeapons.ROSE_GOLD_BOW);
                                        content.add(RegionalWeapons.AMBER_IRON_BOW);
                                        content.add(RegionalWeapons.GHOST_COPPER_BOW);
                                        content.add(RegionalWeapons.DIAMOND_BOW);
                                        content.add(RegionalWeapons.NETHERITE_BOW);
                                        content.add(RegionalWeapons.FREEZING_NETHERITE_BOW);
                                        content.add(RegionalWeapons.SCORCHING_NETHERITE_BOW);
                                        content.add(RegionalWeapons.BLOOMING_NETHERITE_BOW);

                                        content.add(RegionalWeapons.WOOD_CROSSBOW);
                                        content.add(RegionalWeapons.IRON_CROSSBOW);
                                        content.add(RegionalWeapons.ROSE_GOLD_CROSSBOW);
                                        content.add(RegionalWeapons.AMBER_IRON_CROSSBOW);
                                        content.add(RegionalWeapons.GHOST_COPPER_CROSSBOW);
                                        content.add(RegionalWeapons.DIAMOND_CROSSBOW);
                                        content.add(RegionalWeapons.NETHERITE_CROSSBOW);
                                        content.add(RegionalWeapons.FREEZING_NETHERITE_CROSSBOW);
                                        content.add(RegionalWeapons.SCORCHING_NETHERITE_CROSSBOW);
                                        content.add(RegionalWeapons.BLOOMING_NETHERITE_CROSSBOW);

                                        content.add(RegionalWeapons.PRISMARINE_TRIDENT);
                                        content.add(RegionalWeapons.IRON_TRIDENT);
                                        content.add(RegionalWeapons.ROSE_GOLD_TRIDENT);
                                        content.add(RegionalWeapons.AMBER_IRON_TRIDENT);
                                        content.add(RegionalWeapons.GHOST_COPPER_TRIDENT);
                                        content.add(RegionalWeapons.DIAMOND_TRIDENT);
                                        content.add(RegionalWeapons.NETHERITE_TRIDENT);
                                        content.add(RegionalWeapons.FREEZING_NETHERITE_TRIDENT);
                                        content.add(RegionalWeapons.SCORCHING_NETHERITE_TRIDENT);
                                        content.add(RegionalWeapons.BLOOMING_NETHERITE_TRIDENT);

                                        content.add(RegionalArmor.WOOD_SHIELD);
                                        content.add(RegionalArmor.IRON_SHIELD);
                                        content.add(RegionalArmor.ROSE_GOLD_SHIELD);
                                        content.add(RegionalArmor.AMBER_IRON_SHIELD);
                                        content.add(RegionalArmor.GHOST_COPPER_SHIELD);
                                        content.add(RegionalArmor.DIAMOND_SHIELD);
                                        content.add(RegionalArmor.NETHERITE_SHIELD);
                                        content.add(RegionalArmor.BLOOMING_NEHERITE_SHIELD);
                                        content.add(RegionalArmor.SCORCHING_NETHERITE_SHIELD);
                                        content.add(RegionalArmor.FREEZING_NETHERITE_SHIELD);

                                });
        }
}
