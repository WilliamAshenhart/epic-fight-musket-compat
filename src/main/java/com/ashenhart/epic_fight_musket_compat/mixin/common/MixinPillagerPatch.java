package com.ashenhart.epic_fight_musket_compat.mixin.common;

import ewewukek.musketmod.GunItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.world.capabilities.entitypatch.mob.PillagerPatch;

@Mixin(value = PillagerPatch.class, remap = false)
public class MixinPillagerPatch {

    @Inject(method = "setAIAsInfantry", at = @At("HEAD"), cancellable = true)
    private void epicfight_musket_compat$cancelMeleeAI(boolean holdingRangedWeapon, CallbackInfo ci) {
        PillagerPatch patch = (PillagerPatch) (Object) this;

        if (patch.getOriginal().getMainHandItem().getItem() instanceof GunItem) {
            ci.cancel();
        }
    }
}
