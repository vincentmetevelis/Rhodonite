package com.vincentmet.rhodonite.armor.rhodonite;

import java.util.List;
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

public class RhodoniteBoots extends ArmorItem {
    public RhodoniteBoots(IArmorMaterial armorMaterial, EquipmentSlotType equipmentSlotType, Properties properties) {
        super(armorMaterial, equipmentSlotType, properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("Ability: Flight").setStyle(new Style().setColor(TextFormatting.BLUE)));
        tooltip.add(new TranslationTextComponent("Use: Equip The Full Set").setStyle(new Style().setColor(TextFormatting.DARK_AQUA)));
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (!player.getEntityData().contains("wearingArmor")) {
            player.getEntityData().putBoolean("wearingArmor", false);
            player.getEntityData().putBoolean("canFly", player.abilities.allowFlying);
        }

        ItemStack stackHead = player.inventory.armorItemInSlot(3);
        ItemStack stackChest = player.inventory.armorItemInSlot(2);
        ItemStack stackLegging = player.inventory.armorItemInSlot(1);
        ItemStack stackBoots = player.inventory.armorItemInSlot(0);


        if (    stackHead != null && stackHead.getItem() instanceof RhodoniteHelmet &&
                stackChest != null && stackChest.getItem() instanceof RhodoniteChestplate &&
                stackLegging != null && stackLegging.getItem() instanceof RhodoniteLeggings &&
                stackBoots != null && stackBoots.getItem() instanceof RhodoniteBoots){
            player.getEntityData().putBoolean("wearingArmor", true);
            player.abilities.allowFlying = true;
        } else {
            player.getEntityData().putBoolean("wearingArmor", false);
            player.abilities.allowFlying = player.getEntityData().getBoolean("canFly");
        }
        player.fallDistance = 0.0F;
    }
}
