package com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.mob;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.item.ShieldItem;
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
        animator.addLivingAnimation(LivingMotions.DRINK, Animations.BIPED_DRINK);
        animator.addLivingAnimation(LivingMotions.EAT, Animations.BIPED_EAT);
        animator.addLivingAnimation(LivingMotions.JUMP, Animations.BIPED_JUMP);
        animator.addLivingAnimation(LivingMotions.SLEEP, Animations.BIPED_SLEEPING);
        animator.addLivingAnimation(LivingMotions.MOUNT, Animations.BIPED_MOUNT);
        animator.addLivingAnimation(LivingMotions.BLOCK, Animations.BIPED_BLOCK);
    }

    @Override
    public void updateMotion(boolean considerInaction) {
        if (this.original.isUsingItem() && this.original.getUseItem().getItem() instanceof ShieldItem) {
            this.currentCompositeMotion = LivingMotions.BLOCK;
        } else {
            super.commonAggressiveRangedMobUpdateMotion(considerInaction);
        }
    }
}