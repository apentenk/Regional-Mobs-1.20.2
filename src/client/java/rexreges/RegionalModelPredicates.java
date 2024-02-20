package rexreges;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import rexreges.Armor.RegionalArmor;
import rexreges.Weapons.RegionalCrossbow;
import rexreges.Weapons.RegionalWeapons;

public class RegionalModelPredicates {
    public static void registerModelPredicates() {
        registerBowModels(RegionalWeapons.WOOD_BOW);
        registerBowModels(RegionalWeapons.IRON_BOW);
        registerBowModels(RegionalWeapons.AMBER_IRON_BOW);
        registerBowModels(RegionalWeapons.GHOST_COPPER_BOW);
        registerBowModels(RegionalWeapons.ROSE_GOLD_BOW);
        registerBowModels(RegionalWeapons.DIAMOND_BOW);
        registerBowModels(RegionalWeapons.NETHERITE_BOW);

        registerBowModels(RegionalWeapons.FREEZING_NETHERITE_BOW);
        registerBowModels(RegionalWeapons.SCORCHING_NETHERITE_BOW);
        registerBowModels(RegionalWeapons.BLOOMING_NETHERITE_BOW);

        registerCrossbowModels(RegionalWeapons.WOOD_CROSSBOW);
        registerCrossbowModels(RegionalWeapons.IRON_CROSSBOW);
        registerCrossbowModels(RegionalWeapons.AMBER_IRON_CROSSBOW);
        registerCrossbowModels(RegionalWeapons.GHOST_COPPER_CROSSBOW);
        registerCrossbowModels(RegionalWeapons.ROSE_GOLD_CROSSBOW);
        registerCrossbowModels(RegionalWeapons.DIAMOND_CROSSBOW);
        registerCrossbowModels(RegionalWeapons.NETHERITE_CROSSBOW);

        registerCrossbowModels(RegionalWeapons.FREEZING_NETHERITE_CROSSBOW);
        registerCrossbowModels(RegionalWeapons.SCORCHING_NETHERITE_CROSSBOW);
        registerCrossbowModels(RegionalWeapons.BLOOMING_NETHERITE_CROSSBOW);

        registerTridentThrowing(RegionalWeapons.PRISMARINE_TRIDENT);
        registerTridentThrowing(RegionalWeapons.IRON_TRIDENT);
        registerTridentThrowing(RegionalWeapons.AMBER_IRON_TRIDENT);
        registerTridentThrowing(RegionalWeapons.GHOST_COPPER_TRIDENT);
        registerTridentThrowing(RegionalWeapons.ROSE_GOLD_TRIDENT);
        registerTridentThrowing(RegionalWeapons.DIAMOND_TRIDENT);
        registerTridentThrowing(RegionalWeapons.NETHERITE_TRIDENT);

        registerTridentThrowing(RegionalWeapons.FREEZING_NETHERITE_TRIDENT);
        registerTridentThrowing(RegionalWeapons.SCORCHING_NETHERITE_TRIDENT);
        registerTridentThrowing(RegionalWeapons.BLOOMING_NETHERITE_TRIDENT);

        registerShieldBlocking(RegionalArmor.WOOD_SHIELD);
        registerShieldBlocking(RegionalArmor.IRON_SHIELD);
        registerShieldBlocking(RegionalArmor.AMBER_IRON_SHIELD);
        registerShieldBlocking(RegionalArmor.GHOST_COPPER_SHIELD);
        registerShieldBlocking(RegionalArmor.ROSE_GOLD_SHIELD);
        registerShieldBlocking(RegionalArmor.DIAMOND_SHIELD);
        registerShieldBlocking(RegionalArmor.NETHERITE_SHIELD);

        registerShieldBlocking(RegionalArmor.FREEZING_NETHERITE_SHIELD);
        registerShieldBlocking(RegionalArmor.SCORCHING_NETHERITE_SHIELD);
        registerShieldBlocking(RegionalArmor.BLOOMING_NEHERITE_SHIELD);
    }

    private static void registerBowModels(Item bow) {
        registerBowPullModel(bow);
        registerBowPullingModel(bow);
    }

    private static void registerCrossbowModels(Item crossbow) {
        registerCrossbowPull(crossbow);
        registerCrossbowPulling(crossbow);
        registerCrossbowCharged(crossbow);
        registerCrossbowFirework(crossbow);
    }

    private static void registerBowPullModel(Item item) {
        ModelPredicateProviderRegistry.register(item, new Identifier("pull"),
                (itemStack, clientWorld, livingEntity, integer) -> {
                    if (livingEntity == null) {
                        return 0.0F;
                    }
                    return livingEntity.getActiveItem() != itemStack ? 0.0F
                            : (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 20.0f;

                });
    }

    private static void registerBowPullingModel(Item item) {
        ModelPredicateProviderRegistry.register(item, new Identifier("pulling"),
                (itemStack, clientWorld, livingEntity, integer) -> {
                    if (livingEntity == null) {
                        return 0.0F;
                    }
                    return livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
                });
    }

    private static void registerCrossbowPull(Item item) {
        ModelPredicateProviderRegistry.register(item, new Identifier("pull"),
                (itemStack, clientWorld, livingEntity, integer) -> {
                    if (livingEntity == null) {
                        return 0.0F;
                    }
                    if (RegionalCrossbow.isCharged((ItemStack) itemStack)) {
                        return 0.0f;
                    }
                    return (float) (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft())
                            / (float) CrossbowItem.getPullTime((ItemStack) itemStack);
                });

    }

    private static void registerCrossbowPulling(Item item) {
        ModelPredicateProviderRegistry.register(item, new Identifier("pulling"),
                (itemStack, clientWorld, livingEntity, integer) -> {
                    return livingEntity != null && livingEntity.isUsingItem()
                            && livingEntity.getActiveItem() == itemStack
                            && !RegionalCrossbow.isCharged(itemStack) ? 1.0F : 0.0F;
                });
    }

    private static void registerCrossbowCharged(Item item) {
        ModelPredicateProviderRegistry.register(item, new Identifier("charged"),
                (itemStack, clientWorld, livingEntity, integer) -> {
                    return livingEntity != null && CrossbowItem.isCharged(itemStack) ? 1.0F : 0.0F;
                });
    }

    private static void registerCrossbowFirework(Item item) {
        ModelPredicateProviderRegistry.register(item, new Identifier("firework"),
                (itemStack, clientWorld, livingEntity, integer) -> {
                    return livingEntity != null && CrossbowItem.isCharged(itemStack)
                            && CrossbowItem.hasProjectile(itemStack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
                });
    }

    private static void registerTridentThrowing(Item item) {
        ModelPredicateProviderRegistry.register(item, new Identifier("throwing"),
                (itemStack, clientWorld, livingEntity, integer) -> {
                    return livingEntity != null && livingEntity.isUsingItem()
                            && livingEntity.getActiveItem() == itemStack
                                    ? 1.0F
                                    : 0.0F;
                });
    }

    private static void registerShieldBlocking(Item item) {
        ModelPredicateProviderRegistry.register(item, new Identifier("blocking"),
                (itemStack, clientWorld, livingEntity, integer) -> {
                    return livingEntity != null && livingEntity.isUsingItem()
                            && livingEntity.getActiveItem() == itemStack ? 1.0f : 0.0f;
                });
    }
}
