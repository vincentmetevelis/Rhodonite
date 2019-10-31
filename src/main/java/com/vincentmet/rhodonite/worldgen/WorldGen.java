package com.vincentmet.rhodonite.worldgen;

import com.vincentmet.rhodonite.Objects;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class WorldGen {

    private static final CustomOreFeature ENDSTONE_ORE = new CustomOreFeature(null, Blocks.END_STONE);
    private static final CustomOreFeature STONE_ORE = new CustomOreFeature(null, Blocks.STONE);

    public static void addOresToBiome() {
        Biomes.THE_END.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                ENDSTONE_ORE,
                new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Objects.Blocks.blockOreRhodonite.getDefaultState(), 8), //OldBlockType, newBlock, VeinSize
                Placement.COUNT_RANGE,
                new CountRangeConfig(20, 0, 0, 32) // count, bottom_offset, top_offset, maximum
        ));
        for(Biome biome : Biome.BIOMES){
            if(!(biome == Biomes.THE_END || biome == Biomes.NETHER)){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(
                        STONE_ORE,
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Objects.Blocks.blockOreFluorite.getDefaultState(), 8),
                        Placement.COUNT_RANGE,
                        new CountRangeConfig(7, 0, 0, 32)
                ));
            }
        }
    }
}
