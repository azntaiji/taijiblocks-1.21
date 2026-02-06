package com.zachtaiji.taijiblocks.entity;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class FlamingoEntityModel extends EntityModel<FlamingoEntity> {

    public static final EntityModelLayer LAYER = new EntityModelLayer(
            Identifier.of("taijiblocks", "flamingo"), "main");

    private final ModelPart body;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;
    private final ModelPart leftWing;
    private final ModelPart rightWing;
    private final ModelPart tail;

    public FlamingoEntityModel(ModelPart root) {
        this.body = root.getChild("body");
        this.neck = root.getChild("neck");
        this.head = this.neck.getChild("head");
        this.leftLeg = root.getChild("left_leg");
        this.rightLeg = root.getChild("right_leg");
        this.leftWing = root.getChild("left_wing");
        this.rightWing = root.getChild("right_wing");
        this.tail = root.getChild("tail");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        // Body - oval shaped, pink
        modelPartData.addChild("body", ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(-3.0f, -3.0f, -4.0f, 6.0f, 6.0f, 8.0f, Dilation.NONE),
                ModelTransform.pivot(0.0f, 12.0f, 0.0f));

        // Neck - long and curved upward
        ModelPartData neckData = modelPartData.addChild("neck", ModelPartBuilder.create()
                        .uv(0, 14)
                        .cuboid(-1.0f, -10.0f, -1.0f, 2.0f, 10.0f, 2.0f, Dilation.NONE),
                ModelTransform.pivot(0.0f, 10.0f, -3.0f));

        // Head - small, on top of neck
        neckData.addChild("head", ModelPartBuilder.create()
                        .uv(20, 0)
                        .cuboid(-1.5f, -3.0f, -2.5f, 3.0f, 3.0f, 4.0f, Dilation.NONE)
                        // Beak
                        .uv(20, 7)
                        .cuboid(-0.5f, -2.0f, -5.5f, 1.0f, 2.0f, 3.0f, Dilation.NONE),
                ModelTransform.pivot(0.0f, -10.0f, 0.0f));

        // Left leg - long and thin
        modelPartData.addChild("left_leg", ModelPartBuilder.create()
                        .uv(8, 14)
                        .cuboid(-0.5f, 0.0f, -0.5f, 1.0f, 9.0f, 1.0f, Dilation.NONE),
                ModelTransform.pivot(1.5f, 15.0f, 0.0f));

        // Right leg - long and thin
        modelPartData.addChild("right_leg", ModelPartBuilder.create()
                        .uv(12, 14)
                        .cuboid(-0.5f, 0.0f, -0.5f, 1.0f, 9.0f, 1.0f, Dilation.NONE),
                ModelTransform.pivot(-1.5f, 15.0f, 0.0f));

        // Left wing
        modelPartData.addChild("left_wing", ModelPartBuilder.create()
                        .uv(28, 0)
                        .cuboid(0.0f, -2.0f, -3.0f, 1.0f, 4.0f, 6.0f, Dilation.NONE),
                ModelTransform.pivot(3.0f, 12.0f, 0.0f));

        // Right wing
        modelPartData.addChild("right_wing", ModelPartBuilder.create()
                        .uv(28, 0)
                        .mirrored()
                        .cuboid(-1.0f, -2.0f, -3.0f, 1.0f, 4.0f, 6.0f, Dilation.NONE),
                ModelTransform.pivot(-3.0f, 12.0f, 0.0f));

        // Tail feathers
        modelPartData.addChild("tail", ModelPartBuilder.create()
                        .uv(36, 0)
                        .cuboid(-1.5f, -1.0f, 0.0f, 3.0f, 2.0f, 3.0f, Dilation.NONE),
                ModelTransform.pivot(0.0f, 11.0f, 4.0f));

        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public void setAngles(FlamingoEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // Head rotation
        this.head.pitch = headPitch * ((float) Math.PI / 180f);
        this.neck.yaw = headYaw * ((float) Math.PI / 180f);

        // Leg walking animation
        this.rightLeg.pitch = MathHelper.cos(limbAngle * 0.6662f) * 1.4f * limbDistance;
        this.leftLeg.pitch = MathHelper.cos(limbAngle * 0.6662f + (float) Math.PI) * 1.4f * limbDistance;

        // Wing flap when moving
        this.rightWing.roll = MathHelper.cos(limbAngle * 0.6662f) * 0.3f * limbDistance;
        this.leftWing.roll = -MathHelper.cos(limbAngle * 0.6662f) * 0.3f * limbDistance;

        // Idle neck sway
        this.neck.roll = MathHelper.cos(animationProgress * 0.05f) * 0.05f;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        this.body.render(matrices, vertices, light, overlay, color);
        this.neck.render(matrices, vertices, light, overlay, color);
        this.leftLeg.render(matrices, vertices, light, overlay, color);
        this.rightLeg.render(matrices, vertices, light, overlay, color);
        this.leftWing.render(matrices, vertices, light, overlay, color);
        this.rightWing.render(matrices, vertices, light, overlay, color);
        this.tail.render(matrices, vertices, light, overlay, color);
    }
}
