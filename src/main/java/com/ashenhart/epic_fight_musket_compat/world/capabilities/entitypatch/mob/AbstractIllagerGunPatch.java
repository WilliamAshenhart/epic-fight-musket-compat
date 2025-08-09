package com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.mob;

import com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.MusketHumanoidMobPatch;
import net.minecraft.world.entity.PathfinderMob;
import yesman.epicfight.api.animation.Animator;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.world.capabilities.entitypatch.Faction;

public abstract class AbstractIllagerGunPatch<T extends PathfinderMob> extends MusketHumanoidMobPatch<T> {
    public AbstractIllagerGunPatch(Faction faction) {
        super(faction);
    }

    @Override
    public void initAnimator(Animator animator) {
        super.initAnimator(animator);

        animator.addLivingAnimation(LivingMotions.IDLE, Animations.ILLAGER_IDLE);
        animator.addLivingAnimation(LivingMotions.WALK, Animations.ILLAGER_WALK);
        animator.addLivingAnimation(LivingMotions.DEATH, Animations.BIPED_DEATH);
    }
}