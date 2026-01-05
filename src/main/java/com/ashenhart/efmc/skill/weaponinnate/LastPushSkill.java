package com.ashenhart.efmc.skill.weaponinnate;

import com.ashenhart.efmc.gameassets.MusketAnimations;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.neoevent.playerpatch.AttackEndEvent;
import yesman.epicfight.api.neoevent.playerpatch.DealDamageEvent;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.registry.entries.EpicFightMobEffects;
import yesman.epicfight.registry.entries.EpicFightSkillDataKeys;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class LastPushSkill extends WeaponInnateSkill {
    private static final UUID EVENT_UUID = UUID.fromString("1f6aea85-2194-4761-af8e-1a5c99c4f414");
    private final AssetAccessor<? extends AttackAnimation> first;
    private final AssetAccessor<? extends AttackAnimation> second;
    private final AssetAccessor<? extends AttackAnimation> third;
    private final AssetAccessor<? extends AttackAnimation> fail;

    public LastPushSkill(WeaponInnateSkill.Builder<?> builder) {
        super(builder);

        this.first = MusketAnimations.LAST_PUSH_TRY;
        this.second = MusketAnimations.LAST_PUSH_HIT;
        this.third = MusketAnimations.LAST_PUSH_EXECUTE;
        this.fail = MusketAnimations.LAST_PUSH_FAIL;
    }

    public void attackAnimationEndEvent(AttackEndEvent event, SkillContainer container) {
        if (MusketAnimations.LAST_PUSH_TRY.equals(event.getAnimation())) {
            List<LivingEntity> hurtEntities = ((ServerPlayerPatch)event.getPlayerPatch()).getCurrentlyActuallyHitEntities();
            ((ServerPlayerPatch)event.getPlayerPatch()).reserveAnimation(this.second);
            ((ServerPlayerPatch)event.getPlayerPatch()).getServerAnimator().getPlayerFor((AssetAccessor)null).reset();
            ((ServerPlayerPatch)event.getPlayerPatch()).getCurrentlyActuallyHitEntities().clear();
        }
        if (MusketAnimations.LAST_PUSH_HIT.equals(event.getAnimation())) {
            List<LivingEntity> hurtEntities = event.getPlayerPatch().getCurrentlyActuallyHitEntities();
            PlayerPatch<?> playerPatch = event.getPlayerPatch();

            if (!hurtEntities.isEmpty() && hurtEntities.get(0).isAlive()) {
                ((ServerPlayerPatch)event.getPlayerPatch()).getServerAnimator().getPlayerFor(null).reset();
                ((ServerPlayerPatch)event.getPlayerPatch()).reserveAnimation(this.third);
                ((ServerPlayerPatch)event.getPlayerPatch()).getCurrentlyActuallyHitEntities().clear();
            } else {
                event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                event.getPlayerPatch().reserveAnimation(this.fail);
                event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
            }
        }
    }

    public void dealDamagePost(DealDamageEvent.Post event, SkillContainer skillContainer) {
        if (this.second.equals(event.getDamageSource().getAnimation())) {
            event.getDamageSource().attachImpactModifier(ValueModifier.adder((float)(Integer)skillContainer.getDataManager().getDataValue(EpicFightSkillDataKeys.LAST_HIT_COUNT) * 0.4F));
        }

    }

    public void executeOnServer(SkillContainer container, CompoundTag arguments) {
        container.getExecutor().playAnimationSynchronized(this.first, 0.0F);
        LivingEntity target = (LivingEntity) container.getExecutor().getTarget();
        ((ServerPlayer)container.getExecutor().getOriginal()).addEffect(new MobEffectInstance((Holder<MobEffect>) EpicFightMobEffects.STUN_IMMUNITY.get(), 38, 0, true, false, false));
        if (target != null && target.isAlive()) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 36, 50));
        }
    }

    @Override
    public List<Component> getTooltipOnItem(ItemStack itemStack, CapabilityItem cap, PlayerPatch<?> playerCap) {
        List<Component> list = super.getTooltipOnItem(itemStack, cap, playerCap);
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map) this.properties.get(0), "Charge");
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map) this.properties.get(1), "Stab");
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, (Map) this.properties.get(2), "Kick");

        return list;
    }

    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        this.first.get().phases[0].addProperties(this.properties.get(0).entrySet());
        this.second.get().phases[0].addProperties(this.properties.get(1).entrySet());
        this.third.get().phases[0].addProperties(this.properties.get(2).entrySet());
        return this;
    }
}
