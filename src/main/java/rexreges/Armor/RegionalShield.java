package rexreges.Armor;

import java.util.List;
import java.util.UUID;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import rexreges.RegionalMobs;

public class RegionalShield extends ShieldItem {
    private final Ingredient repair;
    private final String texture;
    private final float damage;
    protected final UUID SHIELD_KNOCKBACK = UUID.fromString("a62104a6-53a4-448d-8900-b1ae0c4a7b3c");
    private final boolean upgrade;
    private final boolean alloy;
    private final StatusEffect bonusOne;
    private final StatusEffect bonusTwo;

    public RegionalShield(ToolMaterial material, String texture,
            Settings settings) {
        this(material, material.getRepairIngredient(), texture, settings, false, false, StatusEffects.GLOWING,
                StatusEffects.GLOWING);
    }

    public RegionalShield(ToolMaterial material, Ingredient repair, String texture,
            Settings settings, boolean upgrade, boolean alloy, StatusEffect bonusOne, StatusEffect bonusTwo) {
        super(settings.maxDamage(material.getDurability()));
        this.repair = repair;
        this.damage = material.getAttackDamage();
        this.texture = texture;
        this.upgrade = upgrade;
        this.alloy = alloy;
        this.bonusOne = bonusOne;
        this.bonusTwo = bonusTwo;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        int parry = 0;
        if (!world.isClient()) {
            if (user.getAttacker() != null && user instanceof PlayerEntity) {
                if (Math.abs(user.age - user.getLastAttackedTime()) < 10) {
                    LivingEntity entity = user.getAttacker();
                    entity.takeKnockback(0.33f, MathHelper.sin(user.getYaw() * ((float) Math.PI / 180)),
                            -MathHelper.cos(user.getYaw() * ((float) Math.PI / 180)));
                    if (entity.damage((user.getDamageSources().playerAttack((PlayerEntity) user)), this.damage)) {
                        if (upgrade) {
                            user.addStatusEffect(new StatusEffectInstance(bonusOne, 200, 0, false, false, true));
                        } else if (alloy) {
                            int duration = bonusOne.equals(StatusEffects.SATURATION) ? 1 : 200;
                            user.addStatusEffect(new StatusEffectInstance(bonusOne, duration, 0, false, false, true));
                            user.addStatusEffect(new StatusEffectInstance(bonusTwo, 200, 0, false, false, true));
                        }
                    }
                    parry = 40;
                }
            }
            ((PlayerEntity) user).getItemCooldownManager().set(stack.getItem(), (int) (80 - parry));
        }
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient) {
            float f = (float) (stack.getMaxUseTime() - remainingUseTicks);
            if (f > 30 && user instanceof PlayerEntity) {
                ((PlayerEntity) user).getItemCooldownManager().set(stack.getItem(), (int) (80));
                user.clearActiveItem();
            }
        }
    }

    public Ingredient getRepairIngredient() {
        return this.repair;
    }

    public String getTexture(boolean pattern) {
        if (pattern) {
            return ("block/" + this.texture + "");
        } else {
            return ("block/" + this.texture + "_nopattern");
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(""));
        tooltip.add(Text.translatable("Parry Damage:").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable(RegionalMobs.formatNumberToolTip(this.damage))
                .formatted(Formatting.BLUE));
        super.appendTooltip(stack, world, tooltip, context);
    }
}