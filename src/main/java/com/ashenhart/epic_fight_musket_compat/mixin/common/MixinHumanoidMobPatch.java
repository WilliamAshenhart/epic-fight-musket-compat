package com.ashenhart.epic_fight_musket_compat.mixin.common;

import com.ashenhart.epic_fight_musket_compat.gameassets.MusketMobCombatBehaviours;
import com.ashenhart.epic_fight_musket_compat.world.capabilities.item.MusketWeaponCategories;
import com.google.common.collect.ImmutableMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.world.capabilities.entitypatch.HumanoidMobPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.Style;
import yesman.epicfight.world.capabilities.item.WeaponCategory;
import yesman.epicfight.world.entity.ai.goal.CombatBehaviors;

import java.util.Map;

@Mixin (HumanoidMobPatch.class)
public abstract class MixinHumanoidMobPatch {

    @Shadow(remap = false)
    protected Map<WeaponCategory, Map<Style, CombatBehaviors.Builder<HumanoidMobPatch<?>>>> weaponAttackMotions;

    @Inject(method = "setWeaponMotions", at = @At("TAIL"),remap = false)
    private void setWeaponAttackMotions(CallbackInfo ci) {
        this.weaponAttackMotions.put(MusketWeaponCategories.MUSKET, ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, MusketMobCombatBehaviours.HUMANOID_MUSKET));
        this.weaponAttackMotions.put(MusketWeaponCategories.PISTOL, ImmutableMap.of(CapabilityItem.Styles.ONE_HAND, MusketMobCombatBehaviours.HUMANOID_PISTOL));
        this.weaponAttackMotions.put(MusketWeaponCategories.BAYONET, ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, MusketMobCombatBehaviours.HUMANOID_BAYONET));
        this.weaponAttackMotions.put(MusketWeaponCategories.SCOPED, ImmutableMap.of(CapabilityItem.Styles.TWO_HAND, MusketMobCombatBehaviours.HUMANOID_MUSKET));
        this.weaponAttackMotions.put(MusketWeaponCategories.CEREMONIAL_MUSKET, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviours.HUMANOID_MUSKET));
        this.weaponAttackMotions.put(MusketWeaponCategories.CEREMONIAL_PISTOL, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviours.HUMANOID_PISTOL));
    }
}
