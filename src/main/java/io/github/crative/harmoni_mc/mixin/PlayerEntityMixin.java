package io.github.crative.harmoni_mc.mixin;

import io.github.crative.harmoni_mc.util.IPlayerEntityM;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin implements IPlayerEntityM {
	@Unique
	public boolean hasDoubleJump = true;

	@Override
	public boolean harmoni_mc$hasDoubleJump() {
		return hasDoubleJump;
	}

	@Override
	public void harmoni_mc$setHasDoubleJump(boolean hasDoubleJump) {
		this.hasDoubleJump = hasDoubleJump;
	}
}
