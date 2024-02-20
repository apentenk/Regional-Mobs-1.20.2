package rexreges.Mobs.Hostile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;
import rexreges.StatusEffects.RegionalStatusEffects;

public class LurkerEntity extends RegionalCreeperEntity {
    public static final String TEXTURE = "textures/entity/lurker.png";

    public LurkerEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world, new StatusEffectInstance(RegionalStatusEffects.LURKER_BLESSING));
    }
    
}
