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
		//* Starter Pouch recipe
		ShapedRecipeJsonFactory.create(RecipeCategory.MISC, HarmoniItems.STARTER_POUCH)
				.pattern("SLS")
				.pattern("IGI")
				.pattern("LLL")
				.ingredient('S', ()->Items.STICK)
				.ingredient('L', ()->Items.LEATHER)
				.ingredient('I', ()->Items.IRON_BLOCK)
				.ingredient('G', ()->Items.GOLD_BLOCK)
				.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
				.criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
				.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_BLOCK))
				.criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_BLOCK))
				.offerTo(exporter, Identifier.of(HarmoniMc.MOD_ID, getRecipeName(HarmoniItems.STARTER_POUCH)));


		//* Magic Mirror recipe
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

		//* Trident recipes
		ShapedRecipeJsonFactory.create(RecipeCategory.MISC, HarmoniItems.TRIDENT_SPIKE)
			.pattern("I")
			.pattern("D")
			.ingredient('I', ()->Items.PRISMARINE_SHARD)
			.ingredient('D', ()->Items.DIAMOND)
			.criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
			.criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
			.offerTo(exporter, Identifier.of(HarmoniMc.MOD_ID, getRecipeName(HarmoniItems.TRIDENT_SPIKE)));

		ShapedRecipeJsonFactory.create(RecipeCategory.COMBAT, Items.TRIDENT)
			.pattern(" II")
			.pattern(" SI")
			.pattern("S  ")
			.ingredient('I', ()->HarmoniItems.TRIDENT_SPIKE)
			.ingredient('S', ()->Items.BREEZE_ROD)
			.criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(HarmoniItems.TRIDENT_SPIKE))
			.criterion(hasItem(Items.BREEZE_ROD), conditionsFromItem(Items.BREEZE_ROD))
			.offerTo(exporter, Identifier.of(HarmoniMc.MOD_ID, getRecipeName(Items.TRIDENT)));

	}
}
