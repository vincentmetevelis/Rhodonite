package com.vincentmet.rhodonite;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

public final class RhodoniteGameEvents {
    private RhodoniteGameEvents() {
    }

    /**
     * Armor {@code inventoryTick} is unreliable for equipped armor in 1.21; run the same logic on the player tick (server only).
     */
    public static void onPlayerTickPost(net.neoforged.neoforge.event.tick.PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) {
            return;
        }
        RhodoniteHelper.doRhodoniteArmorTickLogic(player);
        Item feet = player.getItemBySlot(EquipmentSlot.FEET).getItem();
        if (feet == ModEventHandler.ITEM_ARMOR_RHODONITE_BOOTS.get() || feet == ModEventHandler.ITEM_ARMOR_FLUORITE_BOOTS.get()) {
            RhodoniteHelper.setFallDamageToZero(player);
        }
    }
}
