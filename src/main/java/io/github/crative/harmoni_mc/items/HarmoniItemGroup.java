package io.github.crative.harmoni_mc.items;

import io.github.crative.harmoni_mc.HarmoniMc;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class HarmoniItemGroup {
	public static final ItemGroup HARMONI_GROUP = FabricItemGroup.builder()
		.icon(() -> new ItemStack(HarmoniItems.MAGIC_MIRROR))
		.name(Text.translatable("itemgroup.harmoni-mc.harmoni_group"))
		.entries((context, entries) ->{
			entries.addItem(HarmoniItems.STARTER_POUCH);
			entries.addItem(HarmoniItems.MAGIC_MIRROR);
			entries.addItem(HarmoniItems.TRIDENT_SPIKE);
			entries.addItem(HarmoniItems.TEST_ITEM);
		})
		.build();

	public static void registerItemGroup() {
		Registry.register(Registries.ITEM_GROUP, Identifier.of(HarmoniMc.MOD_ID, "extended_armor_group"), HARMONI_GROUP);
		HarmoniMc.LOGGER.info("Registered item group for " + HarmoniMc.MOD_ID);

	}
}
