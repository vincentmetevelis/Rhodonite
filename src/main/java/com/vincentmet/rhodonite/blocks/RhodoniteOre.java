package com.vincentmet.rhodonite.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import javax.annotation.Nullable;
import java.util.List;

public class RhodoniteOre extends Block {

    public RhodoniteOre(Block.Properties blockProperties) {
        super(blockProperties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader player, List<ITextComponent> tooltip, ITooltipFlag advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(new TranslationTextComponent("Can Be Found In The End").setStyle(new Style().setColor(TextFormatting.BLUE)));
    }
}
