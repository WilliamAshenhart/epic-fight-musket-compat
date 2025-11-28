package com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.mob;

import net.minecraft.world.entity.PathfinderMob;
import yesman.epicfight.api.animation.Animator;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.world.capabilities.entitypatch.Faction;
import yesman.epicfight.world.capabilities.entitypatch.HumanoidMobPatch;

public abstract class AbstractRecruitPatch<T extends PathfinderMob> extends HumanoidMobPatch<T> {
    public AbstractRecruitPatch(Faction faction) {
        super(faction);
    }

    @Override
    public void initAnimator(Animator animator) {
        super.initAnimator(animator);

        animator.addLivingAnimation(LivingMotions.IDLE, Animations.BIPED_IDLE);
        animator.addLivingAnimation(LivingMotions.WALK, Animations.BIPED_WALK);
        animator.addLivingAnimation(LivingMotions.DEATH, Animations.BIPED_DEATH);
    }
}