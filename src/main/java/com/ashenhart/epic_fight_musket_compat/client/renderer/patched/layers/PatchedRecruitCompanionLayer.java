package com.ashenhart.epic_fight_musket_compat.client.renderer.patched.layers;

import com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.mob.AbstractRecruitPatch;
import com.mojang.blaze3d.vertex.PoseStack;
import com.talhanation.recruits.client.models.RecruitVillagerModel;
import com.talhanation.recruits.entities.AbstractRecruitEntity;
import com.talhanation.recruits.entities.ICompanion;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.api.client.model.Meshes;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.client.mesh.VillagerMesh;
import yesman.epicfight.client.renderer.patched.layer.ModelRenderLayer;

public class PatchedRecruitCompanionLayer extends ModelRenderLayer<AbstractRecruitEntity, AbstractRecruitPatch<AbstractRecruitEntity>, RecruitVillagerModel, RenderLayer<AbstractRecruitEntity, RecruitVillagerModel>, VillagerMesh> {
    private static final ResourceLocation LOCATION =
            ResourceLocation.fromNamespaceAndPath("recruits", "textures/entity/villager/villager_assassin_cloth.png");
    public PatchedRecruitCompanionLayer() {
        super(Meshes.VILLAGER_ZOMBIE);
    }

    @Override
    protected void renderLayer(AbstractRecruitPatch<AbstractRecruitEntity> entitypatch, AbstractRecruitEntity entityliving, RenderLayer<AbstractRecruitEntity, RecruitVillagerModel> vanillaLayer, PoseStack postStack, MultiBufferSource buffer, int packedLight,
                               OpenMatrix4f[] poses, float bob, float yRot, float xRot, float partialTicks) {
        if (!entityliving.isInvisible() && entityliving instanceof ICompanion) {
            this.mesh.get().draw(postStack, buffer, RenderType.entityCutoutNoCull(LOCATION),
                    packedLight, 1.0F, 1.0F, 1.0F, 1.0F, LivingEntityRenderer.getOverlayCoords(entityliving, 0.0F), entitypatch.getArmature(),poses);
        }

    }
}
