package com.vincentmet.rhodonite.datagen;

import com.vincentmet.rhodonite.Objects;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class RhodoniteItemTagGenerator extends ItemTagsProvider {
    public RhodoniteItemTagGenerator(DataGenerator generator, BlockTagsProvider blockTagsProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.ORES).add(Objects.Blocks.blockOreRhodonite.asItem(), Objects.Blocks.blockOreFluorite.asItem());
        tag(Tags.Items.STORAGE_BLOCKS).add(Objects.Blocks.blockFluorite.asItem(), Objects.Blocks.blockRhodonite.asItem());
        tag(Tags.Items.NUGGETS).add(Objects.Items.itemFluoriteNugget, Objects.Items.itemRhodoniteNugget);
        tag(Tags.Items.INGOTS).add(Objects.Items.itemRhodoniteIngot);
        tag(Tags.Items.GEMS).add(Objects.Items.itemFluoriteCrystal);
        tag(Tags.Items.DUSTS).add(Objects.Items.itemRhodoniteDust);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Rhodonite: Item Tag Generator";
    }
}
