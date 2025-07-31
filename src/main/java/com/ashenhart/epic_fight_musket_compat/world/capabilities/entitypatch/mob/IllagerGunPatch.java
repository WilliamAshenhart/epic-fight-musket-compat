package com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.mob;


import com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.CustomMusketHumanoidMobPatch;
import yesman.epicfight.api.data.reloader.MobPatchReloadListener;
import yesman.epicfight.world.capabilities.entitypatch.Faction;
import yesman.epicfight.world.capabilities.entitypatch.mob.PillagerPatch;

public class IllagerGunPatch<T extends PillagerPatch> extends CustomMusketHumanoidMobPatch {

    public IllagerGunPatch(Faction faction, MobPatchReloadListener.CustomHumanoidMobPatchProvider provider) {
        super(faction, provider);
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