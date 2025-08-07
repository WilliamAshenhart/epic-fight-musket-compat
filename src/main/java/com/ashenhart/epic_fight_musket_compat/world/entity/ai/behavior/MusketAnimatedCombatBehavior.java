package com.ashenhart.epic_fight_musket_compat.world.entity.ai.behavior;

import ewewukek.musketmod.GunItem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
import yesman.epicfight.world.entity.ai.behavior.AnimatedCombatBehavior;
import yesman.epicfight.world.entity.ai.goal.CombatBehaviors;

public class MusketAnimatedCombatBehavior extends AnimatedCombatBehavior {
    public MusketAnimatedCombatBehavior(MobPatch mobpatch, CombatBehaviors combatBehaviors) {
        super(mobpatch, combatBehaviors);
    }
    @Override
    protected boolean checkExtraStartConditions(ServerLevel levelIn, Mob entityIn) {
        return this.isHoldingGun(entityIn) && this.isValidTarget(this.mobpatch.getTarget());
    }
    private boolean isHoldingGun(Mob mob) {
        return mob.isHolding((stack) -> {
            Item item = stack.getItem();
            return item instanceof GunItem && GunItem.canUse(mob);
        });
    }
}
