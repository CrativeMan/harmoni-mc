package io.github.crative.harmoni_mc;

import io.github.crative.harmoni_mc.datagenerator.ModModelProvider;
import io.github.crative.harmoni_mc.datagenerator.ModTranslationProvider;
import io.github.crative.harmoni_mc.datagenerator.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class HarmoniDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModTranslationProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
