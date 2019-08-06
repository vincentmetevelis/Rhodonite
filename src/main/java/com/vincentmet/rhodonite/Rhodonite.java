package com.vincentmet.rhodonite;

import com.vincentmet.rhodonite.lib.Ref;
import com.vincentmet.rhodonite.proxies.ClientProxy;
import com.vincentmet.rhodonite.proxies.IProxy;
import com.vincentmet.rhodonite.proxies.ServerProxy;
import com.vincentmet.rhodonite.worldgen.WorldGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Ref.MODID)
public class Rhodonite {
    public static final ItemGroup tab = new ItemGroup("tab_rhodonite") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Objects.Items.Tools.itemToolRhodoniteSword);
        }
    };

    public static Rhodonite INSTANCE;
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public Rhodonite(){
        INSTANCE = this;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FluidRegistry.enableUniversalBucket();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){
        WorldGen.addOresToBiome();
    }
}
