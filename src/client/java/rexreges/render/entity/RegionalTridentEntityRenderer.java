package rexreges.render.entity;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import rexreges.Weapons.RegionalTridentEntity;

public class RegionalTridentEntityRenderer extends EntityRenderer<RegionalTridentEntity> {
    private TridentEntityModel model;
    private String texture;

    public RegionalTridentEntityRenderer(EntityRendererFactory.Context context, String texture) {
        super(context);
        this.model = new TridentEntityModel(context.getPart(EntityModelLayers.TRIDENT));
        this.texture = texture;
    }

    @Override
    public void render(RegionalTridentEntity tridentEntity, float f, float g, MatrixStack matrixStack,
            VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(
                MathHelper.lerp((float) g, (float) tridentEntity.prevYaw, (float) tridentEntity.getYaw()) - 90.0f));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(
                MathHelper.lerp((float) g, (float) tridentEntity.prevPitch, (float) tridentEntity.getPitch()) + 90.0f));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider,
                this.model.getLayer(this.getTexture(tridentEntity)), false, tridentEntity.isEnchanted());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        matrixStack.pop();
        super.render(tridentEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(RegionalTridentEntity entity) {
        return new Identifier(this.texture);
    }

}
