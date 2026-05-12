package com.vincentmet.rhodonite;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/** Items that should show the enchantment glint without being enchanted. */
public class GlintItem extends Item {
    public GlintItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
