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
    }
}
