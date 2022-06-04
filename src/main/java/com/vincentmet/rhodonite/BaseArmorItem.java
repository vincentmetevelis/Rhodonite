package com.vincentmet.rhodonite;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BaseArmorItem extends ArmorItem {
    private QuadConsumer<ItemStack, World, List<ITextComponent>, ITooltipFlag> hoverTextConsumer;
    private TriConsumer<ItemStack, World, PlayerEntity> armorTickConsumer;

    public BaseArmorItem(IArmorMaterial armorMaterial, EquipmentSlotType equipmentSlotType, Properties properties, QuadConsumer<ItemStack, World, List<ITextComponent>, ITooltipFlag> hoverTextConsumer, TriConsumer<ItemStack, World, PlayerEntity> armorTickConsumer) {
        super(armorMaterial, equipmentSlotType, properties);
        this.hoverTextConsumer = hoverTextConsumer;
        this.armorTickConsumer = armorTickConsumer;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        hoverTextConsumer.accept(stack, world, tooltip, flag);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        armorTickConsumer.accept(stack, world, player);
    }
}