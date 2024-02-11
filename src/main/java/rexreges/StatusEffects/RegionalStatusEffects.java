package rexreges.StatusEffects;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import rexreges.RegionalMobs;
import rexreges.Items.RegionalItems;
import rexreges.mixin.BrewingRecipeRegistryMixin;

public class RegionalStatusEffects {
        public static final StatusEffect REACH = new RegionalStatusEffect(StatusEffectCategory.BENEFICIAL, 0);
        public static final StatusEffect VULNERABLE = new RegionalStatusEffect(StatusEffectCategory.HARMFUL, 9662828);
        public static final StatusEffect BRUTAL = new RegionalStatusEffect(StatusEffectCategory.BENEFICIAL, 0)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                        "eb83e810-0d14-40f4-9775-47f8ac6d33d2", 0.2f,
                                        EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        public static final StatusEffect GENTLE = new RegionalStatusEffect(StatusEffectCategory.HARMFUL, 0)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                        "62a7ebad-dbc1-4812-9ddd-d4eca6f7ffee",
                                        -0.15f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);


        public static final StatusEffect BRUTAL_VITA = new RegionalStatusEffect(StatusEffectCategory.BENEFICIAL, 0)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                        "eb83e810-0d14-40f4-9775-47f8ac6d33d2", 0.05f,
                                        EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        public static final StatusEffect GENTLE_MORS = new RegionalStatusEffect(StatusEffectCategory.HARMFUL, 0)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                        "62a7ebad-dbc1-4812-9ddd-d4eca6f7ffee",
                                        -0.04f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);


        public static final StatusEffect SPEED_VITA = new RegionalStatusEffect(StatusEffectCategory.BENEFICIAL, 0)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                        "dbacb420-9ee4-4680-9be3-d80eeae9b24a", 0.05f,
                                        EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        public static final StatusEffect SLOWNESS_MORS = new RegionalStatusEffect(StatusEffectCategory.HARMFUL, 0)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                        "90dd73ae-4f59-467d-bf09-91205010a7fb",
                                        -0.04f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        public static final StatusEffect RESITANCE_VITA = new RegionalStatusEffect(StatusEffectCategory.BENEFICIAL, 0);
        public static final StatusEffect VULNERABLE_MORS = new RegionalStatusEffect(StatusEffectCategory.HARMFUL,
                        9662828);

        public static final Potion RESISTANCE = new Potion(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600));
        public static final Potion LONG_RESISTANCE = new Potion("resistance",
                        new StatusEffectInstance(StatusEffects.RESISTANCE, 9600));
        public static final Potion STRONG_RESISTANCE = new Potion("resistance",
                        new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 1));
        public static final Potion VULNERABLE_POTION = new Potion(new StatusEffectInstance(VULNERABLE, 1800));
        public static final Potion LONG_VULNERABLE = new Potion("vulnerable",
                        new StatusEffectInstance(VULNERABLE, 4800));

        public static final Potion BRUTAL_POTION = new Potion(new StatusEffectInstance(BRUTAL, 3600));
        public static final Potion LONG_BRUTAL = new Potion("brutal",
                        new StatusEffectInstance(BRUTAL, 9600));
        public static final Potion STRONG_BRUTAL = new Potion("brutal",
                        new StatusEffectInstance(BRUTAL, 1800, 1));
        public static final Potion GENTLE_POTION = new Potion(new StatusEffectInstance(GENTLE, 1800));
        public static final Potion LONG_GENTLE = new Potion("gentle",
                        new StatusEffectInstance(GENTLE, 4800));

        public static final Potion HASTE = new Potion(new StatusEffectInstance(StatusEffects.HASTE, 3600));
        public static final Potion LONG_HASTE = new Potion("haste",
                        new StatusEffectInstance(StatusEffects.HASTE, 9600));
        public static final Potion STRONG_HASTE = new Potion("haste",
                        new StatusEffectInstance(StatusEffects.HASTE, 1800, 1));


        public static void registerStatusEffectsAndPotions() {
                RegionalMobs.LOGGER.debug("Registering Armor for " + RegionalMobs.MOD_ID);

                RegionalMobs.registerEffect("brutal", BRUTAL);
                RegionalMobs.registerEffect("gentle", GENTLE);
                RegionalMobs.registerEffect("vulnerable", VULNERABLE);

                RegionalMobs.registerEffect("brutal_vita", BRUTAL_VITA);
                RegionalMobs.registerEffect("speed_vita", SPEED_VITA);
                RegionalMobs.registerEffect("resistance_vita", RESITANCE_VITA);

                RegionalMobs.registerEffect("gentle_mors", GENTLE_MORS);
                RegionalMobs.registerEffect("slowness_mors", SLOWNESS_MORS);
                RegionalMobs.registerEffect("vulnerable_mors", VULNERABLE_MORS);

                RegionalMobs.registerPotion("resistance", RESISTANCE);
                RegionalMobs.registerPotion("long_resistance", LONG_RESISTANCE);
                RegionalMobs.registerPotion("strong_resistance", STRONG_RESISTANCE);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, RegionalItems.LUSH_SILK,
                                RESISTANCE);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(RESISTANCE, Items.REDSTONE, LONG_RESISTANCE);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(RESISTANCE, Items.GLOWSTONE_DUST,
                                STRONG_RESISTANCE);

                RegionalMobs.registerPotion("vulnerable", VULNERABLE_POTION);
                RegionalMobs.registerPotion("long_vulnerable", LONG_VULNERABLE);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(RESISTANCE, Items.FERMENTED_SPIDER_EYE,
                                VULNERABLE_POTION);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(VULNERABLE_POTION, Items.REDSTONE,
                                LONG_VULNERABLE);

                RegionalMobs.registerPotion("brutal", BRUTAL_POTION);
                RegionalMobs.registerPotion("long_brutal", LONG_BRUTAL);
                RegionalMobs.registerPotion("strong_brutal", STRONG_BRUTAL);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, RegionalItems.DESERT_SILK,
                                BRUTAL_POTION);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(BRUTAL_POTION, Items.REDSTONE, LONG_BRUTAL);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(BRUTAL_POTION, Items.GLOWSTONE_DUST,
                                STRONG_BRUTAL);

                RegionalMobs.registerPotion("gentle", GENTLE_POTION);
                RegionalMobs.registerPotion("long_gentle", LONG_GENTLE);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(BRUTAL_POTION, Items.FERMENTED_SPIDER_EYE,
                                GENTLE_POTION);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(GENTLE_POTION, Items.REDSTONE,
                                LONG_GENTLE);

                RegionalMobs.registerPotion("haste", HASTE);
                RegionalMobs.registerPotion("long_haste", LONG_HASTE);
                RegionalMobs.registerPotion("strong_haste", STRONG_HASTE);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, RegionalItems.ARCTIC_SILK,
                                HASTE);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(HASTE, Items.REDSTONE, LONG_HASTE);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(HASTE, Items.GLOWSTONE_DUST, STRONG_HASTE);
        }
}
