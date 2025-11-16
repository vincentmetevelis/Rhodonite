package com.vincentmet.rhodonite;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Objects {
    public static class Items{
        public static Item itemRhodoniteDust;
        public static Item itemRhodoniteIngot;
        public static Item itemRhodoniteCrystal;
        public static Item itemRhodoniteCrystalInfused;
        public static Item itemRhodoniteHeart;
        public static Item itemRhodoniteSwordHandle;
        public static Item itemRhodoniteSwordBlade;
        public static Item itemRhodoniteSharpeningKit;
        public static Item itemRhodoniteNugget;
        public static Item itemObsidianRod;

        public static Item itemFluoriteCrystal;
        public static Item itemFluoriteNugget;

        public static class BlockItems{
            public static Item itemBlockRhodonite;
            public static Item itemBlockOreRhodonite;

            public static Item itemBlockOreFluorite;
            public static Item itemBlockFluorite;
        }

        public static class Armor{
            public static Item itemArmorRhodoniteHelmet;
            public static Item itemArmorRhodoniteChest;
            public static Item itemArmorRhodoniteLeggins;
            public static Item itemArmorRhodoniteBoots;

            public static Item itemArmorFluoriteHelmet;
            public static Item itemArmorFluoriteChest;
            public static Item itemArmorFluoriteLeggings;
            public static Item itemArmorFluoriteBoots;
        }

        public static class Tools{
            public static Item itemToolRhodoniteSwordNoodle;
            public static Item itemToolRhodoniteSword;
            public static Item itemToolRhodonitePickaxe;
            public static Item itemToolRhodoniteShovel;
            public static Item itemToolRhodoniteAxe;
            public static Item itemToolRhodoniteHoe;

            public static Item itemToolFluoriteSword;
            public static Item itemToolFluoritePickaxe;
            public static Item itemToolFluoriteShovel;
            public static Item itemToolFluoriteAxe;
            public static Item itemToolFluoriteHoe;
        }

        public static class Food{
            public static Item itemRhodoniteApple;
        }
        
        public static void init() {
            itemRhodoniteDust = ModEventHandler.ITEM_RHODONITE_DUST.get();
            itemRhodoniteIngot = ModEventHandler.ITEM_RHODONITE_INGOT.get();
            itemRhodoniteCrystal = ModEventHandler.ITEM_RHODONITE_CRYSTAL.get();
            itemRhodoniteCrystalInfused = ModEventHandler.ITEM_RHODONITE_CRYSTAL_INFUSED.get();
            itemRhodoniteHeart = ModEventHandler.ITEM_RHODONITE_HEART.get();
            itemRhodoniteSwordHandle = ModEventHandler.ITEM_RHODONITE_SWORD_HANDLE.get();
            itemRhodoniteSwordBlade = ModEventHandler.ITEM_RHODONITE_SWORD_BLADE.get();
            itemRhodoniteSharpeningKit = ModEventHandler.ITEM_RHODONITE_SHARPENING_KIT.get();
            itemRhodoniteNugget = ModEventHandler.ITEM_RHODONITE_NUGGET.get();
            itemObsidianRod = ModEventHandler.ITEM_OBSIDIAN_ROD.get();
            
            itemFluoriteCrystal = ModEventHandler.ITEM_FLUORITE_CRYSTAL.get();
            itemFluoriteNugget = ModEventHandler.ITEM_FLUORITE_NUGGET.get();
            
            BlockItems.itemBlockRhodonite = ModEventHandler.ITEM_BLOCK_RHODONITE.get();
            BlockItems.itemBlockOreRhodonite = ModEventHandler.ITEM_BLOCK_ORE_RHODONITE.get();
            BlockItems.itemBlockFluorite = ModEventHandler.ITEM_BLOCK_FLUORITE.get();
            BlockItems.itemBlockOreFluorite = ModEventHandler.ITEM_BLOCK_ORE_FLUORITE.get();
            
            Armor.itemArmorRhodoniteHelmet = ModEventHandler.ITEM_ARMOR_RHODONITE_HELMET.get();
            Armor.itemArmorRhodoniteChest = ModEventHandler.ITEM_ARMOR_RHODONITE_CHESTPLATE.get();
            Armor.itemArmorRhodoniteLeggins = ModEventHandler.ITEM_ARMOR_RHODONITE_LEGGINGS.get();
            Armor.itemArmorRhodoniteBoots = ModEventHandler.ITEM_ARMOR_RHODONITE_BOOTS.get();
            
            Armor.itemArmorFluoriteHelmet = ModEventHandler.ITEM_ARMOR_FLUORITE_HELMET.get();
            Armor.itemArmorFluoriteChest = ModEventHandler.ITEM_ARMOR_FLUORITE_CHESTPLATE.get();
            Armor.itemArmorFluoriteLeggings = ModEventHandler.ITEM_ARMOR_FLUORITE_LEGGINGS.get();
            Armor.itemArmorFluoriteBoots = ModEventHandler.ITEM_ARMOR_FLUORITE_BOOTS.get();
            
            Tools.itemToolRhodoniteSwordNoodle = ModEventHandler.ITEM_TOOL_RHODONITE_SWORD_NOODLE.get();
            Tools.itemToolRhodoniteSword = ModEventHandler.ITEM_TOOL_RHODONITE_SWORD.get();
            Tools.itemToolRhodonitePickaxe = ModEventHandler.ITEM_TOOL_RHODONITE_PICKAXE.get();
            Tools.itemToolRhodoniteShovel = ModEventHandler.ITEM_TOOL_RHODONITE_SHOVEL.get();
            Tools.itemToolRhodoniteAxe = ModEventHandler.ITEM_TOOL_RHODONITE_AXE.get();
            Tools.itemToolRhodoniteHoe = ModEventHandler.ITEM_TOOL_RHODONITE_HOE.get();
            
            Tools.itemToolFluoriteSword = ModEventHandler.ITEM_TOOL_FLUORITE_SWORD.get();
            Tools.itemToolFluoritePickaxe = ModEventHandler.ITEM_TOOL_FLUORITE_PICKAXE.get();
            Tools.itemToolFluoriteShovel = ModEventHandler.ITEM_TOOL_FLUORITE_SHOVEL.get();
            Tools.itemToolFluoriteAxe = ModEventHandler.ITEM_TOOL_FLUORITE_AXE.get();
            Tools.itemToolFluoriteHoe = ModEventHandler.ITEM_TOOL_FLUORITE_HOE.get();
            
            Food.itemRhodoniteApple = ModEventHandler.ITEM_FOOD_RHODONITE_APPLE.get();
        }
    }

    public static class Blocks{
        public static Block blockRhodonite;
        public static Block blockOreRhodonite;

        public static Block blockOreFluorite;
        public static Block blockFluorite;
        
        public static void init() {
            blockRhodonite = ModEventHandler.BLOCK_RHODONITE.get();
            blockOreRhodonite = ModEventHandler.BLOCK_ORE_RHODONITE.get();
            blockFluorite = ModEventHandler.BLOCK_FLUORITE.get();
            blockOreFluorite = ModEventHandler.BLOCK_ORE_FLUORITE.get();
        }
    }
}
