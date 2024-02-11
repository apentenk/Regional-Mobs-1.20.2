package rexreges.Tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RegionalSwordItem extends SwordItem implements RegionalToolItem {
    private final boolean upgrade;
    private final StatusEffect bonusOne;
    private final StatusEffect bonusTwo;

    public RegionalSwordItem(SwordItem base, Settings settings, boolean upgrade, StatusEffect bonusOne,
            StatusEffect bonusTwo) {
        super(base.getMaterial(), (int) base.getAttackDamage(), -2.4f, settings);
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
            this.critBonus(attacker, bonusTwo);
        }
        return hit;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.getHardness(world, pos) != 0.0f) {
            if (state.isIn(BlockTags.SWORD_EFFICIENT)) {
                stack.damage(1, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                if (upgrade) {
                    critBonus(miner, bonusTwo);
                }
            } else {
                stack.damage(2, miner, e -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
            }
        }
        return true;
    }

}
