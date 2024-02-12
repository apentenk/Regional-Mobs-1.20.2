package rexreges.Weapons;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.TridentItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import rexreges.Tools.RegionalToolItem;

public class RegionalTrident extends TridentItem{
        private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    private final ToolMaterial material;
    private final float attackSpeed;
    private final int enchantability;
    private final Ingredient repair;
    private final boolean upgrade;
    private final boolean alloy;
    private final StatusEffect bonusOne;
    private final StatusEffect bonusTwo;
    private final String name;
    private final EntityType<? extends RegionalTridentEntity> entityType;


    public RegionalTrident(ToolMaterial material, float attackSpeed, String name,
            EntityType<? extends RegionalTridentEntity> entityType) {
        this(material, attackSpeed, material.getRepairIngredient(), name, entityType,false, false,null,null);
    }

    public RegionalTrident(ToolMaterial material, float attackSpeed, Ingredient repair, String name,
            EntityType<? extends RegionalTridentEntity> entityType, boolean upgrade, boolean alloy, StatusEffect bonusOne, StatusEffect bonusTwo) {
        super(new Item.Settings().maxDamage(material.getDurability()));
        this.material = material;
        this.attackSpeed = attackSpeed;
        this.enchantability = material.getEnchantability();
        this.repair = repair;
        this.name = name;
        this.entityType = entityType;
        this.upgrade = upgrade;
        this.alloy = alloy;
        this.bonusOne = bonusOne;
        this.bonusTwo = bonusTwo;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID,
                "Tool modifier", material.getAttackDamage() + 4.0f, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID,
                "Tool modifier", (double) this.attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    public EntityType<? extends RegionalTridentEntity> getEntityType() {
        return this.entityType;
    }


    public ToolMaterial getMaterial() {
        return this.material;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repair;
    }

    public String getTrident() {
        return this.name;
    }

    public String getTexture() {
        return "textures/entity/" + this.name + ".png";
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!(user instanceof PlayerEntity)) {
            return;
        }
        PlayerEntity playerEntity = (PlayerEntity) user;
        float i = this.getMaxUseTime(stack) - (remainingUseTicks);
        if (i < 10) {
            return;
        }
        int j = EnchantmentHelper.getRiptide(stack);
        if (j > 0 && !playerEntity.isTouchingWaterOrRain()) {
            return;
        }
        if (!world.isClient) {
            stack.damage(1, playerEntity, p -> p.sendToolBreakStatus(user.getActiveHand()));
            if (j == 0) {
                RegionalTridentEntity tridentEntity = new RegionalTridentEntity(world, (LivingEntity) playerEntity,
                        stack, this);
                if (user.isSneaking()) {
                    tridentEntity.setCritical(true);
                }
                tridentEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0f,
                        2.5f + (float) j * 0.5f, 1.0f);
                if (playerEntity.getAbilities().creativeMode) {
                    tridentEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                }
                world.spawnEntity(tridentEntity);
                world.playSoundFromEntity(null, tridentEntity, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS,
                        1.0f, 1.0f);
                if (!playerEntity.getAbilities().creativeMode) {
                    playerEntity.getInventory().removeOne(stack);
                }
            }
        }
        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        if (j > 0) {
            float f = playerEntity.getYaw();
            float g = playerEntity.getPitch();
            float h = -MathHelper.sin(f * ((float) Math.PI / 180)) * MathHelper.cos(g * ((float) Math.PI / 180));
            float k = -MathHelper.sin(g * ((float) Math.PI / 180));
            float l = MathHelper.cos(f * ((float) Math.PI / 180)) * MathHelper.cos(g * ((float) Math.PI / 180));
            float m = MathHelper.sqrt(h * h + k * k + l * l);
            float n = 3.0f * ((1.0f + (float) j) / 4.0f);
            playerEntity.addVelocity(h *= n / m, k *= n / m, l *= n / m);
            playerEntity.useRiptide(20);
            if (playerEntity.isOnGround()) {
                // float o = 1.1999999f;
                playerEntity.move(MovementType.SELF, new Vec3d(0.0, 1.1999999284744263, 0.0));
            }
            SoundEvent soundEvent = j >= 3 ? SoundEvents.ITEM_TRIDENT_RIPTIDE_3
                    : (j == 2 ? SoundEvents.ITEM_TRIDENT_RIPTIDE_2 : SoundEvents.ITEM_TRIDENT_RIPTIDE_1);
            world.playSoundFromEntity(null, playerEntity, soundEvent, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (upgrade) {
            RegionalToolItem.updateToolBonus(world, entity, selected, bonusOne, 1);
        } else if(alloy){
            RegionalToolItem.updateToolBonus(world, entity, selected, bonusOne, bonusTwo, 0);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        if (upgrade) {
            RegionalToolItem.critBonus(attacker, bonusTwo);
        }
        return true;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return this.attributeModifiers;
        }
        return super.getAttributeModifiers(slot);
    }
}
