package io.github.crative.harmoni_mc.items.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class StarterPouchItem extends Item {
	public StarterPouchItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {


		if (user.experienceLevel < 5) {
			user.sendMessage(Text.translatable("text.harmoni-mc.starter_pouch_level_req"), true);
			return TypedActionResult.fail(user.getStackInHand(hand));
		} else {
			user.giveItemStack(new ItemStack(Items.IRON_HELMET, 1));
			user.giveItemStack(new ItemStack(Items.IRON_CHESTPLATE, 1));
			user.giveItemStack(new ItemStack(Items.IRON_LEGGINGS, 1));
			user.giveItemStack(new ItemStack(Items.IRON_BOOTS, 1));
			user.giveItemStack(new ItemStack(Items.IRON_SWORD, 1));
			user.giveItemStack(new ItemStack(Items.BOW, 1));
			user.giveItemStack(new ItemStack(Items.ARROW, 64));
			user.getStackInHand(hand).decrement(1);
			user.experienceLevel -= 5;
			return TypedActionResult.success(user.getStackInHand(hand));
		}
	}
}
