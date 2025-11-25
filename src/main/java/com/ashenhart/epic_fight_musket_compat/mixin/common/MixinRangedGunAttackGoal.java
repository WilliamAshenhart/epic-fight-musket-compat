package com.ashenhart.epic_fight_musket_compat.mixin.common;

import ewewukek.musketmod.*;
import net.minecraft.world.entity.monster.Monster;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

@Mixin(value = RangedGunAttackGoal.class, remap = false)
public class MixinRangedGunAttackGoal {
    @Shadow
    public Monster mob;

    @Inject(method = "fire", at = @At("TAIL"))
    private void epicfight_musket_compat$onFire(float spread, CallbackInfo ci) {
        // Retrieve the Epic Fight entity patch for the mob and play the shooting animation
        EpicFightCapabilities.getUnparameterizedEntityPatch(this.mob, LivingEntityPatch.class)
                .ifPresent(LivingEntityPatch::playShootingAnimation);
    }

}