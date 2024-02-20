package rexreges.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.tag.DamageTypeTags;
import rexreges.StatusEffects.RegionalStatusEffects;

@Mixin(LivingEntity.class)
public class SubmissionMixin {
    LivingEntity thisEntity = ((LivingEntity) (Object) this);

    @ModifyVariable(method = "modifyAppliedDamage", at = @At("HEAD"))
    private float calculateSubmission(float amount, DamageSource source) {
        if (!source.isIn(DamageTypeTags.BYPASSES_RESISTANCE)) {
            if(thisEntity.hasStatusEffect(RegionalStatusEffects.PLAGUED)){
                amount *= 1.15f;
            }
            if (thisEntity.hasStatusEffect(RegionalStatusEffects.SUBMISSION)) {
                amount *= (float) 1f
                        + ((thisEntity.getStatusEffect(RegionalStatusEffects.SUBMISSION).getAmplifier() + 1f)
                                * 0.15f);
            }
            if (thisEntity.hasStatusEffect(RegionalStatusEffects.SUBMISSION_MORS)) {
                amount *= (float) 1f + 0.075f;
            }
            if (thisEntity.hasStatusEffect(RegionalStatusEffects.RESITANCE_VITA)) {
                amount *= 0.9f;
            }
        }
        return amount;
    }

}
