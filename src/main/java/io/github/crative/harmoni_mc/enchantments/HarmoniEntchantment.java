package io.github.crative.harmoni_mc.enchantments;

import com.mojang.serialization.MapCodec;
import io.github.crative.harmoni_mc.HarmoniMc;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import io.github.crative.harmoni_mc.enchantments.effects.ReelingEnchantmentEffect;

public class HarmoniEntchantment {
	public static final RegistryKey<Enchantment> REELING_KEY = RegistryKey.of(RegistryKeys.ENCHANTMENT, HarmoniMc.id("reeling"));

	public static final MapCodec<ReelingEnchantmentEffect> REELING_EFFECT = register("gale", ReelingEnchantmentEffect.CODEC);

	private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String name, MapCodec<T> codec) {
		return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, HarmoniMc.id(name), codec);
	}

	public static void load() {}
}
