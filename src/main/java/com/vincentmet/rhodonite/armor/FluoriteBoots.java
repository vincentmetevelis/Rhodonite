package com.vincentmet.rhodonite.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class FluoriteBoots extends ArmorItem{
    public FluoriteBoots(ArmorMaterial armorMaterial, EquipmentSlot equipmentSlotType, Properties properties) {
        super(armorMaterial, equipmentSlotType, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        player.fallDistance = 0.0F;
    }
}