package net.tastypommeslul.goosebumps.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.tastypommeslul.goosebumps.Goosebumps;
import net.tastypommeslul.goosebumps.entity.custom.AmongUs;

public class AmongUsRenderer extends MobEntityRenderer<AmongUs, AmongUs.AmongUsEntityRenderState, AmongUsModel> {
    public AmongUsRenderer(EntityRendererFactory.Context context) {
        super(context, new AmongUsModel(context.getPart(AmongUsModel.AMONG_US)), 0.75f);
    }


    @Override
    public AmongUs.AmongUsEntityRenderState createRenderState() {
        return new AmongUs.AmongUsEntityRenderState();
    }

    @Override
    public Identifier getTexture(AmongUs.AmongUsEntityRenderState state) {
        return Identifier.of(Goosebumps.MOD_ID, "textures/entity/amongus/amongus.png");
    }

    @Override
    public void render(AmongUs.AmongUsEntityRenderState livingEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntityRenderState.baby) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }
}
