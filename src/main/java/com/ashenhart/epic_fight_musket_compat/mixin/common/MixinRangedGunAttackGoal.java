package com.ashenhart.epic_fight_musket_compat.mixin.common;

import ewewukek.musketmod.GunItem;
import ewewukek.musketmod.RangedGunAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
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
                    target = "Lnet/minecraft/world/entity/monster/Monster;getUseItem()Lnet/minecraft/world/item/ItemStack;"
           ),
            method = "tick()V"
    )
    public ItemStack epicfight$tick (Monster self) {
        GunItem.canUse(self);

        EpicFightCapabilities.getUnparameterizedEntityPatch(self, LivingEntityPatch.class).ifPresent(entitypatch -> {
            entitypatch.playShootingAnimation();
        });
        return null;
    }
}
