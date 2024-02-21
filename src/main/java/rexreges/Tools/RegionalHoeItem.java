package rexreges.Tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RegionalHoeItem extends HoeItem{
    private final boolean upgrade;
    private final StatusEffect bonusOne;
    private final StatusEffect bonusTwo;


    public RegionalHoeItem(HoeItem base, Settings settings, boolean upgrade, StatusEffect bonusOne, StatusEffect bonusTwo) {
        super(base.getMaterial(), (int)(base.getAttackDamage() - base.getMaterial().getAttackDamage()), 0, settings);
        this.upgrade = upgrade;
        this.bonusOne = bonusOne;
        this.bonusTwo = bonusTwo;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean hit = super.postHit(stack, target, attacker);
        if (hit && RegionalToolItem.isCritial(attacker)) {
            attacker.addStatusEffect(new StatusEffectInstance(bonusOne, 200, 0,false,false, true));
            if(!upgrade){
                attacker.addStatusEffect(new StatusEffectInstance(bonusTwo, 200, 0,false,false, true));
            }
        }
        return hit;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        boolean mine = super.postMine(stack, world, state, pos, miner);
        if (mine) {
            miner.addStatusEffect(new StatusEffectInstance(bonusOne, 200, 0,false,false, true));
            if(!upgrade){
                miner.addStatusEffect(new StatusEffectInstance(bonusTwo, 200, 0,false,false, true));
            }
        }
        return mine;
    }
}
