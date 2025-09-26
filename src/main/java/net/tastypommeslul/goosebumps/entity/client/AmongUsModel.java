package net.tastypommeslul.goosebumps.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.tastypommeslul.goosebumps.Goosebumps;
import net.tastypommeslul.goosebumps.entity.custom.AmongUs;

public class AmongUsModel extends EntityModel<AmongUs.AmongUsEntityRenderState> {
    public static final EntityModelLayer AMONG_US = new EntityModelLayer(Identifier.of(Goosebumps.MOD_ID, "among_us"), "main");
    private final ModelPart bone;
    private final Animation walkingAnim;
    public AmongUsModel(ModelPart root) {
        super(root);
        this.bone = root.getChild("bone");
        walkingAnim = AmongUsAnimations.WALKING.createAnimation(bone);
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 15.0F, -3.0F));
        ModelPartData left_leg = bone.addChild("left_leg", ModelPartBuilder.create().uv(26, 28).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(4.0F, 5.0F, 3.0F));
        ModelPartData body = bone.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -14.0F, -3.0F, 14.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 5.0F, 3.0F));
        ModelPartData backpack = bone.addChild("backpack", ModelPartBuilder.create().uv(0, 20).cuboid(-5.0F, -7.0F, -3.0F, 10.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 3.0F, 9.0F));
        ModelPartData visor = bone.addChild("visor", ModelPartBuilder.create().uv(-1, 30).cuboid(-5.0F, -9.0F, -10.0F, 10.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 3.0F, 9.0F));
        ModelPartData right_leg = bone.addChild("right_leg", ModelPartBuilder.create().uv(26, 20).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(-4.0F, 5.0F, 3.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(AmongUs.AmongUsEntityRenderState state) {
        this.getBone().traverse().forEach(ModelPart::resetTransform);
        this.walkingAnim.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f);
    }

    public ModelPart getBone() {
        return bone;
    }
}
