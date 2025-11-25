package com.ashenhart.epic_fight_musket_compat.mixin.common;

import ewewukek.musketmod.RangedGunAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.world.capabilities.entitypatch.MobPatch;

import java.util.Iterator;
import java.util.Set;

@Mixin(value = MobPatch.class, remap = false)
public class MixinMobPatch {

    @Inject(method = "selectGoalToRemove", at = @At("TAIL"))
    private void epicfight_musket_compat$keepGunGoals(Set<Goal> toRemove, CallbackInfo ci) {
        Iterator<Goal> iterator = toRemove.iterator();
        while (iterator.hasNext()) {
            Goal goal = iterator.next();
            if (goal instanceof RangedGunAttackGoal) {
                iterator.remove();
            }
        }
    }
}
