package com.vincentmet.rhodonite.lib;

import com.vincentmet.rhodonite.Objects;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ToolMaterials implements IItemTier {
    RHODONITE(5, 9876, 50, 12, 30, ()->{return Ingredient.fromItems(Objects.Items.itemRhodoniteIngot);}),
    RHODONITE_NOODLE(1, 42, 3, 1, 5, ()->{return Ingredient.fromItems(Objects.Items.itemRhodoniteIngot);}),
    FLUORITE(4, 1337, 15, 5, 30, ()->{return Ingredient.fromItems(Objects.Items.itemFluoriteCrystal);});

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
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial;
    }
}
