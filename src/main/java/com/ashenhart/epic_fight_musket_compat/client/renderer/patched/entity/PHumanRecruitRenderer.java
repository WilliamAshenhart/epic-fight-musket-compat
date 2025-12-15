package com.ashenhart.epic_fight_musket_compat.client.renderer.patched.entity;

import com.ashenhart.epic_fight_musket_compat.client.renderer.patched.layers.PatchedHumanRecruitBiomeLayer;
import com.ashenhart.epic_fight_musket_compat.client.renderer.patched.layers.PatchedHumanRecruitCompanionLayer;
import com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.mob.AbstractRecruitPatch;
import com.talhanation.recruits.client.models.RecruitVillagerModel;
import com.talhanation.recruits.client.render.layer.RecruitHumanBiomeLayer;
import com.talhanation.recruits.client.render.layer.RecruitHumanCompanionLayer;
import com.talhanation.recruits.entities.AbstractRecruitEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.EntityType;
import yesman.epicfight.api.client.model.Meshes;
import yesman.epicfight.client.mesh.HumanoidMesh;
import yesman.epicfight.client.renderer.patched.entity.PHumanoidRenderer;

public class PHumanRecruitRenderer extends PHumanoidRenderer<AbstractRecruitEntity, AbstractRecruitPatch<AbstractRecruitEntity>, RecruitVillagerModel, LivingEntityRenderer<AbstractRecruitEntity,RecruitVillagerModel>, HumanoidMesh> {
    public PHumanRecruitRenderer(EntityRendererProvider.Context context, EntityType<?> entityType) {
        super(Meshes.BIPED, context, entityType);

        this.addPatchedLayer(RecruitHumanBiomeLayer.class, new PatchedHumanRecruitBiomeLayer());
        this.addPatchedLayer(RecruitHumanCompanionLayer.class, new PatchedHumanRecruitCompanionLayer());
    }
}
