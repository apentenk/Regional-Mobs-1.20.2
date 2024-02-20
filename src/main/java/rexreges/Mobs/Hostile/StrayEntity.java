package rexreges.Mobs.Hostile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StrayEntity extends RegionalSkeletonEntity{
    public static final String TEXTURE = "textures/entity/stray_regional.png";
    public static final String OVERLAY_TEXTURE = "textures/entity/stray_regional_overlay.png";

    public StrayEntity(EntityType<? extends RegionalSkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected PersistentProjectileEntity createArrowProjectile(ItemStack arrow, float damageModifier) {
        PersistentProjectileEntity persistentProjectileEntity = super.createArrowProjectile(arrow, damageModifier);
        if (persistentProjectileEntity instanceof ArrowEntity) {
            ((ArrowEntity)persistentProjectileEntity).addEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300));
        }
        return persistentProjectileEntity;
    }
}
