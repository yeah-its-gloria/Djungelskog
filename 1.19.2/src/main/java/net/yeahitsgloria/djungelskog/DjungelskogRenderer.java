// SPDX-FileCopyrightText: Copyright 2024 Gloria G. (yeah-its-gloria)
// SPDX-License-Identifier: BSD-2-Clause

package net.yeahitsgloria.djungelskog;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DjungelskogRenderer extends MobRenderer<DjungelskogEntity, DjungelskogModel<DjungelskogEntity>> {
    private static final ResourceLocation BEAR_LOCATION =  new ResourceLocation(Djungelskog.MODID, "textures/entity/djungelskog.png");

    public DjungelskogRenderer(EntityRendererProvider.Context context) {
        super(context, new DjungelskogModel<>(context.bakeLayer(ModelLayers.POLAR_BEAR)), 0.9F);
    }

    public ResourceLocation getTextureLocation(DjungelskogEntity entity) {
        return BEAR_LOCATION;
    }

    protected void scale(DjungelskogEntity entity, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(1.2F, 1.2F, 1.2F);

        super.scale(entity, poseStack, partialTickTime);
    }
}
