package rexreges.Weapons;

import org.jetbrains.annotations.Nullable;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RegionalTridentEntity extends TridentEntity {
    private boolean dealtDamage;
    private ItemStack tridentStack;
    private ToolMaterial material;
    private boolean isCritical = false;
    private StatusEffect bonusOne;
    private StatusEffect bonusTwo;
    private boolean upgrade;
    private boolean alloy;

    private EntityType<? extends RegionalTridentEntity> type;

    public RegionalTridentEntity(EntityType<? extends RegionalTridentEntity> entityType, World world) {
        super(entityType, world);
        setValues(getTrident(entityType));
    }

    public RegionalTridentEntity(World world, LivingEntity owner, ItemStack stack, Item trident) {
        super(world, owner, stack);
        setValues((RegionalTrident) trident);
    }

    private void setValues(RegionalTrident trident) {
        this.tridentStack = new ItemStack(trident);
        this.material = trident.getMaterial();
        this.type = trident.getEntityType();
        this.bonusOne = trident.getBonusOne();
        this.bonusTwo = trident.getBonusTwo();
        this.upgrade = trident.isUpgrade();
        this.alloy = trident.isAlloy();
    }

    private RegionalTrident getTrident(EntityType<? extends RegionalTridentEntity> entityType) {
        if (entityType.equals(RegionalTridentEntityTypes.IronTridentEntityType)) {
            return RegionalWeapons.IRON_TRIDENT;
        } else if (entityType.equals(RegionalTridentEntityTypes.RoseGoldTridentEntityType)) {
            return RegionalWeapons.ROSE_GOLD_TRIDENT;
        } else if (entityType.equals(RegionalTridentEntityTypes.AmberIronTridentEntityType)) {
            return RegionalWeapons.AMBER_IRON_TRIDENT;
        } else if (entityType.equals(RegionalTridentEntityTypes.GhostCopperTridentEntityType)) {
            return RegionalWeapons.GHOST_COPPER_TRIDENT;
        } else if (entityType.equals(RegionalTridentEntityTypes.DiamondTridentEntityType)) {
            return RegionalWeapons.DIAMOND_TRIDENT;
        } else if (entityType.equals(RegionalTridentEntityTypes.NetheriteTridentEntityType)) {
            return RegionalWeapons.NETHERITE_TRIDENT;
        } else if (entityType.equals(RegionalTridentEntityTypes.FreezingNetheriteTridentEntityType)) {
            return RegionalWeapons.FREEZING_NETHERITE_TRIDENT;
        } else if (entityType.equals(RegionalTridentEntityTypes.ScorchingNetheriteTridentEntityType)) {
            return RegionalWeapons.SCORCHING_NETHERITE_TRIDENT;
        } else if (entityType.equals(RegionalTridentEntityTypes.BloomingNetheriteTridentEntityType)) {
            return RegionalWeapons.BLOOMING_NETHERITE_TRIDENT;
        }
        return RegionalWeapons.PRISMARINE_TRIDENT;
    }

    public void setCritical(boolean bool) {
        this.isCritical = bool;
    }

    @Override
    public EntityType<?> getType() {
        return this.type;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        float f = this.material.getAttackDamage() + 4.0f;
        f *= isCritical ? 1.5f : 1f;
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            f += EnchantmentHelper.getAttackDamage(this.tridentStack, livingEntity.getGroup());
        }
        Entity entity2 = this.getOwner();
        DamageSource damageSource = this.getDamageSources().trident(this, entity2 == null ? this : entity2);
        this.dealtDamage = true;
        SoundEvent soundEvent = SoundEvents.ITEM_TRIDENT_HIT;
        if (entity.damage(damageSource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity2 = (LivingEntity) entity;
                if (entity2 instanceof LivingEntity) {
                    EnchantmentHelper.onUserDamaged(livingEntity2, entity2);
                    EnchantmentHelper.onTargetDamaged((LivingEntity) entity2, livingEntity2);
                }
                this.onHit(livingEntity2);
                if (isCritical && this.getOwner() instanceof LivingEntity) {
                    LivingEntity owner = (LivingEntity) this.getOwner();
                    if (this.upgrade) {
                        owner.addStatusEffect(new StatusEffectInstance(bonusOne, 200, 0, false, false, true));
                    } else if (this.alloy) {
                        owner.addStatusEffect(new StatusEffectInstance(bonusOne, 200, 0, false, false, true));
                        owner.addStatusEffect(new StatusEffectInstance(bonusTwo, 200, 0, false, false, true));
                    }
                }
            }
        }
        this.setVelocity(this.getVelocity().multiply(-0.01, -0.1, -0.01));
        float g = 1.0f;
        if (this.getWorld() instanceof ServerWorld && this.getWorld().isThundering() && this.hasChanneling()) {
            LightningEntity lightningEntity;
            BlockPos blockPos = entity.getBlockPos();
            if (this.getWorld().isSkyVisible(blockPos)
                    && (lightningEntity = EntityType.LIGHTNING_BOLT.create(this.getWorld())) != null) {
                lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockPos));
                lightningEntity
                        .setChanneler(entity2 instanceof ServerPlayerEntity ? (ServerPlayerEntity) entity2 : null);
                this.getWorld().spawnEntity(lightningEntity);
                soundEvent = SoundEvents.ITEM_TRIDENT_THUNDER;
                g = 5.0f;
            }
        }
        this.playSound(soundEvent, g, 1.0f);
    }

    @Override
    @Nullable
    protected EntityHitResult getEntityCollision(Vec3d currentPosition, Vec3d nextPosition) {
        if (this.dealtDamage) {
            return null;
        }
        return super.getEntityCollision(currentPosition, nextPosition);
    }
}
