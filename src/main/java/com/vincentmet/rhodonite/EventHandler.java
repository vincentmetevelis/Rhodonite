package com.vincentmet.rhodonite;

import com.vincentmet.rhodonite.lib.ArmorMaterials;
import com.vincentmet.rhodonite.armor.rhodonite.RhodoniteBoots;
import com.vincentmet.rhodonite.armor.rhodonite.RhodoniteChestplate;
import com.vincentmet.rhodonite.armor.rhodonite.RhodoniteHelmet;
import com.vincentmet.rhodonite.armor.rhodonite.RhodoniteLeggings;
import com.vincentmet.rhodonite.blocks.RhodoniteOre;
import com.vincentmet.rhodonite.items.HeartOfRhodonite;
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
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber(modid = Ref.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventHandler {
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                Objects.Items.itemRhodoniteDust = new Item(new Item.Properties().maxStackSize(64).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_dust")),
                Objects.Items.itemRhodoniteIngot = new Item(new Item.Properties().maxStackSize(64).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_ingot")),
                Objects.Items.itemRhodoniteCrystal = new Item(new Item.Properties().maxStackSize(64).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_crystal")),
                Objects.Items.itemRhodoniteCrystalInfused = new Item(new Item.Properties().maxStackSize(64).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_crystal_infused")),
                Objects.Items.itemRhodoniteHeart = new HeartOfRhodonite(new ResourceLocation(Ref.MODID, "item_rhodonite_heart"), 64, Rhodonite.tab),
                Objects.Items.itemRhodoniteSwordHandle = new Item(new Item.Properties().maxStackSize(64).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_sword_handle")),
                Objects.Items.itemRhodoniteSwordBlade = new Item(new Item.Properties().maxStackSize(64).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_sword_blade")),
                Objects.Items.itemRhodoniteSharpeningKit = new Item(new Item.Properties().maxStackSize(64).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_sharpening_kit")),
                Objects.Items.itemRhodoniteNugget = new Item(new Item.Properties().maxStackSize(64).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_rhodonite_nugget")),
                Objects.Items.itemObsidianRod = new Item(new Item.Properties().maxStackSize(64).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_obsidian_rod")),
                Objects.Items.Food.itemRhodoniteApple = new Item(new Item.Properties().maxStackSize(64).group(Rhodonite.tab).food(new Food.Builder().saturation(5F).hunger(10).setAlwaysEdible().effect(new EffectInstance(Effects.REGENERATION, 6000), 2).effect(new EffectInstance(Effects.RESISTANCE, 10000), 1).effect(new EffectInstance(Effects.WATER_BREATHING, 6000), 1).effect(new EffectInstance(Effects.ABSORPTION, 10000), 5).build())).setRegistryName(new ResourceLocation(Ref.MODID, "item_food_rhodonite_apple")),

                Objects.Items.Armor.itemArmorRhodoniteHelmet = new RhodoniteHelmet(ArmorMaterials.RHODONITE, EquipmentSlotType.HEAD, new Item.Properties().maxStackSize(1).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_rhodonite_helmet")),
                Objects.Items.Armor.itemArmorRhodoniteChest = new RhodoniteChestplate(ArmorMaterials.RHODONITE, EquipmentSlotType.CHEST, new Item.Properties().maxStackSize(1).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_rhodonite_chestplate")),
                Objects.Items.Armor.itemArmorRhodoniteLeggins = new RhodoniteLeggings(ArmorMaterials.RHODONITE, EquipmentSlotType.LEGS, new Item.Properties().maxStackSize(1).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_rhodonite_leggings")),
                Objects.Items.Armor.itemArmorRhodoniteBoots = new RhodoniteBoots(ArmorMaterials.RHODONITE, EquipmentSlotType.FEET, new Item.Properties().maxStackSize(1).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_armor_rhodonite_boots")),

                Objects.Items.Tools.itemToolRhodoniteSwordNoodle = new SwordItem(ToolMaterials.RHODONITE_NOODLE, 1, 1, new Item.Properties().maxStackSize(1).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_sword_noodle")),
                Objects.Items.Tools.itemToolRhodoniteSword = new SwordItem(ToolMaterials.RHODONITE, 9, 9, new Item.Properties().maxStackSize(1).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_sword")),
                Objects.Items.Tools.itemToolRhodonitePickaxe = new PickaxeItem(ToolMaterials.RHODONITE, 9, 9, new Item.Properties().maxStackSize(1).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_pickaxe")),
                Objects.Items.Tools.itemToolRhodoniteShovel = new ShovelItem(ToolMaterials.RHODONITE, 9, 9, new Item.Properties().maxStackSize(1).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_shovel")),
                Objects.Items.Tools.itemToolRhodoniteAxe = new AxeItem(ToolMaterials.RHODONITE, 9, 9, new Item.Properties().maxStackSize(1).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_axe")),
                Objects.Items.Tools.itemToolRhodoniteHoe = new HoeItem(ToolMaterials.RHODONITE, 9, new Item.Properties().maxStackSize(1).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "item_tool_rhodonite_hoe")),

                Objects.Items.BlockItems.itemBlockRhodonite = new BlockItem(Objects.Blocks.blockRhodonite, new Item.Properties().maxStackSize(64).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "block_rhodonite")),
                Objects.Items.BlockItems.itemBlockOreRhodonite = new BlockItem(Objects.Blocks.blockOreRhodonite, new Item.Properties().maxStackSize(64).group(Rhodonite.tab)).setRegistryName(new ResourceLocation(Ref.MODID, "block_ore_rhodonite"))
        );
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                Objects.Blocks.blockRhodonite = new DefaultBlock(new ResourceLocation(Ref.MODID, "block_rhodonite"), Material.IRON),
                Objects.Blocks.blockOreRhodonite = new RhodoniteOre(new ResourceLocation(Ref.MODID, "block_ore_rhodonite"), Material.ROCK)
        );
    }
}