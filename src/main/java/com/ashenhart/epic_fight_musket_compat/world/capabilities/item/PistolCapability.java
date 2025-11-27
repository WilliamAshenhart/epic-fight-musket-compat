package com.ashenhart.epic_fight_musket_compat.world.capabilities.item;

import com.ashenhart.epic_fight_musket_compat.gameassets.MusketAnimations;
import com.google.common.collect.Maps;
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
import yesman.epicfight.api.animation.types.StaticAnimation;
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
import java.util.Map;

public class PistolCapability extends RangedWeaponCapability {
    private final List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> mainAttackMotion;
    private final List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> dualWieldAttackMotion;
    private final List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> offHandAttackMotion;
    private final List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> offHandFistAttackMotion;
    private final List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> mountAttackMotion;

    private final Map<LivingMotion, AnimationManager.AnimationAccessor<? extends StaticAnimation>> dualWieldLivingMotions;
    private final Map<LivingMotion, AnimationManager.AnimationAccessor<? extends StaticAnimation>> offHandLivingMotions;

    protected PistolCapability(CapabilityItem.Builder builder) {
        super(builder);

        this.mainAttackMotion = List.of(MusketAnimations.PISTOL_AUTO_1, MusketAnimations.PISTOL_AUTO_2, MusketAnimations.PISTOL_AUTO_3, MusketAnimations.PISTOL_DASH, yesman.epicfight.gameasset.Animations.SWORD_AIR_SLASH);
        this.dualWieldAttackMotion = List.of(MusketAnimations.DUAL_PISTOL_AUTO1, MusketAnimations.DUAL_PISTOL_AUTO2, MusketAnimations.DUAL_PISTOL_DASH, MusketAnimations.DUAL_PISTOL_AIRSLASH);
        this.offHandAttackMotion = List.of(Animations.SWORD_AUTO1, Animations.SWORD_AUTO2, Animations.SWORD_DUAL_AUTO3, Animations.SWORD_DASH, Animations.SWORD_AIR_SLASH);
        this.offHandFistAttackMotion = List.of(Animations.FIST_AUTO1, Animations.FIST_AUTO2, Animations.FIST_AUTO2, Animations.FIST_DASH, Animations.FIST_AIR_SLASH);
        this.mountAttackMotion = List.of(Animations.SWORD_MOUNT_ATTACK);

        this.dualWieldLivingMotions = Maps.newHashMap(this.rangeAnimationModifiers);

        this.dualWieldLivingMotions.put(LivingMotions.IDLE, Animations.BIPED_HOLD_DUAL_WEAPON);
        this.dualWieldLivingMotions.put(LivingMotions.AIM, MusketAnimations.HOLD_DUAL_PISTOL);
        this.dualWieldLivingMotions.put(LivingMotions.SHOT, MusketAnimations.DUAL_PISTOL_SHOT);
        this.dualWieldLivingMotions.put(LivingMotions.WALK, Animations.BIPED_HOLD_DUAL_WEAPON);
        this.dualWieldLivingMotions.put(LivingMotions.RUN, Animations.BIPED_RUN_DUAL);

        this.offHandLivingMotions = Maps.newHashMap(this.rangeAnimationModifiers);

        this.offHandLivingMotions.put(LivingMotions.IDLE, Animations.BIPED_HOLD_DUAL_WEAPON);
        this.offHandLivingMotions.put(LivingMotions.AIM, MusketAnimations.HOLD_OFFHAND);
        this.offHandLivingMotions.put(LivingMotions.SHOT, MusketAnimations.OFFHAND_SHOT);
        this.offHandLivingMotions.put(LivingMotions.RELOAD, MusketAnimations.RELOAD_OFFHAND);
        this.offHandLivingMotions.put(LivingMotions.WALK, Animations.BIPED_HOLD_DUAL_WEAPON);
        this.offHandLivingMotions.put(LivingMotions.RUN, Animations.BIPED_RUN_DUAL);
    }

    @Override
    public Map<LivingMotion, AnimationManager.AnimationAccessor<? extends StaticAnimation>> getLivingMotionModifier(LivingEntityPatch<?> playerdata, InteractionHand hand) {
        if (hand == InteractionHand.MAIN_HAND) {
            Style currentStyle = this.getStyle(playerdata);

            if (currentStyle == Styles.TWO_HAND) {
                return this.dualWieldLivingMotions;
            }

            if (currentStyle == Styles.ONE_HAND || currentStyle == Styles.COMMON) {
                return this.offHandLivingMotions;
            }

            return this.rangeAnimationModifiers;
        }

        return super.getLivingMotionModifier(playerdata, hand);
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
        Style currentStyle = this.getStyle(playerpatch);

        if (currentStyle == Styles.TWO_HAND) {
            return this.dualWieldAttackMotion;
        }

        if (currentStyle == Styles.ONE_HAND) {
            return this.offHandAttackMotion;
        }

        if (currentStyle == Styles.COMMON) {
            return this.offHandFistAttackMotion;
        }

        return this.mainAttackMotion;
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
            return Styles.COMMON;
        }
        if (entitypatch.getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == MusketWeaponCategories.PISTOL && (entitypatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == WeaponCategories.SWORD || entitypatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == WeaponCategories.PICKAXE || entitypatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == WeaponCategories.AXE || entitypatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == WeaponCategories.SHOVEL || entitypatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == WeaponCategories.HOE)) {
            return Styles.ONE_HAND;
        }
        if (entitypatch.getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == MusketWeaponCategories.PISTOL && entitypatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == MusketWeaponCategories.PISTOL) {
            return Styles.TWO_HAND;
        }
        return Styles.RANGED;
    }

    @Override
    public boolean canBePlacedOffhand() {
        return true;
    }

    @Override
    public boolean checkOffhandValid(LivingEntityPatch<?> entityPatch) {
        ItemStack offhandItem = entityPatch.getOriginal().getOffhandItem();
        CapabilityItem itemCap = EpicFightCapabilities.getItemStackCapability(offhandItem);
        boolean isPistol = itemCap.getWeaponCategory() == MusketWeaponCategories.PISTOL;
        return isPistol || !(offhandItem.getItem() instanceof SwordItem || offhandItem.getItem() instanceof DiggerItem);
    }
}
