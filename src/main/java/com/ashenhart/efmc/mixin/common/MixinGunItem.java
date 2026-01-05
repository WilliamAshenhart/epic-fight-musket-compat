package com.ashenhart.efmc.mixin.common;

import ewewukek.musketmod.GunItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

@Mixin(value = GunItem.class, remap = false)
public class MixinGunItem {

    @Inject(
            method = "fire(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;)V",
            at = @At("HEAD")
    )
    private void epicfight_musket_compat$onFire(LivingEntity entity, ItemStack stack, Vec3 direction, Vec3 smokeOffset, CallbackInfo ci) {
        EpicFightCapabilities.getUnparameterizedEntityPatch(entity, LivingEntityPatch.class).ifPresent(LivingEntityPatch::playShootingAnimation);
    }
}