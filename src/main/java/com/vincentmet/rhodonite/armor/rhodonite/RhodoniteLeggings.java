package com.vincentmet.rhodonite.armor.rhodonite;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class RhodoniteLeggings extends ArmorItem {
    public RhodoniteLeggings(IArmorMaterial armorMaterial, EquipmentSlotType equipmentSlotType, Properties properties) {
        super(armorMaterial, equipmentSlotType, properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("Ability: Flight").setStyle(new Style().setColor(TextFormatting.BLUE)));
        tooltip.add(new TranslationTextComponent("Use: Equip The Full Set").setStyle(new Style().setColor(TextFormatting.DARK_AQUA)));
    }
}

