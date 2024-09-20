package io.github.crative.harmoni_mc.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerHandler {
	private static ServerPlayerEntity getServerPlayerEntity(PlayerEntity player) {
		if (player instanceof ServerPlayerEntity) {
			return (ServerPlayerEntity) player;
		}
		return null;
	}

	public static PlayerEntity getPlayerEntity(ServerPlayerEntity player) {
		return (PlayerEntity) player;
	}
}
