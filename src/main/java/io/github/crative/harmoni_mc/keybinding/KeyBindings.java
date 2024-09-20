package io.github.crative.harmoni_mc.keybinding;

import com.mojang.blaze3d.platform.InputUtil;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBind;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
	public static KeyBind jumpKey;

	public static void registerKeyBindings() {
		jumpKey = new KeyBind(
			"key.harmoni_mc.jump",
			InputUtil.Type.KEYSYM,
			GLFW.GLFW_KEY_SPACE,
			"category.harmoni_mc.key"
		);

		KeyBindingHelper.registerKeyBinding(jumpKey);
	}
}
