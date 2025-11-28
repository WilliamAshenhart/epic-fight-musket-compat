package com.ashenhart.epic_fight_musket_compat.renderer.patched.entity;

import com.ashenhart.epic_fight_musket_compat.renderer.patched.layers.PatchedGuardBiomeLayer;
import com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.mob.AbstractRecruitPatch;
import com.talhanation.recruits.client.models.RecruitVillagerModel;
import com.talhanation.recruits.client.render.layer.RecruitVillagerBiomeLayer;
import com.talhanation.recruits.entities.AbstractRecruitEntity;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.world.entity.EntityType;
import yesman.epicfight.api.client.model.Meshes;
import yesman.epicfight.client.mesh.VillagerMesh;
import yesman.epicfight.client.renderer.patched.entity.PHumanoidRenderer;

public class PRecruitRenderer extends PHumanoidRenderer<AbstractRecruitEntity, AbstractRecruitPatch<AbstractRecruitEntity>, RecruitVillagerModel, LivingEntityRenderer<AbstractRecruitEntity,RecruitVillagerModel>, VillagerMesh> {
    public PRecruitRenderer(EntityRendererProvider.Context context, EntityType<?> entityType) {
        super(Meshes.VILLAGER_ZOMBIE, context, entityType);

        this.addPatchedLayer(RecruitVillagerBiomeLayer.class, new PatchedGuardBiomeLayer());
    }
}
