package com.vincentmet.rhodonite.worldgen;

import com.vincentmet.rhodonite.Objects;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class WorldGen {
    public static void addOresToBiome() {
        Biomes.THE_END.addFeature(
                GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.EMERALD_ORE
                        .withConfiguration(new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), Objects.Blocks.blockOreRhodonite.getDefaultState()))/*OldBlockType, newBlock, VeinSize*/
                        .withPlacement(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(20, 0, 0, 32)))// count, bottom_offset, top_offset, maximum
        );
        for(Biome biome : Biome.BIOMES){
            if(!(biome == Biomes.THE_END || biome == Biomes.NETHER)){
                biome.addFeature(
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        Feature.ORE
                                .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Objects.Blocks.blockOreFluorite.getDefaultState(), 8))
                                .withPlacement(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(7, 0, 0, 32)))
                );
            }
        }
    }
}