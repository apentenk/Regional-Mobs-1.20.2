package rexreges.render.entity;

import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;

public class RegionalCreeperEntityRenderer extends CreeperEntityRenderer{
    private final Identifier texture;

    public RegionalCreeperEntityRenderer(Context context, String texture) {
        super(context);
        this.texture = new Identifier(texture);
    }

    @Override
    public Identifier getTexture(CreeperEntity creeperEntity) {
        return texture;
    }
    
}
