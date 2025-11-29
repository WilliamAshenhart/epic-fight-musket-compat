package com.ashenhart.epic_fight_musket_compat.client.renderer.armor;

import com.ashenhart.epic_fight_musket_compat.client.model.armor.MusketUniformModel;
import com.ashenhart.epic_fight_musket_compat.world.item.MusketUniformItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MusketUniformRenderer extends GeoArmorRenderer<MusketUniformItem> {
    public MusketUniformRenderer() {
        super(new MusketUniformModel());
    }
}
