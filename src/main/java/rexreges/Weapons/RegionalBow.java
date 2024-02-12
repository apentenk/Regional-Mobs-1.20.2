package rexreges.Weapons;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import rexreges.RegionalMobs;

public class RegionalBow extends BowItem {
    private final float damage;
    private final int enchantability;
    private final Ingredient repair;
    private final boolean upgrade;
    private final boolean alloy;
    private final StatusEffect bonusOne;
    private final StatusEffect bonusTwo;

    public RegionalBow(ToolMaterial material, float damage,
            Settings settings) {
        super(settings.maxDamage(material.getDurability()));
        this.damage = damage;
        this.enchantability = material.getEnchantability();
        this.repair = material.getRepairIngredient();
        this.upgrade = false;
        this.alloy = false;
        this.bonusOne = null;
        this.bonusTwo = null;
    }

    public RegionalBow(ToolMaterial material, float damage, Item repair,
            Settings settings, boolean upgrade, boolean alloy, StatusEffect bonusOne, StatusEffect bonusTwo) {
        super(settings.maxDamage(material.getDurability()));
        this.damage = damage;
        this.enchantability = material.getEnchantability();
        this.repair = Ingredient.ofItems(repair);
        this.upgrade = upgrade;
        this.alloy = alloy;
        this.bonusOne = bonusOne;
        this.bonusTwo = bonusTwo;
    }

    public Ingredient getRepair() {
        return repair;
    }

    public int getEnchantability() {
        return enchantability;
    }

    public float getDamage() {
        return damage;
    }

    public float progress(int useTicks, ItemStack stack, LivingEntity user) {
        if (user.hasStatusEffect(StatusEffects.HASTE)) {
            return ((float) useTicks) / 10.0F;
        } else {
            return ((float) useTicks) / 20.0F;
        }
    }

    public float pullProgress(int useTicks, ItemStack stack, LivingEntity user) {
        float f = progress(useTicks, stack, user);
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        boolean bl2;

        float f;
        if (!(user instanceof PlayerEntity)) {
            return;
        }
        PlayerEntity playerEntity = (PlayerEntity) user;
        boolean bl = playerEntity.getAbilities().creativeMode
                || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
        ItemStack itemStack = playerEntity.getProjectileType(stack);
        if (itemStack.isEmpty() && !bl) {
            return;
        }
        if (itemStack.isEmpty()) {
            itemStack = new ItemStack(Items.ARROW);
        }
        if ((double) (f = pullProgress(this.getMaxUseTime(stack) - remainingUseTicks, stack, user)) < 0.1) {
            return;
        }
        bl2 = bl && itemStack.isOf(Items.ARROW);
        if (!world.isClient) {
            int k;
            int j;
            PersistentProjectileEntity persistentProjectileEntity = RegionalArrowEntity.createArrow(world, itemStack,
                    playerEntity, this.damage, playerEntity.isSneaking(), this.upgrade, this.alloy, this.bonusOne, this.bonusTwo);
            persistentProjectileEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0f,
                    1, 1.0f);
            Vec3d velocity = persistentProjectileEntity.getVelocity().normalize();
            persistentProjectileEntity.setVelocity(velocity.x, velocity.y, velocity.z, f * 4.0f, 0);
            if ((j = EnchantmentHelper.getLevel(Enchantments.POWER, stack)) > 0) {
                persistentProjectileEntity
                        .setDamage(persistentProjectileEntity.getDamage() + ((double) j * 0.125f + 0.125f));
            }
            if ((k = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack)) > 0) {
                persistentProjectileEntity.setPunch(k);
            }
            if (EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0) {
                persistentProjectileEntity.setOnFireFor(100);
            }
            stack.damage(1, playerEntity, p -> p.sendToolBreakStatus(playerEntity.getActiveHand()));
            if (bl2 || playerEntity.getAbilities().creativeMode
                    && (itemStack.isOf(Items.SPECTRAL_ARROW) || itemStack.isOf(Items.TIPPED_ARROW))) {
                persistentProjectileEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
            }
            world.spawnEntity(persistentProjectileEntity);
        }
        world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(),
                SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0f,
                1.0f / (world.getRandom().nextFloat() * 0.4f + 1.2f) + f * 0.5f);
        if (!bl2 && !playerEntity.getAbilities().creativeMode) {
            itemStack.decrement(1);
            if (itemStack.isEmpty()) {
                playerEntity.getInventory().removeOne(itemStack);
            }
        }
        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("Fired Arrow:").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(RegionalMobs.formatNumberToolTip(this.damage * 3) + " Damage")
                .formatted(Formatting.DARK_GREEN));
        super.appendTooltip(stack, world, tooltip, context);
    }
}