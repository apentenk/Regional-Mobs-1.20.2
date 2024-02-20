package rexreges.render.entity;

import net.minecraft.client.render.entity.StrayEntityRenderer;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.util.Identifier;

public class RegionalSkeletonEntityRenderer extends StrayEntityRenderer {
        private final Identifier texture;

    public RegionalSkeletonEntityRenderer(Context context, String texture, String overlay) {
        super(context);
        this.texture = new Identifier(texture);
        this.addFeature(new RegionalSkeletonOverlayRenderer<AbstractSkeletonEntity, SkeletonEntityModel<AbstractSkeletonEntity>>(this, context.getModelLoader(), overlay));
    }

    @Override
    public Identifier getTexture(AbstractSkeletonEntity pillagerEntity) {
        return texture;
    }

}
