package rexreges.Mobs.Hostile;

import org.joml.Vector3f;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import rexreges.StatusEffects.RegionalStatusEffects;

public class TillagerEntity extends RegionalPillagerEntity{
    public static final String TEXTURE = "textures/entity/tillager.png";

    public TillagerEntity(EntityType<? extends RegionalPillagerEntity> entityType, World world) {
        super(entityType, world);
    }
    
    @Override
    public void shoot(LivingEntity entity, LivingEntity target, ProjectileEntity projectile, float multishotSpray, float speed) {
        double d = target.getX() - entity.getX();
        double e = target.getZ() - entity.getZ();
        double f = Math.sqrt(d * d + e * e);
        double g = target.getBodyY(0.3333333333333333) - projectile.getY() + f * (double)0.2f;
        Vector3f vector3f = this.getProjectileLaunchVelocity(entity, new Vec3d(d, g, e), multishotSpray);
        projectile.setVelocity(vector3f.x(), vector3f.y(), vector3f.z(), speed, 14 - entity.getWorld().getDifficulty().getId() * 4);
        ((ArrowEntity)projectile).addEffect(new StatusEffectInstance(RegionalStatusEffects.PLAGUED, 200));
        entity.playSound(SoundEvents.ITEM_CROSSBOW_SHOOT, 1.0f, 1.0f / (entity.getRandom().nextFloat() * 0.4f + 0.8f));
    }
}
