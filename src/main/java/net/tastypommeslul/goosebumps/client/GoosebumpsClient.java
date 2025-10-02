package net.tastypommeslul.goosebumps.client;

import com.moulberry.lattice.Lattice;
import com.moulberry.lattice.element.LatticeElements;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.tastypommeslul.goosebumps.compat.GoosebumpsConfig;
import net.tastypommeslul.goosebumps.entity.ModEntities;
import net.tastypommeslul.goosebumps.entity.client.AmongUsModel;
import net.tastypommeslul.goosebumps.entity.client.AmongUsRenderer;

public class GoosebumpsClient implements ClientModInitializer {

    private static LatticeElements latticeElements;
    @Override
    public void onInitializeClient() {
        latticeElements = LatticeElements.fromAnnotations(Text.literal("Goosebumps Config"), new GoosebumpsConfig());
        EntityModelLayerRegistry.registerModelLayer(AmongUsModel.AMONG_US, AmongUsModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.AMONG_US, AmongUsRenderer::new);
    }

    public static Screen createConfigScreen(Screen oldScreen) {
        return Lattice.createConfigScreen(latticeElements, null, oldScreen);
    }
}
