package com.vincentmet.rhodonite;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
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
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(ModEventHandler.class);
        MinecraftForge.EVENT_BUS.register(ForgeEventHandler.class);
    }
}