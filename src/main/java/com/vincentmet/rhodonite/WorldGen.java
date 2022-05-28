package com.vincentmet.rhodonite;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class WorldGen {
    public static final RuleTest ENDSTONE_TEST = new BlockMatchTest(Blocks.END_STONE);

    //Rhodonite ore
    public static final List<OreConfiguration.TargetBlockState> ORE_RHODONITE_TARGET_LIST = List.of(OreConfiguration.target(ENDSTONE_TEST, Objects.Blocks.blockOreRhodonite.defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_RHODONITE_CF = FeatureUtils.register("ore_rhodonite", Feature.ORE, new OreConfiguration(ORE_RHODONITE_TARGET_LIST, 3));
    public static final Holder<PlacedFeature> ORE_RHODONITE_PF = PlacementUtils.register("ore_rhodonite_pf", ORE_RHODONITE_CF, OrePlacements.commonOrePlacement(50, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(64))));

    //Fluorite ore
    public static final List<OreConfiguration.TargetBlockState> ORE_FLUORITE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.NATURAL_STONE, Objects.Blocks.blockOreFluorite.defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_FLUORITE_CF = FeatureUtils.register("ore_fluorite", Feature.ORE, new OreConfiguration(ORE_FLUORITE_TARGET_LIST, 5));
    public static final Holder<PlacedFeature> ORE_FLUORITE_PF = PlacementUtils.register("ore_fluorite_pf", ORE_FLUORITE_CF, OrePlacements.commonOrePlacement(50, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(64))));

    public static void generateOres(final BiomeLoadingEvent event){
        List<Holder<PlacedFeature>> features = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
        features.add(ORE_RHODONITE_PF);
        features.add(ORE_FLUORITE_PF);
    }
}