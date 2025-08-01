package com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.mob;


import com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.CustomMusketHumanoidMobPatch;
import com.ashenhart.epic_fight_musket_compat.world.capabilities.item.MusketWeaponCategories;
import com.ashenhart.epic_fight_musket_compat.gameassets.MusketMobCombatBehaviors;
import com.google.common.collect.ImmutableMap;
import yesman.epicfight.api.data.reloader.MobPatchReloadListener;
import yesman.epicfight.world.capabilities.entitypatch.Faction;
import yesman.epicfight.world.capabilities.entitypatch.mob.PillagerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public class IllagerGunPatch<T extends PillagerPatch> extends CustomMusketHumanoidMobPatch {

    public IllagerGunPatch(Faction faction, MobPatchReloadListener.CustomHumanoidMobPatchProvider provider) {
        super(faction, provider);
    }

    @Override
    protected void setWeaponMotions() {
        super.setWeaponMotions();

        this.weaponAttackMotions.put(MusketWeaponCategories.PISTOL, ImmutableMap.of(CapabilityItem.Styles.RANGED, MusketMobCombatBehaviors.HUMANOID_PISTOL));
    }

    @Override
    public void updateMotion(boolean considerInaction) {
        super.commonAggressiveMusketMobUpdateMotion(considerInaction);
    }

    @Override
    public void setAIAsMusketeer(boolean holdingGun) {
        if (!holdingGun) {
            super.setAIAsMusketeer(holdingGun);
        }
    }
}