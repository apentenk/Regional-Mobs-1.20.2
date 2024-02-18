package rexreges.Tools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import rexreges.RegionalMobs;
import rexreges.StatusEffects.RegionalStatusEffects;

public class RegionalTools {

        public static final AxeItem ROSE_GOLD_AXE = new RegionalAxeItem((AxeItem)Items.DIAMOND_AXE, new Item.Settings(),false,RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.VULNERABLE_MORS);
        public static final AxeItem AMBER_IRON_AXE = new RegionalAxeItem((AxeItem)Items.DIAMOND_AXE, new Item.Settings(),false,RegionalStatusEffects.BRUTAL_VITA, RegionalStatusEffects.SLOWNESS_MORS);
        public static final AxeItem GHOST_COPPER_AXE = new RegionalAxeItem((AxeItem)Items.DIAMOND_AXE, new Item.Settings(),false,RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.GENTLE_MORS);
        public static final AxeItem FREEZING_NETHERITE_AXE = new RegionalAxeItem((AxeItem)Items.NETHERITE_AXE, new Item.Settings().fireproof(),true,RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.HASTE_VITA);
        public static final AxeItem SCORCHING_NETHERITE_AXE = new RegionalAxeItem((AxeItem)Items.NETHERITE_AXE, new Item.Settings().fireproof(),true,RegionalStatusEffects.BRUTAL_VITA, RegionalStatusEffects.REACH_VITA);
        public static final AxeItem BLOOMING_NETHERITE_AXE = new RegionalAxeItem((AxeItem)Items.NETHERITE_AXE, new Item.Settings().fireproof(),true,RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.ABSORPTION_VITA);

        public static final HoeItem ROSE_GOLD_HOE = new RegionalHoeItem((HoeItem)Items.DIAMOND_HOE, new Item.Settings(),false,RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.VULNERABLE_MORS);
        public static final HoeItem AMBER_IRON_HOE = new RegionalHoeItem((HoeItem)Items.DIAMOND_HOE, new Item.Settings(),false,RegionalStatusEffects.BRUTAL_VITA, RegionalStatusEffects.SLOWNESS_MORS);
        public static final HoeItem GHOST_COPPER_HOE = new RegionalHoeItem((HoeItem)Items.DIAMOND_HOE, new Item.Settings(),false,RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.GENTLE_MORS);
        public static final HoeItem FREEZING_NETHERITE_HOE = new RegionalHoeItem((HoeItem)Items.NETHERITE_HOE, new Item.Settings().fireproof(),true,RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.HASTE_VITA);
        public static final HoeItem SCORCHING_NETHERITE_HOE = new RegionalHoeItem((HoeItem)Items.NETHERITE_HOE, new Item.Settings().fireproof(),true,RegionalStatusEffects.BRUTAL_VITA, RegionalStatusEffects.REACH_VITA);
        public static final HoeItem BLOOMING_NETHERITE_HOE = new RegionalHoeItem((HoeItem)Items.NETHERITE_HOE, new Item.Settings().fireproof(),true,RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.ABSORPTION_VITA);

        public static final PickaxeItem ROSE_GOLD_PICKAXE = new RegionalPickaxeItem((PickaxeItem)Items.DIAMOND_PICKAXE, new Item.Settings(),false,RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.VULNERABLE_MORS);
        public static final PickaxeItem AMBER_IRON_PICKAXE = new RegionalPickaxeItem((PickaxeItem)Items.DIAMOND_PICKAXE, new Item.Settings(),false,RegionalStatusEffects.BRUTAL_VITA, RegionalStatusEffects.SLOWNESS_MORS);
        public static final PickaxeItem GHOST_COPPER_PICKAXE = new RegionalPickaxeItem((PickaxeItem)Items.DIAMOND_PICKAXE, new Item.Settings(),false,RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.GENTLE_MORS);
        public static final PickaxeItem FREEZING_NETHERITE_PICKAXE = new RegionalPickaxeItem((PickaxeItem)Items.NETHERITE_PICKAXE, new Item.Settings().fireproof(),true,RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.HASTE_VITA);
        public static final PickaxeItem SCORCHING_NETHERITE_PICKAXE = new RegionalPickaxeItem((PickaxeItem)Items.NETHERITE_PICKAXE, new Item.Settings().fireproof(),true,RegionalStatusEffects.BRUTAL_VITA, RegionalStatusEffects.REACH_VITA);
        public static final PickaxeItem BLOOMING_NETHERITE_PICKAXE = new RegionalPickaxeItem((PickaxeItem)Items.NETHERITE_PICKAXE, new Item.Settings().fireproof(),true,RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.ABSORPTION_VITA);

        public static final ShovelItem ROSE_GOLD_SHOVEL = new RegionalShovelItem((ShovelItem)Items.DIAMOND_SHOVEL, new Item.Settings(),false,RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.VULNERABLE_MORS);
        public static final ShovelItem AMBER_IRON_SHOVEL = new RegionalShovelItem((ShovelItem)Items.DIAMOND_SHOVEL, new Item.Settings(),false,RegionalStatusEffects.BRUTAL_VITA, RegionalStatusEffects.SLOWNESS_MORS);
        public static final ShovelItem GHOST_COPPER_SHOVEL = new RegionalShovelItem((ShovelItem)Items.DIAMOND_SHOVEL, new Item.Settings(),false,RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.GENTLE_MORS);
        public static final ShovelItem FREEZING_NETHERITE_SHOVEL = new RegionalShovelItem((ShovelItem)Items.NETHERITE_SHOVEL, new Item.Settings().fireproof(),true,RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.HASTE_VITA);
        public static final ShovelItem SCORCHING_NETHERITE_SHOVEL = new RegionalShovelItem((ShovelItem)Items.NETHERITE_SHOVEL, new Item.Settings().fireproof(),true,RegionalStatusEffects.BRUTAL_VITA, RegionalStatusEffects.REACH_VITA);
        public static final ShovelItem BLOOMING_NETHERITE_SHOVEL = new RegionalShovelItem((ShovelItem)Items.NETHERITE_SHOVEL, new Item.Settings().fireproof(),true,RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.ABSORPTION_VITA);

