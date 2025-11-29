package com.ashenhart.epic_fight_musket_compat.world.item;

import com.ashenhart.epic_fight_musket_compat.Epic_fight_musket_compat;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class MusketItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Epic_fight_musket_compat.MODID);

    public static final RegistryObject<Item> MUSKETEER_HAT = ITEMS.register("musketeer_hat",
            () -> new MusketUniformItem(MusketArmorMaterials.MUSKETEER_UNIFORM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MUSKETEER_VEST = ITEMS.register("musketeer_vest",
            () -> new MusketUniformItem(MusketArmorMaterials.MUSKETEER_UNIFORM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MUSKETEER_TROUSERS = ITEMS.register("musketeer_trousers",
            () -> new MusketUniformItem(MusketArmorMaterials.MUSKETEER_UNIFORM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MUSKETEER_BOOTS = ITEMS.register("musketeer_boots",
            () -> new MusketUniformItem(MusketArmorMaterials.MUSKETEER_UNIFORM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void addToCreativeTab(ResourceKey<CreativeModeTab> tab, Consumer<RegistryObject<Item>> helper) {
        if (tab == CreativeModeTabs.COMBAT) {
            helper.accept(MUSKETEER_HAT);
            helper.accept(MUSKETEER_VEST);
            helper.accept(MUSKETEER_TROUSERS);
            helper.accept(MUSKETEER_BOOTS);
        }
    }
}
