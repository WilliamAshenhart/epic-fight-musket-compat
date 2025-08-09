package com.ashenhart.epic_fight_musket_compat.gameassets;

import yesman.epicfight.world.capabilities.entitypatch.HumanoidMobPatch;
import yesman.epicfight.world.entity.ai.goal.CombatBehaviors;

public class MusketMobCombatBehaviors {
    public static final CombatBehaviors.Builder<HumanoidMobPatch<?>> HUMANOID_MUSKET = CombatBehaviors.<HumanoidMobPatch<?>>builder()
            .newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(100.0F).canBeInterrupted(false).looping(true)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.MUSKET_AUTO_1).withinEyeHeight().withinDistance(0.0D, 1.8D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.MUSKET_AUTO_2).withinEyeHeight().withinDistance(0.0D, 1.8D))
            ).newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(60.0F).canBeInterrupted(false).looping(true)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.MUSKET_DASH).withinEyeHeight().withinDistance(0.0D, 5.0D))
            );
    public static final CombatBehaviors.Builder<HumanoidMobPatch<?>> HUMANOID_BAYONET = CombatBehaviors.<HumanoidMobPatch<?>>builder()
            .newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(100.0F).canBeInterrupted(false).looping(true)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.MUSKET_AUTO_1).withinEyeHeight().withinDistance(0.0D, 1.8D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.MUSKET_AUTO_2).withinEyeHeight().withinDistance(0.0D, 1.8D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.BAYONET_AUTO).withinEyeHeight().withinDistance(0.0D, 1.8D))
            ).newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(60.0F).canBeInterrupted(false).looping(true)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.BAYONET_DASH).withinEyeHeight().withinDistance(0.0D, 5.0D))
            );
    public static final CombatBehaviors.Builder<HumanoidMobPatch<?>> HUMANOID_PISTOL = CombatBehaviors.<HumanoidMobPatch<?>>builder()
            .newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(100.0F).canBeInterrupted(false).looping(true)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.PISTOL_AUTO_1).withinEyeHeight().withinDistance(0.0D, 1.8D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.PISTOL_AUTO_2).withinEyeHeight().withinDistance(0.0D, 1.8D))
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.PISTOL_AUTO_3).withinEyeHeight().withinDistance(0.0D, 1.8D))
            ).newBehaviorSeries(
                    CombatBehaviors.BehaviorSeries.<HumanoidMobPatch<?>>builder().weight(60.0F).canBeInterrupted(false).looping(true)
                            .nextBehavior(CombatBehaviors.Behavior.<HumanoidMobPatch<?>>builder().animationBehavior(MusketAnimations.PISTOL_DASH).withinEyeHeight().withinDistance(0.0D, 5.0D))
            );
}
