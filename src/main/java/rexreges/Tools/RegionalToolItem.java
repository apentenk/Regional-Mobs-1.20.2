package rexreges.Tools;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.world.World;

public interface RegionalToolItem {

    default void critBonus(LivingEntity entity, StatusEffect bonusOne) {
        if (isCritial(entity)) {
            if (bonusOne.equals(StatusEffects.SATURATION)) {
                entity.addStatusEffect(new StatusEffectInstance(bonusOne));
            } else {
                updateToolBonus(entity, bonusOne, 0, true);
            }
        }
    }

    default void updateToolBonus(World world, Entity entity, boolean selected, StatusEffect bonusOne, int amplifier) {
        if (!world.isClient()) {
            if (entity instanceof LivingEntity && selected) {
                LivingEntity livingEntity = (LivingEntity) entity;
                updateToolBonus(livingEntity, bonusOne, amplifier, false);
            }
        }
    }

    default void updateToolBonus(World world, Entity entity, boolean selected, StatusEffect bonusOne,
            StatusEffect bonusTwo, int amplifier) {
        if (!world.isClient()) {
            if (entity instanceof LivingEntity && selected) {
                LivingEntity livingEntity = (LivingEntity) entity;
                updateToolBonus(livingEntity, bonusOne, bonusTwo, amplifier);
            }
        }
    }

    public static void updateToolBonus(LivingEntity livingEntity, StatusEffect bonusOne, int amplifier, boolean crit) {
        if (!livingEntity.hasStatusEffect(bonusOne)
                || livingEntity.getStatusEffect(bonusOne).isDurationBelow(220)) {
            livingEntity.addStatusEffect(new StatusEffectInstance(bonusOne, 260, amplifier, false, crit, true));
        }
    }

    public static void updateToolBonus(LivingEntity livingEntity, StatusEffect bonusOne, StatusEffect bonusTwo,
            int amplifier) {
        if (!livingEntity.hasStatusEffect(bonusOne)
                || livingEntity.getStatusEffect(bonusOne).isDurationBelow(220)) {
            livingEntity.addStatusEffect(new StatusEffectInstance(bonusOne, 260, amplifier, false, false, true));
            livingEntity.addStatusEffect(new StatusEffectInstance(bonusTwo, 260, amplifier, false, false, true));

        }
        if (!livingEntity.hasStatusEffect(bonusTwo)
                || livingEntity.getStatusEffect(bonusTwo).isDurationBelow(220)) {
            livingEntity.addStatusEffect(new StatusEffectInstance(bonusOne, 260, amplifier, false, false, true));
            livingEntity.addStatusEffect(new StatusEffectInstance(bonusTwo, 260, amplifier, false, false, true));
        }
    }

    public static boolean isCritial(LivingEntity entity) {
        return (entity.fallDistance > 0.0f && !entity.isOnGround() && !entity.isClimbing() && !entity.isTouchingWater()
                && !entity.hasStatusEffect(StatusEffects.BLINDNESS) && !entity.hasVehicle());
    }
}