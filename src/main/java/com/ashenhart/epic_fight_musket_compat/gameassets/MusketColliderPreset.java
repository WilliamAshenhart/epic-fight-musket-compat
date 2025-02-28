package com.ashenhart.epic_fight_musket_compat.gameassets;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import net.minecraft.resources.ResourceLocation;

import com.ashenhart.epic_fight_musket_compat.Epic_fight_musket_compat;

import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.MultiOBBCollider;

public class MusketColliderPreset {

    private static final BiMap<ResourceLocation, Collider> PRESETS = HashBiMap.create();

    public static Collider registerCollider(ResourceLocation rl, Collider collider) {
        if (PRESETS.containsKey(rl)) {
            throw new IllegalStateException("Collider named " + rl + " already registered.");
        }
        PRESETS.put(rl, collider);

        return collider;
    }

    public static final Collider MUSKET = registerCollider(new ResourceLocation(Epic_fight_musket_compat.MODID, "musket"), new MultiOBBCollider(3, 0.4D, 0.7D, 0.4D, 0D, -0.5D, 0D));
}