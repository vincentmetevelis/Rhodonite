package com.vincentmet.rhodonite;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class RhodoniteHelper {
    public static void addRhodoniteHoverText(List<Component> tooltip) {
        tooltip.add(Component.translatable(ChatFormatting.BLUE + "Ability: Flight"));
        tooltip.add(Component.translatable(ChatFormatting.DARK_AQUA + "Use: Equip the full set"));
    }

    public static void addNoFallDamageHoverText(List<Component> tooltip) {
        tooltip.add(Component.translatable(ChatFormatting.BLUE + "Ability: No fall damage"));
    }

    public static void addEmptyLineHoverText(List<Component> tooltip) {
        tooltip.add(Component.literal(""));
    }

    public static void setFallDamageToZero(Player player) {
        player.fallDistance = 0.0F;
    }

    public static void doRhodoniteArmorTickLogic(Player player) {
        if (!Config.RHODONITE_ARMOR_FLIGHT.getAsBoolean()) {
            return;
        }
        boolean beforeMayfly = player.getAbilities().mayfly;
        boolean beforeFlying = player.getAbilities().flying;

        boolean isWearingFullSetOfRhodonite =
                player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModEventHandler.ITEM_ARMOR_RHODONITE_HELMET.get()
                        && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModEventHandler.ITEM_ARMOR_RHODONITE_CHESTPLATE.get()
                        && player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModEventHandler.ITEM_ARMOR_RHODONITE_LEGGINGS.get()
                        && player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModEventHandler.ITEM_ARMOR_RHODONITE_BOOTS.get();

        if (!player.getPersistentData().contains("wearingFullRhodoniteArmor")) {
            player.getPersistentData().putBoolean("wearingFullRhodoniteArmor", false);
        }
        boolean wasWearingArmorLastTick = player.getPersistentData().getBoolean("wearingFullRhodoniteArmor");

        if (!isWearingFullSetOfRhodonite && wasWearingArmorLastTick && !player.isCreative()) {
            player.getAbilities().mayfly = false;
            player.getAbilities().flying = false;
        } else if (isWearingFullSetOfRhodonite) {
            player.getAbilities().mayfly = true;
        }
        player.getPersistentData().putBoolean("wearingFullRhodoniteArmor", isWearingFullSetOfRhodonite);

        if (player instanceof ServerPlayer serverPlayer
                && (beforeMayfly != player.getAbilities().mayfly || beforeFlying != player.getAbilities().flying)) {
            serverPlayer.onUpdateAbilities();
        }
    }

    public static void addFoundInEndHoverText(List<Component> tooltip) {
        tooltip.add(Component.translatable(ChatFormatting.BLUE + "Can be found in the end!"));
    }
}
