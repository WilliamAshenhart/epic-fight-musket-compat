package com.ashenhart.epic_fight_musket_compat.world.capabilities.item;

import net.minecraft.world.item.Item;

import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.util.function.Function;

public enum MusketWeaponCategories implements WeaponCategory, Function<Item, CapabilityItem.Builder> {
    MUSKET, BAYONET, PISTOL, BANNER;

    final int id;

    MusketWeaponCategories() {
        this.id = WeaponCategory.ENUM_MANAGER.assign(this);
    }

    @Override
    public int universalOrdinal() {
        return this.id;
    }
    @Override
    public CapabilityItem.Builder apply(Item item) {
        return WeaponCategoryMapper.apply(item, this);
    }
}