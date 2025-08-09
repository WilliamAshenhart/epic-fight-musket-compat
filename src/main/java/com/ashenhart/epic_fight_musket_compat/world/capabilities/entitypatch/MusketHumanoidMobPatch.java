package com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.ashenhart.epic_fight_musket_compat.gameassets.MusketMobCombatBehaviors;
import com.ashenhart.epic_fight_musket_compat.world.capabilities.item.MusketWeaponCategories;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;

import ewewukek.musketmod.GunItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.item.*;
import yesman.epicfight.api.animation.AnimationManager.AnimationAccessor;
import yesman.epicfight.api.animation.Animator;
import yesman.epicfight.api.animation.LivingMotion;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.client.animation.Layer;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.MobCombatBehaviors;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.network.EpicFightNetworkManager;
import yesman.epicfight.network.server.SPChangeLivingMotion;
import yesman.epicfight.world.capabilities.entitypatch.Faction;
import yesman.epicfight.world.capabilities.entitypatch.HumanoidMobPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.CapabilityItem.WeaponCategories;
import yesman.epicfight.world.capabilities.item.Style;
import yesman.epicfight.world.capabilities.item.WeaponCategory;
import yesman.epicfight.world.damagesource.StunType;
import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
import yesman.epicfight.world.entity.ai.goal.AnimatedAttackGoal;
import yesman.epicfight.world.entity.ai.goal.CombatBehaviors;
import yesman.epicfight.world.entity.ai.goal.TargetChasingGoal;

public abstract class MusketHumanoidMobPatch<T extends PathfinderMob> extends HumanoidMobPatch<T> {
    protected Map<WeaponCategory, Map<Style, Set<Pair<LivingMotion, AnimationAccessor<? extends StaticAnimation>>>>> weaponLivingMotions;
    protected Map<WeaponCategory, Map<Style, CombatBehaviors.Builder<HumanoidMobPatch<?>>>> weaponAttackMotions;

    public MusketHumanoidMobPatch(Faction faction) {
        super(faction);
        this.setWeaponMotions();
    }

    @Override
    protected void initAI() {
        super.initAI();

        if (this.original.getVehicle() != null && this.original.getVehicle() instanceof Mob) {
            this.setAIAsMounted(this.original.getVehicle());
        } else {
            this.setAIAsInfantry(this.original.getMainHandItem().getItem() instanceof ProjectileWeaponItem);
        }
        if (this.original.getVehicle() != null && this.original.getVehicle() instanceof Mob) {
            this.setAIAsMounted(this.original.getVehicle());
        } else {
            this.setAIAsMusketeer(this.original.getMainHandItem().getItem() instanceof GunItem);
        }
    }

    protected void setWeaponMotions() {
        this.weaponAttackMotions = Maps.newHashMap();
        this.weaponAttackMotions.put(MusketWeaponCategories.MUSKET, ImmutableMap.of(CapabilityItem.Styles.COMMON, MusketMobCombatBehaviors.HUMANOID_MUSKET));
        this.weaponAttackMotions.put(MusketWeaponCategories.BAYONET, ImmutableMap.of(CapabilityItem.Styles.COMMON, MusketMobCombatBehaviors.HUMANOID_MUSKET));
        this.weaponAttackMotions.put(MusketWeaponCategories.SCOPED, ImmutableMap.of(CapabilityItem.Styles.COMMON, MusketMobCombatBehaviors.HUMANOID_MUSKET));
        this.weaponAttackMotions.put(MusketWeaponCategories.PISTOL, ImmutableMap.of(CapabilityItem.Styles.COMMON, MusketMobCombatBehaviors.HUMANOID_PISTOL));
        this.weaponAttackMotions.put(MusketWeaponCategories.CEREMONIAL_MUSKET, ImmutableMap.of(CapabilityItem.Styles.COMMON, MusketMobCombatBehaviors.HUMANOID_MUSKET));
        this.weaponAttackMotions.put(MusketWeaponCategories.CEREMONIAL_PISTOL, ImmutableMap.of(CapabilityItem.Styles.COMMON, MusketMobCombatBehaviors.HUMANOID_PISTOL));
    }

    protected CombatBehaviors.Builder<HumanoidMobPatch<?>> getHoldingItemWeaponMotionBuilder() {
        CapabilityItem itemCap = this.getHoldingItemCapability(InteractionHand.MAIN_HAND);

        if (this.weaponAttackMotions.containsKey(itemCap.getWeaponCategory())) {
            Map<Style, CombatBehaviors.Builder<HumanoidMobPatch<?>>> motionByStyle = this.weaponAttackMotions.get(itemCap.getWeaponCategory());
            Style style = itemCap.getStyle(this);

            if (motionByStyle.containsKey(style) || motionByStyle.containsKey(CapabilityItem.Styles.COMMON)) {
                return motionByStyle.getOrDefault(style, motionByStyle.get(CapabilityItem.Styles.COMMON));
            }
        }

        return this.original.getMainHandItem().isEmpty() ? MobCombatBehaviors.HUMANOID_FIST : MobCombatBehaviors.HUMANOID_ONEHAND_TOOLS;
    }

    public void setAIAsMusketeer(boolean holdingGun) {
        CombatBehaviors.Builder<HumanoidMobPatch<?>> builder = this.getHoldingItemWeaponMotionBuilder();

        if (builder != null) {
            this.original.goalSelector.addGoal(0, new AnimatedAttackGoal<>(this, builder.build(this)));
            this.original.goalSelector.addGoal(1, new TargetChasingGoal(this, this.getOriginal(), 1.0D, true));
        }
    }

    protected final void commonAggressiveMusketMobUpdate(boolean considerInaction) {
        this.commonAggressiveRangedMobUpdateMotion(considerInaction);
        UseAnim useAction = this.original.getItemInHand(this.original.getUsedItemHand()).getUseAnimation();

        if (this.getClientAnimator().getCompositeLayer(Layer.Priority.MIDDLE).animationPlayer.getRealAnimation().get().isReboundAnimation())
            currentCompositeMotion = LivingMotions.SHOT;
        else if (this.original.isUsingItem()) {
            if (useAction == UseAnim.CROSSBOW)
                currentCompositeMotion = LivingMotions.RELOAD;
            else
                currentCompositeMotion = LivingMotions.AIM;
        } else {
            if (GunItem.isLoaded(this.original.getMainHandItem()))
                currentCompositeMotion = LivingMotions.AIM;
            else
                currentCompositeMotion = this.currentLivingMotion;
        }
        if (CrossbowItem.isCharged(this.original.getMainHandItem()))
            currentCompositeMotion = LivingMotions.AIM;
        else
            currentCompositeMotion = currentLivingMotion;
    }
}