package com.vincentmet.rhodonite;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ArmorMaterials implements ArmorMaterial{
    RHODONITE(new ResourceLocation(Ref.MODID, "material_armor_rhodonite"), 1000, new int[]{8, 14, 20, 8}, 30, SoundEvents.ARMOR_EQUIP_DIAMOND, 40F, ()->{return Ingredient.of(Objects.Items.itemRhodoniteIngot);}, 4),
    FLUORITE(new ResourceLocation(Ref.MODID, "material_armor_fluorite"), 250, new int[]{4, 7, 10, 4}, 30, SoundEvents.ARMOR_EQUIP_DIAMOND, 20F, ()->{return Ingredient.of(Objects.Items.itemFluoriteCrystal);}, 2);

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
    public int getDurabilityForSlot(EquipmentSlot equipmentSlotType) {
        return MAX_DAMAGE_ARRAY[equipmentSlotType.getIndex()] * maxDamageFactor;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot equipmentSlotType) {
        return damageReductionAmountArray[equipmentSlotType.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
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