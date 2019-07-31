package com.vincentmet.rhodonite;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class DefaultBlock extends Block {
    private ResourceLocation resourceLocation;
    private Material material;

    public DefaultBlock(ResourceLocation resourceLocation, Material material){
        super(Block.Properties.create(material).hardnessAndResistance(2f));
        setRegistryName(resourceLocation);
        this.resourceLocation = resourceLocation;
        this.material = material;
    }

    public ResourceLocation getResourceLocation() {
        return resourceLocation;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public Block getBlock() {
        return this;
    }
}