        public static final SwordItem ROSE_GOLD_SWORD = new RegionalSwordItem((SwordItem)Items.DIAMOND_SWORD, new Item.Settings(),false,RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.VULNERABLE_MORS);
        public static final SwordItem AMBER_IRON_SWORD = new RegionalSwordItem((SwordItem)Items.DIAMOND_SWORD, new Item.Settings(),false,RegionalStatusEffects.BRUTAL_VITA, RegionalStatusEffects.SLOWNESS_MORS);
        public static final SwordItem GHOST_COPPER_SWORD = new RegionalSwordItem((SwordItem)Items.DIAMOND_SWORD, new Item.Settings(),false,RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.GENTLE_MORS);
        public static final SwordItem FREEZING_NETHERITE_SWORD = new RegionalSwordItem((SwordItem)Items.NETHERITE_SWORD, new Item.Settings().fireproof(),true,RegionalStatusEffects.SPEED_VITA, RegionalStatusEffects.HASTE_VITA);
        public static final SwordItem SCORCHING_NETHERITE_SWORD = new RegionalSwordItem((SwordItem)Items.NETHERITE_SWORD, new Item.Settings().fireproof(),true,RegionalStatusEffects.BRUTAL_VITA, RegionalStatusEffects.REACH_VITA);
        public static final SwordItem BLOOMING_NETHERITE_SWORD = new RegionalSwordItem((SwordItem)Items.NETHERITE_SWORD, new Item.Settings().fireproof(),true,RegionalStatusEffects.RESITANCE_VITA, RegionalStatusEffects.ABSORPTION_VITA);


        public static void registerTools() {
                RegionalMobs.LOGGER.debug("Registering Tools and Weapons for " + RegionalMobs.MOD_ID);
                RegionalMobs.registerItem("freezing_netherite_axe", FREEZING_NETHERITE_AXE);
                RegionalMobs.registerItem("freezing_netherite_hoe", FREEZING_NETHERITE_HOE);
                RegionalMobs.registerItem("freezing_netherite_pickaxe", FREEZING_NETHERITE_PICKAXE);
                RegionalMobs.registerItem("freezing_netherite_shovel", FREEZING_NETHERITE_SHOVEL);
                RegionalMobs.registerItem("freezing_netherite_sword", FREEZING_NETHERITE_SWORD);

                RegionalMobs.registerItem("scorching_netherite_axe", SCORCHING_NETHERITE_AXE);
                RegionalMobs.registerItem("scorching_netherite_hoe", SCORCHING_NETHERITE_HOE);
                RegionalMobs.registerItem("scorching_netherite_pickaxe", SCORCHING_NETHERITE_PICKAXE);
                RegionalMobs.registerItem("scorching_netherite_shovel", SCORCHING_NETHERITE_SHOVEL);
                RegionalMobs.registerItem("scorching_netherite_sword", SCORCHING_NETHERITE_SWORD);

                RegionalMobs.registerItem("blooming_netherite_axe", BLOOMING_NETHERITE_AXE);
                RegionalMobs.registerItem("blooming_netherite_hoe", BLOOMING_NETHERITE_HOE);
                RegionalMobs.registerItem("blooming_netherite_pickaxe", BLOOMING_NETHERITE_PICKAXE);
                RegionalMobs.registerItem("blooming_netherite_shovel", BLOOMING_NETHERITE_SHOVEL);
                RegionalMobs.registerItem("blooming_netherite_sword", BLOOMING_NETHERITE_SWORD);

                RegionalMobs.registerItem("rose_gold_axe", ROSE_GOLD_AXE);
                RegionalMobs.registerItem("rose_gold_hoe", ROSE_GOLD_HOE);
                RegionalMobs.registerItem("rose_gold_pickaxe", ROSE_GOLD_PICKAXE);
                RegionalMobs.registerItem("rose_gold_shovel", ROSE_GOLD_SHOVEL);
                RegionalMobs.registerItem("rose_gold_sword", ROSE_GOLD_SWORD);

                RegionalMobs.registerItem("amber_iron_axe", AMBER_IRON_AXE);
                RegionalMobs.registerItem("amber_iron_hoe", AMBER_IRON_HOE);
                RegionalMobs.registerItem("amber_iron_pickaxe", AMBER_IRON_PICKAXE);
                RegionalMobs.registerItem("amber_iron_shovel", AMBER_IRON_SHOVEL);
                RegionalMobs.registerItem("amber_iron_sword", AMBER_IRON_SWORD);

                RegionalMobs.registerItem("ghost_copper_axe", GHOST_COPPER_AXE);
                RegionalMobs.registerItem("ghost_copper_hoe", GHOST_COPPER_HOE);
                RegionalMobs.registerItem("ghost_copper_pickaxe", GHOST_COPPER_PICKAXE);
                RegionalMobs.registerItem("ghost_copper_shovel", GHOST_COPPER_SHOVEL);
                RegionalMobs.registerItem("ghost_copper_sword", GHOST_COPPER_SWORD);
        }
}