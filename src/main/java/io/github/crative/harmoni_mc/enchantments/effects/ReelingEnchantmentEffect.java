package io.github.crative.harmoni_mc.enchantments.effects;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.LevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record ReelingEnchantmentEffect(LevelBasedValue amount) implements EnchantmentEntityEffect {
	public static final MapCodec<ReelingEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			LevelBasedValue.CODEC.fieldOf("amount").forGetter(ReelingEnchantmentEffect::amount)
		).apply(instance, ReelingEnchantmentEffect::new)
	);

	@Override
	public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
		assert MinecraftClient.getInstance().player != null;
		Vec3d playerPos = MinecraftClient.getInstance().player.getPos();
		Vec3d targetPos = target.getPos();

		if (targetPos.distanceTo(playerPos) < 2) {
			return;
		}

		Vec3d directionVector = playerPos.subtract(target.getPos()).normalize();
		Vec3d velocity = directionVector.multiply(amount.getValue(level));
		target.setVelocity(velocity);
	}

	@Override
	public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
		return CODEC;
	}
}
