package com.ashenhart.efmc;

import com.ashenhart.efmc.events.MusketCompatScopeEvent;
import com.ashenhart.efmc.gameassets.MusketAnimations;
import com.ashenhart.efmc.world.capabilities.item.WeaponCapabilityPresets;
import com.ashenhart.efmc.world.item.MusketItems;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Epic_fight_musket_compat.MODID)
public class Epic_fight_musket_compat {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "efmc";

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Epic_fight_musket_compat(IEventBus modEventBus, ModContainer modContainer) {
        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (Epic_fight_musket_compat) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(MusketAnimations::registerAnimations);
        modEventBus.addListener(WeaponCapabilityPresets::register);
        MusketItems.register(modEventBus);
        modEventBus.addListener(this::creativeTabs);
    }

    private void creativeTabs(final BuildCreativeModeTabContentsEvent event) {
        MusketItems.addToCreativeTab(event.getTabKey(), event::accept);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}