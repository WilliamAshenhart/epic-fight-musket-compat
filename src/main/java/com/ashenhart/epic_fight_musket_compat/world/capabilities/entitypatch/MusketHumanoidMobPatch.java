package com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch;

import com.ashenhart.epic_fight_musket_compat.gameassets.MusketMobCombatBehaviors;
import com.ashenhart.epic_fight_musket_compat.world.capabilities.item.MusketWeaponCategories;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import ewewukek.musketmod.GunItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.item.UseAnim;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.client.animation.Layer;
import yesman.epicfight.api.data.reloader.MobPatchReloadListener;
import yesman.epicfight.gameasset.MobCombatBehaviors;
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

public class MusketHumanoidMobPatch<T extends PathfinderMob> extends CustomHumanoidMobPatch<T> {
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

    public void setWeaponMotions() {
        this.weaponAttackMotions = Maps.newHashMap();
        this.weaponAttackMotions.put(MusketWeaponCategories.MUSKET, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviors.HUMANOID_MUSKET));
        this.weaponAttackMotions.put(MusketWeaponCategories.SCOPED, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviors.HUMANOID_MUSKET));
        this.weaponAttackMotions.put(MusketWeaponCategories.BAYONET, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviors.HUMANOID_BAYONET));
        this.weaponAttackMotions.put(MusketWeaponCategories.PISTOL, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviors.HUMANOID_PISTOL));
        this.weaponAttackMotions.put(MusketWeaponCategories.CEREMONIAL_MUSKET, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviors.HUMANOID_MUSKET));
        this.weaponAttackMotions.put(MusketWeaponCategories.CEREMONIAL_PISTOL, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviors.HUMANOID_PISTOL));
    }
    public void setAIAsMusketeer(boolean holdingGun) {
        CombatBehaviors.Builder<HumanoidMobPatch<?>> builder = this.getHoldingItemWeaponMotionBuilder();

        if (builder != null) {
            this.original.goalSelector.addGoal(0, new AnimatedAttackGoal<>(this, builder.build(this)));
            this.original.goalSelector.addGoal(1, new TargetChasingGoal(this, this.getOriginal(), 1.0D, true));
        }
    }
}
