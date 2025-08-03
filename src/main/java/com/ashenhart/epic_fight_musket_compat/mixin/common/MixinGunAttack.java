package com.ashenhart.epic_fight_musket_compat.mixin.common;

import ewewukek.musketmod.GunItem;
import ewewukek.musketmod.RangedGunAttackGoal;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.CrossbowAttack;
import net.minecraft.world.entity.monster.RangedAttackMob;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

@Mixin(value = RangedGunAttackGoal.class)
public class MixinGunAttack {
    @Redirect(
            at = @At(
                    value = "INVOKE",
                    target = "Lewewukek/musketmod/GunItem;mobUse(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/phys/Vec3;)V"
            ),
            method = "fire"
    )
    private void epicfight$gunAttack(GunItem item, LivingEntity self, InteractionHand hand, Vec3 direction) {
        self.getUseItem();

        EpicFightCapabilities.getUnparameterizedEntityPatch((Entity)self, LivingEntityPatch.class).ifPresent(entitypatch -> {
            entitypatch.playShootingAnimation();
        });
    }
}
