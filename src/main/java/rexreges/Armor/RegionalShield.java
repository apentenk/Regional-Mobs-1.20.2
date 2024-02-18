package rexreges.Armor;

import java.util.List;
import java.util.UUID;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
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
import rexreges.Tools.RegionalToolItem;

public class RegionalShield extends ShieldItem {
    private final Ingredient repair;
    private final String texture;
    private final float damage;
    protected final UUID SHIELD_KNOCKBACK = UUID.fromString("a62104a6-53a4-448d-8900-b1ae0c4a7b3c");
    private boolean canParry = false;
    private final boolean upgrade;
    private final StatusEffect bonusOne;
    private final StatusEffect bonusTwo;

    public RegionalShield(ToolMaterial material, String texture,
            Settings settings) {
        this(material, material.getRepairIngredient(), texture, settings, false, StatusEffects.GLOWING,
                StatusEffects.GLOWING);
    }

    public RegionalShield(ToolMaterial material, Ingredient repair, String texture,
            Settings settings, boolean upgrade, StatusEffect bonusOne, StatusEffect bonusTwo) {
        super(settings.maxDamage(material.getDurability()));
        this.repair = repair;
        this.damage = material.getAttackDamage();
        this.texture = texture;
        this.upgrade = upgrade;
        this.bonusOne = bonusOne;
        this.bonusTwo = bonusTwo;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        this.canParry = false;
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    public boolean parry(PlayerEntity user, LivingEntity entity) {
        if (entity.equals(user.getAttacker()) && user.age - user.getLastAttackedTime() < 20 && canParry) {
            entity.takeKnockback(0.5f, MathHelper.sin(user.getYaw() * ((float) Math.PI / 180)),
                    -MathHelper.cos(user.getYaw() * ((float) Math.PI / 180)));
            if (entity.damage(user.getDamageSources().playerAttack(user), this.damage) && this.upgrade) {
                RegionalToolItem.critBonus(user, bonusTwo);
            }
            this.canParry = false;
            return true;
        }
        return false;
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient) {
            float f = (float) (stack.getMaxUseTime() - remainingUseTicks);
            if (f < 500 && f > 0) {
                this.canParry = true;
            } else {
                this.canParry = false;
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (this.bonusOne != StatusEffects.GLOWING) {
            if (upgrade) {
                RegionalToolItem.updateToolBonus(world, entity, selected, bonusOne, 0);
            } else {
                RegionalToolItem.updateToolBonus(world, entity, selected, bonusOne, bonusTwo, 0);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);

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