package rexreges.render.entity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

public class RegionalSkeletonOverlayRenderer<T extends MobEntity & RangedAttackMob , M extends EntityModel<T>>
extends FeatureRenderer<T, M> {
    private final Identifier skin;
    private final SkeletonEntityModel<T> model;

    public RegionalSkeletonOverlayRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader, String skin) {
        super(context);
        this.skin = new Identifier(skin);
        this.model = new SkeletonEntityModel<T>(loader.getModelPart(EntityModelLayers.STRAY_OUTER));
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T mobEntity, float f, float g, float h, float j, float k, float l) {
        RegionalSkeletonOverlayRenderer.render(this.getContextModel(),this.model, this.skin, matrixStack, vertexConsumerProvider, i, mobEntity, f, g, j, k, l, h, 1.0f, 1.0f, 1.0f);
    }
}

