package com.vincentmet.rhodonite;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Ref.MODID)
public class BaseClass {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ref.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RHODONITE_TAB = CREATIVE_MODE_TABS.register("rhodonite_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModEventHandler.ITEM_TOOL_RHODONITE_SWORD.get()))
            .title(Component.translatable("itemGroup.rhodonite"))
            .displayItems((parameters, output) -> ModEventHandler.ITEMS.getEntries().forEach(item -> output.accept(item.get())))
            .build());

    public BaseClass(IEventBus modEventBus, ModContainer modContainer) {
        ModEventHandler.ARMOR_MATERIALS.register(modEventBus);
        ModEventHandler.BLOCKS.register(modEventBus);
        ModEventHandler.ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        NeoForge.EVENT_BUS.addListener(RhodoniteGameEvents::onPlayerTickPost);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Objects.Items.init();
            Objects.Blocks.init();
        });
    }
}
