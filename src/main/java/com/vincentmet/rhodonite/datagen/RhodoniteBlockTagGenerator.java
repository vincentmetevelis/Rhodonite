package com.vincentmet.rhodonite.datagen;

import com.vincentmet.rhodonite.Objects;
import com.vincentmet.rhodonite.Ref;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class RhodoniteBlockTagGenerator extends BlockTagsProvider {
    public RhodoniteBlockTagGenerator(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Ref.MODID, existingFileHelper);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Rhodonite: Block Tag Generator";
    }

    @Override
    protected void addTags() {
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(Objects.Blocks.blockOreFluorite, Objects.Blocks.blockFluorite);
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(Objects.Blocks.blockOreRhodonite, Objects.Blocks.blockRhodonite);
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(Objects.Blocks.blockOreFluorite, Objects.Blocks.blockFluorite, Objects.Blocks.blockOreRhodonite, Objects.Blocks.blockRhodonite);
        tag(Tags.Blocks.ORES).add(Objects.Blocks.blockOreRhodonite, Objects.Blocks.blockOreFluorite);
        tag(Tags.Blocks.STORAGE_BLOCKS).add(Objects.Blocks.blockFluorite, Objects.Blocks.blockRhodonite);
    }
}
