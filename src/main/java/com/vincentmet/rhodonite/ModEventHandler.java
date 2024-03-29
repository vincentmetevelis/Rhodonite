package com.vincentmet.rhodonite;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ref.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventHandler {
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                Objects.Items.itemRhodoniteDust = new Item(new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_dust")),
                Objects.Items.itemRhodoniteIngot = new Item(new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_ingot")),
                Objects.Items.itemRhodoniteCrystal = new Item(new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_crystal")),
                Objects.Items.itemRhodoniteCrystalInfused = new Item(new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_crystal_infused")),
                Objects.Items.itemRhodoniteHeart = new ItemHeartOfRhodonite(new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_heart")),
                Objects.Items.itemRhodoniteSwordHandle = new Item(new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_sword_handle")),
                Objects.Items.itemRhodoniteSwordBlade = new Item(new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_sword_blade")),
                Objects.Items.itemRhodoniteSharpeningKit = new Item(new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_sharpening_kit")),
                Objects.Items.itemRhodoniteNugget = new Item(new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_nugget")),
                Objects.Items.itemObsidianRod = new Item(new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_obsidian_rod")),
                Objects.Items.Food.itemRhodoniteApple = new Item(new Item.Properties().stacksTo(64).tab(BaseClass.tab).food(new FoodProperties.Builder().saturationMod(5F).nutrition(10).alwaysEat().effect(()->new MobEffectInstance(MobEffects.REGENERATION, 6000), 2).effect(()->new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10000), 1).effect(()->new MobEffectInstance(MobEffects.WATER_BREATHING, 6000), 1).effect(()->new MobEffectInstance(MobEffects.ABSORPTION, 10000), 5).build())).setRegistryName(new ResourceLocation(Ref.MODID, "item_food_rhodonite_apple")),
                Objects.Items.itemFluoriteCrystal = new Item(new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_fluorite_crystal")),
                Objects.Items.itemFluoriteNugget = new Item(new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_fluorite_nugget")),

                Objects.Items.Armor.itemArmorRhodoniteHelmet = new BaseArmorItem(ArmorMaterials.RHODONITE, EquipmentSlot.HEAD, new Item.Properties().stacksTo(1).tab(BaseClass.tab), (stack, level, tooltip, tooltipFlag) -> RhodoniteHelper.addRhodoniteHoverText(tooltip), (stack, level, player) -> RhodoniteHelper.doRhodoniteArmorTickLogic(player)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_rhodonite_helmet")),
                Objects.Items.Armor.itemArmorRhodoniteChest = new BaseArmorItem(ArmorMaterials.RHODONITE, EquipmentSlot.CHEST, new Item.Properties().stacksTo(1).tab(BaseClass.tab), (stack, level, tooltip, tooltipFlag) -> RhodoniteHelper.addRhodoniteHoverText(tooltip), (stack, level, player) -> RhodoniteHelper.doRhodoniteArmorTickLogic(player)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_rhodonite_chestplate")),
                Objects.Items.Armor.itemArmorRhodoniteLeggins = new BaseArmorItem(ArmorMaterials.RHODONITE, EquipmentSlot.LEGS, new Item.Properties().stacksTo(1).tab(BaseClass.tab), (stack, level, tooltip, tooltipFlag) -> RhodoniteHelper.addRhodoniteHoverText(tooltip), (stack, level, player) -> RhodoniteHelper.doRhodoniteArmorTickLogic(player)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_rhodonite_leggings")),
                Objects.Items.Armor.itemArmorRhodoniteBoots = new BaseArmorItem(ArmorMaterials.RHODONITE, EquipmentSlot.FEET, new Item.Properties().stacksTo(1).tab(BaseClass.tab), (stack, level, tooltip, tooltipFlag) -> {
                    RhodoniteHelper.addRhodoniteHoverText(tooltip);
                    RhodoniteHelper.addEmptyLineHoverText(tooltip);
                    RhodoniteHelper.addNoFallDamageHoverText(tooltip);}, (stack, level, player) -> {
                    RhodoniteHelper.doRhodoniteArmorTickLogic(player);
                    RhodoniteHelper.setFallDamageToZero(player);}).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_rhodonite_boots")),

                Objects.Items.Armor.itemArmorFluoriteHelmet = new ArmorItem(ArmorMaterials.FLUORITE, EquipmentSlot.HEAD, new Item.Properties().stacksTo(1).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_fluorite_helmet")),
                Objects.Items.Armor.itemArmorFluoriteChest = new ArmorItem(ArmorMaterials.FLUORITE, EquipmentSlot.CHEST, new Item.Properties().stacksTo(1).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_fluorite_chestplate")),
                Objects.Items.Armor.itemArmorFluoriteLeggings = new ArmorItem(ArmorMaterials.FLUORITE, EquipmentSlot.LEGS, new Item.Properties().stacksTo(1).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_fluorite_leggings")),
                Objects.Items.Armor.itemArmorFluoriteBoots = new BaseArmorItem(ArmorMaterials.FLUORITE, EquipmentSlot.FEET, new Item.Properties().stacksTo(1).tab(BaseClass.tab), (stack, level, tooltip, tooltipFlag) -> RhodoniteHelper.addNoFallDamageHoverText(tooltip), (stack, level, player) -> RhodoniteHelper.setFallDamageToZero(player)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_fluorite_boots")),

                Objects.Items.Tools.itemToolRhodoniteSwordNoodle = new SwordItem(ToolMaterials.RHODONITE_NOODLE, 1, 1, new Item.Properties().stacksTo(1).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_sword_noodle")),
                Objects.Items.Tools.itemToolRhodoniteSword = new SwordItem(ToolMaterials.RHODONITE, 9, 9, new Item.Properties().stacksTo(1).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_sword")),
                Objects.Items.Tools.itemToolRhodonitePickaxe = new PickaxeItem(ToolMaterials.RHODONITE, 2, 9, new Item.Properties().stacksTo(1).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_pickaxe")),
                Objects.Items.Tools.itemToolRhodoniteShovel = new ShovelItem(ToolMaterials.RHODONITE, 2, 9, new Item.Properties().stacksTo(1).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_shovel")),
                Objects.Items.Tools.itemToolRhodoniteAxe = new AxeItem(ToolMaterials.RHODONITE, 2, 9, new Item.Properties().stacksTo(1).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_axe")),
                Objects.Items.Tools.itemToolRhodoniteHoe = new HoeItem(ToolMaterials.RHODONITE, 2, 2, new Item.Properties().stacksTo(1).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_hoe")),

                Objects.Items.Tools.itemToolFluoriteSword = new SwordItem(ToolMaterials.FLUORITE, 9, 9, new Item.Properties().stacksTo(1).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_fluorite_sword")),
                Objects.Items.Tools.itemToolFluoritePickaxe = new PickaxeItem(ToolMaterials.FLUORITE, 2, 9, new Item.Properties().stacksTo(1).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_fluorite_pickaxe")),
                Objects.Items.Tools.itemToolFluoriteShovel = new ShovelItem(ToolMaterials.FLUORITE, 2, 9, new Item.Properties().stacksTo(1).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_fluorite_shovel")),
                Objects.Items.Tools.itemToolFluoriteAxe = new AxeItem(ToolMaterials.FLUORITE, 2, 9, new Item.Properties().stacksTo(1).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_fluorite_axe")),
                Objects.Items.Tools.itemToolFluoriteHoe = new HoeItem(ToolMaterials.FLUORITE, 2, 1, new Item.Properties().stacksTo(1).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_fluorite_hoe")),

                Objects.Items.BlockItems.itemBlockRhodonite = new BlockItem(Objects.Blocks.blockRhodonite, new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "block_rhodonite")),
                Objects.Items.BlockItems.itemBlockOreRhodonite = new BlockItem(Objects.Blocks.blockOreRhodonite, new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "block_ore_rhodonite")),
                Objects.Items.BlockItems.itemBlockFluorite = new BlockItem(Objects.Blocks.blockFluorite, new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "block_fluorite")),
                Objects.Items.BlockItems.itemBlockOreFluorite = new BlockItem(Objects.Blocks.blockOreFluorite, new Item.Properties().stacksTo(64).tab(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "block_ore_fluorite"))
        );
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                Objects.Blocks.blockRhodonite = new Block(Block.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(6F)).setRegistryName(new ResourceLocation(Ref.MODID, "block_rhodonite")),
                Objects.Blocks.blockOreRhodonite = new BaseBlock(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(6F), (stack, blockGetter, tooltip, tooltipFlag) -> RhodoniteHelper.addFoundInEndHoverText(tooltip)).setRegistryName(new ResourceLocation(Ref.MODID, "block_ore_rhodonite")),

                Objects.Blocks.blockFluorite = new Block(Block.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(4F)).setRegistryName(new ResourceLocation(Ref.MODID, "block_fluorite")),
                Objects.Blocks.blockOreFluorite = new Block(Block.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(4F)).setRegistryName(new ResourceLocation(Ref.MODID, "block_ore_fluorite"))
        );
    }
}