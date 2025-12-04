package com.ashenhart.epic_fight_musket_compat.events;

import com.ashenhart.epic_fight_musket_compat.Epic_fight_musket_compat;
import com.ashenhart.epic_fight_musket_compat.client.renderer.patched.entity.PHumanRecruitRenderer;
import com.ashenhart.epic_fight_musket_compat.client.renderer.patched.entity.PRecruitRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;

@Mod.EventBusSubscriber(modid = Epic_fight_musket_compat.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MusketCompatClientEvents {
    @SubscribeEvent
    public static void registerPatchedEntityRenderers(PatchedRenderersEvent.Add event) {
        if (ModList.get().isLoaded("recruits")) {
            RecruitCompatClientEvents.registerPatchedEntityRenderers(event);
        }
    }

    public static class RecruitCompatClientEvents {
        public static void registerPatchedEntityRenderers(PatchedRenderersEvent.Add event) {
            if (com.talhanation.recruits.config.RecruitsClientConfig.RecruitsLookLikeVillagers.get()) {
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.RECRUIT.get(), entityType -> new PRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.SCOUT.get(), entityType -> new PRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.BOWMAN.get(), entityType -> new PRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.PATROL_LEADER.get(), entityType -> new PRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.NOMAD.get(), entityType -> new PRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.RECRUIT_SHIELDMAN.get(), entityType -> new PRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.HORSEMAN.get(), entityType -> new PRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.CROSSBOWMAN.get(), entityType -> new PRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.CAPTAIN.get(), entityType -> new PRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.MESSENGER.get(), entityType -> new PRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
            } else {
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.RECRUIT.get(), entityType -> new PHumanRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.SCOUT.get(), entityType -> new PHumanRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.BOWMAN.get(), entityType -> new PHumanRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.PATROL_LEADER.get(), entityType -> new PHumanRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.NOMAD.get(), entityType -> new PHumanRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.RECRUIT_SHIELDMAN.get(), entityType -> new PHumanRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.HORSEMAN.get(), entityType -> new PHumanRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.CROSSBOWMAN.get(), entityType -> new PHumanRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.CAPTAIN.get(), entityType -> new PHumanRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
                event.addPatchedEntityRenderer(com.talhanation.recruits.init.ModEntityTypes.MESSENGER.get(), entityType -> new PHumanRecruitRenderer(
                                event.getContext(),
                                entityType
                        )
                );
            }
        }
    }
}