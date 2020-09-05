package com.vincentmet.rhodonite.blocks;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.*;
import net.minecraft.world.IBlockReader;

public class RhodoniteOre extends Block {

    public RhodoniteOre(Block.Properties blockProperties) {
        super(blockProperties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader player, List<ITextComponent> tooltip, ITooltipFlag advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(new TranslationTextComponent(TextFormatting.BLUE + "Can Be Found In The End"));
    }
}
