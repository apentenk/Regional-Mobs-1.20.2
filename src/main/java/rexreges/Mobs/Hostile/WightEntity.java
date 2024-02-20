package rexreges.Mobs.Hostile;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import rexreges.StatusEffects.RegionalStatusEffects;

public class WightEntity extends RegionalZombieEntity{
    public static final String TEXTURE = "textures/entity/wight.png";

    public WightEntity(EntityType<? extends RegionalZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    public static boolean canSpawn(EntityType<HuskEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        BlockPos blockPos = pos;
        while (world.getBlockState(blockPos = blockPos.up()).isOf(Blocks.POWDER_SNOW)) {
        }
        return RegionalZombieEntity.canSpawnInDark(type, world, spawnReason, pos, random) && (spawnReason == SpawnReason.SPAWNER || world.isSkyVisible(blockPos.down()));
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean bl = super.tryAttack(target);
        if (bl && target instanceof LivingEntity) {
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(RegionalStatusEffects.FATIGUE, 200), this);
        }
        return bl;
    }

    @Override
    protected boolean burnsInDaylight() {
        return true;
    }

}
