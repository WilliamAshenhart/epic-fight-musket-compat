package com.ashenhart.epic_fight_musket_compat.client.renderer.patched.layers;

import com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.mob.AbstractRecruitPatch;
import com.mojang.blaze3d.vertex.PoseStack;

import com.talhanation.recruits.client.models.RecruitVillagerModel;
import com.talhanation.recruits.entities.AbstractRecruitEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import yesman.epicfight.api.client.model.Meshes;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.client.mesh.VillagerMesh;
import yesman.epicfight.client.renderer.patched.layer.ModelRenderLayer;

@OnlyIn(Dist.CLIENT)
public class PatchedRecruitBiomeLayer extends ModelRenderLayer<AbstractRecruitEntity, AbstractRecruitPatch<AbstractRecruitEntity>, RecruitVillagerModel, RenderLayer<AbstractRecruitEntity, RecruitVillagerModel>, VillagerMesh> {
    private static final ResourceLocation[] BIOME_TEXTURE = new ResourceLocation[]{
            ResourceLocation.fromNamespaceAndPath("recruits", "textures/entity/villager/biome/villager_desert.png"),
            ResourceLocation.fromNamespaceAndPath("recruits", "textures/entity/villager/biome/villager_jungle.png"),
            ResourceLocation.fromNamespaceAndPath("recruits", "textures/entity/villager/biome/villager_plains.png"),
            ResourceLocation.fromNamespaceAndPath("recruits", "textures/entity/villager/biome/villager_savanna.png"),
            ResourceLocation.fromNamespaceAndPath("recruits", "textures/entity/villager/biome/villager_snowy_tundra.png"),
            ResourceLocation.fromNamespaceAndPath("recruits", "textures/entity/villager/biome/villager_swamp.png"),
            ResourceLocation.fromNamespaceAndPath("recruits", "textures/entity/villager/biome/villager_taiga.png")
    };

    public PatchedRecruitBiomeLayer() {
        super(Meshes.VILLAGER_ZOMBIE);
    }


    @Override
    protected void renderLayer(AbstractRecruitPatch<AbstractRecruitEntity> entitypatch, AbstractRecruitEntity entityliving, RenderLayer<AbstractRecruitEntity, RecruitVillagerModel> vanillaLayer, PoseStack postStack, MultiBufferSource buffer, int packedLight,
                               OpenMatrix4f[] poses, float bob, float yRot, float xRot, float partialTicks) {

        if (!entityliving.isInvisible()) {
            if (!entityliving.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
                this.mesh.get().head.setHidden(true);
                this.mesh.get().hat.setHidden(true);
            }
            if (!entityliving.getItemBySlot(EquipmentSlot.LEGS).isEmpty()) {
                this.mesh.get().jacket.setHidden(true);
            }
            int biomeId = entityliving.getBiome();
            ResourceLocation texture = BIOME_TEXTURE[biomeId % BIOME_TEXTURE.length];

            this.mesh.get().draw(postStack, buffer, RenderType.entityCutoutNoCull(texture),
                    packedLight, 1.0F, 1.0F, 1.0F, 1.0F, LivingEntityRenderer.getOverlayCoords(entityliving, 0.0F), entitypatch.getArmature(), poses);

            this.mesh.get().head.setHidden(false);
            this.mesh.get().hat.setHidden(false);
            this.mesh.get().jacket.setHidden(false);
        }
    }
}