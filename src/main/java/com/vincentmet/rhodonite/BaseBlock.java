package com.vincentmet.rhodonite;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class BaseBlock extends Block {
    private final QuadConsumer<ItemStack, BlockGetter, List<Component>, TooltipFlag> hoverTextConsumer;

    public BaseBlock(Properties blockProperties, QuadConsumer<ItemStack, BlockGetter, List<Component>, TooltipFlag> hoverTextConsumer) {
        super(blockProperties);
        this.hoverTextConsumer = hoverTextConsumer;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag advanced) {
        hoverTextConsumer.accept(stack, context.level(), tooltip, advanced);
    }
}
