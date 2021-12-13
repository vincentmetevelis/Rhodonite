package com.vincentmet.rhodonite.datagen;

import com.vincentmet.rhodonite.Ref;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneratorRegistry {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();

        if (event.includeServer()) {
            generator.addProvider(new RhodoniteBlockTagGenerator(generator, event.getExistingFileHelper()));
            generator.addProvider(new RhodoniteItemTagGenerator(generator, new BlockTagsProvider(generator, Ref.MODID, event.getExistingFileHelper()), Ref.MODID, event.getExistingFileHelper()));
            generator.addProvider(new RhodoniteRecipeGenerator(generator, Ref.MODID));
        }
    }
}
