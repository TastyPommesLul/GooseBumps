package net.tastypommeslul.goosebumps.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.tastypommeslul.goosebumps.entity.ModEntities;
import net.tastypommeslul.goosebumps.entity.client.AmongUsModel;
import net.tastypommeslul.goosebumps.entity.client.AmongUsRenderer;

public class GoosebumpsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(AmongUsModel.AMONG_US, AmongUsModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.AMONG_US, AmongUsRenderer::new);
    }
}
