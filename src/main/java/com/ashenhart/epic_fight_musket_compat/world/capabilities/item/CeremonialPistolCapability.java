package com.ashenhart.epic_fight_musket_compat.world.capabilities.item;

import com.ashenhart.epic_fight_musket_compat.gameassets.MusketAnimations;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.UseAnim;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.LivingMotion;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.particle.HitParticleType;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.RangedWeaponCapability;
import yesman.epicfight.world.capabilities.item.Style;

import java.util.List;

public class CeremonialPistolCapability extends RangedWeaponCapability {
	private final List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> attackMotion;

	protected CeremonialPistolCapability(CapabilityItem.Builder builder) {
		super(builder);

		this.attackMotion = List.of(MusketAnimations.CEREMONIAL_PISTOL_AUTO_1, MusketAnimations.CEREMONIAL_PISTOL_AUTO_2, MusketAnimations.CEREMONIAL_PISTOL_AUTO_3, MusketAnimations.CEREMONIAL_PISTOL_DASH, yesman.epicfight.gameasset.Animations.SWORD_AIR_SLASH);
	}

	@Override
	public Style getStyle(LivingEntityPatch<?> entitypatch) {
		return Styles.RANGED;
	}

	@Override
	public SoundEvent getHitSound() {
		return EpicFightSounds.BLUNT_HIT.get();
	}

	@Override
	public HitParticleType getHitParticle() {
		return EpicFightParticles.HIT_BLUNT.get();
	}

	@Override
	public List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> getAutoAttackMotion(PlayerPatch<?> playerpatch) {
		return this.attackMotion;
	}

	@Override
	public LivingMotion getLivingMotion(LivingEntityPatch<?> entitypatch, InteractionHand hand) {
		return entitypatch.getOriginal().isUsingItem() && entitypatch.getOriginal().getUseItem().getUseAnimation() == UseAnim.BOW ? LivingMotions.AIM : null;
	}

	@Override
	public boolean checkOffhandValid(LivingEntityPatch<?> entityPatch) {
		ItemStack offhandItem = entityPatch.getOriginal().getOffhandItem();
		CapabilityItem itemCap = EpicFightCapabilities.getItemStackCapability(offhandItem);
		boolean isPistol = itemCap.getWeaponCategory() == MusketWeaponCategories.CEREMONIAL_PISTOL;
		return isPistol || !(offhandItem.getItem() instanceof SwordItem || offhandItem.getItem() instanceof DiggerItem);
	}
}