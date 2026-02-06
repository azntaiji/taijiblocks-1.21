package com.zachtaiji.taijiblocks.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class FlamingoEntityRenderer extends MobEntityRenderer<FlamingoEntity, FlamingoEntityModel> {

    private static final Identifier TEXTURE = Identifier.of("taijiblocks", "textures/entity/flamingo.png");

    public FlamingoEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new FlamingoEntityModel(context.getPart(FlamingoEntityModel.LAYER)), 0.4f);
    }

    @Override
    public Identifier getTexture(FlamingoEntity entity) {
        return TEXTURE;
    }
}
