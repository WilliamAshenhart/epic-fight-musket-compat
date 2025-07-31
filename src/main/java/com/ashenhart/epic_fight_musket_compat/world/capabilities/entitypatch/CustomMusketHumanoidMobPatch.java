package com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch;

import com.ashenhart.epic_fight_musket_compat.world.entity.ai.behavior.MusketAnimatedCombatBehavior;
import ewewukek.musketmod.GunItem;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.UseAnim;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.client.animation.Layer;
import yesman.epicfight.api.data.reloader.MobPatchReloadListener;
import yesman.epicfight.world.capabilities.entitypatch.Faction;
import yesman.epicfight.world.capabilities.entitypatch.HumanoidMobPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.entity.ai.behavior.AnimatedCombatBehavior;
import yesman.epicfight.world.entity.ai.behavior.MoveToTargetSinkStopInaction;
import yesman.epicfight.world.entity.ai.brain.BrainRecomposer;
import yesman.epicfight.world.entity.ai.goal.AnimatedAttackGoal;
import yesman.epicfight.world.entity.ai.goal.CombatBehaviors;
import yesman.epicfight.world.entity.ai.goal.TargetChasingGoal;

public class CustomMusketHumanoidMobPatch<T extends PathfinderMob> extends MusketHumanoidMobPatch<T> {
    private final MobPatchReloadListener.CustomHumanoidMobPatchProvider provider;

    public CustomMusketHumanoidMobPatch(Faction faction, MobPatchReloadListener.CustomHumanoidMobPatchProvider provider) {
        super(faction, provider);

        this.provider = provider;
    }

    @Override
    public void setAIAsMusketeer(boolean holdingGun) {
        boolean useBrain = !this.original.getBrain().availableBehaviorsByPriority.isEmpty();

        if (useBrain) {
            if (!holdingGun) {
                CombatBehaviors.Builder<HumanoidMobPatch<?>> builder = this.getHoldingItemWeaponMotionBuilder();
                BrainRecomposer.recomposeBrainByType(this.original.getType(), this.original.getBrain(), (builder != null) ? new MusketAnimatedCombatBehavior(this, builder.build(this)) : null, new MoveToTargetSinkStopInaction());
            }
        } else {
            if (!holdingGun) {
                CombatBehaviors.Builder<HumanoidMobPatch<?>> builder = this.getHoldingItemWeaponMotionBuilder();

                if (builder != null) {
                    this.original.goalSelector.addGoal(0, new AnimatedAttackGoal<>(this, builder.build(this)));
                    this.original.goalSelector.addGoal(1, new TargetChasingGoal(this, this.getOriginal(), this.provider.getChasingSpeed(), true));
                }
            }
        }
    }

    @Override
    public void updateMotion(boolean considerInaction) {
        super.commonAggressiveMobUpdateMotion(considerInaction);
        if (GunItem.isLoaded(this.original.getMainHandItem()))
            currentCompositeMotion = LivingMotions.AIM;
        else if (this.getClientAnimator().getCompositeLayer(Layer.Priority.MIDDLE).animationPlayer.getAnimation().get().isReboundAnimation())
            currentCompositeMotion = LivingMotions.NONE;
        else if (this.original.swinging && this.original.getSleepingPos().isEmpty())
            currentCompositeMotion = LivingMotions.DIGGING;
        else
            currentCompositeMotion = currentLivingMotion;
    }
}