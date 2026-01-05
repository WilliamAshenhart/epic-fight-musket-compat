package com.ashenhart.efmc.world.capabilities.item;

import com.ashenhart.efmc.Epic_fight_musket_compat;
import com.ashenhart.efmc.gameassets.MusketAnimations;
import com.ashenhart.efmc.gameassets.MusketColliderPreset;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.neoevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.RangedWeaponCapability;

import java.util.function.Function;

public class WeaponCapabilityPresets {

    public static final Function<Item, RangedWeaponCapability.Builder> MUSKET = (item) -> RangedWeaponCapability.builder()
            .zoomInType(CapabilityItem.ZoomInType.AIMING)
            .addAnimationsModifier(LivingMotions.IDLE, MusketAnimations.HOLD_MUSKET)
            .addAnimationsModifier(LivingMotions.WALK, MusketAnimations.WALK_MUSKET)
            .addAnimationsModifier(LivingMotions.CHASE, MusketAnimations.RUN_MUSKET)
            .addAnimationsModifier(LivingMotions.RUN, MusketAnimations.RUN_MUSKET)
            .addAnimationsModifier(LivingMotions.JUMP, MusketAnimations.HOLD_MUSKET)
            .addAnimationsModifier(LivingMotions.KNEEL, MusketAnimations.KNEEL_MUSKET)
            .addAnimationsModifier(LivingMotions.SNEAK, MusketAnimations.SNEAK_MUSKET)
            .addAnimationsModifier(LivingMotions.SWIM, MusketAnimations.HOLD_MUSKET)
            .addAnimationsModifier(LivingMotions.RELOAD, MusketAnimations.RELOAD_MUSKET)
            .addAnimationsModifier(LivingMotions.AIM, MusketAnimations.MUSKET_AIM)
            .addAnimationsModifier(LivingMotions.SHOT, MusketAnimations.MUSKET_SHOT)
            .constructor(MusketCapability::new)
            .category(MusketWeaponCategories.MUSKET)
            .collider(MusketColliderPreset.MUSKET);

    public static final Function<Item, RangedWeaponCapability.Builder> BAYONET = (item) -> RangedWeaponCapability.builder()
            .zoomInType(CapabilityItem.ZoomInType.AIMING)
            .addAnimationsModifier(LivingMotions.IDLE, MusketAnimations.HOLD_BAYONET)
            .addAnimationsModifier(LivingMotions.WALK, MusketAnimations.WALK_BAYONET)
            .addAnimationsModifier(LivingMotions.CHASE, MusketAnimations.RUN_BAYONET)
            .addAnimationsModifier(LivingMotions.RUN, MusketAnimations.RUN_BAYONET)
            .addAnimationsModifier(LivingMotions.JUMP, MusketAnimations.HOLD_BAYONET)
            .addAnimationsModifier(LivingMotions.KNEEL, MusketAnimations.KNEEL_MUSKET)
            .addAnimationsModifier(LivingMotions.SNEAK, MusketAnimations.SNEAK_MUSKET)
            .addAnimationsModifier(LivingMotions.SWIM, MusketAnimations.HOLD_BAYONET)
            .addAnimationsModifier(LivingMotions.RELOAD, MusketAnimations.RELOAD_MUSKET)
            .addAnimationsModifier(LivingMotions.AIM, MusketAnimations.MUSKET_AIM)
            .addAnimationsModifier(LivingMotions.SHOT, MusketAnimations.MUSKET_SHOT)
            .constructor(BayonetCapability::new)
            .category(MusketWeaponCategories.BAYONET)
            .collider(MusketColliderPreset.MUSKET);

    public static final Function<Item, RangedWeaponCapability.Builder> SCOPED = (item) -> RangedWeaponCapability.builder()
            .zoomInType(CapabilityItem.ZoomInType.AIMING)
            .addAnimationsModifier(LivingMotions.IDLE, MusketAnimations.HOLD_MUSKET)
            .addAnimationsModifier(LivingMotions.WALK, MusketAnimations.WALK_MUSKET)
            .addAnimationsModifier(LivingMotions.CHASE, MusketAnimations.RUN_MUSKET)
            .addAnimationsModifier(LivingMotions.RUN, MusketAnimations.RUN_MUSKET)
            .addAnimationsModifier(LivingMotions.JUMP, MusketAnimations.HOLD_MUSKET)
            .addAnimationsModifier(LivingMotions.KNEEL, MusketAnimations.KNEEL_MUSKET)
            .addAnimationsModifier(LivingMotions.SNEAK, MusketAnimations.SNEAK_MUSKET)
            .addAnimationsModifier(LivingMotions.SWIM, MusketAnimations.HOLD_MUSKET)
            .addAnimationsModifier(LivingMotions.RELOAD, MusketAnimations.RELOAD_MUSKET)
            .addAnimationsModifier(LivingMotions.AIM, MusketAnimations.AIM_SCOPE)
            .addAnimationsModifier(LivingMotions.SHOT, MusketAnimations.SCOPE_SHOT)
            .constructor(MusketCapability::new)
            .category(MusketWeaponCategories.SCOPED)
            .collider(MusketColliderPreset.MUSKET);

