package com.vincentmet.rhodonite.armor;

import com.vincentmet.rhodonite.Config;
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

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(Config.RHODONITE_ARMOR_FLIGHT.get()){
            ItemStack stackHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
            ItemStack stackChest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
            ItemStack stackLegging = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
            ItemStack stackBoots = player.getItemStackFromSlot(EquipmentSlotType.FEET);

            boolean isWearingFullSetOfRhodonite = stackHead != null && stackHead.getItem() instanceof RhodoniteHelmet && stackChest != null && stackChest.getItem() instanceof RhodoniteChestplate && stackLegging != null && stackLegging.getItem() instanceof RhodoniteLeggings && stackBoots != null && stackBoots.getItem() instanceof RhodoniteBoots;
            if(!player.getPersistentData().contains("wearingFullRhodoniteArmor"))player.getPersistentData().putBoolean("wearingFullRhodoniteArmor", false);
            boolean wasWearingArmorLastTick = player.getPersistentData().getBoolean("wearingFullRhodoniteArmor");

            if(!isWearingFullSetOfRhodonite && wasWearingArmorLastTick && !player.isCreative()){
                player.abilities.allowFlying = false;
                player.abilities.isFlying = false;
            }else if(isWearingFullSetOfRhodonite){
                player.abilities.allowFlying = true;
            }
            player.getPersistentData().putBoolean("wearingFullRhodoniteArmor", isWearingFullSetOfRhodonite);
        }
    }
}

