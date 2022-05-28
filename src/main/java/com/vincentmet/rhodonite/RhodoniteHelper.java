package com.vincentmet.rhodonite;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class RhodoniteHelper {
    public static void addRhodoniteHoverText(List<Component> tooltip){
        tooltip.add(new TranslatableComponent(ChatFormatting.BLUE + "Ability: Flight"));
        tooltip.add(new TranslatableComponent(ChatFormatting.DARK_AQUA + "Use: Equip the full set"));
    }

    public static void addNoFallDamageHoverText(List<Component> tooltip){
        tooltip.add(new TranslatableComponent(ChatFormatting.BLUE + "Ability: No fall damage"));
    }

    public static void addEmptyLineHoverText(List<Component> tooltip){
        tooltip.add(new TextComponent(""));
    }

    public static void setFallDamageToZero(Player player){
        player.fallDistance = 0.0F;
    }

    public static void doRhodoniteArmorTickLogic(Player player){
        if(Config.RHODONITE_ARMOR_FLIGHT.get()){
            boolean isWearingFullSetOfRhodonite = player.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(Objects.Items.Armor.itemArmorRhodoniteHelmet.asItem()) && player.getItemBySlot(EquipmentSlot.CHEST).getItem().equals(Objects.Items.Armor.itemArmorRhodoniteChest.asItem()) && player.getItemBySlot(EquipmentSlot.LEGS).getItem().equals(Objects.Items.Armor.itemArmorRhodoniteLeggins.asItem()) && player.getItemBySlot(EquipmentSlot.FEET).getItem().equals(Objects.Items.Armor.itemArmorRhodoniteBoots.asItem());
            if(!player.getPersistentData().contains("wearingFullRhodoniteArmor"))player.getPersistentData().putBoolean("wearingFullRhodoniteArmor", false);
            boolean wasWearingArmorLastTick = player.getPersistentData().getBoolean("wearingFullRhodoniteArmor");

            if(!isWearingFullSetOfRhodonite && wasWearingArmorLastTick && !player.isCreative()){
                player.getAbilities().mayfly = false;
                player.getAbilities().flying = false;
            }else if(isWearingFullSetOfRhodonite){
                player.getAbilities().mayfly = true;
            }
            player.getPersistentData().putBoolean("wearingFullRhodoniteArmor", isWearingFullSetOfRhodonite);
        }
    }

    public static void addFoundInEndHoverText(List<Component> tooltip){
        tooltip.add(new TranslatableComponent(ChatFormatting.BLUE + "Can be found in the end!"));
    }
}