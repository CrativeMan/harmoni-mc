package io.github.crative.harmoni_mc.items.custom;

import io.github.crative.harmoni_mc.HarmoniMc;
import io.github.crative.harmoni_mc.items.HarmoniItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class MagicMirrorItem extends Item {
	private static BlockPos spawnPos;

	public MagicMirrorItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (!world.isClient()) {
			MinecraftServer server = world.getServer();
			if (server == null) {
				HarmoniMc.LOGGER.warn("Server is null, cannot teleport player to spawn point");
				return TypedActionResult.fail(user.getStackInHand(hand));
			}
			ServerPlayerEntity serverPlayer = server.getPlayerManager().getPlayer(user.getUuid());
			if (serverPlayer == null) {
				HarmoniMc.LOGGER.warn("ServerPlayer is null, cannot teleport player to spawn point");
				return TypedActionResult.fail(user.getStackInHand(hand));
			}
			spawnPos = serverPlayer.getSpawnPointPosition();
			if (spawnPos == null) {
				spawnPos = world.getSpawnPos();
			}
		}

		if (spawnPos == null) {
			HarmoniMc.LOGGER.warn("Spawn position is null, cannot teleport player to spawn point");
			return TypedActionResult.fail(user.getStackInHand(hand));
		}

		teleportPlayer(user, world, spawnPos);

		user.getItemCooldownManager().set(this, 300); // cooldown 500
		user.getStackInHand(hand).damageEquipment(1, user, EquipmentSlot.MAINHAND); // durability

		return TypedActionResult.success(user.getStackInHand(hand));
	}

	private void teleportPlayer(PlayerEntity player, World world, BlockPos position) {
		BlockPos pos = position;

		while (!blockIsSave(pos, world)) {
			pos = pos.up();
		}

		player.setVelocity(0, 0, 0);
		player.setPos(pos.getX(), pos.getY(), pos.getZ());
	}

	private boolean blockIsSave(BlockPos pos, World world) {
		return world.getBlockState(pos).isAir() && world.getBlockState(pos.up()).isAir();
	}
}
