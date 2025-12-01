package com.ashenhart.epic_fight_musket_compat.gameassets;

import yesman.epicfight.world.capabilities.entitypatch.HumanoidMobPatch;
import yesman.epicfight.world.entity.ai.goal.CombatBehaviors;

public class MusketMobCombatBehaviours {
    public static final CombatBehaviors.Builder<HumanoidMobPatch<?>> RECRUIT_SPEAR = CombatBehaviors.<HumanoidMobPatch<?>>builder()
            .newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(100.0F).canBeInterrupted(false).looping(false)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.RECRUIT_SPEAR_AUTO_1).withinEyeHeight().withinDistance(0.0D, 3.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.RECRUIT_SPEAR_AUTO_2).withinEyeHeight().withinDistance(0.0D, 3.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.RECRUIT_SPEAR_AUTO_3).withinEyeHeight().withinDistance(0.0D, 3.0D))
            );
    public static final CombatBehaviors.Builder<HumanoidMobPatch<?>> HUMANOID_MUSKET = CombatBehaviors.<HumanoidMobPatch<?>>builder()
            .newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(100.0F).canBeInterrupted(false).looping(false)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.MUSKET_AUTO_1).withinEyeHeight().withinDistance(0.0D, 3.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.MUSKET_AUTO_2).withinEyeHeight().withinDistance(0.0D, 3.0D))
            );
    public static final CombatBehaviors.Builder<HumanoidMobPatch<?>> HUMANOID_PISTOL = CombatBehaviors.<HumanoidMobPatch<?>>builder()
            .newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(100.0F).canBeInterrupted(true).looping(false)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.PISTOL_AUTO_1).withinEyeHeight().withinDistance(0.0D, 3.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.PISTOL_AUTO_2).withinEyeHeight().withinDistance(0.0D, 3.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.PISTOL_AUTO_3).withinEyeHeight().withinDistance(0.0D, 3.0D))
            );
    public static final CombatBehaviors.Builder<HumanoidMobPatch<?>> HUMANOID_BAYONET = CombatBehaviors.<HumanoidMobPatch<?>>builder()
            .newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(100.0F).canBeInterrupted(false).looping(false)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.MUSKET_AUTO_1).withinEyeHeight().withinDistance(0.0D, 3.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.MUSKET_AUTO_2).withinEyeHeight().withinDistance(0.0D, 3.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.BAYONET_AUTO).withinEyeHeight().withinDistance(0.0D, 3.0D))
            ).newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(10.0F).canBeInterrupted(false).looping(false).cooldown(100)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.LAST_PUSH_TRY).withinEyeHeight().withinDistance(0.0D, 5.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder()
                                    .behavior((mobPatch) -> {
                                        if (mobPatch.isLastAttackSuccess()) {
                                            mobPatch.setLastAttackSuccess(false);
                                            mobPatch.playAnimationSynchronized(MusketAnimations.LAST_PUSH_HIT, 0.0F);
                                        } else {
                                            mobPatch.playAnimationSynchronized(MusketAnimations.LAST_PUSH_FAIL, 0.0F);
                                        }
                                    }).withinEyeHeight().withinDistance(0.0D, 3.0D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.LAST_PUSH_EXECUTE).custom(HumanoidMobPatch::isLastAttackSuccess).withinEyeHeight().withinDistance(0.0D, 3.0D))
            );
}
