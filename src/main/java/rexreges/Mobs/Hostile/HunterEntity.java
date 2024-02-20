package rexreges.Mobs.Hostile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.world.World;
import rexreges.StatusEffects.RegionalStatusEffects;

public class HunterEntity extends RegionalCreeperEntity{
    public static final String TEXTURE = "textures/entity/hunter.png";
    public HunterEntity(EntityType<? extends RegionalCreeperEntity> entityType, World world) {
        super(entityType, world, new StatusEffectInstance(RegionalStatusEffects.HUNTER_BLESSING));
    }
}
