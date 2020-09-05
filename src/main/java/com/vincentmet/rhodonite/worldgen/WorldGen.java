package com.vincentmet.rhodonite.worldgen;

import com.vincentmet.rhodonite.Objects;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;

public class WorldGen {
    public static void addOresToBiome() {
        Biomes.THE_END.addFeature(
                GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.EMERALD_ORE
                        .withConfiguration(new ReplaceBlockConfig(Blocks.END_STONE.getDefaultState(), Objects.Blocks.blockOreRhodonite.getDefaultState()))/*OldBlockType, newBlock, VeinSize*/
                        .withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 32)))// count, bottom_offset, top_offset, maximum
        );
        for(Biome biome : Biome.BIOMES){
            if(!(biome.getCategory().equals(Biome.Category.THEEND) || biome.getCategory().equals(Biome.Category.NETHER))){
                biome.addFeature(
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        Feature.ORE
                                .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Objects.Blocks.blockOreFluorite.getDefaultState(), 8))
                                .withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 0, 0, 32)))
                );
            }
        }
    }
}