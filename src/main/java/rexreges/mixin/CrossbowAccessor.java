package rexreges.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

@Mixin(CrossbowItem.class)
public interface CrossbowAccessor {
    @Invoker("getProjectiles")
    public static List<ItemStack> invokeGetProjectiles(ItemStack crossbow) {
        throw new AssertionError();
    }

    @Invoker("getSoundPitches")
    public static float[] invokeGetSoundPitches(Random random) {
        throw new AssertionError();
    }

    @Invoker("postShoot")
    public static void invokePostShoot(World world, LivingEntity entity, ItemStack stack) {
        throw new AssertionError();
    }

    @Invoker("loadProjectiles")
    public static boolean invokeLoadProjectiles(LivingEntity shooter, ItemStack crossbow) {
        throw new AssertionError();
    }
}