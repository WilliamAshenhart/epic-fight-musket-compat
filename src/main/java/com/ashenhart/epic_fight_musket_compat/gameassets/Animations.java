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
    public static StaticAnimation RUN_MUSKET;
    public static StaticAnimation KNEEL_MUSKET;
    public static StaticAnimation SNEAK_MUSKET;
    public static StaticAnimation RELOAD_MUSKET;
    public static StaticAnimation MUSKET_AUTO_1;
    public static StaticAnimation HOLD_BAYONET;
    public static StaticAnimation BAYONET;
    public static StaticAnimation BAYONET_CHARGE;
    public static StaticAnimation HOLD_PISTOL;
    public static StaticAnimation RUN_PISTOL;
    public static StaticAnimation RELOAD_PISTOL;
    public static StaticAnimation PISTOL_AUTO_1;

    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.getRegistryMap().put(Epic_fight_musket_compat.MODID, Animations::build);
    }

    private static void build() {

        HumanoidArmature biped = Armatures.BIPED;
        HOLD_MUSKET = new StaticAnimation(true, "biped/living/hold_musket", biped);
        RUN_MUSKET = new MovementAnimation(true, "biped/living/run_musket", biped);
        KNEEL_MUSKET = new MovementAnimation(true, "biped/living/kneel_musket", biped);
        SNEAK_MUSKET = new MovementAnimation(true, "biped/living/sneak_musket", biped);
        RUN_MUSKET = new MovementAnimation(true, "biped/living/run_musket", biped);
        RELOAD_MUSKET = new MovementAnimation(true, "biped/living/reload_musket", biped);
        BAYONET_CHARGE = new BasicAttackAnimation(0.1F, 0.0F, 0.5F, 0.8F, null, biped.toolR, "biped/combat/bayonet_charge", biped)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.0F));
        MUSKET_AUTO_1 = new BasicAttackAnimation(0.1F, 0.0F, 0.4F, 0.5F, null, biped.toolR, "biped/combat/musket_auto_1", biped)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.0F));
        BAYONET = new BasicAttackAnimation(0.1F, 0.0F, 0.4F, 0.7F, null, biped.toolR, "biped/combat/bayonet", biped)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.0F));
        HOLD_BAYONET = new StaticAnimation(true, "biped/living/hold_bayonet", biped);
        HOLD_PISTOL = new StaticAnimation(true, "biped/living/hold_pistol", biped);
        RUN_PISTOL = new StaticAnimation(true, "biped/living/run_pistol", biped);
        RELOAD_PISTOL = new StaticAnimation(true, "biped/living/reload_pistol", biped);
        PISTOL_AUTO_1 = new BasicAttackAnimation(0.1F, 0.0F, 0.4F, 0.6F, null, biped.toolR, "biped/combat/pistol_auto_1", biped)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.0F))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, ((dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.0F));
    }

}
