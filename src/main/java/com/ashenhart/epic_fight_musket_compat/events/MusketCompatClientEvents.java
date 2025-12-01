package com.ashenhart.epic_fight_musket_compat.events;

import com.ashenhart.epic_fight_musket_compat.Epic_fight_musket_compat;
import com.ashenhart.epic_fight_musket_compat.client.renderer.patched.entity.PHumanRecruitRenderer;
import com.ashenhart.epic_fight_musket_compat.client.renderer.patched.entity.PRecruitRenderer;
import com.talhanation.recruits.config.RecruitsClientConfig;
import com.talhanation.recruits.init.ModEntityTypes;
import ewewukek.musketmod.ScopedMusketItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;
import yesman.epicfight.api.forgeevent.BattleModeSustainableEvent;

@Mod.EventBusSubscriber(modid = Epic_fight_musket_compat.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MusketCompatClientEvents {
    public static void onBattleModeSustainable(BattleModeSustainableEvent event) {
        if (event.getPlayerPatch().isLogicalClient()) {
            Player playerPatch =  event.getPlayerPatch().getOriginal();

            if (playerPatch.isUsingItem() && playerPatch.getUseItem().getItem() instanceof ScopedMusketItem && ScopedMusketItem.isLoaded(playerPatch.getMainHandItem())) {
                if (isFirstPerson()) {
                    event.setCanceled(true);
                }
            }
        }
    }

    private static boolean isFirstPerson() {
        return Minecraft.getInstance().options.getCameraType().isFirstPerson();
    }

    @SubscribeEvent
    public static void registerPatchedEntityRenderers(PatchedRenderersEvent.Add event) {
        if (RecruitsClientConfig.RecruitsLookLikeVillagers.get()) {
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
        else {
            event.addPatchedEntityRenderer(ModEntityTypes.RECRUIT.get(), entityType -> new PHumanRecruitRenderer(
                            event.getContext(),
                            entityType
                    )
            );
            event.addPatchedEntityRenderer(ModEntityTypes.SCOUT.get(), entityType -> new PHumanRecruitRenderer(
                            event.getContext(),
                            entityType
                    )
            );
            event.addPatchedEntityRenderer(ModEntityTypes.BOWMAN.get(), entityType -> new PHumanRecruitRenderer(
                            event.getContext(),
                            entityType
                    )
            );
            event.addPatchedEntityRenderer(ModEntityTypes.PATROL_LEADER.get(), entityType -> new PHumanRecruitRenderer(
                            event.getContext(),
                            entityType
                    )
            );
            event.addPatchedEntityRenderer(ModEntityTypes.NOMAD.get(), entityType -> new PHumanRecruitRenderer(
                            event.getContext(),
                            entityType
                    )
            );
            event.addPatchedEntityRenderer(ModEntityTypes.RECRUIT_SHIELDMAN.get(), entityType -> new PHumanRecruitRenderer(
                            event.getContext(),
                            entityType
                    )
            );
            event.addPatchedEntityRenderer(ModEntityTypes.HORSEMAN.get(), entityType -> new PHumanRecruitRenderer(
                            event.getContext(),
                            entityType
                    )
            );
            event.addPatchedEntityRenderer(ModEntityTypes.CROSSBOWMAN.get(), entityType -> new PHumanRecruitRenderer(
                            event.getContext(),
                            entityType
                    )
            );
            event.addPatchedEntityRenderer(ModEntityTypes.CAPTAIN.get(), entityType -> new PHumanRecruitRenderer(
                            event.getContext(),
                            entityType
                    )
            );
            event.addPatchedEntityRenderer(ModEntityTypes.MESSENGER.get(), entityType -> new PHumanRecruitRenderer(
                            event.getContext(),
                            entityType
                    )
            );

        }
    }
}
