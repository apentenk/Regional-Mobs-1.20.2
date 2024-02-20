package rexreges.render.entity;

import net.minecraft.client.render.entity.SpiderEntityRenderer;

import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.entity.mob.CaveSpiderEntity;
import net.minecraft.util.Identifier;

public class RegionalSpiderEntityRenderer extends SpiderEntityRenderer<CaveSpiderEntity>{
    private final Identifier texture;

    public RegionalSpiderEntityRenderer(Context context, String texture, String eyes) {
        super(context);
        this.texture = new Identifier(texture);
        this.addFeature(new RegionalSpiderEyeFeatureRenderer<>(this, eyes));
    }
    
    @Override
    public Identifier getTexture(CaveSpiderEntity spiderEntity) {
        return texture;
    }
}
