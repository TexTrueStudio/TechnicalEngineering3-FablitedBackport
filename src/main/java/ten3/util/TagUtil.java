package ten3.util;

import java.util.Collection;
import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagUtil {

    public static boolean containsItem(Item t, String s) {
        return getItemsTag(s).contains(t);
    }

    public static TagKey<Item> key(String s) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(s));
    }

    public static Collection<Item> getItemsTag(String s) {
        var opt = BuiltInRegistries.ITEM.getTag(key(s));
        return opt.isPresent() ? opt.get().stream().map(Holder::value).toList() : List.of();
    }

    public static boolean containsItem(Item t, TagKey<Item> s) {
        return t.getDefaultInstance().is(s);
    }

    public static boolean containsBlock(Block t, String s) {
        return t.defaultBlockState().is(TagKey.create(Registries.BLOCK, new ResourceLocation(s)));
    }

}