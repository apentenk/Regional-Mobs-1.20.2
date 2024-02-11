package rexreges.Items;

import net.minecraft.item.Item;
import rexreges.RegionalMobs;

public class RegionalItems {

    public static final Item ROSE_GOLD_INGOT = new Item(new Item.Settings());
    public static final Item AMBER_IRON_INGOT = new Item(new Item.Settings());
    public static final Item GHOST_COPPER_INGOT = new Item(new Item.Settings());

    public static final Item ARCTIC_SILK = new Item(new Item.Settings());
    public static final Item DESERT_SILK = new Item(new Item.Settings());
    public static final Item LUSH_SILK = new Item(new Item.Settings());
    

    public static void registerItems() {
        RegionalMobs.registerItem("rose_gold_ingot", ROSE_GOLD_INGOT);
        RegionalMobs.registerItem("amber_iron_ingot", AMBER_IRON_INGOT);
        RegionalMobs.registerItem("ghost_copper_ingot", GHOST_COPPER_INGOT);
        RegionalMobs.registerItem("desert_silk", DESERT_SILK);
        RegionalMobs.registerItem("arctic_silk", ARCTIC_SILK);
        RegionalMobs.registerItem("lush_silk", LUSH_SILK);
    }
}
