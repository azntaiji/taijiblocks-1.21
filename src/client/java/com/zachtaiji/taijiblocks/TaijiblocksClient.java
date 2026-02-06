package com.zachtaiji.taijiblocks;

import com.zachtaiji.taijiblocks.entity.FlamingoEntityModel;
import com.zachtaiji.taijiblocks.entity.FlamingoEntityRenderer;
import com.zachtaiji.taijiblocks.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class TaijiblocksClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntities.FLAMINGO, FlamingoEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(FlamingoEntityModel.LAYER, FlamingoEntityModel::getTexturedModelData);
	}
}