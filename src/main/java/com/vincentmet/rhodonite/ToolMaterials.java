package com.vincentmet.rhodonite;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;

/**
 * Tool tiers for Rhodonite and Fluorite tools. Vanilla {@link SimpleTier} replaces the old enum + {@code Tier} pattern.
 */
public final class ToolMaterials {
    /**
     * Blocks that Rhodonite-tier tools still cannot mine for drops. Empty: Rhodonite tools are top tier for this mod.
     */
    public static final TagKey<Block> INCORRECT_FOR_RHODONITE_TOOL = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(Ref.MODID, "incorrect_for_rhodonite_tool"));

    public static final Tier RHODONITE = new SimpleTier(
            INCORRECT_FOR_RHODONITE_TOOL,
            9876,
            50,
            12,
            30,
            () -> Ingredient.of(ModEventHandler.ITEM_RHODONITE_INGOT.get())
    );
    public static final Tier RHODONITE_NOODLE = new SimpleTier(
            BlockTags.INCORRECT_FOR_STONE_TOOL,
            42,
            3,
            1,
            5,
            () -> Ingredient.of(ModEventHandler.ITEM_RHODONITE_INGOT.get())
    );
    public static final Tier FLUORITE = new SimpleTier(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1337,
            15,
            5,
            30,
            () -> Ingredient.of(ModEventHandler.ITEM_FLUORITE_CRYSTAL.get())
    );

    private ToolMaterials() {
    }
}
