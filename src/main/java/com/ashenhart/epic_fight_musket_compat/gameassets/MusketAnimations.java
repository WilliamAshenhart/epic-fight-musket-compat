package com.ashenhart.epic_fight_musket_compat.gameassets;

import com.ashenhart.epic_fight_musket_compat.Epic_fight_musket_compat;
import ewewukek.musketmod.Sounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.AnimationManager.AnimationRegistryEvent;
import yesman.epicfight.api.animation.AnimationManager.AnimationAccessor;
import yesman.epicfight.api.animation.property.AnimationProperty.*;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;


public class MusketAnimations {

    public static AnimationAccessor<StaticAnimation> HOLD_MUSKET;
    public static AnimationAccessor<StaticAnimation> HOLD_CEREMONIAL_MUSKET;
    public static AnimationAccessor<MovementAnimation> WALK_CEREMONIAL_MUSKET;
    public static AnimationAccessor<MovementAnimation> RUN_CEREMONIAL_MUSKET;
    public static AnimationAccessor<AimAnimation> CEREMONIAL_MUSKET_AIM;
    public static AnimationAccessor<BasicAttackAnimation> CEREMONIAL_MUSKET_AUTO_1;
    public static AnimationAccessor<BasicAttackAnimation> CEREMONIAL_MUSKET_AUTO_2;
    public static AnimationAccessor<BasicAttackAnimation> CEREMONIAL_MUSKET_AUTO_3;
    public static AnimationAccessor<AimAnimation>  MUSKET_AIM;
    public static AnimationAccessor<ReboundAnimation> MUSKET_SHOT;
    public static AnimationAccessor<MovementAnimation> WALK_MUSKET;
    public static AnimationAccessor<MovementAnimation> RUN_MUSKET;
    public static AnimationAccessor<StaticAnimation> KNEEL_MUSKET;
    public static AnimationAccessor<MovementAnimation> SNEAK_MUSKET;
    public static AnimationAccessor<StaticAnimation> RELOAD_MUSKET;
    public static AnimationAccessor<BasicAttackAnimation> MUSKET_AUTO_1;
    public static AnimationAccessor<BasicAttackAnimation> MUSKET_AUTO_2;
    public static AnimationAccessor<DashAttackAnimation> MUSKET_DASH;
    public static AnimationAccessor<StaticAnimation> HOLD_BAYONET;
    public static AnimationAccessor<MovementAnimation> WALK_BAYONET;
    public static AnimationAccessor<MovementAnimation> RUN_BAYONET;
    public static AnimationAccessor<BasicAttackAnimation> BAYONET_AUTO;
    public static AnimationAccessor<DashAttackAnimation> BAYONET_DASH;
    public static AnimationAccessor<StaticAnimation> HOLD_PISTOL;
    public static AnimationAccessor<AimAnimation> PISTOL_AIM;
    public static AnimationAccessor<ReboundAnimation> PISTOL_SHOT;
    public static AnimationAccessor<StaticAnimation> KNEEL_PISTOL;
    public static AnimationAccessor<MovementAnimation> SNEAK_PISTOL;
    public static AnimationAccessor<MovementAnimation> WALK_PISTOL;
    public static AnimationAccessor<MovementAnimation> RUN_PISTOL;
    public static AnimationAccessor<StaticAnimation> RELOAD_PISTOL;
    public static AnimationAccessor<StaticAnimation> HOLD_DUAL_PISTOL;
    public static AnimationAccessor<ReboundAnimation> DUAL_PISTOL_SHOT;
    public static AnimationAccessor<StaticAnimation> HOLD_OFFHAND;
    public static AnimationAccessor<StaticAnimation> RELOAD_OFFHAND;
    public static AnimationAccessor<ReboundAnimation> OFFHAND_SHOT;
    public static AnimationAccessor<BasicAttackAnimation> DUAL_PISTOL_AUTO1;
    public static AnimationAccessor<BasicAttackAnimation> DUAL_PISTOL_AUTO2;
    public static AnimationAccessor<DashAttackAnimation> DUAL_PISTOL_DASH;
    public static AnimationAccessor<AirSlashAnimation> DUAL_PISTOL_AIRSLASH;
    public static AnimationAccessor<AimAnimation> CEREMONIAL_PISTOL_AIM;
    public static AnimationAccessor<BasicAttackAnimation> CEREMONIAL_PISTOL_AUTO_1;
    public static AnimationAccessor<BasicAttackAnimation> CEREMONIAL_PISTOL_AUTO_2;
    public static AnimationAccessor<BasicAttackAnimation> CEREMONIAL_PISTOL_AUTO_3;
    public static AnimationAccessor<DashAttackAnimation> CEREMONIAL_PISTOL_DASH;
    public static AnimationAccessor<BasicAttackAnimation> PISTOL_AUTO_1;
    public static AnimationAccessor<BasicAttackAnimation> PISTOL_AUTO_2;
    public static AnimationAccessor<BasicAttackAnimation> PISTOL_AUTO_3;
    public static AnimationAccessor<DashAttackAnimation> PISTOL_DASH;
    public static AnimationAccessor<AimAnimation> AIM_SCOPE;
    public static AnimationAccessor<MovementAnimation> SNEAK_SCOPE;
    public static AnimationAccessor<StaticAnimation> KNEEL_SCOPE;
    public static AnimationAccessor<AttackAnimation> LAST_PUSH_EXECUTE;
    public static AnimationAccessor<AttackAnimation> LAST_PUSH_EXECUTE_LOADED;
    public static AnimationAccessor<AttackAnimation> LAST_PUSH_HIT;
    public static AnimationAccessor<AttackAnimation> LAST_PUSH_TRY;
    public static AnimationAccessor<AttackAnimation> LAST_PUSH_FAIL;
    public static AnimationAccessor<StaticAnimation> RECRUIT_SPEAR_LIVING;
    public static AnimationAccessor<BasicAttackAnimation> RECRUIT_SPEAR_AUTO_1;
    public static AnimationAccessor<BasicAttackAnimation> RECRUIT_SPEAR_AUTO_2;
    public static AnimationAccessor<BasicAttackAnimation> RECRUIT_SPEAR_AUTO_3;

    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.newBuilder(Epic_fight_musket_compat.MODID, MusketAnimations::build);
    }
    public static void build(AnimationManager.AnimationBuilder builder) {
        HOLD_MUSKET = builder.nextAccessor("biped/living/hold_musket", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        HOLD_CEREMONIAL_MUSKET = builder.nextAccessor("biped/living/hold_ceremonial_musket", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        WALK_CEREMONIAL_MUSKET = builder.nextAccessor("biped/living/walk_ceremonial_musket", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        RUN_CEREMONIAL_MUSKET = builder.nextAccessor("biped/living/run_ceremonial_musket", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        CEREMONIAL_MUSKET_AIM = builder.nextAccessor("biped/combat/ceremonial_musket_aim", (accessor) -> new AimAnimation(true, accessor, "biped/combat/ceremonial_musket_aim_mid", "biped/combat/ceremonial_musket_aim_up", "biped/combat/ceremonial_musket_aim_down", "biped/combat/ceremonial_musket_aim_lying", Armatures.BIPED));
        CEREMONIAL_MUSKET_AUTO_1 = builder.nextAccessor("biped/combat/ceremonial_musket_auto_1", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.3F, 0.5F, 0.7F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,2.1F));
        CEREMONIAL_MUSKET_AUTO_2 = builder.nextAccessor("biped/combat/ceremonial_musket_auto_2", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.2F, 0.4F, 0.7F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,2.1F));
        CEREMONIAL_MUSKET_AUTO_3 = builder.nextAccessor("biped/combat/ceremonial_musket_auto_3", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.3F, 0.5F, 0.6F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,2.1F));
        MUSKET_AIM = builder.nextAccessor("biped/combat/musket_aim", (accessor) -> new AimAnimation(true, accessor, "biped/combat/musket_aim_mid", "biped/combat/musket_aim_up", "biped/combat/musket_aim_down", "biped/combat/musket_aim_lying", Armatures.BIPED));
        MUSKET_SHOT = builder.nextAccessor("biped/combat/musket_shot", (accessor) -> new ReboundAnimation(false, accessor, "biped/combat/musket_shot_mid", "biped/combat/musket_shot_up", "biped/combat/musket_shot_down", "biped/combat/musket_shot_lying", Armatures.BIPED));
        WALK_MUSKET = builder.nextAccessor("biped/living/walk_musket", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        RUN_MUSKET = builder.nextAccessor("biped/living/run_musket", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        KNEEL_MUSKET = builder.nextAccessor("biped/living/kneel_musket", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        SNEAK_MUSKET = builder.nextAccessor("biped/living/sneak_musket", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        RELOAD_MUSKET = builder.nextAccessor("biped/living/reload_musket", (accessor) -> new StaticAnimation(false, accessor, Armatures.BIPED));
        HOLD_BAYONET = builder.nextAccessor("biped/living/hold_bayonet", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        WALK_BAYONET = builder.nextAccessor("biped/living/walk_bayonet", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        RUN_BAYONET = builder.nextAccessor("biped/living/run_bayonet", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        BAYONET_AUTO = builder.nextAccessor("biped/combat/bayonet_auto", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.4F, 0.6F, 0.7F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_HIT.get())
                        .addProperty(AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLADE)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,1.3F));
        BAYONET_DASH = builder.nextAccessor("biped/combat/bayonet_dash", (accessor) ->
                new DashAttackAnimation(0.1F, 0.2F, 0.4F, 0.6F, 0.9F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED, true)
                        .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F))
                        .addProperty(AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLADE_HIT.get())
                        .addProperty(AttackPhaseProperty.PARTICLE, EpicFightParticles.HIT_BLADE)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,1.3F));
        MUSKET_AUTO_1 = builder.nextAccessor("biped/combat/musket_auto_1", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.5F, 0.6F, 0.8F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,1.3F));
        MUSKET_AUTO_2 = builder.nextAccessor("biped/combat/musket_auto_2", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.3F, 0.4F, 0.8F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,1.3F));
        MUSKET_DASH = builder.nextAccessor("biped/combat/musket_dash", (accessor) ->
                new DashAttackAnimation(0.1F, 0.2F, 0.4F, 0.6F, 0.9F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED, true)
                        .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F))
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,1.3F));
        HOLD_PISTOL = builder.nextAccessor("biped/living/hold_pistol", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        PISTOL_AIM = builder.nextAccessor("biped/combat/pistol_aim", (accessor) -> new AimAnimation(true, accessor, "biped/combat/pistol_aim_mid", "biped/combat/pistol_aim_up", "biped/combat/pistol_aim_down", "biped/combat/pistol_aim_lying", Armatures.BIPED));
        PISTOL_SHOT = builder.nextAccessor("biped/combat/pistol_shot", (accessor) -> new ReboundAnimation(false, accessor, "biped/combat/pistol_shot_mid", "biped/combat/pistol_shot_up", "biped/combat/pistol_shot_down", "biped/combat/pistol_shot_lying", Armatures.BIPED));
        KNEEL_PISTOL = builder.nextAccessor("biped/living/kneel_pistol", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        SNEAK_PISTOL = builder.nextAccessor("biped/living/sneak_pistol", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        RUN_PISTOL = builder.nextAccessor("biped/living/run_pistol", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        WALK_PISTOL = builder.nextAccessor("biped/living/walk_pistol", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        RELOAD_PISTOL = builder.nextAccessor("biped/living/reload_pistol", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        HOLD_DUAL_PISTOL = builder.nextAccessor("biped/living/hold_dual_pistol", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        DUAL_PISTOL_SHOT = builder.nextAccessor("biped/combat/dual_pistol_shot", (accessor) -> new ReboundAnimation(false, accessor, "biped/combat/dual_pistol_shot_mid", "biped/combat/dual_pistol_shot_up", "biped/combat/dual_pistol_shot_down", "biped/combat/dual_pistol_shot_lying", Armatures.BIPED));
        HOLD_OFFHAND = builder.nextAccessor("biped/living/hold_offhand", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        RELOAD_OFFHAND = builder.nextAccessor("biped/living/reload_offhand", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        OFFHAND_SHOT = builder.nextAccessor("biped/combat/offhand_shot", (accessor) -> new ReboundAnimation(false, accessor, "biped/combat/offhand_shot_mid", "biped/combat/offhand_shot_up", "biped/combat/offhand_shot_down", "biped/combat/offhand_shot_lying", Armatures.BIPED));
        DUAL_PISTOL_AUTO1 = builder.nextAccessor("biped/combat/dual_pistol_auto1", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.2F, 0.4F, 0.6F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,2.1F));
        DUAL_PISTOL_AUTO2 = builder.nextAccessor("biped/combat/dual_pistol_auto2", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.3F, 0.4F, 0.8F, null, Armatures.BIPED.get().toolL, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,2.1F));
        DUAL_PISTOL_DASH = builder.nextAccessor("biped/combat/dual_pistol_dash", (accessor) ->
                new DashAttackAnimation(0.1F, 0.0F, 0.2F, 0.4F, 0.65F, null, Armatures.BIPED.get().toolL, accessor, Armatures.BIPED, true)
                        .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F))
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,2.1F));
        DUAL_PISTOL_AIRSLASH = builder.nextAccessor("biped/combat/dual_pistol_airslash", (accessor) -> new AirSlashAnimation(0.1F, 0.4F, 0.8F, 1.0F, ColliderPreset.DUAL_SWORD_AIR_SLASH, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,2.1F));
        CEREMONIAL_PISTOL_AIM = builder.nextAccessor("biped/combat/ceremonial_pistol_aim", (accessor) -> new AimAnimation(true, accessor, "biped/combat/ceremonial_pistol_aim_mid", "biped/combat/ceremonial_pistol_aim_up", "biped/combat/ceremonial_pistol_aim_down", "biped/combat/ceremonial_pistol_aim_lying", Armatures.BIPED));
        CEREMONIAL_PISTOL_AUTO_1 = builder.nextAccessor("biped/combat/ceremonial_pistol_auto_1", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.2F, 0.3F, 0.5F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,2.1F));
        CEREMONIAL_PISTOL_AUTO_2 = builder.nextAccessor("biped/combat/ceremonial_pistol_auto_2", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.2F, 0.3F, 0.6F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,2.6F));
        CEREMONIAL_PISTOL_AUTO_3 = builder.nextAccessor("biped/combat/ceremonial_pistol_auto_3", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.3F, 0.4F, 0.6F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,2.6F));
        CEREMONIAL_PISTOL_DASH = builder.nextAccessor("biped/combat/ceremonial_pistol_dash", (accessor) ->
                new DashAttackAnimation(0.1F, 0.0F, 0.2F, 0.46F, 0.7F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED, true)
                        .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F))
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,2.6F));
        PISTOL_AUTO_1 = builder.nextAccessor("biped/combat/pistol_auto_1", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.5F, 0.6F, 0.8F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,1.5F));
        PISTOL_AUTO_2 = builder.nextAccessor("biped/combat/pistol_auto_2", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.3F, 0.4F, 0.8F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,1.5F));
        PISTOL_AUTO_3 = builder.nextAccessor("biped/combat/pistol_auto_3", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.5F, 0.6F, 0.8F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,1.5F));
        PISTOL_DASH = builder.nextAccessor("biped/combat/pistol_dash", (accessor) ->
                new DashAttackAnimation(0.1F, 0.0F, 0.2F, 0.46F, 0.7F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED, true)
                        .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F))
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,1.5F));
        AIM_SCOPE = builder.nextAccessor("biped/combat/scope_aim", (accessor) -> new AimAnimation(true, accessor, "biped/combat/scope_aim_mid", "biped/combat/musket_aim_up", "biped/combat/musket_aim_down", "biped/combat/musket_aim_lying", Armatures.BIPED));
        KNEEL_SCOPE = builder.nextAccessor("biped/living/kneel_scope", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        SNEAK_SCOPE = builder.nextAccessor("biped/living/sneak_musket", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        LAST_PUSH_TRY = builder.nextAccessor("biped/skill/last_push_try", (accessor) ->
                new AttackAnimation(0.1F, 0.4F, 0.6F, 1.6F, 2.7F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F));
        LAST_PUSH_EXECUTE = builder.nextAccessor("biped/skill/last_push_execute", (accessor) ->
                new AttackAnimation(0.15F, 0.1F, 0.3F, 0.4F, 0.8F, ColliderPreset.FIST, Armatures.BIPED.get().legL, accessor, Armatures.BIPED)
                        .addProperty(ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.4F));
        LAST_PUSH_FAIL = builder.nextAccessor("biped/skill/last_push_fail", (accessor) ->
                new AttackAnimation(0F, 0F, 0F, 0F, 0.32F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackPhaseProperty.SWING_SOUND, SoundEvents.EMPTY)
                        .addProperty(AttackPhaseProperty.HIT_SOUND, SoundEvents.EMPTY)
                        .addProperty(ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.6F));
        LAST_PUSH_HIT = builder.nextAccessor("biped/skill/last_push_hit", (accessor) ->
                new AttackAnimation(0.08F, 0.1F, 0.4F, 0.6F, 0.8F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.4F));
        LAST_PUSH_EXECUTE_LOADED = builder.nextAccessor("biped/skill/last_push_execute_loaded", (accessor) ->
                new AttackAnimation(0.15F, 0.1F, 0.3F, 0.4F, 0.8F, ColliderPreset.FIST, Armatures.BIPED.get().legL, accessor, Armatures.BIPED)
                        .addProperty(AttackPhaseProperty.SWING_SOUND, SoundEvents.EMPTY)
                        .addProperty(AttackPhaseProperty.HIT_SOUND, Sounds.MUSKET_FIRE)
                        .addProperty(ActionAnimationProperty.CANCELABLE_MOVE, false)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.4F));
        RECRUIT_SPEAR_LIVING = builder.nextAccessor("biped/living/recruit_spear_living", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        RECRUIT_SPEAR_AUTO_1 = builder.nextAccessor("biped/combat/recruit_spear_auto_1", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.2F, 0.5F, 1.0F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,1.2F));
        RECRUIT_SPEAR_AUTO_2 = builder.nextAccessor("biped/combat/recruit_spear_auto_2", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.3F, 0.4F, 1.3F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,1.2F));
        RECRUIT_SPEAR_AUTO_3 = builder.nextAccessor("biped/combat/recruit_spear_auto_3", (accessor) ->
                new BasicAttackAnimation(0.1F, 0.5F, 0.6F, 1.4F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED,1.2F));
    }
}
