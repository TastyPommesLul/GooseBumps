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
    public static final GoosebumpsConfig config = new GoosebumpsConfig();
    @Override
    public void onInitializeClient() {
        latticeElements = LatticeElements.fromAnnotations(Text.literal("Goosebumps Config"), config);
        EntityModelLayerRegistry.registerModelLayer(AmongUsModel.AMONG_US, AmongUsModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.AMONG_US, AmongUsRenderer::new);

//        HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, Identifier.of(Goosebumps.MOD_ID, "bleb"), GoosebumpsClient::render);
    }

    public static Screen createConfigScreen(Screen oldScreen) {
        return Lattice.createConfigScreen(latticeElements, null, oldScreen);
    }

//    private static void render(DrawContext ctx, RenderTickCounter tickCounter) {
//        MinecraftClient client = MinecraftClient.getInstance();
//        ctx.drawText(client.textRenderer, "Boobies", (client.getWindow().getScaledWidth() / 2) - 19, client.getWindow().getScaledHeight() - 32, Colors.GREEN, true);
//    }
}
