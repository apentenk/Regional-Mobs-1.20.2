package rexreges.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import rexreges.Weapons.RegionalTrident;

@Mixin(BuiltinModelItemRenderer.class)
public class BuiltinTridentRenderMixin {
    @Shadow
    private TridentEntityModel modelTrident;

    @ModifyVariable(method = "render", at = @At("STORE"))
    private VertexConsumer changeLayer(VertexConsumer vertexConsumer2, ItemStack stack, ModelTransformationMode mode,
            MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.getItem() instanceof RegionalTrident) {
            RegionalTrident trident = (RegionalTrident) stack.getItem();
            return ItemRenderer.getDirectItemGlintConsumer(vertexConsumers,
                    modelTrident.getLayer(new Identifier(trident.getTexture())), false, stack.hasGlint());
        }
        return vertexConsumer2;
    }
}
