package com.vincentmet.rhodonite.worldgen;


import com.vincentmet.rhodonite.Objects;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class WorldGen {

    private static final CustomOreFeature END_ORE = new CustomOreFeature(null);

    public static void addOresToBiome() {
        Biomes.THE_END.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                END_ORE,
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Objects.Blocks.blockOreRhodonite.getDefaultState(), 8), //OldBlockType, newBlock, VeinSize
                Placement.COUNT_RANGE,
                new CountRangeConfig(20, 0, 0, 32) // count, bottom_offset, top_offset, maximum
        ));
    }
}
