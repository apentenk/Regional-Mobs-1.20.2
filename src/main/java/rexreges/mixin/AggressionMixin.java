package rexreges.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import rexreges.StatusEffects.RegionalStatusEffects;

@Mixin(LivingEntity.class)
public class AggressionMixin {
    
    @ModifyVariable(method = "damage", at = @At("HEAD"))
    private float modifyDamage(float amount, DamageSource source){
        float f = amount;
        if (source.getSource() instanceof LivingEntity){
            LivingEntity entity = (LivingEntity)source.getSource();
            if(entity.hasStatusEffect(RegionalStatusEffects.SEARED)){
                f *= 0.85f;
            }
            if (entity.hasStatusEffect(RegionalStatusEffects.AGGRESSION)){
                f *= 1 + ((entity.getStatusEffect(RegionalStatusEffects.AGGRESSION).getAmplifier() +1) *0.2f);
            }

            if (entity.hasStatusEffect(RegionalStatusEffects.KINDNESS)){
                f *= 1 - ((entity.getStatusEffect(RegionalStatusEffects.KINDNESS).getAmplifier() + 1f) * 0.15f);
            }
            if (entity.hasStatusEffect(RegionalStatusEffects.AGGRESSION_VITA)){
                f *= (1 + 0.1f);          
            }
            if (entity.hasStatusEffect(RegionalStatusEffects.KINDNESS_MORS)){
                f *= (1 - 0.075f);
            }
        }
        return f;
    }
}
