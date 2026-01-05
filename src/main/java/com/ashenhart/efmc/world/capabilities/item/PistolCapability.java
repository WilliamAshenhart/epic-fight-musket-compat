package com.ashenhart.efmc.world.capabilities.item;

import com.ashenhart.efmc.gameassets.MusketAnimations;
import com.google.common.collect.Maps;
import ewewukek.musketmod.GunItem;
import ewewukek.musketmod.PistolItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.*;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.LivingMotion;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.registry.entries.EpicFightSounds;
import yesman.epicfight.registry.entries.EpicFightParticles;
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
    private final List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> mountAttackMotion;

    private final Map<LivingMotion, AnimationManager.AnimationAccessor<? extends StaticAnimation>> dualWieldLivingMotions;
    private final Map<LivingMotion, AnimationManager.AnimationAccessor<? extends StaticAnimation>> offHandLivingMotions;

    protected PistolCapability(RangedWeaponCapability.Builder builder) {
        super(builder);

        this.mainAttackMotion = List.of(MusketAnimations.PISTOL_AUTO_1, MusketAnimations.PISTOL_AUTO_2, MusketAnimations.PISTOL_AUTO_3, MusketAnimations.PISTOL_DASH, Animations.SWORD_AIR_SLASH);
        this.dualWieldAttackMotion = List.of(MusketAnimations.DUAL_PISTOL_AUTO1, MusketAnimations.DUAL_PISTOL_AUTO2, MusketAnimations.DUAL_PISTOL_DASH, MusketAnimations.DUAL_PISTOL_AIRSLASH);
        this.mountAttackMotion = List.of(Animations.SWORD_MOUNT_ATTACK);

        this.dualWieldLivingMotions = Maps.newHashMap(this.rangeAnimationModifiers);

        this.dualWieldLivingMotions.put(LivingMotions.IDLE, Animations.BIPED_HOLD_DUAL_WEAPON);
        this.dualWieldLivingMotions.put(LivingMotions.AIM, MusketAnimations.HOLD_DUAL_PISTOL);
        this.dualWieldLivingMotions.put(LivingMotions.SHOT, MusketAnimations.DUAL_PISTOL_SHOT);
        this.dualWieldLivingMotions.put(LivingMotions.WALK, Animations.BIPED_HOLD_DUAL_WEAPON);
        this.dualWieldLivingMotions.put(LivingMotions.RUN, Animations.BIPED_RUN_DUAL);

        this.offHandLivingMotions = Maps.newHashMap(this.rangeAnimationModifiers);

        this.offHandLivingMotions.put(LivingMotions.IDLE, Animations.BIPED_IDLE);
        this.offHandLivingMotions.put(LivingMotions.AIM, MusketAnimations.HOLD_OFFHAND);
        this.offHandLivingMotions.put(LivingMotions.SHOT, MusketAnimations.OFFHAND_SHOT);
        this.offHandLivingMotions.put(LivingMotions.RELOAD, MusketAnimations.RELOAD_OFFHAND);
        this.offHandLivingMotions.put(LivingMotions.WALK, Animations.BIPED_HOLD_DUAL_WEAPON);
        this.offHandLivingMotions.put(LivingMotions.RUN, Animations.BIPED_RUN);
    }
    @Override
    public Map<LivingMotion, AnimationManager.AnimationAccessor<? extends StaticAnimation>> getLivingMotionModifier(LivingEntityPatch<?> playerdata, InteractionHand hand) {
        if (hand == InteractionHand.MAIN_HAND) {
            Style currentStyle = this.getStyle(playerdata);

            if (currentStyle == Styles.TWO_HAND) {
                return this.dualWieldLivingMotions;
            }

            return this.rangeAnimationModifiers;
        }
        if (hand == InteractionHand.OFF_HAND) {
            Item mainHandItem = playerdata.getOriginal().getMainHandItem().getItem();
            if (!(mainHandItem instanceof GunItem) && !(mainHandItem instanceof TridentItem) && !(mainHandItem instanceof ProjectileWeaponItem)) {
                return this.offHandLivingMotions;
            }
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
        return this.mainAttackMotion;
    }

    public List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> getMountAttackMotion() {
        return this.mountAttackMotion;
    }


    @Override
    public LivingMotion getLivingMotion(LivingEntityPatch<?> entitypatch, InteractionHand hand) {
        return entitypatch.getEntityState().canUseItem() &&
                entitypatch.getOriginal().getItemInHand(hand).getItem() instanceof GunItem &&
                PistolItem.isLoaded(entitypatch.getOriginal().getItemInHand(hand))
                ? LivingMotions.AIM : null;
    }

    @Override
    public Style getStyle(LivingEntityPatch<?> entitypatch) {
        if (entitypatch.getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == MusketWeaponCategories.PISTOL) {
            return Styles.TWO_HAND;
        }
        return Styles.ONE_HAND;
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
