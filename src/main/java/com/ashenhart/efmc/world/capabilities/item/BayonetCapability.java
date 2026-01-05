package com.ashenhart.efmc.world.capabilities.item;

import com.ashenhart.efmc.gameassets.MusketAnimations;
import com.ashenhart.efmc.gameassets.MusketSkills;
import ewewukek.musketmod.GunItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.LivingMotion;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.registry.entries.EpicFightSounds;
import yesman.epicfight.registry.entries.EpicFightParticles;
import yesman.epicfight.particle.HitParticleType;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.RangedWeaponCapability;
import yesman.epicfight.world.capabilities.item.Style;

import javax.annotation.Nullable;
import java.util.List;

public class BayonetCapability extends RangedWeaponCapability {
        private final List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> attackMotion;
    protected BayonetCapability(RangedWeaponCapability.Builder builder) {
            super(builder);

            this.attackMotion = List.of(MusketAnimations.MUSKET_AUTO_1, MusketAnimations.MUSKET_AUTO_2, MusketAnimations.BAYONET_AUTO, MusketAnimations.BAYONET_DASH, yesman.epicfight.gameasset.Animations.SPEAR_TWOHAND_AIR_SLASH);
        }

        @Override
        public Style getStyle (LivingEntityPatch< ? > entitypatch) {
            return Styles.TWO_HAND;
        }

        @Override
        public SoundEvent getHitSound () {
            return EpicFightSounds.BLUNT_HIT.get();
        }

        @Override
        public HitParticleType getHitParticle () {
            return EpicFightParticles.HIT_BLUNT.get();
        }

        @Override
        public List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> getAutoAttackMotion
        (PlayerPatch< ? > playerpatch) {
            return this.attackMotion;
        }

        @Override
        public LivingMotion getLivingMotion (LivingEntityPatch < ? > entitypatch, InteractionHand hand) {
            return entitypatch.getEntityState().canUseItem() &&
                    entitypatch.getOriginal().getMainHandItem().getItem() instanceof GunItem &&
                    GunItem.isLoaded(entitypatch.getOriginal().getMainHandItem())
                    ? LivingMotions.AIM : null;
    }
    @Nullable
    @Override
    public Skill getInnateSkill(PlayerPatch<?> playerPatch, ItemStack itemStack) {
        return (Skill) MusketSkills.LAST_PUSH.get();
    }
}