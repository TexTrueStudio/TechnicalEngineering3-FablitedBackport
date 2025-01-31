package ten3.util;

import java.util.Collection;
import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class TagUtil {

	public static boolean containsItem(Item t, String s) {
		return getItemsTag(s).contains(t);
	}

	public static TagKey<Item> keyItem(String s) {
		return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(s));
	}

	public static TagKey<Fluid> keyFluid(String s) {
		return TagKey.create(Registry.FLUID_REGISTRY, new ResourceLocation(s));
	}

	public static Collection<Item> getItemsTag(String s) {
		var t = Registry.ITEM.getTag(keyItem(s));
		return t.isPresent() ? t.get().stream().map(Holder::value).toList() : List.of();
	}

	public static Collection<Fluid> getFluidsTag(String s) {
		var t = Registry.FLUID.getTag(keyFluid(s));
		return t.isPresent() ? t.get().stream().map(Holder::value).toList() : List.of();
	}

	public static boolean containsItem(Item t, TagKey<Item> s) {
		return t.getDefaultInstance().is(s);
	}

	public static boolean containsFluid(Fluid t, TagKey<Fluid> s) {
		return t.defaultFluidState().is(s);
	}

	public static boolean containsBlock(Block t, String s) {
		return t.defaultBlockState().is(TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(s)));
	}

}
