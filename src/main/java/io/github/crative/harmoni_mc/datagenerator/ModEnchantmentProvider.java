package io.github.crative.harmoni_mc.datagenerator;

import io.github.crative.harmoni_mc.enchantments.HarmoniEntchantment;
import io.github.crative.harmoni_mc.enchantments.effects.ReelingEnchantmentEffect;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.LevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.entity.EquipmentSlotGroup;
import net.minecraft.item.Item;
import net.minecraft.registry.HolderLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModEnchantmentProvider extends FabricDynamicRegistryProvider {
	public ModEnchantmentProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(HolderLookup.Provider registries, Entries entries) {
		HolderLookup.RegistryLookup<Item> itemLookup = registries.getLookupOrThrow(RegistryKeys.ITEM);

		register(entries, HarmoniEntchantment.REELING_KEY, Enchantment.builder(
			Enchantment.createProperties(
				itemLookup.getTagOrThrow(ItemTags.WEAPON_ENCHANTABLE),
				20,
				2,
				Enchantment.cost(1, 10),
				Enchantment.cost(1, 15),
				7,
				EquipmentSlotGroup.MAINHAND
			))
			.addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
				EnchantmentEffectTarget.ATTACKER,
				EnchantmentEffectTarget.VICTIM,
				new ReelingEnchantmentEffect(LevelBasedValue.constant(1)))
		);
	}

	private static void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
		entries.add(key, builder.build(key.getValue()), resourceConditions);
	}

	@Override
	public String getName() {
		return "HarmoniMC - Enchantment provider";
	}
}
