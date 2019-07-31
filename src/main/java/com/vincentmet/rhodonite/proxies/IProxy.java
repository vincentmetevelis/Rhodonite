package com.vincentmet.rhodonite.proxies;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public interface IProxy {
    void setup(final FMLCommonSetupEvent event);
}
