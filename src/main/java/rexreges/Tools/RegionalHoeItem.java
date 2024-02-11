package rexreges.Tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RegionalHoeItem extends HoeItem implements RegionalToolItem{
    private final boolean upgrade;
    private final StatusEffect bonusOne;
    private final StatusEffect bonusTwo;


    public RegionalHoeItem(HoeItem base, Settings settings, boolean upgrade, StatusEffect bonusOne, StatusEffect bonusTwo) {
        super(base.getMaterial(), (int)base.getAttackDamage(), 0, settings);
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
        boolean hit = super.postHit(stack, target, attacker);
        if (hit && upgrade) {
            critBonus(attacker, bonusTwo);
        }
        return hit;
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
