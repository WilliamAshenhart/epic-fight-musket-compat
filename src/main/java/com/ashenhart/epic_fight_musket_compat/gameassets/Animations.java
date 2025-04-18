package com.ashenhart.epic_fight_musket_compat.gameassets;

import com.ashenhart.epic_fight_musket_compat.Epic_fight_musket_compat;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.forgeevent.AnimationRegistryEvent;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.model.armature.HumanoidArmature;

public class Animations {
    public static StaticAnimation HOLD_MUSKET;
    public static StaticAnimation WALK_MUSKET;
    public static StaticAnimation RUN_MUSKET;
    public static StaticAnimation KNEEL_MUSKET;
    public static StaticAnimation SNEAK_MUSKET;
    public static StaticAnimation RELOAD_MUSKET;
    public static StaticAnimation MUSKET_AUTO_1;
    public static StaticAnimation HOLD_BAYONET;
    public static StaticAnimation BAYONET;
    public static StaticAnimation BAYONET_CHARGE;
    public static StaticAnimation HOLD_PISTOL;
    public static StaticAnimation KNEEL_PISTOL;
    public static StaticAnimation SNEAK_PISTOL;
    public static StaticAnimation WALK_PISTOL;
    public static StaticAnimation RUN_PISTOL;
    public static StaticAnimation RELOAD_PISTOL;
    public static StaticAnimation PISTOL_AUTO_1;
    public static StaticAnimation PISTOL_AUTO_2;
    public static StaticAnimation PISTOL_AUTO_3;
    public static StaticAnimation PISTOL_DASH;
    public static StaticAnimation HOLD_BANNER;
    public static StaticAnimation SNEAK_BANNER;
    public static StaticAnimation KNEEL_BANNER;
    public static StaticAnimation HOLD_SCOPE;

    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.getRegistryMap().put(Epic_fight_musket_compat.MODID, Animations::build);
    }

    private static void build() {

        HumanoidArmature biped = Armatures.BIPED;
        HOLD_MUSKET = new StaticAnimation(true, "biped/living/hold_musket", biped);
        WALK_MUSKET = new MovementAnimation(true, "biped/living/walk_musket", biped);
        RUN_MUSKET = new MovementAnimation(true, "biped/living/run_musket", biped);
        KNEEL_MUSKET = new MovementAnimation(true, "biped/living/kneel_musket", biped);
        SNEAK_MUSKET = new MovementAnimation(true, "biped/living/sneak_musket", biped);
        RUN_MUSKET = new MovementAnimation(true, "biped/living/run_musket", biped);
        RELOAD_MUSKET = new StaticAnimation(true, "biped/living/reload_musket", biped);
        BAYONET_CHARGE = new BasicAttackAnimation(0.1F, 0.2F, 0.4F, 0.6F, 0.9F, null, biped.toolR, "biped/combat/bayonet_charge", biped)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.0F));
        MUSKET_AUTO_1 = new BasicAttackAnimation(0.1F, 0.3F, 0.5F, 0.8F, null, biped.toolR, "biped/combat/musket_auto_1", biped)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.0F));
        BAYONET = new BasicAttackAnimation(0.1F, 0.4F, 0.6F, 0.7F, null, biped.toolR, "biped/combat/bayonet", biped)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.0F));
        HOLD_BAYONET = new StaticAnimation(true, "biped/living/hold_bayonet", biped);
        HOLD_PISTOL = new StaticAnimation(true, "biped/living/hold_pistol", biped);
        KNEEL_PISTOL = new StaticAnimation(true, "biped/living/kneel_pistol", biped);
        SNEAK_PISTOL = new StaticAnimation(true, "biped/living/sneak_pistol", biped);
        RUN_PISTOL = new MovementAnimation(true, "biped/living/run_pistol", biped);
        WALK_PISTOL = new MovementAnimation(true, "biped/living/walk_pistol", biped);
        RELOAD_PISTOL = new StaticAnimation(true, "biped/living/reload_pistol", biped);
        PISTOL_AUTO_1 = new BasicAttackAnimation(0.1F, 0.5F, 0.6F, 0.8F, null, biped.toolR, "biped/combat/pistol_auto_1", biped)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.0F));
        PISTOL_AUTO_2 = new BasicAttackAnimation(0.1F, 0.3F, 0.4F, 0.8F, null, biped.toolR, "biped/combat/pistol_auto_2", biped)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.3F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.0F));
        PISTOL_AUTO_3 = new BasicAttackAnimation(0.1F, 0.5F, 0.6F, 0.8F, null, biped.toolR, "biped/combat/pistol_auto_3", biped)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.0F));
        PISTOL_DASH = new DashAttackAnimation(0.1F, 0.0F, 0.2F, 0.4F, 0.65F, null, biped.toolR, "biped/combat/pistol_dash", biped)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.0F));
        HOLD_BANNER = new StaticAnimation(true, "biped/living/hold_banner", biped);
        KNEEL_BANNER = new StaticAnimation(true, "biped/living/kneel_banner", biped);
        SNEAK_BANNER = new StaticAnimation(true, "biped/living/sneak_banner", biped);
        HOLD_SCOPE = new StaticAnimation(true, "biped/living/hold_scope", biped);
    }
}
