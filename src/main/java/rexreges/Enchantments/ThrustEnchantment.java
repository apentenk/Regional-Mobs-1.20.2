package rexreges.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ThrustEnchantment extends Enchantment{
    
    public ThrustEnchantment() {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.TRIDENT, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }
    
    @Override
    public int getMinPower(int level) {
        return 15 + (level - 1) * 9;
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        return 1.0f + (float)Math.max(0, level - 1) * 0.5f;
    }

    public void onTargetDamaged (LivingEntity user, Entity target, int level){
        if(target instanceof LivingEntity && level >5){
            if(user.isTouchingWaterOrRain() || target.isTouchingWaterOrRain()){
                if(((LivingEntity)target).isUndead()){
                    ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,1,6));
                }else{
                    ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,1,4));
                }
            }
        }
    }
}