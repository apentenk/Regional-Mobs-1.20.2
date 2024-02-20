package rexreges.StatusEffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class AbsorptionVita extends StatusEffect {


    protected AbsorptionVita() {
        super(StatusEffectCategory.BENEFICIAL, 0x2552A5);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        if (entity.getAbsorptionAmount() <= 0.0f && !entity.getWorld().isClient) {
            entity.removeStatusEffect(this);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        super.onApplied(entity, amplifier);
        entity.setAbsorptionAmount(Math.max(entity.getAbsorptionAmount(), (float)(2 * (1 + amplifier))));
    }
    
}
