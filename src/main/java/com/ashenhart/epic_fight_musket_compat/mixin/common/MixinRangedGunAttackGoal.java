package com.ashenhart.epic_fight_musket_compat.mixin.common;

import ewewukek.musketmod.*;
import net.minecraft.world.entity.monster.Monster;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

@Mixin(value = RangedGunAttackGoal.class)
public class MixinRangedGunAttackGoal {
    
    @Final
    @Shadow(remap = false)
    public Monster mob;

    @Inject(method = "tick", at = @At("HEAD"))
    private void epicfight_musket_compat$setAggressive(CallbackInfo ci) {
        if (!this.mob.isAggressive()) {
            this.mob.setAggressive(true);
        }
    }

    @Inject(method = "fire", at = @At("TAIL"), remap = false)
    private void epicfight_musket_compat$onFire(float spread, CallbackInfo ci) {
        EpicFightCapabilities.getUnparameterizedEntityPatch(this.mob, LivingEntityPatch.class)
                .ifPresent(LivingEntityPatch::playShootingAnimation);
    }

}