package io.github.crative.harmoni_mc.datagenerator;

import io.github.crative.harmoni_mc.items.HarmoniItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModTranslationProvider extends FabricLanguageProvider {

	public ModTranslationProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(dataOutput, registryLookup);
	}

	@Override
	public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
		translationBuilder.add(HarmoniItems.MAGIC_MIRROR, "Magic Mirror");
		translationBuilder.add("itemgroup.harmoni-mc.harmoni_group", "Harmoni MC");
	}
}
