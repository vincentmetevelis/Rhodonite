package com.vincentmet.rhodonite;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.List;

public class RhodoniteHelper {
    public static void addRhodoniteHoverText(List<ITextComponent> tooltip){
        tooltip.add(new TranslationTextComponent(TextFormatting.BLUE + "Ability: Flight"));
        tooltip.add(new TranslationTextComponent(TextFormatting.DARK_AQUA + "Use: Equip the full set"));
    }

    public static void addNoFallDamageHoverText(List<ITextComponent> tooltip){
        tooltip.add(new TranslationTextComponent(TextFormatting.BLUE + "Ability: No fall damage"));
    }

    public static void addEmptyLineHoverText(List<ITextComponent> tooltip){
        tooltip.add(new StringTextComponent(""));
    }

    public static void setFallDamageToZero(PlayerEntity player){
        player.fallDistance = 0.0F;
    }

    public static void doRhodoniteArmorTickLogic(PlayerEntity player){
        if(Config.RHODONITE_ARMOR_FLIGHT.get()){
            boolean isWearingFullSetOfRhodonite = player.getItemBySlot(EquipmentSlotType.HEAD).getItem().equals(Objects.Items.Armor.itemArmorRhodoniteHelmet.asItem()) && player.getItemBySlot(EquipmentSlotType.CHEST).getItem().equals(Objects.Items.Armor.itemArmorRhodoniteChest.asItem()) && player.getItemBySlot(EquipmentSlotType.LEGS).getItem().equals(Objects.Items.Armor.itemArmorRhodoniteLeggins.asItem()) && player.getItemBySlot(EquipmentSlotType.FEET).getItem().equals(Objects.Items.Armor.itemArmorRhodoniteBoots.asItem());
            if(!player.getPersistentData().contains("wearingFullRhodoniteArmor"))player.getPersistentData().putBoolean("wearingFullRhodoniteArmor", false);
            boolean wasWearingArmorLastTick = player.getPersistentData().getBoolean("wearingFullRhodoniteArmor");

            if(!isWearingFullSetOfRhodonite && wasWearingArmorLastTick && !player.isCreative()){
                player.abilities.mayfly = false;
                player.abilities.flying = false;
            }else if(isWearingFullSetOfRhodonite){
                player.abilities.mayfly = true;
            }
            player.getPersistentData().putBoolean("wearingFullRhodoniteArmor", isWearingFullSetOfRhodonite);
        }
    }

    public static void addFoundInEndHoverText(List<ITextComponent> tooltip){
        tooltip.add(new TranslationTextComponent(TextFormatting.BLUE + "Can be found in the end!"));
    }
}