package com.ashenhart.efmc.client.renderer.armor;

import com.ashenhart.efmc.world.item.MusketUniformItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public final class MusketUniformRenderer extends GeoArmorRenderer<MusketUniformItem> {
    public MusketUniformRenderer() {
        super(new DefaultedItemGeoModel<>(ResourceLocation.fromNamespaceAndPath("efmc", "geo/musketeer_uniform.geo.json")));
    }
}
