package com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch;

import com.ashenhart.epic_fight_musket_compat.gameassets.MusketMobCombatBehaviors;
import com.ashenhart.epic_fight_musket_compat.world.capabilities.item.MusketWeaponCategories;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;
import ewewukek.musketmod.GunItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.UseAnim;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.LivingMotion;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.client.animation.Layer;
import yesman.epicfight.api.data.reloader.MobPatchReloadListener;
import yesman.epicfight.world.capabilities.entitypatch.CustomHumanoidMobPatch;
import yesman.epicfight.world.capabilities.entitypatch.Faction;
import yesman.epicfight.world.capabilities.entitypatch.HumanoidMobPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.Style;
import yesman.epicfight.world.capabilities.item.WeaponCategory;
import yesman.epicfight.world.entity.ai.goal.AnimatedAttackGoal;
import yesman.epicfight.world.entity.ai.goal.CombatBehaviors;
import yesman.epicfight.world.entity.ai.goal.TargetChasingGoal;

import java.util.Map;
import java.util.Set;

public class MusketHumanoidMobPatch<T extends PathfinderMob> extends CustomHumanoidMobPatch<T> {
    protected Map<WeaponCategory, Map<Style, Set<Pair<LivingMotion, AnimationManager.AnimationAccessor<? extends StaticAnimation>>>>> weaponLivingMotions;
    protected Map<WeaponCategory, Map<Style, CombatBehaviors.Builder<HumanoidMobPatch<?>>>> weaponAttackMotions;

    public MusketHumanoidMobPatch(Faction faction, MobPatchReloadListener.CustomHumanoidMobPatchProvider provider) {
        super(faction, provider);
        this.setWeaponMotions();
    }


    @Override
    public void initAI() {
        super.initAI();
        if (this.original.getMainHandItem().getItem() instanceof GunItem) {
            this.setAIAsMusketeer(this.original.getMainHandItem().getItem() instanceof GunItem);
        }
    }

    public void setWeaponMotion() {
        this.weaponAttackMotions = Maps.newHashMap();
        this.weaponAttackMotions.put(MusketWeaponCategories.MUSKET, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviors.HUMANOID_MUSKET));
        this.weaponAttackMotions.put(MusketWeaponCategories.SCOPED, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviors.HUMANOID_MUSKET));
        this.weaponAttackMotions.put(MusketWeaponCategories.BAYONET, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviors.HUMANOID_BAYONET));
        this.weaponAttackMotions.put(MusketWeaponCategories.PISTOL, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviors.HUMANOID_PISTOL));
        this.weaponAttackMotions.put(MusketWeaponCategories.CEREMONIAL_MUSKET, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviors.HUMANOID_MUSKET));
        this.weaponAttackMotions.put(MusketWeaponCategories.CEREMONIAL_PISTOL, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviors.HUMANOID_PISTOL));
    }

    protected void setAIAsMusketeer(boolean holdingGun) {
        CombatBehaviors.Builder<HumanoidMobPatch<?>> builder = this.getHoldingItemWeaponMotionBuilder();

        if (builder != null) {
            this.original.goalSelector.addGoal(0, new AnimatedAttackGoal<>(this, builder.build(this)));
            this.original.goalSelector.addGoal(1, new TargetChasingGoal(this, this.getOriginal(), 1.0D, true));
        }
    }

    @Override
    public void onMount(boolean isMountOrDismount, Entity ridingEntity) {
        if (this.original == null) {
            return;
        }
        if (!this.original.level().isClientSide() && !this.original.isNoAi()) {
            Set<Goal> toRemove = Sets.newHashSet();
            this.selectGoalToRemove(toRemove);
            toRemove.forEach(this.original.goalSelector::removeGoal);

            if (isMountOrDismount) {
                this.setAIAsMounted(ridingEntity);
            } else {
                this.setAIAsInfantry(this.original.getMainHandItem().getItem() instanceof ProjectileWeaponItem);
            }
            if (isMountOrDismount) {
                this.setAIAsMusketeer(this.original.getMainHandItem().getItem() instanceof GunItem);
            }
        }
    }
    protected final void commonAggressiveMusketMobUpdateMotion(boolean considerInaction) {
        this.commonAggressiveMobUpdateMotion(considerInaction);
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
    }
}
