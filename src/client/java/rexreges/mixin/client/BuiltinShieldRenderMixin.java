package rexreges.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import rexreges.Armor.RegionalShield;

@Mixin(BuiltinModelItemRenderer.class)
public class BuiltinShieldRenderMixin {
    @Shadow
    private ShieldEntityModel modelShield;

    @ModifyVariable(method = "render", at = @At("STORE"))
    private SpriteIdentifier changeLayer(SpriteIdentifier spriteIdentifier, ItemStack stack,
            ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
            int overlay) {
        if (stack.getItem() instanceof RegionalShield) {
            RegionalShield shield = (RegionalShield) stack.getItem();
            boolean bl = BlockItem.getBlockEntityNbt(stack) != null;
            SpriteIdentifier identifier = new SpriteIdentifier(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE,
                    new Identifier("minecraft", shield.getTexture(bl)));
            return identifier;
        }
        return spriteIdentifier;
    }
}
