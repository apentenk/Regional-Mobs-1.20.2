package rexreges.Mobs.Hostile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.world.World;
import rexreges.StatusEffects.RegionalStatusEffects;

public class StalkerEntity extends RegionalCreeperEntity{
    public static final String TEXTURE = "textures/entity/stalker.png";

    public StalkerEntity(EntityType<? extends RegionalCreeperEntity> entityType, World world) {
        super(entityType, world, new StatusEffectInstance(RegionalStatusEffects.STALKER_BLESSING));
    }
    
}
