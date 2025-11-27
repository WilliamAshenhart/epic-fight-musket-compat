package com.ashenhart.epic_fight_musket_compat.world.capabilities.item;

import com.ashenhart.epic_fight_musket_compat.gameassets.MusketAnimations;
import ewewukek.musketmod.GunItem;
import ewewukek.musketmod.MusketItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.animation.AnimationManager.AnimationAccessor;
import yesman.epicfight.api.animation.LivingMotion;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.particle.HitParticleType;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.RangedWeaponCapability;
import yesman.epicfight.world.capabilities.item.Style;

import java.util.List;

public class MusketCapability extends RangedWeaponCapability {
    private final List<AnimationAccessor<? extends AttackAnimation>> attackMotion;
    protected MusketCapability(CapabilityItem.Builder builder) {
        super(builder);

        this.attackMotion = List.of(MusketAnimations.MUSKET_AUTO_1, MusketAnimations.MUSKET_AUTO_2, MusketAnimations.MUSKET_DASH, yesman.epicfight.gameasset.Animations.SPEAR_TWOHAND_AIR_SLASH);
    }

    @Override
    public Style getStyle(LivingEntityPatch<?> entitypatch) {
        return Styles.TWO_HAND;
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
    public List<AnimationAccessor<? extends AttackAnimation>> getAutoAttackMotion(PlayerPatch<?> playerpatch) {
        return this.attackMotion;
    }

    @Override
    public LivingMotion getLivingMotion(LivingEntityPatch<?> entitypatch, InteractionHand hand) {
        return entitypatch.getEntityState().canUseItem() &&
                entitypatch.getOriginal().getMainHandItem().getItem() instanceof GunItem &&
                MusketItem.isLoaded(entitypatch.getOriginal().getMainHandItem())
                ? LivingMotions.AIM : null;
    }
}
