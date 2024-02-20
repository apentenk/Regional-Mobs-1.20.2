package rexreges.render.entity;

import net.minecraft.client.render.entity.HuskEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

public class RegionalZombieEntityRenderer extends HuskEntityRenderer {
        private final Identifier texture;

    public RegionalZombieEntityRenderer(Context context, String texture) {
        super(context);
        this.texture = new Identifier(texture);
    }

    @Override
    public Identifier getTexture(ZombieEntity pillagerEntity) {
        return texture;
    }

}
