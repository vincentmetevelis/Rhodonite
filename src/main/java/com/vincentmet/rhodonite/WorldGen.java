package com.vincentmet.rhodonite;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class WorldGen {
    public static void registerFeature(Block block, RuleTest surroundingBlock, int veinSize, int maxY, int veinsPerChunk){
        OreConfiguration feature = new OreConfiguration(surroundingBlock, block.defaultBlockState(), veinSize);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, block.getRegistryName(), Feature.ORE.configured(feature));
        //TODO
        //.rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(maxY)).count(veinsPerChunk).squared());
    
    }
    
    public static void setupGen() {
        for(Map.Entry<ResourceKey<Biome>, Biome> biome : ForgeRegistries.BIOMES.getEntries()){
            if(!biome.getValue().getBiomeCategory().equals(Biome.BiomeCategory.NETHER) && !biome.getValue().getBiomeCategory().equals(Biome.BiomeCategory.THEEND)){ // Overworld
                addFeatureToBiome(biome.getValue(), GenerationStep.Decoration.UNDERGROUND_ORES, BuiltinRegistries.CONFIGURED_FEATURE.get(Objects.Blocks.blockOreFluorite.getRegistryName()));
            }
            if(biome.getValue().getBiomeCategory().equals(Biome.BiomeCategory.THEEND)){
                addFeatureToBiome(biome.getValue(), GenerationStep.Decoration.UNDERGROUND_ORES, BuiltinRegistries.CONFIGURED_FEATURE.get(Objects.Blocks.blockOreRhodonite.getRegistryName()));
            }
        }
    }
    
    public static void addFeatureToBiome(Biome biome, GenerationStep.Decoration decoration, ConfiguredFeature<?, ?> configuredFeature){
        //TODO
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = new ArrayList(biome.getGenerationSettings().features());
    
        while (biomeFeatures.size() <= decoration.ordinal()) {
            biomeFeatures.add(new ArrayList<>());
        }
        List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList<>(biomeFeatures.get(decoration.ordinal()));
        features.add(() -> configuredFeature);
        biomeFeatures.set(decoration.ordinal(), features);
        ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, biome.getGenerationSettings(), biomeFeatures, "features");
    }
}