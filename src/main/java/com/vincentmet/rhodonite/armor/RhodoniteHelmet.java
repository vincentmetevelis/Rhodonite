package com.vincentmet.rhodonite.armor;

import com.vincentmet.rhodonite.Config;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class RhodoniteHelmet extends ArmorItem{
    public RhodoniteHelmet(ArmorMaterial armorMaterial, EquipmentSlot equipmentSlotType, Properties properties) {
        super(armorMaterial, equipmentSlotType, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(new TranslatableComponent(ChatFormatting.BLUE + "Ability: Flight"));
        tooltip.add(new TranslatableComponent(ChatFormatting.DARK_AQUA + "Use: Equip The Full Set"));
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(Config.RHODONITE_ARMOR_FLIGHT.get()){
            ItemStack stackHead = player.getItemBySlot(EquipmentSlot.HEAD);
            ItemStack stackChest = player.getItemBySlot(EquipmentSlot.CHEST);
            ItemStack stackLegging = player.getItemBySlot(EquipmentSlot.LEGS);
            ItemStack stackBoots = player.getItemBySlot(EquipmentSlot.FEET);

            boolean isWearingFullSetOfRhodonite = stackHead != null && stackHead.getItem() instanceof RhodoniteHelmet && stackChest != null && stackChest.getItem() instanceof RhodoniteChestplate && stackLegging != null && stackLegging.getItem() instanceof RhodoniteLeggings && stackBoots != null && stackBoots.getItem() instanceof RhodoniteBoots;
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
}
