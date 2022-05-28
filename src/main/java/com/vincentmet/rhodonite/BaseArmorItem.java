package com.vincentmet.rhodonite;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class BaseArmorItem extends ArmorItem {
    private QuadConsumer<ItemStack, Level, List<Component>, TooltipFlag> hoverTextConsumer;
    private TriConsumer<ItemStack, Level, Player> armorTickConsumer;

    public BaseArmorItem(ArmorMaterial armorMaterial, EquipmentSlot equipmentSlotType, Properties properties, QuadConsumer<ItemStack, Level, List<Component>, TooltipFlag> hoverTextConsumer, TriConsumer<ItemStack, Level, Player> armorTickConsumer) {
        super(armorMaterial, equipmentSlotType, properties);
        this.hoverTextConsumer = hoverTextConsumer;
        this.armorTickConsumer = armorTickConsumer;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        hoverTextConsumer.accept(stack, world, tooltip, flag);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        armorTickConsumer.accept(stack, world, player);
    }
}