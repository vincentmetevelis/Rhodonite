package com.vincentmet.rhodonite;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.List;

public class BaseBlock extends Block {
    private QuadConsumer<ItemStack, IBlockReader, List<ITextComponent>, ITooltipFlag> hoverTextConsumer;

    public BaseBlock(Block.Properties blockProperties, QuadConsumer<ItemStack, IBlockReader, List<ITextComponent>, ITooltipFlag> hoverTextConsumer) {
        super(blockProperties);
        this.hoverTextConsumer = hoverTextConsumer;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable IBlockReader player, List<ITextComponent> tooltip, ITooltipFlag advanced) {
        hoverTextConsumer.accept(stack, player, tooltip, advanced);
    }
}