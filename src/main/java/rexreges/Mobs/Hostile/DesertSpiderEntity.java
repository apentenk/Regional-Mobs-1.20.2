package rexreges.Mobs.Hostile;

import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CaveSpiderEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public class DesertSpiderEntity extends RegionalSpiderEntity {
    public static final String TEXTURE = "textures/entity/desert_spider.png";
    public static final String EYE_TEXTURE = "textures/entity/desert_spider_eyes.png";

    public DesertSpiderEntity(EntityType<? extends CaveSpiderEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, -1));
        return entityData;
    }
}
