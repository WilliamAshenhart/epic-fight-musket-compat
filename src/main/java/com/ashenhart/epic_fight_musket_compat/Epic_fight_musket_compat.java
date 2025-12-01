package com.ashenhart.epic_fight_musket_compat;

import com.ashenhart.epic_fight_musket_compat.events.MusketCompatScopeEvent;
import com.ashenhart.epic_fight_musket_compat.gameassets.MusketAnimations;
import com.ashenhart.epic_fight_musket_compat.world.capabilities.item.MusketWeaponCategories;
import com.ashenhart.epic_fight_musket_compat.world.item.MusketItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Epic_fight_musket_compat.MODID)
public class Epic_fight_musket_compat {
    public static final String MODID = "epic_fight_musket_compat";
    public Epic_fight_musket_compat(FMLJavaModLoadingContext eventBus) {
        IEventBus bus = eventBus.getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new MusketCompatScopeEvent());
        MusketItems.ITEMS.register(bus);
        WeaponCategory.ENUM_MANAGER.registerEnumCls(MODID, MusketWeaponCategories.class);
        bus.addListener(MusketAnimations::registerAnimations);
        bus.addListener(this::creativeTabs);
    }

    public void creativeTabs(final BuildCreativeModeTabContentsEvent event) {
        MusketItems.addToCreativeTab(event.getTabKey(), event::accept);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
    public static class ServerForgeEvents {
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void addMusketReloadListenerEvent(final AddReloadListenerEvent event) {
            event.addListener(AnimationManager.getInstance());
        }
    }
}
