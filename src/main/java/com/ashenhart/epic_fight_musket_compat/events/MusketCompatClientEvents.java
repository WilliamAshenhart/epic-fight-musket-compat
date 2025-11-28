package com.ashenhart.epic_fight_musket_compat.events;

import com.ashenhart.epic_fight_musket_compat.Epic_fight_musket_compat;
import com.ashenhart.epic_fight_musket_compat.renderer.patched.entity.PRecruitRenderer;
import com.talhanation.recruits.init.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;

@Mod.EventBusSubscriber(modid = Epic_fight_musket_compat.MODID, value = Dist.CLIENT)
public class MusketCompatClientEvents {
    @SubscribeEvent
    public static void registerPatchedEntityRenderers(PatchedRenderersEvent.Add event) {
        event.addPatchedEntityRenderer(ModEntityTypes.RECRUIT.get(), entityType -> new PRecruitRenderer(
                        event.getContext(),
                        entityType
                )
        );
        event.addPatchedEntityRenderer(ModEntityTypes.SCOUT.get(), entityType -> new PRecruitRenderer(
                        event.getContext(),
                        entityType
                )
        );
        event.addPatchedEntityRenderer(ModEntityTypes.BOWMAN.get(), entityType -> new PRecruitRenderer(
                        event.getContext(),
                        entityType
                )
        );
        event.addPatchedEntityRenderer(ModEntityTypes.PATROL_LEADER.get(), entityType -> new PRecruitRenderer(
                        event.getContext(),
                        entityType
                )
        );
        event.addPatchedEntityRenderer(ModEntityTypes.NOMAD.get(), entityType -> new PRecruitRenderer(
                        event.getContext(),
                        entityType
                )
        );
        event.addPatchedEntityRenderer(ModEntityTypes.RECRUIT_SHIELDMAN.get(), entityType -> new PRecruitRenderer(
                        event.getContext(),
                        entityType
                )
        );
        event.addPatchedEntityRenderer(ModEntityTypes.HORSEMAN.get(), entityType -> new PRecruitRenderer(
                        event.getContext(),
                        entityType
                )
        );
        event.addPatchedEntityRenderer(ModEntityTypes.CROSSBOWMAN.get(), entityType -> new PRecruitRenderer(
                        event.getContext(),
                        entityType
                )
        );
        event.addPatchedEntityRenderer(ModEntityTypes.CAPTAIN.get(), entityType -> new PRecruitRenderer(
                        event.getContext(),
                        entityType
                )
        );
        event.addPatchedEntityRenderer(ModEntityTypes.MESSENGER.get(), entityType -> new PRecruitRenderer(
                        event.getContext(),
                        entityType
                )
        );
    }
}
