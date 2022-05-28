package com.vincentmet.rhodonite;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;

public class BaseBlock extends Block{
    private QuadConsumer<ItemStack, BlockGetter, List<Component>, TooltipFlag> hoverTextConsumer;

    public BaseBlock(Block.Properties blockProperties, QuadConsumer<ItemStack, BlockGetter, List<Component>, TooltipFlag> hoverTextConsumer) {
        super(blockProperties);
        this.hoverTextConsumer = hoverTextConsumer;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter player, List<Component> tooltip, TooltipFlag advanced) {
        hoverTextConsumer.accept(stack, player, tooltip, advanced);
    }
}