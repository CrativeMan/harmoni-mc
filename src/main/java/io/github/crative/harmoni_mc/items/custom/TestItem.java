package io.github.crative.harmoni_mc.items.custom;

import io.github.crative.harmoni_mc.util.IPlayerEntityM;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TestItem extends Item {
	public TestItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		IPlayerEntityM player = (IPlayerEntityM) user;

		if (!user.isOnGround()) {
			Vec3d velocity = user.getVelocity();
			user.setVelocity(velocity.x, 0.7, velocity.z);
			return TypedActionResult.success(user.getStackInHand(hand));
		}

		return TypedActionResult.pass(user.getStackInHand(hand));
	}
}
