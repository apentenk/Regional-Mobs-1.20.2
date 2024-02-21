package rexreges.Weapons;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpectralArrowItem;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class RegionalArrowEntity extends ArrowEntity {
    private final boolean upgrade;
    private final boolean alloy;
    private final boolean crit;
    private final StatusEffect bonusOne;
    private final StatusEffect bonusTwo;
    private boolean isSpectral = false;

    public RegionalArrowEntity(World world, LivingEntity owner, boolean upgrade, boolean alloy, StatusEffect bonusOne,
            StatusEffect bonusTwo, boolean crit) {
        super(world, owner);
        this.upgrade = upgrade;
        this.alloy = alloy;
        this.crit = crit;
        this.bonusOne = bonusOne;
        this.bonusTwo = bonusTwo;
    }

    public void setSpectral(boolean spectral) {
        this.isSpectral = spectral;
    }

    public static PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter,
            float damage, boolean crit,
            boolean upgrade, boolean alloy, StatusEffect bonusOne, StatusEffect bonusTwo) {
        RegionalArrowEntity arrowEntity = new RegionalArrowEntity(world, shooter, upgrade, alloy, bonusOne, bonusTwo, crit);
        if (stack.getItem() instanceof SpectralArrowItem) {
            arrowEntity.setSpectral(true);
        }
        arrowEntity.initFromStack(stack);
        arrowEntity.setDamage(damage);
        if (crit) {
            arrowEntity.setDamage(damage * 1.5);
        }
        return arrowEntity;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (entityHitResult.getEntity() instanceof LivingEntity && this.getOwner() instanceof LivingEntity) {
            LivingEntity target = (LivingEntity) entityHitResult.getEntity();
            LivingEntity attacker = (LivingEntity) this.getOwner();
            if (isSpectral) {
                StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.GLOWING, 200, 0);
                target.addStatusEffect(statusEffectInstance, this.getEffectCause());
            }
            if (this.crit) {
                if (this.upgrade) {
                    attacker.addStatusEffect(new StatusEffectInstance(bonusOne, 200, 0,false,false, true));
                } else if(this.alloy){
                    attacker.addStatusEffect(new StatusEffectInstance(bonusOne, 200, 0,false,false, true));
                    attacker.addStatusEffect(new StatusEffectInstance(bonusTwo, 200, 0,false,false, true));
                }
                
            }
        }
    }
}
