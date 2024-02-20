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
        public static final StatusEffect SUBMISSION = new RegionalStatusEffect(StatusEffectCategory.HARMFUL, 9662828);

        public static final StatusEffect RESITANCE_VITA = new RegionalStatusEffect(StatusEffectCategory.BENEFICIAL,
                        9520880);
        public static final StatusEffect SUBMISSION_MORS = new RegionalStatusEffect(StatusEffectCategory.HARMFUL,
                        9662828);

        public static final StatusEffect AGGRESSION = new RegionalStatusEffect(StatusEffectCategory.BENEFICIAL,
                        16758454);
        public static final StatusEffect KINDNESS = new RegionalStatusEffect(StatusEffectCategory.HARMFUL, 8018779);

        public static final StatusEffect AGGRESSION_VITA = new RegionalStatusEffect(StatusEffectCategory.BENEFICIAL,
                        16758454);
        public static final StatusEffect KINDNESS_MORS = new RegionalStatusEffect(StatusEffectCategory.HARMFUL,
                        8018779);

        public static final StatusEffect SPEED_VITA = new RegionalStatusEffect(StatusEffectCategory.BENEFICIAL, 3402751)
                        .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                                        "dbacb420-9ee4-4680-9be3-d80eeae9b24a", 0.1f,
                                        EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        public static final StatusEffect SLOWNESS_MORS = new RegionalStatusEffect(StatusEffectCategory.HARMFUL, 9154528)
                        .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                                        "90dd73ae-4f59-467d-bf09-91205010a7fb",
                                        -0.075f, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        public static final StatusEffect ABSORPTION_VITA = new AbsorptionVita()
                        .addAttributeModifier(EntityAttributes.GENERIC_MAX_ABSORPTION,
                                        "cab79d16-6ea8-42b7-a6dd-ab0fe6b1b302", 2.0,
                                        EntityAttributeModifier.Operation.ADDITION);
        public static final StatusEffect STRENGTH_VITA = new RegionalStatusEffect(StatusEffectCategory.BENEFICIAL,
                        16762624)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                        "a09867cf-57f8-4040-8f87-256a83862b64", 1.5,
                                        EntityAttributeModifier.Operation.ADDITION);
        public static final StatusEffect HASTE_VITA = new RegionalStatusEffect(StatusEffectCategory.BENEFICIAL,
                        14270531)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED,
                                        "42531d4b-9c05-4819-95bf-b32c3df6f0bf", 0.05,
                                        EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        public static final StatusEffect DEPLETION_MORS = new RegionalStatusEffect(StatusEffectCategory.HARMFUL, 7247)
                        .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH,
                                        "77e9f761-bee9-4329-9601-45b6dc820201", -2.0,
                                        EntityAttributeModifier.Operation.ADDITION);
        public static final StatusEffect WEAKNESS_MORS = new RegionalStatusEffect(StatusEffectCategory.HARMFUL,
                        0x484D48)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                                        "20ac74a9-b476-46da-bda3-cb0c0a25465b", -2.0,
                                        EntityAttributeModifier.Operation.ADDITION);
        public static final StatusEffect FATIGUE_MORS = new RegionalStatusEffect(StatusEffectCategory.HARMFUL, 4866583)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED,
                                        "4d23cf13-30aa-438e-b534-62570d9274da", -0.05,
                                        EntityAttributeModifier.Operation.MULTIPLY_TOTAL);;

        public static final StatusEffect DEPLETION = new RegionalStatusEffect(StatusEffectCategory.HARMFUL, 7247)
                        .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH,
                                        "d665175f-2923-462d-bacd-94f5a951a9e4", -4.0,
                                        EntityAttributeModifier.Operation.ADDITION);
        public static final StatusEffect FATIGUE = new RegionalStatusEffect(StatusEffectCategory.HARMFUL, 4866583)
                        .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED,
                                        "83aff3a0-4a13-49bc-aa63-6157c8fad14b", -0.1,
                                        EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

        public static final Potion RESISTANCE = new Potion(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600));
        public static final Potion LONG_RESISTANCE = new Potion("resistance",
                        new StatusEffectInstance(StatusEffects.RESISTANCE, 9600));
        public static final Potion STRONG_RESISTANCE = new Potion("resistance",
                        new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 1));
        public static final Potion SUBMISSION_POTION = new Potion(new StatusEffectInstance(SUBMISSION, 1800));
        public static final Potion LONG_SUBMISSION = new Potion("submission",
                        new StatusEffectInstance(SUBMISSION, 4800));

        public static final Potion AGGRESSION_POTION = new Potion(new StatusEffectInstance(AGGRESSION, 3600));
        public static final Potion LONG_AGGRESSION = new Potion("aggression",
                        new StatusEffectInstance(AGGRESSION, 9600));
        public static final Potion STRONG_AGGRESSION = new Potion("aggression",
                        new StatusEffectInstance(AGGRESSION, 1800, 1));
        public static final Potion KINDNESS_POTION = new Potion(new StatusEffectInstance(KINDNESS, 1800));
        public static final Potion LONG_KINDNESS = new Potion("kindness",
                        new StatusEffectInstance(KINDNESS, 4800));

        public static final Potion HASTE = new Potion(new StatusEffectInstance(StatusEffects.HASTE, 3600));
        public static final Potion LONG_HASTE = new Potion("haste",
                        new StatusEffectInstance(StatusEffects.HASTE, 9600));
        public static final Potion STRONG_HASTE = new Potion("haste",
                        new StatusEffectInstance(StatusEffects.HASTE, 1800, 1));

        public static void registerStatusEffectsAndPotions() {
                RegionalMobs.LOGGER.debug("Registering Armor for " + RegionalMobs.MOD_ID);

                RegionalMobs.registerEffect("submission", SUBMISSION);

                RegionalMobs.registerEffect("resistance_vita", RESITANCE_VITA);
                RegionalMobs.registerEffect("submission_mors", SUBMISSION_MORS);

                RegionalMobs.registerEffect("aggression", AGGRESSION);
                RegionalMobs.registerEffect("kindness", KINDNESS);

                RegionalMobs.registerEffect("aggression_vita", AGGRESSION_VITA);
                RegionalMobs.registerEffect("kindness_mors", KINDNESS_MORS);

                RegionalMobs.registerEffect("speed_vita", SPEED_VITA);
                RegionalMobs.registerEffect("slowness_mors", SLOWNESS_MORS);

                RegionalMobs.registerEffect("depletion", DEPLETION);
                RegionalMobs.registerEffect("fatigue", FATIGUE);

                RegionalMobs.registerEffect("absorption_vita", ABSORPTION_VITA);
                RegionalMobs.registerEffect("strength_vita", STRENGTH_VITA);
                RegionalMobs.registerEffect("haste_vita", HASTE_VITA);

                RegionalMobs.registerEffect("depletion_mors", DEPLETION_MORS);
                RegionalMobs.registerEffect("weakness_mors", WEAKNESS_MORS);
                RegionalMobs.registerEffect("fatigue_mors", FATIGUE_MORS);

                RegionalMobs.registerPotion("resistance", RESISTANCE);
                RegionalMobs.registerPotion("long_resistance", LONG_RESISTANCE);
                RegionalMobs.registerPotion("strong_resistance", STRONG_RESISTANCE);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, RegionalItems.LUSH_SILK,
                                RESISTANCE);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(RESISTANCE, Items.REDSTONE, LONG_RESISTANCE);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(RESISTANCE, Items.GLOWSTONE_DUST,
                                STRONG_RESISTANCE);

                RegionalMobs.registerPotion("submission", SUBMISSION_POTION);
                RegionalMobs.registerPotion("long_submission", LONG_SUBMISSION);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(RESISTANCE, Items.FERMENTED_SPIDER_EYE,
                                SUBMISSION_POTION);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(SUBMISSION_POTION, Items.REDSTONE,
                                LONG_SUBMISSION);

                RegionalMobs.registerPotion("aggression", AGGRESSION_POTION);
                RegionalMobs.registerPotion("long_aggression", LONG_AGGRESSION);
                RegionalMobs.registerPotion("strong_aggression", STRONG_AGGRESSION);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, RegionalItems.DESERT_SILK,
                                AGGRESSION_POTION);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(AGGRESSION_POTION, Items.REDSTONE,
                                LONG_AGGRESSION);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(AGGRESSION_POTION, Items.GLOWSTONE_DUST,
                                STRONG_AGGRESSION);

                RegionalMobs.registerPotion("kindness", KINDNESS_POTION);
                RegionalMobs.registerPotion("long_kindness", LONG_KINDNESS);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(AGGRESSION_POTION, Items.FERMENTED_SPIDER_EYE,
                                KINDNESS_POTION);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(KINDNESS_POTION, Items.REDSTONE,
                                LONG_KINDNESS);

                RegionalMobs.registerPotion("haste", HASTE);
                RegionalMobs.registerPotion("long_haste", LONG_HASTE);
                RegionalMobs.registerPotion("strong_haste", STRONG_HASTE);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, RegionalItems.ARCTIC_SILK,
                                HASTE);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(HASTE, Items.REDSTONE, LONG_HASTE);
                BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(HASTE, Items.GLOWSTONE_DUST, STRONG_HASTE);
        }
}
