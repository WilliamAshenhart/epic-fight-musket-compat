package com.ashenhart.epic_fight_musket_compat.mixin.common;

import ewewukek.musketmod.GunItem;
import ewewukek.musketmod.RangedGunAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.world.capabilities.entitypatch.MobPatch;

import java.util.Set;

@Mixin(value = MobPatch.class, remap = false)
public class MixinMobPatch {

    @Inject(method = "selectGoalToRemove", at = @At("TAIL"))
    private void epicfight_musket_compat$keepGunGoals(Set<Goal> toRemove, CallbackInfo ci) {
        toRemove.removeIf(goal -> goal instanceof RangedGunAttackGoal);
    }

    @Inject(method = "commonAggressiveRangedMobUpdateMotion", at = @At("TAIL"))
    private void epicfight_musket_compat$setGunAimMotion(boolean considerInaction, CallbackInfo ci) {
        this.epicfight_musket_compat$applyAimMotion();
    }

    @Inject(method = "commonAggressiveMobUpdateMotion", at = @At("TAIL"))
    private void epicfight_musket_compat$setGunAimMotionMelee(boolean considerInaction, CallbackInfo ci) {
        this.epicfight_musket_compat$applyAimMotion();
    }

    @Unique
    private void epicfight_musket_compat$applyAimMotion() {
        MobPatch<?> self = (MobPatch<?>) (Object) this;
        ItemStack mainHandItem = self.getOriginal().getMainHandItem();

        if (mainHandItem.getItem() instanceof GunItem && GunItem.isLoaded(self.getOriginal().getMainHandItem())) {
            if (!self.getOriginal().isUsingItem()) {
                self.currentCompositeMotion = LivingMotions.AIM;
            }
        }
    }
}