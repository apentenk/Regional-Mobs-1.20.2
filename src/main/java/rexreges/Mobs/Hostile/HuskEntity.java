package rexreges.Mobs.Hostile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.world.World;

public class HuskEntity extends RegionalZombieEntity{
    public static final String TEXTURE = "textures/entity/husk_regional.png";

    public HuskEntity(EntityType<? extends RegionalZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean bl = super.tryAttack(target);
        if (bl && target instanceof LivingEntity) {
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200), this);
        }
        return bl;
    }

}
