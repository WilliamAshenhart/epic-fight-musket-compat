package com.ashenhart.epic_fight_musket_compat.events;

import ewewukek.musketmod.GunItem;
import ewewukek.musketmod.ScopedMusketItem;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.forgeevent.BattleModeSustainableEvent;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;

@Mod.EventBusSubscriber(modid = "epic_fight_musket_compat", value = Dist.CLIENT)
public class MusketCompatScopeEvent {
    @SubscribeEvent
    public void onBattleMode(BattleModeSustainableEvent battleModeEvent) {
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
