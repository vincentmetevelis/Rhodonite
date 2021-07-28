package com.vincentmet.rhodonite.blocks;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;

public class RhodoniteOre extends Block{

    public RhodoniteOre(Block.Properties blockProperties) {
        super(blockProperties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter player, List<Component> tooltip, TooltipFlag advanced) {
        super.appendHoverText(stack, player, tooltip, advanced);
        tooltip.add(new TranslatableComponent(ChatFormatting.BLUE + "Can Be Found In The End"));
    }
}
