package rexreges.Tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RegionalAxeItem extends AxeItem implements RegionalToolItem {
    private final boolean upgrade;
    private final StatusEffect bonusOne;
    private final StatusEffect bonusTwo;

    public RegionalAxeItem(AxeItem base, Settings settings, boolean upgrade, StatusEffect bonusOne, StatusEffect bonusTwo) {
        super(base.getMaterial(), base.getAttackDamage(), -3.0f, settings);
        this.upgrade = upgrade;
        this.bonusOne = bonusOne;
        this.bonusTwo = bonusTwo;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (upgrade) {
            this.updateToolBonus(world, entity, selected, bonusOne, 1);
        } else {
            this.updateToolBonus(world, entity, selected, bonusOne, bonusTwo, 0);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        if (upgrade) {
            critBonus(attacker, bonusTwo);
        }
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        boolean mine = super.postMine(stack, world, state, pos, miner);
        if (mine && upgrade) {
            critBonus(miner, bonusTwo);
        }
        return mine;
    }

}
