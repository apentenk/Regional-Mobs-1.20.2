package rexreges.render.entity;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class RegionalSpiderEyeFeatureRenderer<T extends Entity, M extends SpiderEntityModel<T>>extends EyesFeatureRenderer<T, M>{

    private final RenderLayer skin;

    public RegionalSpiderEyeFeatureRenderer(FeatureRendererContext<T, M> featureRendererContext, String eyesTexture) {
        super(featureRendererContext);
        this.skin = RenderLayer.getEyes(new Identifier(eyesTexture));
    }

    @Override
    public RenderLayer getEyesTexture() {
        return this.skin;
    }

}
