package com.vincentmet.rhodonite;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod(Ref.MODID)
public class BaseClass {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ref.MODID);
    
    public static final RegistryObject<CreativeModeTab> RHODONITE_TAB = CREATIVE_MODE_TABS.register("rhodonite_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModEventHandler.ITEM_TOOL_RHODONITE_SWORD.get()))
            .title(Component.translatable("itemGroup.rhodonite"))
            .displayItems((parameters, output) -> {
                ModEventHandler.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
            })
            .build());

    public BaseClass(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        ModEventHandler.BLOCKS.register(modEventBus);
        ModEventHandler.ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        
        modEventBus.addListener(this::commonSetup);
        
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
        Config.loadConfig(Config.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(Ref.MODID + "-common.toml"));
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void commonSetup(final net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Objects.Items.init();
            Objects.Blocks.init();
        });
    }
}