package com.vincentmet.rhodonite.lib;

import com.vincentmet.rhodonite.Objects;
import java.util.function.Supplier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.*;

public enum ArmorMaterials implements IArmorMaterial {
    RHODONITE(new ResourceLocation(Ref.MODID, "material_armor_rhodonite"), 1000, new int[]{8, 14, 20, 8}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 40F, ()->{return Ingredient.fromItems(Objects.Items.itemRhodoniteIngot);}, 4),
    FLUORITE(new ResourceLocation(Ref.MODID, "material_armor_fluorite"), 250, new int[]{4, 7, 10, 4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 20F, ()->{return Ingredient.fromItems(Objects.Items.itemFluoriteCrystal);}, 2);

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{4, 7, 8, 5};
    private final ResourceLocation name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Ingredient repairMaterial;
    private final float knockbackResistance;

    ArmorMaterials(ResourceLocation name, int maxDamageFactor, int[] damageReductionAmount, int enchantability, SoundEvent sound, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResistance){
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmount;
        this.enchantability = enchantability;
        this.soundEvent = sound;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial.get();
        this.knockbackResistance = knockbackResistance;
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
        return repairMaterial;
    }

    @Override
    public String getName() {
        return name.toString();
    }

    @Override
    public float getToughness() {
        return toughness;
    }
    
    @Override
    public float getKnockbackResistance(){//arrow knockback resistance
        return knockbackResistance;
    }
}
