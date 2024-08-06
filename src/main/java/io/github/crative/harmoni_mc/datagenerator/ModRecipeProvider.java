package io.github.crative.harmoni_mc.datagenerator;

import io.github.crative.harmoni_mc.HarmoniMc;
import io.github.crative.harmoni_mc.items.HarmoniItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeCategory;
import net.minecraft.registry.HolderLookup;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
	public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void generateRecipes(RecipeExporter exporter) {
		ShapedRecipeJsonFactory.create(RecipeCategory.TOOLS, HarmoniItems.MAGIC_MIRROR)
			.pattern(" I ")
			.pattern("IGI")
			.pattern("IBI")
			.ingredient('I', ()->Items.IRON_INGOT)
			.ingredient('G', ()->Items.GLASS_PANE)
			.ingredient('B', ()->Items.IRON_BLOCK)
			.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
			.criterion(hasItem(Items.IRON_BLOCK), conditionsFromItem(Items.IRON_BLOCK))
			.criterion(hasItem(Items.GLASS_PANE), conditionsFromItem(Items.GLASS_PANE))
			.offerTo(exporter, Identifier.of(HarmoniMc.MOD_ID, getRecipeName(HarmoniItems.MAGIC_MIRROR)));
	}
}
