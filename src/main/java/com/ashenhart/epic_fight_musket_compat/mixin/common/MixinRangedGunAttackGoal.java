package com.ashenhart.epic_fight_musket_compat.mixin.common;

import ewewukek.musketmod.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

@Mixin(value = RangedGunAttackGoal.class)
public class MixinRangedGunAttackGoal {
    @Redirect(
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/monster/Monster;releaseUsingItem()V"
            ),
            method = "tick()V"
    )
    private void epicfight$tick(Monster self) {
        self.releaseUsingItem();

        EpicFightCapabilities.getUnparameterizedEntityPatch((Entity)self, LivingEntityPatch.class).ifPresent(entitypatch -> {
            entitypatch.playShootingAnimation();
        });
    }
}