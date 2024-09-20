package io.github.crative.harmoni_mc;

import io.github.crative.harmoni_mc.enchantments.HarmoniEntchantment;
import io.github.crative.harmoni_mc.items.HarmoniItemGroup;
import io.github.crative.harmoni_mc.items.HarmoniItems;
import io.github.crative.harmoni_mc.keybinding.KeyBindings;
import io.github.crative.harmoni_mc.server.TickHandler;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HarmoniMc implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("harmoni");
	public static final String MOD_ID = "harmoni-mc";

    @Override
    public void onInitialize(ModContainer mod) {
        LOGGER.info("Initializing HarmoniMC(" + MOD_ID + ")");
		HarmoniItems.registerModItems();
		HarmoniItemGroup.registerItemGroup();
		HarmoniEntchantment.load();

		TickHandler.registerTickHandler();
		KeyBindings.registerKeyBindings();
    }

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
