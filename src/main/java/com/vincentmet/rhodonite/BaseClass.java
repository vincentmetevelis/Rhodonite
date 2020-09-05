package com.vincentmet.rhodonite;

import com.vincentmet.rhodonite.lib.Ref;
import com.vincentmet.rhodonite.worldgen.WorldGen;
import net.minecraft.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Ref.MODID)
public class BaseClass {
    public static final ItemGroup tab = new ItemGroup("tab_rhodonite") {
        @Override
        public ItemStack createIcon() {
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

    private void setup(final FMLCommonSetupEvent event){
        WorldGen.addOresToBiome();
    }
}
