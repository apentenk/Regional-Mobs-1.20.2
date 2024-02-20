package rexreges.render.entity;

import net.minecraft.client.render.entity.PillagerEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.util.Identifier;

public class RegionalPillagerEntityRenderer extends PillagerEntityRenderer {
        private final Identifier texture;

    public RegionalPillagerEntityRenderer(Context context, String texture) {
        super(context);
        this.texture = new Identifier(texture);
    }

    @Override
    public Identifier getTexture(PillagerEntity pillagerEntity) {
        return texture;
    }

}
