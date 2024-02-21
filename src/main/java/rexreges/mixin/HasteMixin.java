package rexreges.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.player.PlayerEntity;
import rexreges.StatusEffects.RegionalStatusEffects;

@Mixin(PlayerEntity.class)
public class HasteMixin {
    @Inject(method = "getBlockBreakingSpeed", at = @At("RETURN"), cancellable = true)
    private void calculateHaste(CallbackInfoReturnable<Float> cir) {
        float amp;
        PlayerEntity entity = (PlayerEntity) ((Object) this);
        if (entity.hasStatusEffect(RegionalStatusEffects.VIGOR)){
            amp = entity.getStatusEffect(RegionalStatusEffects.FATIGUE).getAmplifier();
            cir.setReturnValue(cir.getReturnValue() * (1.0f +((amp+1)*025)));
        }
        if (entity.hasStatusEffect(RegionalStatusEffects.VIGOR_VITA)) {
            cir.setReturnValue(cir.getReturnValue() * (1.0f + 0.1f));
            cir.setReturnValue(cir.getReturnValue() * 10);
        }
        if (entity.hasStatusEffect(RegionalStatusEffects.FATIGUE)) {
            amp = entity.getStatusEffect(RegionalStatusEffects.FATIGUE).getAmplifier();
            cir.setReturnValue(cir.getReturnValue() * (1.0f + ((amp + 1) * 0.2f)));
        }
        if (entity.hasStatusEffect(RegionalStatusEffects.FATIGUE_MORS)) {
            cir.setReturnValue(cir.getReturnValue() * (1.0f - 0.1f));
        }
    }
}
