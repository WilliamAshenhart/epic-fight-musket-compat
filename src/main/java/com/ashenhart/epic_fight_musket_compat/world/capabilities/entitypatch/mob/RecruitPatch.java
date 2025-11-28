package com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.mob;

import net.minecraft.world.entity.PathfinderMob;
import yesman.epicfight.world.capabilities.entitypatch.Factions;

import net.minecraft.world.entity.Entity;

public class RecruitPatch<T extends PathfinderMob> extends AbstractRecruitPatch<T> {
    public RecruitPatch() {
        super(Factions.VILLAGER);
    }


    @Override
    public void updateMotion(boolean considerInaction) {
        super.commonAggressiveRangedMobUpdateMotion(considerInaction);

    }

    @Override
    public void setAIAsInfantry(boolean holdingRanedWeapon) {
        if (!holdingRanedWeapon) {
            super.setAIAsInfantry(holdingRanedWeapon);
        }
    }

    @Override
    public void setAIAsMounted(Entity ridingEntity) {
    }
}