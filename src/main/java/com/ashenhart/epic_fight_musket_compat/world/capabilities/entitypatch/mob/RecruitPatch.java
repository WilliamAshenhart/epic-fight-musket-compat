package com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.mob;

import com.ashenhart.epic_fight_musket_compat.gameassets.MusketAnimations;
import com.ashenhart.epic_fight_musket_compat.gameassets.MusketMobCombatBehaviours;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.world.entity.PathfinderMob;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.world.capabilities.entitypatch.Factions;

import net.minecraft.world.entity.Entity;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.Set;

public class RecruitPatch<T extends PathfinderMob> extends AbstractRecruitPatch<T> {
    public RecruitPatch() {
        super(Factions.VILLAGER);
    }


    @Override
    public void updateMotion(boolean considerInaction) {
        super.commonAggressiveRangedMobUpdateMotion(considerInaction);

    }

    @Override
    protected void setWeaponMotions() {
        super.setWeaponMotions();

        this.weaponLivingMotions.put(CapabilityItem.WeaponCategories.SPEAR, ImmutableMap.of(
                CapabilityItem.Styles.TWO_HAND, Set.of(
                        Pair.of(LivingMotions.IDLE, MusketAnimations.RECRUIT_SPEAR_LIVING),
                        Pair.of(LivingMotions.WALK, MusketAnimations.RECRUIT_SPEAR_LIVING)
                )
        ));
        this.weaponAttackMotions.put(CapabilityItem.WeaponCategories.SPEAR, ImmutableMap.of(
                CapabilityItem.Styles.TWO_HAND, MusketMobCombatBehaviours.RECRUIT_SPEAR));
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