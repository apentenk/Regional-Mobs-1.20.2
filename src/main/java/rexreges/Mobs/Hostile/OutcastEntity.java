package rexreges.Mobs.Hostile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import rexreges.StatusEffects.RegionalStatusEffects;

public class OutcastEntity extends RegionalSkeletonEntity{
    public static final String TEXTURE = "textures/entity/outcast.png";
    public static final String OVERLAY_TEXTURE = "textures/entity/outcast_overlay.png";

    public OutcastEntity(EntityType<? extends RegionalSkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected PersistentProjectileEntity createArrowProjectile(ItemStack arrow, float damageModifier) {
        PersistentProjectileEntity persistentProjectileEntity = super.createArrowProjectile(arrow, damageModifier);
        if (persistentProjectileEntity instanceof ArrowEntity) {
            ((ArrowEntity)persistentProjectileEntity).addEffect(new StatusEffectInstance(RegionalStatusEffects.SUBMISSION, 300));
        }
        return persistentProjectileEntity;
    }
}
