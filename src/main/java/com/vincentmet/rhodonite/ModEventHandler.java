package com.vincentmet.rhodonite;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEventHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ref.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ref.MODID);

    // Items
    public static final RegistryObject<Item> ITEM_RHODONITE_DUST = ITEMS.register("item_rhodonite_dust", 
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_RHODONITE_INGOT = ITEMS.register("item_rhodonite_ingot", 
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_RHODONITE_CRYSTAL = ITEMS.register("item_rhodonite_crystal", 
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_RHODONITE_CRYSTAL_INFUSED = ITEMS.register("item_rhodonite_crystal_infused", 
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_RHODONITE_HEART = ITEMS.register("item_rhodonite_heart", 
        () -> new ItemHeartOfRhodonite(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_RHODONITE_SWORD_HANDLE = ITEMS.register("item_rhodonite_sword_handle", 
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_RHODONITE_SWORD_BLADE = ITEMS.register("item_rhodonite_sword_blade", 
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_RHODONITE_SHARPENING_KIT = ITEMS.register("item_rhodonite_sharpening_kit", 
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_RHODONITE_NUGGET = ITEMS.register("item_rhodonite_nugget", 
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_OBSIDIAN_ROD = ITEMS.register("item_obsidian_rod", 
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ITEM_FLUORITE_CRYSTAL = ITEMS.register("item_fluorite_crystal", 
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ITEM_FLUORITE_NUGGET = ITEMS.register("item_fluorite_nugget", 
        () -> new Item(new Item.Properties()));

    // Food
    public static final RegistryObject<Item> ITEM_FOOD_RHODONITE_APPLE = ITEMS.register("item_food_rhodonite_apple",
        () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .saturationMod(5F)
            .nutrition(10)
            .alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 6000), 2)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10000), 1)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 6000), 1)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 10000), 5)
            .build())));

    // Armor - Rhodonite
    public static final RegistryObject<Item> ITEM_ARMOR_RHODONITE_HELMET = ITEMS.register("item_armor_rhodonite_helmet",
        () -> new BaseArmorItem(ArmorMaterials.RHODONITE, ArmorItem.Type.HELMET, new Item.Properties(),
            (stack, level, tooltip, tooltipFlag) -> RhodoniteHelper.addRhodoniteHoverText(tooltip),
            (stack, level, player) -> RhodoniteHelper.doRhodoniteArmorTickLogic(player)));
    public static final RegistryObject<Item> ITEM_ARMOR_RHODONITE_CHESTPLATE = ITEMS.register("item_armor_rhodonite_chestplate",
        () -> new BaseArmorItem(ArmorMaterials.RHODONITE, ArmorItem.Type.CHESTPLATE, new Item.Properties(),
            (stack, level, tooltip, tooltipFlag) -> RhodoniteHelper.addRhodoniteHoverText(tooltip),
            (stack, level, player) -> RhodoniteHelper.doRhodoniteArmorTickLogic(player)));
    public static final RegistryObject<Item> ITEM_ARMOR_RHODONITE_LEGGINGS = ITEMS.register("item_armor_rhodonite_leggings",
        () -> new BaseArmorItem(ArmorMaterials.RHODONITE, ArmorItem.Type.LEGGINGS, new Item.Properties(),
            (stack, level, tooltip, tooltipFlag) -> RhodoniteHelper.addRhodoniteHoverText(tooltip),
            (stack, level, player) -> RhodoniteHelper.doRhodoniteArmorTickLogic(player)));
    public static final RegistryObject<Item> ITEM_ARMOR_RHODONITE_BOOTS = ITEMS.register("item_armor_rhodonite_boots",
        () -> new BaseArmorItem(ArmorMaterials.RHODONITE, ArmorItem.Type.BOOTS, new Item.Properties(),
            (stack, level, tooltip, tooltipFlag) -> {
                RhodoniteHelper.addRhodoniteHoverText(tooltip);
                RhodoniteHelper.addEmptyLineHoverText(tooltip);
                RhodoniteHelper.addNoFallDamageHoverText(tooltip);
            },
            (stack, level, player) -> {
                RhodoniteHelper.doRhodoniteArmorTickLogic(player);
                RhodoniteHelper.setFallDamageToZero(player);
            }));

    // Armor - Fluorite
    public static final RegistryObject<Item> ITEM_ARMOR_FLUORITE_HELMET = ITEMS.register("item_armor_fluorite_helmet",
        () -> new ArmorItem(ArmorMaterials.FLUORITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ITEM_ARMOR_FLUORITE_CHESTPLATE = ITEMS.register("item_armor_fluorite_chestplate",
        () -> new ArmorItem(ArmorMaterials.FLUORITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ITEM_ARMOR_FLUORITE_LEGGINGS = ITEMS.register("item_armor_fluorite_leggings",
        () -> new ArmorItem(ArmorMaterials.FLUORITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ITEM_ARMOR_FLUORITE_BOOTS = ITEMS.register("item_armor_fluorite_boots",
        () -> new BaseArmorItem(ArmorMaterials.FLUORITE, ArmorItem.Type.BOOTS, new Item.Properties(),
            (stack, level, tooltip, tooltipFlag) -> RhodoniteHelper.addNoFallDamageHoverText(tooltip),
            (stack, level, player) -> RhodoniteHelper.setFallDamageToZero(player)));

    // Tools - Rhodonite
    public static final RegistryObject<Item> ITEM_TOOL_RHODONITE_SWORD_NOODLE = ITEMS.register("item_tool_rhodonite_sword_noodle",
        () -> new SwordItem(ToolMaterials.RHODONITE_NOODLE, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> ITEM_TOOL_RHODONITE_SWORD = ITEMS.register("item_tool_rhodonite_sword",
        () -> new SwordItem(ToolMaterials.RHODONITE, 9, 9, new Item.Properties()));
    public static final RegistryObject<Item> ITEM_TOOL_RHODONITE_PICKAXE = ITEMS.register("item_tool_rhodonite_pickaxe",
        () -> new PickaxeItem(ToolMaterials.RHODONITE, 2, 9, new Item.Properties()));
    public static final RegistryObject<Item> ITEM_TOOL_RHODONITE_SHOVEL = ITEMS.register("item_tool_rhodonite_shovel",
        () -> new ShovelItem(ToolMaterials.RHODONITE, 2, 9, new Item.Properties()));
    public static final RegistryObject<Item> ITEM_TOOL_RHODONITE_AXE = ITEMS.register("item_tool_rhodonite_axe",
        () -> new AxeItem(ToolMaterials.RHODONITE, 2, 9, new Item.Properties()));
    public static final RegistryObject<Item> ITEM_TOOL_RHODONITE_HOE = ITEMS.register("item_tool_rhodonite_hoe",
        () -> new HoeItem(ToolMaterials.RHODONITE, 2, 2, new Item.Properties()));

    // Tools - Fluorite
    public static final RegistryObject<Item> ITEM_TOOL_FLUORITE_SWORD = ITEMS.register("item_tool_fluorite_sword",
        () -> new SwordItem(ToolMaterials.FLUORITE, 9, 9, new Item.Properties()));
    public static final RegistryObject<Item> ITEM_TOOL_FLUORITE_PICKAXE = ITEMS.register("item_tool_fluorite_pickaxe",
        () -> new PickaxeItem(ToolMaterials.FLUORITE, 2, 9, new Item.Properties()));
    public static final RegistryObject<Item> ITEM_TOOL_FLUORITE_SHOVEL = ITEMS.register("item_tool_fluorite_shovel",
        () -> new ShovelItem(ToolMaterials.FLUORITE, 2, 9, new Item.Properties()));
    public static final RegistryObject<Item> ITEM_TOOL_FLUORITE_AXE = ITEMS.register("item_tool_fluorite_axe",
        () -> new AxeItem(ToolMaterials.FLUORITE, 2, 9, new Item.Properties()));
    public static final RegistryObject<Item> ITEM_TOOL_FLUORITE_HOE = ITEMS.register("item_tool_fluorite_hoe",
        () -> new HoeItem(ToolMaterials.FLUORITE, 2, 1, new Item.Properties()));

    // Blocks
    public static final RegistryObject<Block> BLOCK_RHODONITE = BLOCKS.register("block_rhodonite",
        () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(6F)));
    public static final RegistryObject<Block> BLOCK_ORE_RHODONITE = BLOCKS.register("block_ore_rhodonite",
        () -> new BaseBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(6F),
            (stack, blockGetter, tooltip, tooltipFlag) -> RhodoniteHelper.addFoundInEndHoverText(tooltip)));
    public static final RegistryObject<Block> BLOCK_FLUORITE = BLOCKS.register("block_fluorite",
        () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(4F)));
    public static final RegistryObject<Block> BLOCK_ORE_FLUORITE = BLOCKS.register("block_ore_fluorite",
        () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(4F)));

    // Block Items
    public static final RegistryObject<Item> ITEM_BLOCK_RHODONITE = ITEMS.register("block_rhodonite",
        () -> new BlockItem(BLOCK_RHODONITE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_RHODONITE = ITEMS.register("block_ore_rhodonite",
        () -> new BlockItem(BLOCK_ORE_RHODONITE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ITEM_BLOCK_FLUORITE = ITEMS.register("block_fluorite",
        () -> new BlockItem(BLOCK_FLUORITE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ITEM_BLOCK_ORE_FLUORITE = ITEMS.register("block_ore_fluorite",
        () -> new BlockItem(BLOCK_ORE_FLUORITE.get(), new Item.Properties()));
}