    public static final Function<Item, RangedWeaponCapability.Builder> CEREMONIAL_MUSKET = (item) -> RangedWeaponCapability.builder()
            .zoomInType(CapabilityItem.ZoomInType.USE_TICK)
            .addAnimationsModifier(LivingMotions.IDLE, MusketAnimations.HOLD_CEREMONIAL_MUSKET)
            .addAnimationsModifier(LivingMotions.WALK, MusketAnimations.WALK_CEREMONIAL_MUSKET)
            .addAnimationsModifier(LivingMotions.RUN, MusketAnimations.RUN_CEREMONIAL_MUSKET)
            .addAnimationsModifier(LivingMotions.AIM, MusketAnimations.CEREMONIAL_MUSKET_AIM)
            .collider(MusketColliderPreset.MUSKET)
            .category(MusketWeaponCategories.CEREMONIAL_MUSKET)
            .constructor(CeremonialMusketCapability::new);

    public static final Function<Item, RangedWeaponCapability.Builder> PISTOL = (item) -> RangedWeaponCapability.builder()
            .zoomInType(CapabilityItem.ZoomInType.AIMING)
            .addAnimationsModifier(LivingMotions.IDLE, MusketAnimations.HOLD_PISTOL)
            .addAnimationsModifier(LivingMotions.WALK, MusketAnimations.WALK_PISTOL)
            .addAnimationsModifier(LivingMotions.CHASE, MusketAnimations.WALK_PISTOL)
            .addAnimationsModifier(LivingMotions.RUN, MusketAnimations.RUN_PISTOL)
            .addAnimationsModifier(LivingMotions.JUMP, MusketAnimations.HOLD_PISTOL)
            .addAnimationsModifier(LivingMotions.KNEEL, MusketAnimations.KNEEL_PISTOL)
            .addAnimationsModifier(LivingMotions.SNEAK, MusketAnimations.SNEAK_PISTOL)
            .addAnimationsModifier(LivingMotions.RELOAD, MusketAnimations.RELOAD_PISTOL)
            .addAnimationsModifier(LivingMotions.SHOT, MusketAnimations.PISTOL_SHOT)
            .addAnimationsModifier(LivingMotions.AIM, MusketAnimations.PISTOL_AIM)
            .constructor(PistolCapability::new)
            .category(MusketWeaponCategories.PISTOL)
            .collider(ColliderPreset.TOOLS);

    public static final Function<Item, RangedWeaponCapability.Builder> CEREMONIAL_PISTOL =  (item) -> RangedWeaponCapability.builder()
            .zoomInType(CapabilityItem.ZoomInType.USE_TICK)
            .addAnimationsModifier(LivingMotions.IDLE, yesman.epicfight.gameasset.Animations.BIPED_HOLD_LONGSWORD)
            .addAnimationsModifier(LivingMotions.WALK, yesman.epicfight.gameasset.Animations.BIPED_WALK_LONGSWORD)
            .addAnimationsModifier(LivingMotions.RUN, yesman.epicfight.gameasset.Animations.BIPED_RUN_LONGSWORD)
            .addAnimationsModifier(LivingMotions.AIM, MusketAnimations.CEREMONIAL_PISTOL_AIM)
            .category(MusketWeaponCategories.CEREMONIAL_PISTOL)
            .constructor(CeremonialPistolCapability::new);

    @SubscribeEvent
    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(Epic_fight_musket_compat.MODID, "musket"), MUSKET);
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(Epic_fight_musket_compat.MODID, "bayonet"), BAYONET);
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(Epic_fight_musket_compat.MODID, "pistol"), PISTOL);
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(Epic_fight_musket_compat.MODID, "scoped"), SCOPED);
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(Epic_fight_musket_compat.MODID, "ceremonial_musket"), CEREMONIAL_MUSKET);
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(Epic_fight_musket_compat.MODID, "ceremonial_pistol"), CEREMONIAL_PISTOL);
    }
}
