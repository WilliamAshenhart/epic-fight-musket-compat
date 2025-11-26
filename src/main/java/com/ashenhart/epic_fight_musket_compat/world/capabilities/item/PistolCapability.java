package com.ashenhart.epic_fight_musket_compat.world.capabilities.item;

import com.ashenhart.epic_fight_musket_compat.gameassets.MusketAnimations;
import ewewukek.musketmod.GunItem;
import ewewukek.musketmod.PistolItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.LivingMotion;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.MountAttackAnimation;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.particle.HitParticleType;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.RangedWeaponCapability;
import yesman.epicfight.world.capabilities.item.Style;

import java.util.List;

public class PistolCapability extends RangedWeaponCapability {
    private List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> attackMotion;
    private List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> mountAttackMotion;
    protected PistolCapability(CapabilityItem.Builder builder) {
        super(builder);

        this.attackMotion = List.of(MusketAnimations.PISTOL_AUTO_1, MusketAnimations.PISTOL_AUTO_2, MusketAnimations.PISTOL_AUTO_3, MusketAnimations.PISTOL_DASH, yesman.epicfight.gameasset.Animations.SWORD_AIR_SLASH);
        this.mountAttackMotion = List.of(Animations.SWORD_MOUNT_ATTACK);
    }

    @Override
    public SoundEvent getHitSound() {
        return EpicFightSounds.BLUNT_HIT.get();
    }

    @Override
    public HitParticleType getHitParticle() {
        return EpicFightParticles.HIT_BLUNT.get();
    }

    @Override
    public List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> getAutoAttackMotion(PlayerPatch<?> playerpatch) {
        return this.attackMotion;
    }

    public List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> getMountAttackMotion() {
        return this.mountAttackMotion;
    }


    @Override
    public LivingMotion getLivingMotion(LivingEntityPatch<?> entitypatch, InteractionHand hand) {
        return entitypatch.getEntityState().canUseItem() &&
                entitypatch.getOriginal().getMainHandItem().getItem() instanceof GunItem &&
                PistolItem.isLoaded(entitypatch.getOriginal().getMainHandItem())
                ? LivingMotions.AIM : null;
    }

    @Override
    public Style getStyle(LivingEntityPatch<?> entitypatch) {
        if (entitypatch.getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == MusketWeaponCategories.PISTOL) {
            return Styles.TWO_HAND;
        }
        return Styles.ONE_HAND;
    }
}