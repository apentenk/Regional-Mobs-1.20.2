package rexreges.Mobs.Hostile;

import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.CaveSpiderEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import rexreges.StatusEffects.RegionalStatusEffects;

public class ArcticSpiderEntity extends RegionalSpiderEntity {
    public static final String TEXTURE = "textures/entity/arctic_spider.png";
    public static final String EYE_TEXTURE = "textures/entity/arctic_spider_eyes.png";

    public ArcticSpiderEntity(EntityType<? extends CaveSpiderEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.addStatusEffect(new StatusEffectInstance(RegionalStatusEffects.AGGRESSION, -1));
        return entityData;
    }
}
