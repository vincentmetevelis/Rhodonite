package com.vincentmet.rhodonite;

import com.vincentmet.rhodonite.Objects;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ToolMaterials implements Tier{
    RHODONITE(6, 9876, 50, 12, 30, ()->{return Ingredient.of(Objects.Items.itemRhodoniteIngot);}),
    RHODONITE_NOODLE(1, 42, 3, 1, 5, ()->{return Ingredient.of(Objects.Items.itemRhodoniteIngot);}),
    FLUORITE(5, 1337, 15, 5, 30, ()->{return Ingredient.of(Objects.Items.itemFluoriteCrystal);});

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Ingredient repairMaterial;

    ToolMaterials(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = repairMaterialIn.get();
    }

    @Override
    public int getUses() {
        return this.maxUses;
    }

    @Override
    public float getSpeed() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getLevel() {
        return this.harvestLevel;
    }//todo use TierSortingRegistry for toolLevels

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial;
    }
}