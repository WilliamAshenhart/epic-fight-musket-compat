package com.ashenhart.epic_fight_musket_compat.client.model.armor;

import com.ashenhart.epic_fight_musket_compat.world.item.MusketUniformItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MusketUniformModel extends GeoModel<MusketUniformItem> {
    @Override
    public ResourceLocation getModelResource(MusketUniformItem musketUniformItem) {
        return ResourceLocation.fromNamespaceAndPath("epic_fight_musket_compat", "geo/musketeer_uniform.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MusketUniformItem musketUniformItem) {
        return ResourceLocation.fromNamespaceAndPath("epic_fight_musket_compat", "textures/armor/musketeer_uniform.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MusketUniformItem musketUniformItem) {
        return ResourceLocation.fromNamespaceAndPath("epic_fight_musket_compat", "animations/musketeer_uniform.animation.json");
    }
}
