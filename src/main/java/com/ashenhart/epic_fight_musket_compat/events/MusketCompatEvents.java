package com.ashenhart.epic_fight_musket_compat.events;

import com.ashenhart.epic_fight_musket_compat.Epic_fight_musket_compat;
import com.ashenhart.epic_fight_musket_compat.world.capabilities.entitypatch.mob.RecruitPatch;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import yesman.epicfight.api.forgeevent.EntityPatchRegistryEvent;
import yesman.epicfight.gameasset.Armatures;

@Mod.EventBusSubscriber(modid = Epic_fight_musket_compat.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MusketCompatEvents {
    @SubscribeEvent
    public static void registerPatchedEntities(EntityPatchRegistryEvent event) {
        if (ModList.get().isLoaded("recruits")) {
            RecruitEFCompat.registerPatchedEntities(event);
        }
    }


    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        if (ModList.get().isLoaded("recruits")) {
            event.enqueueWork(RecruitEFCompat::registerEntityTypeArmatures);
        }
    }

    public static class RecruitEFCompat {
        public static void registerPatchedEntities(EntityPatchRegistryEvent event) {
            event.getTypeEntry().put(com.talhanation.recruits.init.ModEntityTypes.RECRUIT.get(), entity -> RecruitPatch::new);
            event.getTypeEntry().put(com.talhanation.recruits.init.ModEntityTypes.BOWMAN.get(), entity -> RecruitPatch::new);
            event.getTypeEntry().put(com.talhanation.recruits.init.ModEntityTypes.CROSSBOWMAN.get(), entity -> RecruitPatch::new);
            event.getTypeEntry().put(com.talhanation.recruits.init.ModEntityTypes.HORSEMAN.get(), entity -> RecruitPatch::new);
            event.getTypeEntry().put(com.talhanation.recruits.init.ModEntityTypes.RECRUIT_SHIELDMAN.get(), entity -> RecruitPatch::new);
            event.getTypeEntry().put(com.talhanation.recruits.init.ModEntityTypes.NOMAD.get(), entity -> RecruitPatch::new);
            event.getTypeEntry().put(com.talhanation.recruits.init.ModEntityTypes.CAPTAIN.get(), entity -> RecruitPatch::new);
            event.getTypeEntry().put(com.talhanation.recruits.init.ModEntityTypes.PATROL_LEADER.get(), entity -> RecruitPatch::new);
            event.getTypeEntry().put(com.talhanation.recruits.init.ModEntityTypes.SCOUT.get(), entity -> RecruitPatch::new);
        }

        private static void registerEntityTypeArmatures() {
            Armatures.registerEntityTypeArmature(com.talhanation.recruits.init.ModEntityTypes.RECRUIT.get(), Armatures.BIPED);
            Armatures.registerEntityTypeArmature(com.talhanation.recruits.init.ModEntityTypes.BOWMAN.get(), Armatures.BIPED);
            Armatures.registerEntityTypeArmature(com.talhanation.recruits.init.ModEntityTypes.CROSSBOWMAN.get(), Armatures.BIPED);
            Armatures.registerEntityTypeArmature(com.talhanation.recruits.init.ModEntityTypes.HORSEMAN.get(), Armatures.BIPED);
            Armatures.registerEntityTypeArmature(com.talhanation.recruits.init.ModEntityTypes.RECRUIT_SHIELDMAN.get(), Armatures.BIPED);
            Armatures.registerEntityTypeArmature(com.talhanation.recruits.init.ModEntityTypes.NOMAD.get(), Armatures.BIPED);
            Armatures.registerEntityTypeArmature(com.talhanation.recruits.init.ModEntityTypes.CAPTAIN.get(), Armatures.BIPED);
            Armatures.registerEntityTypeArmature(com.talhanation.recruits.init.ModEntityTypes.PATROL_LEADER.get(), Armatures.BIPED);
            Armatures.registerEntityTypeArmature(com.talhanation.recruits.init.ModEntityTypes.SCOUT.get(), Armatures.BIPED);
        }
    }
}
