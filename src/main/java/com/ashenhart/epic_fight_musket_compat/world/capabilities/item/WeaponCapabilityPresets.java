package com.ashenhart.epic_fight_musket_compat.world.capabilities.item;
import java.util.function.Function;


import com.ashenhart.epic_fight_musket_compat.gameassets.Animations;
import com.ashenhart.epic_fight_musket_compat.gameassets.MusketColliderPreset;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.ashenhart.epic_fight_musket_compat.Epic_fight_musket_compat;

import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.CapabilityItem.Styles;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

@Mod.EventBusSubscriber(modid = Epic_fight_musket_compat.MODID , bus = Mod.EventBusSubscriber.Bus.MOD)
public class WeaponCapabilityPresets {
    public static final Function<Item, CapabilityItem.Builder> MUSKET = (item) -> {
        CapabilityItem.Builder builder = WeaponCapability.builder()
                .category(MusketWeaponCategories.MUSKET)
                .zoomInType(CapabilityItem.ZoomInType.AIMING)
                .styleProvider((playerpatch) -> Styles.RANGED)
                .collider(MusketColliderPreset.MUSKET)
                .swingSound(EpicFightSounds.WHOOSH.get())
                .hitSound(EpicFightSounds.BLUNT_HIT.get())
                .canBePlacedOffhand(false)
                .newStyleCombo(Styles.RANGED, Animations.MUSKET_AUTO_1, Animations.MUSKET_AUTO_1, yesman.epicfight.gameasset.Animations.SPEAR_TWOHAND_AIR_SLASH)
                .livingMotionModifier(Styles.RANGED, LivingMotions.IDLE, Animations.HOLD_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.WALK, Animations.WALK_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.CHASE, Animations.RUN_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.RUN, Animations.RUN_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.JUMP, Animations.HOLD_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.KNEEL, Animations.KNEEL_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.SNEAK, Animations.SNEAK_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.SWIM, Animations.HOLD_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.AIM, yesman.epicfight.gameasset.Animations.BIPED_CROSSBOW_AIM)
                .livingMotionModifier(Styles.RANGED, LivingMotions.SHOT, yesman.epicfight.gameasset.Animations.BIPED_CROSSBOW_SHOT)
                .livingMotionModifier(Styles.RANGED, LivingMotions.RELOAD, Animations.RELOAD_MUSKET);

        return builder;
    };
    public static final Function<Item, CapabilityItem.Builder> BAYONET = (item) -> {
        CapabilityItem.Builder builder = WeaponCapability.builder()
                .zoomInType(CapabilityItem.ZoomInType.AIMING)
                .category(MusketWeaponCategories.BAYONET)
                .styleProvider((playerpatch) -> Styles.RANGED)
                .collider(MusketColliderPreset.MUSKET)
                .swingSound(EpicFightSounds.WHOOSH.get())
                .hitSound(EpicFightSounds.BLADE_HIT.get())
                .canBePlacedOffhand(false)
                .newStyleCombo(Styles.RANGED, Animations.BAYONET, Animations.BAYONET_DASH, yesman.epicfight.gameasset.Animations.SPEAR_TWOHAND_AIR_SLASH)
                .livingMotionModifier(Styles.RANGED, LivingMotions.IDLE, Animations.HOLD_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.WALK, Animations.WALK_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.CHASE, Animations.RUN_BAYONET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.RUN, Animations.RUN_BAYONET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.JUMP, Animations.HOLD_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.KNEEL, Animations.KNEEL_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.SNEAK, Animations.SNEAK_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.SWIM, Animations.HOLD_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.AIM, yesman.epicfight.gameasset.Animations.BIPED_CROSSBOW_AIM)
                .livingMotionModifier(Styles.RANGED, LivingMotions.SHOT, yesman.epicfight.gameasset.Animations.BIPED_CROSSBOW_SHOT)
                .livingMotionModifier(Styles.RANGED, LivingMotions.RELOAD, Animations.RELOAD_MUSKET);


        return builder;
    };
    public static final Function<Item, CapabilityItem.Builder> PISTOL = (item) -> {
        CapabilityItem.Builder builder = WeaponCapability.builder()
                .zoomInType(CapabilityItem.ZoomInType.AIMING)
                .category(MusketWeaponCategories.PISTOL)
                .styleProvider((playerpatch) -> Styles.RANGED)
                .collider(ColliderPreset.FIST)
                .swingSound(EpicFightSounds.WHOOSH.get())
                .hitSound(EpicFightSounds.BLUNT_HIT.get())
                .canBePlacedOffhand(true)
                .newStyleCombo(Styles.RANGED, Animations.PISTOL_AUTO_1, Animations.PISTOL_AUTO_2, Animations.PISTOL_AUTO_3, Animations.PISTOL_DASH, yesman.epicfight.gameasset.Animations.SWORD_AIR_SLASH)
                .livingMotionModifier(Styles.RANGED, LivingMotions.IDLE, Animations.HOLD_PISTOL)
                .livingMotionModifier(Styles.RANGED, LivingMotions.WALK, Animations.WALK_PISTOL)
                .livingMotionModifier(Styles.RANGED, LivingMotions.CHASE, Animations.WALK_PISTOL)
                .livingMotionModifier(Styles.RANGED, LivingMotions.RUN, Animations.RUN_PISTOL)
                .livingMotionModifier(Styles.RANGED, LivingMotions.JUMP, Animations.HOLD_PISTOL)
                .livingMotionModifier(Styles.RANGED, LivingMotions.KNEEL, Animations.KNEEL_PISTOL)
                .livingMotionModifier(Styles.RANGED, LivingMotions.SNEAK, Animations.SNEAK_PISTOL)
                .livingMotionModifier(Styles.RANGED, LivingMotions.RELOAD, Animations.RELOAD_PISTOL);

        return builder;
    };
    public static final Function<Item, CapabilityItem.Builder> SCOPED = (item) -> {
        CapabilityItem.Builder builder = WeaponCapability.builder()
                .category(MusketWeaponCategories.SCOPED)
                .zoomInType(CapabilityItem.ZoomInType.AIMING)
                .styleProvider((playerpatch) -> Styles.RANGED)
                .collider(MusketColliderPreset.MUSKET)
                .swingSound(EpicFightSounds.WHOOSH.get())
                .hitSound(EpicFightSounds.BLUNT_HIT.get())
                .canBePlacedOffhand(false)
                .newStyleCombo(Styles.RANGED, Animations.MUSKET_AUTO_1, Animations.MUSKET_AUTO_1, yesman.epicfight.gameasset.Animations.SPEAR_TWOHAND_AIR_SLASH)
                .livingMotionModifier(Styles.RANGED, LivingMotions.IDLE, Animations.HOLD_SCOPE)
                .livingMotionModifier(Styles.RANGED, LivingMotions.WALK, Animations.WALK_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.CHASE, Animations.RUN_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.RUN, Animations.RUN_MUSKET)
                .livingMotionModifier(Styles.RANGED, LivingMotions.JUMP, Animations.HOLD_SCOPE)
                .livingMotionModifier(Styles.RANGED, LivingMotions.KNEEL, Animations.KNEEL_SCOPE)
                .livingMotionModifier(Styles.RANGED, LivingMotions.SNEAK, Animations.SNEAK_SCOPE)
                .livingMotionModifier(Styles.RANGED, LivingMotions.SWIM, Animations.HOLD_SCOPE)
                .livingMotionModifier(Styles.RANGED, LivingMotions.AIM, yesman.epicfight.gameasset.Animations.BIPED_CROSSBOW_AIM)
                .livingMotionModifier(Styles.RANGED, LivingMotions.SHOT, yesman.epicfight.gameasset.Animations.BIPED_CROSSBOW_SHOT)
                .livingMotionModifier(Styles.RANGED, LivingMotions.RELOAD, Animations.RELOAD_MUSKET);

        return builder;
    };

    @SubscribeEvent
    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(new ResourceLocation(Epic_fight_musket_compat.MODID, "musket"), MUSKET);
        event.getTypeEntry().put(new ResourceLocation(Epic_fight_musket_compat.MODID, "bayonet"), BAYONET);
        event.getTypeEntry().put(new ResourceLocation(Epic_fight_musket_compat.MODID, "pistol"), PISTOL);
        event.getTypeEntry().put(new ResourceLocation(Epic_fight_musket_compat.MODID, "scoped"), SCOPED);
    }
}
