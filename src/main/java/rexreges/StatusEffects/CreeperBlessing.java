package rexreges.StatusEffects;

import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;

public class CreeperBlessing extends StatusEffect {
    private final StatusEffectInstance blessing;

    protected CreeperBlessing(int color, StatusEffect effect) {
        super(StatusEffectCategory.NEUTRAL, color);
        this.blessing = new StatusEffectInstance(effect, 4800);
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        if(target instanceof HostileEntity){
            if(target.isUndead()){
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE));
            }else{
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH));
            }
            target.addStatusEffect(blessing, source);
        }
    }

    @Override
    public boolean isInstant() {
        return true;
    }
    
}
