package com.ashenhart.efmc.events;

import ewewukek.musketmod.GunItem;
import ewewukek.musketmod.ScopedMusketItem;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import yesman.epicfight.api.neoevent.BattleModeSustainableEvent;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;

@EventBusSubscriber(modid = "efmc", value = Dist.CLIENT)
public class MusketCompatScopeEvent {
    @SubscribeEvent
    public static void onBattleMode(BattleModeSustainableEvent battleModeEvent) {
        if (battleModeEvent.getPlayerPatch().isLogicalClient()) {
            PlayerPatch<?> playerPatch = battleModeEvent.getPlayerPatch();

            if (playerPatch.getEntityState().canUseItem() &&
                    playerPatch.getOriginal().getMainHandItem().getItem() instanceof ScopedMusketItem && GunItem.isLoaded(playerPatch.getOriginal().getMainHandItem()) && ScopedMusketItem.isScoping) {
                if (isFirstPerson()) {
                    battleModeEvent.setCanceled(true);
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static boolean isFirstPerson() {
        return Minecraft.getInstance().options.getCameraType().isFirstPerson();
    }
}
