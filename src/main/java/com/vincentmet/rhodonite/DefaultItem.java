package com.vincentmet.rhodonite;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

public class DefaultItem extends Item{
    public DefaultItem(ResourceLocation resourceLocation, int stacksize, CreativeModeTab tab) {
        super(new Item.Properties().stacksTo(stacksize).tab(tab));
        setRegistryName(resourceLocation);
    }
}
