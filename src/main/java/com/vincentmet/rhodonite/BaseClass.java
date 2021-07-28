package com.vincentmet.rhodonite;

import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Ref.MODID)
public class BaseClass {
    public static final CreativeModeTab tab = new CreativeModeTab("tab_rhodonite") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Objects.Items.Tools.itemToolRhodoniteSword);
        }
    };

    public BaseClass(){
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
        Config.loadConfig(Config.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(Ref.MODID + "-common.toml"));
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(EventHandler.class);
    }

    private void setup(final FMLLoadCompleteEvent event){
        WorldGen.registerFeature(Objects.Blocks.blockOreFluorite, OreConfiguration.Predicates.NATURAL_STONE, 10, 30, 10);
        WorldGen.registerFeature(Objects.Blocks.blockOreRhodonite, new BlockMatchTest(Blocks.END_STONE), 10, 100, 20);
        WorldGen.setupGen();
    }
}