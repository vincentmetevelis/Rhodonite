package com.vincentmet.rhodonite;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class ModEventHandler {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, Ref.MODID);
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Ref.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ref.MODID);

    public static final DeferredItem<Item> ITEM_RHODONITE_DUST = ITEMS.registerSimpleItem("item_rhodonite_dust");
    public static final DeferredItem<Item> ITEM_RHODONITE_INGOT = ITEMS.registerSimpleItem("item_rhodonite_ingot");
    public static final DeferredItem<Item> ITEM_RHODONITE_CRYSTAL = ITEMS.registerSimpleItem("item_rhodonite_crystal");
    public static final DeferredItem<Item> ITEM_RHODONITE_CRYSTAL_INFUSED = ITEMS.registerItem("item_rhodonite_crystal_infused", GlintItem::new);
    public static final DeferredItem<Item> ITEM_RHODONITE_HEART = ITEMS.registerItem("item_rhodonite_heart", ItemHeartOfRhodonite::new);
    public static final DeferredItem<Item> ITEM_RHODONITE_SWORD_HANDLE = ITEMS.registerSimpleItem("item_rhodonite_sword_handle");
    public static final DeferredItem<Item> ITEM_RHODONITE_SWORD_BLADE = ITEMS.registerSimpleItem("item_rhodonite_sword_blade");
    public static final DeferredItem<Item> ITEM_RHODONITE_SHARPENING_KIT = ITEMS.registerItem("item_rhodonite_sharpening_kit", GlintItem::new);
    public static final DeferredItem<Item> ITEM_RHODONITE_NUGGET = ITEMS.registerSimpleItem("item_rhodonite_nugget");
    public static final DeferredItem<Item> ITEM_OBSIDIAN_ROD = ITEMS.registerSimpleItem("item_obsidian_rod");

    public static final DeferredItem<Item> ITEM_FLUORITE_CRYSTAL = ITEMS.registerSimpleItem("item_fluorite_crystal");
    public static final DeferredItem<Item> ITEM_FLUORITE_NUGGET = ITEMS.registerSimpleItem("item_fluorite_nugget");

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ARMOR_MATERIAL_RHODONITE = ARMOR_MATERIALS.register("rhodonite", () -> new ArmorMaterial(
            rhodoniteDefenseMap(),
            30,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.of(ITEM_RHODONITE_INGOT.get()),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Ref.MODID, "material_armor_rhodonite"))),
            40F,
            4F
    ));

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ARMOR_MATERIAL_FLUORITE = ARMOR_MATERIALS.register("fluorite", () -> new ArmorMaterial(
            fluoriteDefenseMap(),
            30,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.of(ITEM_FLUORITE_CRYSTAL.get()),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Ref.MODID, "material_armor_fluorite"))),
            20F,
            2F
    ));

    public static final DeferredItem<Item> ITEM_FOOD_RHODONITE_APPLE = ITEMS.registerItem("item_food_rhodonite_apple", props -> new GlintItem(props.food(new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(5F)
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 6000), 2)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10000), 1)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 6000), 1)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 10000), 5)
            .build())));

    public static final DeferredItem<Item> ITEM_ARMOR_RHODONITE_HELMET = ITEMS.registerItem("item_armor_rhodonite_helmet", props -> new BaseArmorItem(
            ARMOR_MATERIAL_RHODONITE,
            ArmorItem.Type.HELMET,
            props.durability(5000),
            (stack, level, tooltip, tooltipFlag) -> RhodoniteHelper.addRhodoniteHoverText(tooltip)));
    public static final DeferredItem<Item> ITEM_ARMOR_RHODONITE_CHESTPLATE = ITEMS.registerItem("item_armor_rhodonite_chestplate", props -> new BaseArmorItem(
            ARMOR_MATERIAL_RHODONITE,
            ArmorItem.Type.CHESTPLATE,
            props.durability(7000),
            (stack, level, tooltip, tooltipFlag) -> RhodoniteHelper.addRhodoniteHoverText(tooltip)));
    public static final DeferredItem<Item> ITEM_ARMOR_RHODONITE_LEGGINGS = ITEMS.registerItem("item_armor_rhodonite_leggings", props -> new BaseArmorItem(
            ARMOR_MATERIAL_RHODONITE,
            ArmorItem.Type.LEGGINGS,
            props.durability(8000),
            (stack, level, tooltip, tooltipFlag) -> RhodoniteHelper.addRhodoniteHoverText(tooltip)));
    public static final DeferredItem<Item> ITEM_ARMOR_RHODONITE_BOOTS = ITEMS.registerItem("item_armor_rhodonite_boots", props -> new BaseArmorItem(
            ARMOR_MATERIAL_RHODONITE,
            ArmorItem.Type.BOOTS,
            props.durability(4000),
            (stack, level, tooltip, tooltipFlag) -> {
                RhodoniteHelper.addRhodoniteHoverText(tooltip);
                RhodoniteHelper.addEmptyLineHoverText(tooltip);
                RhodoniteHelper.addNoFallDamageHoverText(tooltip);
            }));

    public static final DeferredItem<Item> ITEM_ARMOR_FLUORITE_HELMET = ITEMS.registerItem("item_armor_fluorite_helmet", props -> new ArmorItem(ARMOR_MATERIAL_FLUORITE, ArmorItem.Type.HELMET, props.durability(1250)));
    public static final DeferredItem<Item> ITEM_ARMOR_FLUORITE_CHESTPLATE = ITEMS.registerItem("item_armor_fluorite_chestplate", props -> new ArmorItem(ARMOR_MATERIAL_FLUORITE, ArmorItem.Type.CHESTPLATE, props.durability(1750)));
    public static final DeferredItem<Item> ITEM_ARMOR_FLUORITE_LEGGINGS = ITEMS.registerItem("item_armor_fluorite_leggings", props -> new ArmorItem(ARMOR_MATERIAL_FLUORITE, ArmorItem.Type.LEGGINGS, props.durability(2000)));
    public static final DeferredItem<Item> ITEM_ARMOR_FLUORITE_BOOTS = ITEMS.registerItem("item_armor_fluorite_boots", props -> new BaseArmorItem(
            ARMOR_MATERIAL_FLUORITE,
            ArmorItem.Type.BOOTS,
            props.durability(1000),
            (stack, level, tooltip, tooltipFlag) -> RhodoniteHelper.addNoFallDamageHoverText(tooltip)));

    public static final DeferredItem<Item> ITEM_TOOL_RHODONITE_SWORD_NOODLE = ITEMS.registerItem("item_tool_rhodonite_sword_noodle", props -> new SwordItem(
            ToolMaterials.RHODONITE_NOODLE,
            props.attributes(SwordItem.createAttributes(ToolMaterials.RHODONITE_NOODLE, 1, -2.4F))));
    public static final DeferredItem<Item> ITEM_TOOL_RHODONITE_SWORD = ITEMS.registerItem("item_tool_rhodonite_sword", props -> new GlintSwordItem(
            ToolMaterials.RHODONITE,
            props.attributes(SwordItem.createAttributes(ToolMaterials.RHODONITE, 9, -2.4F))));
    public static final DeferredItem<Item> ITEM_TOOL_RHODONITE_PICKAXE = ITEMS.registerItem("item_tool_rhodonite_pickaxe", props -> new PickaxeItem(
            ToolMaterials.RHODONITE,
            props.attributes(PickaxeItem.createAttributes(ToolMaterials.RHODONITE, 1, -2.8F))));
    public static final DeferredItem<Item> ITEM_TOOL_RHODONITE_SHOVEL = ITEMS.registerItem("item_tool_rhodonite_shovel", props -> new ShovelItem(
            ToolMaterials.RHODONITE,
            props.attributes(ShovelItem.createAttributes(ToolMaterials.RHODONITE, 1.5F, -3.0F))));
    public static final DeferredItem<Item> ITEM_TOOL_RHODONITE_AXE = ITEMS.registerItem("item_tool_rhodonite_axe", props -> new AxeItem(
            ToolMaterials.RHODONITE,
            props.attributes(AxeItem.createAttributes(ToolMaterials.RHODONITE, 5.0F, -3.0F))));
    public static final DeferredItem<Item> ITEM_TOOL_RHODONITE_HOE = ITEMS.registerItem("item_tool_rhodonite_hoe", props -> new HoeItem(
            ToolMaterials.RHODONITE,
            props.attributes(HoeItem.createAttributes(ToolMaterials.RHODONITE, 0.0F, -3.0F))));

    public static final DeferredItem<Item> ITEM_TOOL_FLUORITE_SWORD = ITEMS.registerItem("item_tool_fluorite_sword", props -> new SwordItem(
            ToolMaterials.FLUORITE,
            props.attributes(SwordItem.createAttributes(ToolMaterials.FLUORITE, 9, -2.4F))));
    public static final DeferredItem<Item> ITEM_TOOL_FLUORITE_PICKAXE = ITEMS.registerItem("item_tool_fluorite_pickaxe", props -> new PickaxeItem(
            ToolMaterials.FLUORITE,
            props.attributes(PickaxeItem.createAttributes(ToolMaterials.FLUORITE, 1, -2.8F))));
    public static final DeferredItem<Item> ITEM_TOOL_FLUORITE_SHOVEL = ITEMS.registerItem("item_tool_fluorite_shovel", props -> new ShovelItem(
            ToolMaterials.FLUORITE,
            props.attributes(ShovelItem.createAttributes(ToolMaterials.FLUORITE, 1.5F, -3.0F))));
    public static final DeferredItem<Item> ITEM_TOOL_FLUORITE_AXE = ITEMS.registerItem("item_tool_fluorite_axe", props -> new AxeItem(
            ToolMaterials.FLUORITE,
            props.attributes(AxeItem.createAttributes(ToolMaterials.FLUORITE, 5.0F, -3.0F))));
    public static final DeferredItem<Item> ITEM_TOOL_FLUORITE_HOE = ITEMS.registerItem("item_tool_fluorite_hoe", props -> new HoeItem(
            ToolMaterials.FLUORITE,
            props.attributes(HoeItem.createAttributes(ToolMaterials.FLUORITE, 0.0F, -3.0F))));

    public static final DeferredBlock<Block> BLOCK_RHODONITE = BLOCKS.registerSimpleBlock("block_rhodonite", BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(6F));
    public static final DeferredBlock<Block> BLOCK_ORE_RHODONITE = BLOCKS.register("block_ore_rhodonite", () -> new BaseBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(6F),
            (stack, blockGetter, tooltip, tooltipFlag) -> RhodoniteHelper.addFoundInEndHoverText(tooltip)));
    public static final DeferredBlock<Block> BLOCK_FLUORITE = BLOCKS.registerSimpleBlock("block_fluorite", BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(4F));
    public static final DeferredBlock<Block> BLOCK_ORE_FLUORITE = BLOCKS.registerSimpleBlock("block_ore_fluorite", BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(4F));

    public static final DeferredItem<BlockItem> ITEM_BLOCK_RHODONITE = ITEMS.registerSimpleBlockItem("block_rhodonite", BLOCK_RHODONITE);
    public static final DeferredItem<BlockItem> ITEM_BLOCK_ORE_RHODONITE = ITEMS.registerSimpleBlockItem("block_ore_rhodonite", BLOCK_ORE_RHODONITE);
    public static final DeferredItem<BlockItem> ITEM_BLOCK_FLUORITE = ITEMS.registerSimpleBlockItem("block_fluorite", BLOCK_FLUORITE);
    public static final DeferredItem<BlockItem> ITEM_BLOCK_ORE_FLUORITE = ITEMS.registerSimpleBlockItem("block_ore_fluorite", BLOCK_ORE_FLUORITE);

    private ModEventHandler() {
    }

    private static Map<ArmorItem.Type, Integer> rhodoniteDefenseMap() {
        return Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 8);
            map.put(ArmorItem.Type.LEGGINGS, 20);
            map.put(ArmorItem.Type.CHESTPLATE, 14);
            map.put(ArmorItem.Type.HELMET, 8);
            map.put(ArmorItem.Type.BODY, 14);
        });
    }

    private static Map<ArmorItem.Type, Integer> fluoriteDefenseMap() {
        return Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 4);
            map.put(ArmorItem.Type.LEGGINGS, 10);
            map.put(ArmorItem.Type.CHESTPLATE, 7);
            map.put(ArmorItem.Type.HELMET, 4);
            map.put(ArmorItem.Type.BODY, 7);
        });
    }
}
