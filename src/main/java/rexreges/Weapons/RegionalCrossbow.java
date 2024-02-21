package rexreges.Weapons;

import java.util.List;

import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.CrossbowUser;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import rexreges.RegionalMobs;
import rexreges.Enchantments.RegionalEnchantments;
import rexreges.mixin.CrossbowAccessor;

public class RegionalCrossbow extends CrossbowItem{
    private final float damage;
    private final int enchantability;
    private final Ingredient repair;
    private final boolean upgrade;
    private final boolean alloy;
    private final StatusEffect bonusOne;
    private final StatusEffect bonusTwo;
    @SuppressWarnings("unused")
    private boolean charged = false;
    @SuppressWarnings("unused")
    private boolean loaded = false;

    public RegionalCrossbow(ToolMaterial material, float damage,
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

    public RegionalCrossbow(ToolMaterial material, float damage, Item repair,
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

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (CrossbowItem.isCharged(itemStack)) {
            shootAll(world, user, hand, itemStack, 5, 1.0f, this.damage, user.isSneaking());
            CrossbowItem.setCharged(itemStack, false);
            return TypedActionResult.consume(itemStack);
        }
        if (!user.getProjectileType(itemStack).isEmpty()) {
            if (!CrossbowItem.isCharged(itemStack)) {
                this.charged = false;
                this.loaded = false;
                user.setCurrentHand(hand);
            }
            return TypedActionResult.consume(itemStack);
        }
        return TypedActionResult.fail(itemStack);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        int i = this.getMaxUseTime(stack) - remainingUseTicks;
        float f = getPullProgress(i, stack, user);
        if (f >= 1.0f && !CrossbowItem.isCharged(stack) && CrossbowAccessor.invokeLoadProjectiles(user, stack)) {
            CrossbowItem.setCharged(stack, true);
            SoundCategory soundCategory = user instanceof PlayerEntity ? SoundCategory.PLAYERS : SoundCategory.HOSTILE;
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_CROSSBOW_LOADING_END,
                    soundCategory, 1.0f, 1.0f / (world.getRandom().nextFloat() * 0.5f + 1.0f) + 0.2f);
        }
    }

    public static float getPullProgress(int useTicks, ItemStack stack, LivingEntity user) {
        float f;
        if(user.hasStatusEffect(StatusEffects.HASTE)){
            f = ((float)useTicks +15) / (float) RegionalCrossbow.getPullTime(stack);
        }else{
            f = ((float) useTicks)/ (float) RegionalCrossbow.getPullTime(stack);
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return f;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return RegionalCrossbow.getPullTime(stack) + 3;
    }

    public static int getPullTime(ItemStack stack) {
        int i = EnchantmentHelper.getLevel(Enchantments.QUICK_CHARGE, stack);
        return i == 0 ? 45 : 45 - 5 * i;
    }

    public static void shootAll(World world, LivingEntity entity, Hand hand, ItemStack stack, float speed,
            float divergence, float damage, boolean crit) {
        List<ItemStack> list = CrossbowAccessor.invokeGetProjectiles(stack);
        float[] fs = CrossbowAccessor.invokeGetSoundPitches(entity.getRandom());
        for (int i = 0; i < list.size(); ++i) {
            boolean bl;
            ItemStack itemStack = list.get(i);
            bl = entity instanceof PlayerEntity && ((PlayerEntity) entity).getAbilities().creativeMode;
            if (itemStack.isEmpty())
                continue;
            if (i == 0) {
                shoot(world, entity, hand, stack, itemStack, fs[i], bl, crit, speed, divergence, damage, 0.0f);
                continue;
            }
            if (i == 1) {
                shoot(world, entity, hand, stack, itemStack, fs[i], bl, crit, speed, divergence, damage, -10.0f);
                continue;
            }
            if (i != 2)
                continue;
            shoot(world, entity, hand, stack, itemStack, fs[i], bl, crit, speed, divergence, damage, 10.0f);
        }
        CrossbowAccessor.invokePostShoot(world, entity, stack);
    }

    private static void shoot(World world, LivingEntity shooter, Hand hand, ItemStack crossbow, ItemStack projectile,
            float soundPitch, boolean creative, boolean crit, float speed, float divergence, float damage, float simulated) {
        ProjectileEntity projectileEntity;
        if (world.isClient) {
            return;
        }
        boolean bl = projectile.isOf(Items.FIREWORK_ROCKET);
        if (bl) {
            projectileEntity = new FireworkRocketEntity(world, projectile, shooter, shooter.getX(),
                    shooter.getEyeY() - (double) 0.15f, shooter.getZ(), true);
        } else {
            projectileEntity = createArrow(world, shooter, crossbow, projectile, damage,crit);
            if (creative || simulated != 0.0f) {
                ((PersistentProjectileEntity) projectileEntity).pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
            }
        }
        if (shooter instanceof CrossbowUser) {
            CrossbowUser crossbowUser = (CrossbowUser) ((Object) shooter);
            crossbowUser.shoot(crossbowUser.getTarget(), crossbow, projectileEntity, simulated);
        } else {
            Vec3d vec3d = shooter.getOppositeRotationVector(1.0f);
            Quaternionf quaternionf = new Quaternionf().setAngleAxis((double) (simulated * ((float) Math.PI / 180)),
                    vec3d.x, vec3d.y, vec3d.z);
            Vec3d vec3d2 = shooter.getRotationVec(1.0f);
            Vector3f vector3f = vec3d2.toVector3f().rotate(quaternionf);
            projectileEntity.setVelocity(vector3f.x(), vector3f.y(), vector3f.z(), speed, divergence);
        }
        crossbow.damage(bl ? 3 : 1, shooter, e -> e.sendToolBreakStatus(hand));
        world.spawnEntity(projectileEntity);
        world.playSound(null, shooter.getX(), shooter.getY(), shooter.getZ(), SoundEvents.ITEM_CROSSBOW_SHOOT,
                SoundCategory.PLAYERS, 1.0f, soundPitch);
    }

    private static PersistentProjectileEntity createArrow(World world, LivingEntity entity, ItemStack crossbow,
            ItemStack arrow, float damage, boolean crit) {
        RegionalCrossbow bow = (RegionalCrossbow)crossbow.getItem();
        PersistentProjectileEntity persistentProjectileEntity = RegionalArrowEntity.createArrow(world, arrow, entity,
             bow.getDamage(), crit,bow.upgrade, bow.alloy, bow.bonusOne, bow.bonusTwo);
        persistentProjectileEntity.setSound(SoundEvents.ITEM_CROSSBOW_HIT);
        persistentProjectileEntity.setShotFromCrossbow(true);
        int j;
        if ((j = EnchantmentHelper.getLevel((RegionalEnchantments.WEIGHT), crossbow)) > 0) {
            persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() + (j * 0.1f) + 0.1f);
        }
        int i = EnchantmentHelper.getLevel(Enchantments.PIERCING, crossbow);
        if (i > 0) {
            persistentProjectileEntity.setPierceLevel((byte) i);
        }
        return persistentProjectileEntity;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("Fired Arrow:").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(RegionalMobs.formatNumberToolTip(this.damage * 5) + " Damage")
                .formatted(Formatting.DARK_GREEN));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
