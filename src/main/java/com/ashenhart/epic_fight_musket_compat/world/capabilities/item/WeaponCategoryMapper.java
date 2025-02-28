package com.ashenhart.epic_fight_musket_compat.world.capabilities.item;

import net.minecraft.world.item.Item;

import yesman.epicfight.world.capabilities.item.WeaponCategory;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class WeaponCategoryMapper {
    private static final Map<MusketWeaponCategories, WeaponCategory> categoryMap = new HashMap<>();

    static {
        categoryMap.put(MusketWeaponCategories.MUSKET, CapabilityItem.WeaponCategories.RANGED);
        categoryMap.put(MusketWeaponCategories.BAYONET, CapabilityItem.WeaponCategories.RANGED);
        categoryMap.put(MusketWeaponCategories.PISTOL, CapabilityItem.WeaponCategories.RANGED);
    }

    public static CapabilityItem.Builder apply(Item item, MusketWeaponCategories category) {
        WeaponCategory mappedCategory = categoryMap.getOrDefault(category, category);
        try {
            Method applyMethod = mappedCategory.getClass().getMethod("apply", Item.class);
            return (CapabilityItem.Builder) applyMethod.invoke(mappedCategory, item);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
