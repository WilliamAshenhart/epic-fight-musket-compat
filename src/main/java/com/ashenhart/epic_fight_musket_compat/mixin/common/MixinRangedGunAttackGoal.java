package com.ashenhart.epic_fight_musket_compat.mixin.common;

import ewewukek.musketmod.GunItem;
import ewewukek.musketmod.RangedGunAttackGoal;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

@Mixin(value = RangedGunAttackGoal.class)
public abstract class MixinRangedGunAttackGoal {

    @Redirect(
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/monster/Monster;getUseItem()Lnet/minecraft/world/item/ItemStack;"
            ),
            method = "tick()V"
    )
    private ItemStack epicfight$tick(Monster self) {
        self.startUsingItem(InteractionHand.MAIN_HAND);

        EpicFightCapabilities.getUnparameterizedEntityPatch((Entity)self, LivingEntityPatch.class).ifPresent(livingEntityPatch -> {
            livingEntityPatch.playShootingAnimation();
        });
        return null;
    }
}