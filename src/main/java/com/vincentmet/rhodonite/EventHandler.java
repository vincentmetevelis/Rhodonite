package com.vincentmet.rhodonite;

import com.vincentmet.rhodonite.armor.*;
import com.vincentmet.rhodonite.lib.ArmorMaterials;
import com.vincentmet.rhodonite.blocks.RhodoniteOre;
import com.vincentmet.rhodonite.items.ItemHeartOfRhodonite;
import com.vincentmet.rhodonite.lib.Ref;
import com.vincentmet.rhodonite.lib.ToolMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ref.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventHandler {
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                Objects.Items.itemRhodoniteDust = new Item(new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_dust")),
                Objects.Items.itemRhodoniteIngot = new Item(new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_ingot")),
                Objects.Items.itemRhodoniteCrystal = new Item(new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_crystal")),
                Objects.Items.itemRhodoniteCrystalInfused = new Item(new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_crystal_infused")),
                Objects.Items.itemRhodoniteHeart = new ItemHeartOfRhodonite(new ResourceLocation(Ref.MODID, "item_rhodonite_heart"), 64, BaseClass.tab),
                Objects.Items.itemRhodoniteSwordHandle = new Item(new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_sword_handle")),
                Objects.Items.itemRhodoniteSwordBlade = new Item(new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_sword_blade")),
                Objects.Items.itemRhodoniteSharpeningKit = new Item(new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_sharpening_kit")),
                Objects.Items.itemRhodoniteNugget = new Item(new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_nugget")),
                Objects.Items.itemObsidianRod = new Item(new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_obsidian_rod")),
                Objects.Items.Food.itemRhodoniteApple = new Item(new Item.Properties().maxStackSize(64).group(BaseClass.tab).food(new Food.Builder().saturation(5F).hunger(10).setAlwaysEdible().effect(new EffectInstance(Effects.REGENERATION, 6000), 2).effect(new EffectInstance(Effects.RESISTANCE, 10000), 1).effect(new EffectInstance(Effects.WATER_BREATHING, 6000), 1).effect(new EffectInstance(Effects.ABSORPTION, 10000), 5).build())).setRegistryName(new ResourceLocation(Ref.MODID, "item_food_rhodonite_apple")),
                Objects.Items.itemFluoriteCrystal = new Item(new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_fluorite_crystal")),
                Objects.Items.itemFluoriteNugget = new Item(new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_fluorite_nugget")),

                Objects.Items.Armor.itemArmorRhodoniteHelmet = new RhodoniteHelmet(ArmorMaterials.RHODONITE, EquipmentSlotType.HEAD, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_rhodonite_helmet")),
                Objects.Items.Armor.itemArmorRhodoniteChest = new RhodoniteChestplate(ArmorMaterials.RHODONITE, EquipmentSlotType.CHEST, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_rhodonite_chestplate")),
                Objects.Items.Armor.itemArmorRhodoniteLeggins = new RhodoniteLeggings(ArmorMaterials.RHODONITE, EquipmentSlotType.LEGS, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_rhodonite_leggings")),
                Objects.Items.Armor.itemArmorRhodoniteBoots = new RhodoniteBoots(ArmorMaterials.RHODONITE, EquipmentSlotType.FEET, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_rhodonite_boots")),

                Objects.Items.Armor.itemArmorFluoriteHelmet = new FluoriteHelmet(ArmorMaterials.FLUORITE, EquipmentSlotType.HEAD, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_fluorite_helmet")),
                Objects.Items.Armor.itemArmorFluoriteChest = new FluoriteChestplate(ArmorMaterials.FLUORITE, EquipmentSlotType.CHEST, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_fluorite_chestplate")),
                Objects.Items.Armor.itemArmorFluoriteLeggins = new FluoriteLeggings(ArmorMaterials.FLUORITE, EquipmentSlotType.LEGS, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_fluorite_leggings")),
                Objects.Items.Armor.itemArmorFluoriteBoots = new FluoriteBoots(ArmorMaterials.FLUORITE, EquipmentSlotType.FEET, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_fluorite_boots")),

                Objects.Items.Tools.itemToolRhodoniteSwordNoodle = new SwordItem(ToolMaterials.RHODONITE_NOODLE, 1, 1, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_sword_noodle")),
                Objects.Items.Tools.itemToolRhodoniteSword = new SwordItem(ToolMaterials.RHODONITE, 9, 9, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_sword")),
                Objects.Items.Tools.itemToolRhodonitePickaxe = new PickaxeItem(ToolMaterials.RHODONITE, 2, 9, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_pickaxe")),
                Objects.Items.Tools.itemToolRhodoniteShovel = new ShovelItem(ToolMaterials.RHODONITE, 2, 9, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_shovel")),
                Objects.Items.Tools.itemToolRhodoniteAxe = new AxeItem(ToolMaterials.RHODONITE, 2, 9, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_axe")),
                Objects.Items.Tools.itemToolRhodoniteHoe = new HoeItem(ToolMaterials.RHODONITE, 2, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_hoe")),

                Objects.Items.Tools.itemToolFluoriteSword = new SwordItem(ToolMaterials.FLUORITE, 9, 9, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_fluorite_sword")),
                Objects.Items.Tools.itemToolFluoritePickaxe = new PickaxeItem(ToolMaterials.FLUORITE, 2, 9, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_fluorite_pickaxe")),
                Objects.Items.Tools.itemToolFluoriteShovel = new ShovelItem(ToolMaterials.FLUORITE, 2, 9, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_fluorite_shovel")),
                Objects.Items.Tools.itemToolFluoriteAxe = new AxeItem(ToolMaterials.FLUORITE, 2, 9, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_fluorite_axe")),
                Objects.Items.Tools.itemToolFluoriteHoe = new HoeItem(ToolMaterials.FLUORITE, 2, new Item.Properties().maxStackSize(1).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_fluorite_hoe")),

                Objects.Items.BlockItems.itemBlockRhodonite = new BlockItem(Objects.Blocks.blockRhodonite, new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "block_rhodonite")),
                Objects.Items.BlockItems.itemBlockOreRhodonite = new BlockItem(Objects.Blocks.blockOreRhodonite, new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "block_ore_rhodonite")),
                Objects.Items.BlockItems.itemBlockFluorite = new BlockItem(Objects.Blocks.blockFluorite, new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "block_fluorite")),
                Objects.Items.BlockItems.itemBlockOreFluorite = new BlockItem(Objects.Blocks.blockOreFluorite, new Item.Properties().maxStackSize(64).group(BaseClass.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "block_ore_fluorite"))
        );
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                Objects.Blocks.blockRhodonite = new DefaultBlock(new ResourceLocation(Ref.MODID, "block_rhodonite"), Material.IRON),
                Objects.Blocks.blockOreRhodonite = new RhodoniteOre(new ResourceLocation(Ref.MODID, "block_ore_rhodonite"), Material.ROCK),

                Objects.Blocks.blockFluorite = new DefaultBlock(new ResourceLocation(Ref.MODID, "block_fluorite"), Material.IRON),
                Objects.Blocks.blockOreFluorite = new DefaultBlock(new ResourceLocation(Ref.MODID, "block_ore_fluorite"), Material.ROCK)
        );
    }
}