package com.ashenhart.epic_fight_musket_compat.gameassets;

import com.ashenhart.epic_fight_musket_compat.Epic_fight_musket_compat;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.animation.AnimationClip;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.AnimationManager.AnimationRegistryEvent;
import yesman.epicfight.api.animation.AnimationManager.AnimationAccessor;
import yesman.epicfight.api.animation.property.AnimationProperty.*;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.math.ValueModifier;;
import yesman.epicfight.gameasset.Armatures;

public class Animations {
        public static DirectStaticAnimation EMPTY_ANIMATION = new DirectStaticAnimation() {
            @Override
            public void loadAnimation() {
            }

            @Override
            public AnimationClip getAnimationClip() {
                return AnimationClip.EMPTY_CLIP;
            }
        };

        public static AnimationAccessor<StaticAnimation> HOLD_MUSKET;
        public static AnimationAccessor<MovementAnimation> WALK_MUSKET;
        public static AnimationAccessor<MovementAnimation> RUN_MUSKET;
        public static AnimationAccessor<StaticAnimation> KNEEL_MUSKET;
        public static AnimationAccessor<MovementAnimation> SNEAK_MUSKET;
        public static AnimationAccessor<StaticAnimation> RELOAD_MUSKET;
        public static AnimationAccessor<BasicAttackAnimation> MUSKET_AUTO_1;
        public static AnimationAccessor<MovementAnimation> RUN_BAYONET;
        public static AnimationAccessor<BasicAttackAnimation> BAYONET;
        public static AnimationAccessor<DashAttackAnimation> BAYONET_DASH;
        public static AnimationAccessor<StaticAnimation> HOLD_PISTOL;
        public static AnimationAccessor<StaticAnimation> KNEEL_PISTOL;
        public static AnimationAccessor<MovementAnimation> SNEAK_PISTOL;
        public static AnimationAccessor<MovementAnimation> WALK_PISTOL;
        public static AnimationAccessor<MovementAnimation> RUN_PISTOL;
        public static AnimationAccessor<StaticAnimation> RELOAD_PISTOL;
        public static AnimationAccessor<BasicAttackAnimation> PISTOL_AUTO_1;
        public static AnimationAccessor<BasicAttackAnimation> PISTOL_AUTO_2;
        public static AnimationAccessor<BasicAttackAnimation> PISTOL_AUTO_3;
        public static AnimationAccessor<DashAttackAnimation> PISTOL_DASH;
        public static AnimationAccessor<StaticAnimation> HOLD_BANNER;
        public static AnimationAccessor<MovementAnimation> SNEAK_BANNER;
        public static AnimationAccessor<StaticAnimation> KNEEL_BANNER;
        public static AnimationAccessor<StaticAnimation> HOLD_SCOPE;
        public static AnimationAccessor<MovementAnimation> SNEAK_SCOPE;
        public static AnimationAccessor<StaticAnimation> KNEEL_SCOPE;

    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.newBuilder(Epic_fight_musket_compat.MODID, Animations::build);
    }
    public static void build(AnimationManager.AnimationBuilder builder) {
        HOLD_MUSKET = builder.nextAccessor("biped/living/hold_musket", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        WALK_MUSKET = builder.nextAccessor("biped/living/walk_musket", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        RUN_MUSKET = builder.nextAccessor("biped/living/run_musket", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        KNEEL_MUSKET = builder.nextAccessor("biped/living/kneel_musket", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        SNEAK_MUSKET = builder.nextAccessor("biped/living/sneak_musket", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        RELOAD_MUSKET = builder.nextAccessor("biped/living/reload_musket", (accessor) -> new StaticAnimation(false, accessor, Armatures.BIPED));
        RUN_BAYONET = builder.nextAccessor("biped/living/run_bayonet", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BAYONET_DASH = builder.nextAccessor("biped/combat/bayonet_dash", (accessor) ->
                new DashAttackAnimation(0.1F, 0.2F, 0.4F, 0.6F, 0.9F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED, true)
                        .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F))
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,0.4F));
        MUSKET_AUTO_1 = builder.nextAccessor("biped/combat/musket_auto_1", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.3F, 0.5F, 0.8F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,0.4F));
        BAYONET = builder.nextAccessor("biped/combat/bayonet", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.4F, 0.6F, 0.7F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,0.4F));
        HOLD_PISTOL = builder.nextAccessor("biped/living/hold_pistol", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        KNEEL_PISTOL = builder.nextAccessor("biped/living/kneel_pistol", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        SNEAK_PISTOL = builder.nextAccessor("biped/living/sneak_pistol", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        RUN_PISTOL = builder.nextAccessor("biped/living/run_pistol", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        WALK_PISTOL = builder.nextAccessor("biped/living/walk_pistol", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        RELOAD_PISTOL = builder.nextAccessor("biped/living/reload_pistol", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        PISTOL_AUTO_1 = builder.nextAccessor("biped/combat/pistol_auto_1", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.5F, 0.6F, 0.8F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,0.4F));
        PISTOL_AUTO_2 = builder.nextAccessor("biped/combat/pistol_auto_2", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.3F, 0.4F, 0.8F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,0.4F));
        PISTOL_AUTO_3 = builder.nextAccessor("biped/combat/pistol_auto_3", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.5F, 0.6F, 0.8F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,0.4F));
        PISTOL_DASH = builder.nextAccessor("biped/combat/bayonet_dash", (accessor) ->
                new DashAttackAnimation(0.1F, 0.0F, 0.2F, 0.4F, 0.65F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED, true)
                        .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F))
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,0.4F));
        HOLD_SCOPE = builder.nextAccessor("biped/living/hold_scope", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        KNEEL_SCOPE = builder.nextAccessor("biped/living/kneel_scope", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        SNEAK_SCOPE = builder.nextAccessor("biped/living/sneak_musket", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
    }
}
