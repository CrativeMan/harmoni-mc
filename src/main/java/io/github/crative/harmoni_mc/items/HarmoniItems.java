package io.github.crative.harmoni_mc.items;

import io.github.crative.harmoni_mc.HarmoniMc;
import io.github.crative.harmoni_mc.items.custom.MagicMirrorItem;
import io.github.crative.harmoni_mc.items.custom.StarterPouchItem;
import io.github.crative.harmoni_mc.items.custom.TestItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class HarmoniItems {
	public static final Item MAGIC_MIRROR = registerItem("magic_mirror", new MagicMirrorItem(new Item.Settings()
		.maxCount(1)
		.rarity(Rarity.RARE)
		.maxDamage(50)));
	public static final Item TRIDENT_SPIKE = registerItem("trident_spike", new Item(new Item.Settings()
		.maxCount(16)
		.rarity(Rarity.RARE)));
	public static final Item STARTER_POUCH = registerItem("starter_pouch", new StarterPouchItem(new Item.Settings()
		.maxCount(1)
		.rarity(Rarity.UNCOMMON)));

	public static final Item TEST_ITEM = registerItem("test_item", new TestItem(new Item.Settings()));

	private static Item registerItem(String name, Item item){
		return Registry.register(Registries.ITEM, Identifier.of(HarmoniMc.MOD_ID, name), item);
	}

	public static void registerModItems(){
		HarmoniMc.LOGGER.info("Registering mod items for " + HarmoniMc.MOD_ID);
	}
}
