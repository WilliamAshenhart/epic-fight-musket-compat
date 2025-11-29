package com.ashenhart.epic_fight_musket_compat.events;

import com.ashenhart.epic_fight_musket_compat.Epic_fight_musket_compat;
import com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.mob.RecruitPatch;
import com.talhanation.recruits.init.ModEntityTypes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import yesman.epicfight.api.forgeevent.EntityPatchRegistryEvent;
import yesman.epicfight.gameasset.Armatures;

@Mod.EventBusSubscriber(modid = Epic_fight_musket_compat.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MusketCompatEvents {

    @SubscribeEvent
    public static void registerPatchedEntities(EntityPatchRegistryEvent event) {
        event.getTypeEntry().put(ModEntityTypes.RECRUIT.get(), entity -> RecruitPatch::new);
        event.getTypeEntry().put(ModEntityTypes.BOWMAN.get(), entity -> RecruitPatch::new);
        event.getTypeEntry().put(ModEntityTypes.CROSSBOWMAN.get(), entity -> RecruitPatch::new);
        event.getTypeEntry().put(ModEntityTypes.HORSEMAN.get(), entity -> RecruitPatch::new);
        event.getTypeEntry().put(ModEntityTypes.RECRUIT_SHIELDMAN.get(), entity -> RecruitPatch::new);
        event.getTypeEntry().put(ModEntityTypes.NOMAD.get(), entity -> RecruitPatch::new);
        event.getTypeEntry().put(ModEntityTypes.CAPTAIN.get(), entity -> RecruitPatch::new);
        event.getTypeEntry().put(ModEntityTypes.PATROL_LEADER.get(), entity -> RecruitPatch::new);
        event.getTypeEntry().put(ModEntityTypes.SCOUT.get(), entity -> RecruitPatch::new);
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(MusketCompatEvents::registerEntityTypeArmatures);
    }

    private static void registerEntityTypeArmatures() {
        Armatures.registerEntityTypeArmature(ModEntityTypes.RECRUIT.get(), Armatures.BIPED);
        Armatures.registerEntityTypeArmature(ModEntityTypes.BOWMAN.get(), Armatures.BIPED);
        Armatures.registerEntityTypeArmature(ModEntityTypes.CROSSBOWMAN.get(), Armatures.BIPED);
        Armatures.registerEntityTypeArmature(ModEntityTypes.HORSEMAN.get(), Armatures.BIPED);
        Armatures.registerEntityTypeArmature(ModEntityTypes.RECRUIT_SHIELDMAN.get(), Armatures.BIPED);
        Armatures.registerEntityTypeArmature(ModEntityTypes.NOMAD.get(), Armatures.BIPED);
        Armatures.registerEntityTypeArmature(ModEntityTypes.CAPTAIN.get(), Armatures.BIPED);
        Armatures.registerEntityTypeArmature(ModEntityTypes.PATROL_LEADER.get(), Armatures.BIPED);
        Armatures.registerEntityTypeArmature(ModEntityTypes.SCOUT.get(), Armatures.BIPED);
    }
}
