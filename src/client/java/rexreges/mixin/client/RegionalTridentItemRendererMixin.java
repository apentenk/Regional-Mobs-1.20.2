package rexreges.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.ItemStack;
import rexreges.RegionalMobs;
import rexreges.Weapons.RegionalTrident;

@Mixin(ItemRenderer.class)
public class RegionalTridentItemRendererMixin {

    @Shadow
    private ItemModels models;

    @ModifyVariable(method = "renderItem", at = @At("STORE"))
    private BakedModel changeInventoryModel(BakedModel model, ItemStack stack) {
        if (stack.getItem() instanceof RegionalTrident) {
            String variant = "inventory";
            RegionalTrident trident = (RegionalTrident) stack.getItem();
            return models.getModelManager()
                    .getModel(new ModelIdentifier(RegionalMobs.MOD_ID, trident.getTrident(), variant));
        }
        return model;
    }

}
