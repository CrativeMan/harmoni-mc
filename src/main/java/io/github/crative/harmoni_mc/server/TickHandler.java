package io.github.crative.harmoni_mc.server;

import io.github.crative.harmoni_mc.HarmoniMc;
import io.github.crative.harmoni_mc.util.IPlayerEntityM;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

import static io.github.crative.harmoni_mc.util.PlayerHandler.getPlayerEntity;

public class TickHandler {

	public static void registerTickHandler() {
		ServerTickEvents.END_SERVER_TICK.register(TickHandler::onEndServerTick);
		HarmoniMc.LOGGER.info("Registered tick handler for " + HarmoniMc.MOD_ID);
	}

	private static void onEndServerTick(MinecraftServer server) {
		for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
			if (player.isOnGround()) {
				PlayerEntity user = getPlayerEntity(player);
				IPlayerEntityM iPlayer = (IPlayerEntityM) user;
				iPlayer.harmoni_mc$setHasDoubleJump(true);
			}
		}
	}

}
