package com.vincentmet.rhodonite;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum ToolMaterials implements Tier {
    RHODONITE(BlockTags.NEEDS_DIAMOND_TOOL, 4, 9876, 50, 12, 30, () -> Ingredient.of(ModEventHandler.ITEM_RHODONITE_INGOT.get())),
    RHODONITE_NOODLE(BlockTags.NEEDS_STONE_TOOL, 1, 42, 3, 1, 5, () -> Ingredient.of(ModEventHandler.ITEM_RHODONITE_INGOT.get())),
    FLUORITE(BlockTags.NEEDS_IRON_TOOL, 3, 1337, 15, 5, 30, () -> Ingredient.of(ModEventHandler.ITEM_FLUORITE_CRYSTAL.get()));

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    ToolMaterials(TagKey<Block> incorrectBlocksForDrops, int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public TagKey<Block> getTag() {
        return this.incorrectBlocksForDrops;
    }
}
