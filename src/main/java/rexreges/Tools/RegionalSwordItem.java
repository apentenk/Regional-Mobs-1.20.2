package rexreges.Tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RegionalSwordItem extends SwordItem {
    private final boolean upgrade;
    private final StatusEffect bonusOne;
    private final StatusEffect bonusTwo;

    public RegionalSwordItem(SwordItem base, Settings settings, boolean upgrade, StatusEffect bonusOne,
            StatusEffect bonusTwo) {
        super(base.getMaterial(), (int) (base.getAttackDamage() - base.getMaterial().getAttackDamage()), -2.4f,
                settings);
        this.upgrade = upgrade;
        this.bonusOne = bonusOne;
        this.bonusTwo = bonusTwo;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean hit = super.postHit(stack, target, attacker);
        if (hit && RegionalToolItem.isCritial(attacker)) {
            attacker.addStatusEffect(new StatusEffectInstance(bonusOne, 200, 0, false, false, true));
            if (!upgrade) {
                attacker.addStatusEffect(new StatusEffectInstance(bonusTwo, 200, 0, false, false, true));
            }
        }
        return hit;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.getHardness(world, pos) != 0.0f) {
            if (state.isIn(BlockTags.SWORD_EFFICIENT)) {
                stack.damage(1, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                miner.addStatusEffect(new StatusEffectInstance(bonusOne, 200, 0, false, false, true));
                if (!upgrade) {
                    miner.addStatusEffect(new StatusEffectInstance(bonusTwo, 200, 0, false, false, true));
                }
            } else {
                stack.damage(2, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
            }
        }
        return true;
    }

}
