package com.ashenhart.efmc.world.capabilities.item;

import yesman.epicfight.world.capabilities.item.WeaponCategory;


public enum MusketWeaponCategories implements WeaponCategory {
    MUSKET, BAYONET, PISTOL, SCOPED, CEREMONIAL_MUSKET, CEREMONIAL_PISTOL;

    final int id;

    MusketWeaponCategories() {
        this.id = WeaponCategory.ENUM_MANAGER.assign(this);
    }

    @Override
    public int universalOrdinal() {
        return this.id;
    }
}