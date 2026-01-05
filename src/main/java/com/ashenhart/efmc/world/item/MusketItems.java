package com.ashenhart.efmc.world.item;

import com.ashenhart.efmc.Epic_fight_musket_compat;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

public class MusketItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Epic_fight_musket_compat.MODID);

    public static final DeferredItem<ArmorItem> MUSKETEER_HAT = ITEMS.register("musketeer_hat",
            () -> new ArmorItem(MusketArmorMaterials.MUSKETEER_UNIFORM, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(2))));
    public static final DeferredItem<ArmorItem> MUSKETEER_VEST = ITEMS.register("musketeer_vest",
            () -> new ArmorItem(MusketArmorMaterials.MUSKETEER_UNIFORM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(2))));
    public static final DeferredItem<ArmorItem> MUSKETEER_TROUSERS = ITEMS.register("musketeer_trousers",
            () -> new ArmorItem(MusketArmorMaterials.MUSKETEER_UNIFORM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(2))));
    public static final DeferredItem<ArmorItem> MUSKETEER_BOOTS = ITEMS.register("musketeer_boots",
            () -> new ArmorItem(MusketArmorMaterials.MUSKETEER_UNIFORM, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(2))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


    public static void addToCreativeTab(ResourceKey<CreativeModeTab> tab, Consumer<DeferredItem<ArmorItem>> helper) {
        if (tab == CreativeModeTabs.COMBAT) {
            helper.accept(MUSKETEER_HAT);
            helper.accept(MUSKETEER_VEST);
            helper.accept(MUSKETEER_TROUSERS);
            helper.accept(MUSKETEER_BOOTS);
        }
    }
}
