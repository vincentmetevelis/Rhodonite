package com.vincentmet.rhodonite;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class DefaultItem extends Item{
    public DefaultItem(ResourceLocation resourceLocation, int stacksize, ItemGroup tab) {
        super(new Item.Properties().maxStackSize(stacksize).group(tab));
        setRegistryName(resourceLocation);
    }
}
