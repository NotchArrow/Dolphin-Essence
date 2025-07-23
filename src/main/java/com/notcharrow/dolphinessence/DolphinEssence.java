package com.notcharrow.dolphinessence;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;

public class DolphinEssence implements ModInitializer {
	@Override
	public void onInitialize() {
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
				if (player.hasStatusEffect(StatusEffects.CONDUIT_POWER)) {
					player.addStatusEffect(
							new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 5, 0,
									true, true, true));
				}
			}
		});
	}
}