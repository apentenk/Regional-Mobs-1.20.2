package rexreges.Tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RegionalAxeItem extends AxeItem {
    private final boolean upgrade;
    private final StatusEffect bonusOne;
    private final StatusEffect bonusTwo;

    public RegionalAxeItem(AxeItem base, Settings settings, boolean upgrade, StatusEffect bonusOne,
            StatusEffect bonusTwo) {
        super(base.getMaterial(), base.getAttackDamage() - base.getMaterial().getAttackDamage(), -3.0f, settings);
        this.upgrade = upgrade;
        this.bonusOne = bonusOne;
        this.bonusTwo = bonusTwo;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        if (RegionalToolItem.isCritial(attacker)) {
            attacker.addStatusEffect(new StatusEffectInstance(bonusOne, 200, 0, false, false, true));
            if (!upgrade) {
                attacker.addStatusEffect(new StatusEffectInstance(bonusTwo, 200, 0, false, false, true));
            }
        }
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        boolean mine = super.postMine(stack, world, state, pos, miner);
        if (mine) {
            miner.addStatusEffect(new StatusEffectInstance(bonusOne, 200, 0, false, false, true));
            if (!upgrade) {
                miner.addStatusEffect(new StatusEffectInstance(bonusTwo, 200, 0, false, false, true));
            }
        }
        return mine;
    }

}
