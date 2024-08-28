package io.github.crative.harmoni_mc.datagenerator;

import io.github.crative.harmoni_mc.items.HarmoniItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.client.model.Models;

public class ModModelProvider extends FabricModelProvider {
	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
	}

	@Override
	public void generateItemModels(net.minecraft.data.client.ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(HarmoniItems.MAGIC_MIRROR, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(HarmoniItems.TRIDENT_SPIKE, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(HarmoniItems.STARTER_POUCH, Models.SINGLE_LAYER_ITEM);
	}
}
