package com.vincentmet.rhodonite;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BaseArmorItem extends ArmorItem {
    private final QuadConsumer<ItemStack, Level, List<Component>, TooltipFlag> hoverTextConsumer;

    public BaseArmorItem(
            Holder<ArmorMaterial> material,
            Type type,
            Properties properties,
            QuadConsumer<ItemStack, Level, List<Component>, TooltipFlag> hoverTextConsumer) {
        super(material, type, properties);
        this.hoverTextConsumer = hoverTextConsumer;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        hoverTextConsumer.accept(stack, context.level(), tooltip, flag);
    }
}
