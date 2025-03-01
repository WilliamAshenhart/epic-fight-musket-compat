package com.ashenhart.epic_fight_musket_compat;

import com.ashenhart.epic_fight_musket_compat.gameassets.Animations;
import com.ashenhart.epic_fight_musket_compat.world.capabilities.item.MusketWeaponCategories;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Epic_fight_musket_compat.MODID)
public class Epic_fight_musket_compat {

    public static final String MODID = "epic_fight_musket_compat";

    public Epic_fight_musket_compat() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        WeaponCategory.ENUM_MANAGER.registerEnumCls(MODID, MusketWeaponCategories.class);
        bus.addListener(Animations::registerAnimations);

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
