package com.vincentmet.rhodonite.proxies;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientProxy implements IProxy {
    @Override
    public void setup(FMLCommonSetupEvent event) {
        /*File directory = event.getModConfigurationDirectory();
        cfg = new Configuration(new File(directory.getPath(), "Rhodonite.cfg"));
        ConfigHandler.readCfg();*/
    }
}