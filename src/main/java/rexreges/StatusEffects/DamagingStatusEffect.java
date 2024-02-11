package rexreges.StatusEffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectCategory;

public class DamagingStatusEffect extends RegionalStatusEffect {
    private final float damage;

    protected DamagingStatusEffect(int color, float damage) {
        super(StatusEffectCategory.HARMFUL, color);
        this.damage = damage;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getHealth() > 1.0f) {
            entity.damage(entity.getDamageSources().magic(), damage);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 40 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        }
        return true;
    }

}
