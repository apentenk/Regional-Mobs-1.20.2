package rexreges.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

@Mixin(LivingEntity.class)
public interface LivingEntityAccessor {
    @Accessor("activeItemStack")
    ItemStack activeItemStack();
}
