package com.vincentmet.rhodonite.lib;

import com.vincentmet.rhodonite.Objects;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import java.util.function.Supplier;

public enum ArmorMaterials implements IArmorMaterial {
    RHODONITE(new ResourceLocation(Ref.MODID, "material_armor_rhodonite"), 9, new int[]{4, 7, 8, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1F, ()->{return Ingredient.fromItems(Objects.Items.itemRhodoniteIngot);});

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final ResourceLocation name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyLoadBase<Ingredient> repairMaterial;

    ArmorMaterials(ResourceLocation name, int maxDamageFactor, int[] damageReductionAmount, int enchantability, SoundEvent sound, float toughness, Supplier<Ingredient> repairMaterial){
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmount;
        this.enchantability = enchantability;
        this.soundEvent = sound;
        this.toughness = toughness;
        this.repairMaterial = new LazyLoadBase<>(repairMaterial);
    }

    @Override
    public int getDurability(EquipmentSlotType equipmentSlotType) {
        return MAX_DAMAGE_ARRAY[equipmentSlotType.getIndex()] * maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
        return damageReductionAmountArray[equipmentSlotType.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }

    @Override
    public String getName() {
        return name.toString();
    }

    @Override
    public float getToughness() {
        return toughness;
    }
}
