package com.vincentmet.rhodonite.datagen;

import com.vincentmet.rhodonite.Objects;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class RhodoniteRecipeGenerator extends RecipeProvider {
    private final String modId;
    public RhodoniteRecipeGenerator(DataGenerator generator, String modId) {
        super(generator);
        this.modId = modId;
    }

    @Override
    protected void buildCraftingRecipes(@Nonnull Consumer<FinishedRecipe> consumer) {
        createBlockRecipes(consumer);
        createArmorRecipes(consumer);
        createToolRecipes(consumer);
        createMiscRecipes(consumer);
        createSmeltingRecipes(consumer);
    }

    private void createSmeltingRecipes(Consumer<FinishedRecipe> consumer) {
        //rhodonite ore
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Objects.Items.BlockItems.itemBlockOreRhodonite),
                        Objects.Items.itemRhodoniteIngot, 0.35F, 200)
                .unlockedBy("has_rhodonite_ore", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.BlockItems.itemBlockOreRhodonite))
                .save(consumer, createRecipeSaveLoc("smelting/rhodonite_ore_2_ingot"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Objects.Items.BlockItems.itemBlockOreRhodonite),
                        Objects.Items.itemRhodoniteIngot, 0.35F, 200)
                .unlockedBy("has_rhodonite_ore", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.BlockItems.itemBlockOreRhodonite))
                .save(consumer, createRecipeSaveLoc("smelting/rhodonite_ore_2_ingot_blasting"));

        //rhodonite dust
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Objects.Items.itemRhodoniteDust),
                        Objects.Items.itemRhodoniteIngot, 0.35F, 200)
                .unlockedBy("has_rhodonite_dust", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteDust))
                .save(consumer, createRecipeSaveLoc("smelting/rhodonite_dust_2_ingot"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Objects.Items.itemRhodoniteDust),
                        Objects.Items.itemRhodoniteIngot, 0.35F, 200)
                .unlockedBy("has_rhodonite_dust", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteDust))
                .save(consumer, createRecipeSaveLoc("smelting/rhodonite_dust_2_ingot_blasting"));

        //fluorite ore
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Objects.Items.BlockItems.itemBlockOreFluorite),
                        Objects.Items.itemFluoriteCrystal, 0.35F, 200)
                .unlockedBy("has_fluorite_ore", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.BlockItems.itemBlockOreFluorite))
                .save(consumer, createRecipeSaveLoc("smelting/fluorite_ore_2_ingot"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Objects.Items.BlockItems.itemBlockOreFluorite),
                        Objects.Items.itemFluoriteCrystal, 0.35F, 200)
                .unlockedBy("has_fluorite_ore", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.BlockItems.itemBlockOreFluorite))
                .save(consumer, createRecipeSaveLoc("smelting/fluorite_ore_2_ingot_blasting"));

    }

    private void createBlockRecipes(Consumer<FinishedRecipe> consumer) {
        //uncraft + recraft fluorite
        ShapedRecipeBuilder.shaped(Objects.Items.BlockItems.itemBlockFluorite)
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .define('x', Objects.Items.itemFluoriteCrystal)
                .unlockedBy("has_fluorite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemFluoriteCrystal))
                .save(consumer, createRecipeSaveLoc("fluorite_crystal_2_block"));
        ShapedRecipeBuilder.shaped(Objects.Items.itemFluoriteCrystal)
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .define('x', Objects.Items.itemFluoriteNugget)
                .unlockedBy("has_fluorite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemFluoriteCrystal))
                .save(consumer, createRecipeSaveLoc("fluorite_nugget_2_crystal"));
        ShapelessRecipeBuilder.shapeless(Objects.Items.itemFluoriteCrystal, 9)
                .requires(Objects.Items.BlockItems.itemBlockFluorite)
                .unlockedBy("has_fluorite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemFluoriteCrystal))
                .save(consumer, createRecipeSaveLoc("fluorite_block_2_crystal"));
        ShapelessRecipeBuilder.shapeless(Objects.Items.itemFluoriteNugget, 9)
                .requires(Objects.Items.itemFluoriteCrystal)
                .unlockedBy("has_fluorite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemFluoriteCrystal))
                .save(consumer, createRecipeSaveLoc("fluorite_crystal_2_nugget"));

        //uncraft + recraft rhodonite
        ShapedRecipeBuilder.shaped(Objects.Items.BlockItems.itemBlockRhodonite)
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .define('x', Objects.Items.itemRhodoniteIngot)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("rhodonite_ingot_2_block"));
        ShapedRecipeBuilder.shaped(Objects.Items.itemRhodoniteIngot)
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .define('x', Objects.Items.itemRhodoniteNugget)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("rhodonite_nugget_2_ingot"));
        ShapelessRecipeBuilder.shapeless(Objects.Items.itemRhodoniteNugget, 9)
                .requires(Objects.Items.itemRhodoniteIngot)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("rhodonite_ingot_2_nugget"));
        ShapelessRecipeBuilder.shapeless(Objects.Items.itemRhodoniteIngot, 9)
                .requires(Objects.Items.BlockItems.itemBlockRhodonite)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("rhodonite_block_2_ingot"));
    }

    private void createArmorRecipes(Consumer<FinishedRecipe> consumer) {
        //fluorite
        ShapedRecipeBuilder.shaped(Objects.Items.Armor.itemArmorFluoriteHelmet)
                .pattern("xyx")
                .pattern("x x")
                .define('x', Objects.Items.itemFluoriteCrystal)
                .define('y', Objects.Items.BlockItems.itemBlockFluorite)
                .unlockedBy("has_fluorite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemFluoriteCrystal))
                .save(consumer, createRecipeSaveLoc("armor/fluorite_helmet"));
        ShapedRecipeBuilder.shaped(Objects.Items.Armor.itemArmorFluoriteChest)
                .pattern("x x")
                .pattern("xyx")
                .pattern("xxx")
                .define('x', Objects.Items.itemFluoriteCrystal)
                .define('y', Objects.Items.BlockItems.itemBlockFluorite)
                .unlockedBy("has_fluorite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemFluoriteCrystal))
                .save(consumer, createRecipeSaveLoc("armor/fluorite_chestplate"));
        ShapedRecipeBuilder.shaped(Objects.Items.Armor.itemArmorFluoriteLeggings)
                .pattern("xyx")
                .pattern("x x")
                .pattern("x x")
                .define('x', Objects.Items.itemFluoriteCrystal)
                .define('y', Objects.Items.BlockItems.itemBlockFluorite)
                .unlockedBy("has_fluorite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemFluoriteCrystal))
                .save(consumer, createRecipeSaveLoc("armor/fluorite_leggings"));
        ShapedRecipeBuilder.shaped(Objects.Items.Armor.itemArmorFluoriteBoots)
                .pattern("x x")
                .pattern("y y")
                .define('x', Objects.Items.itemFluoriteCrystal)
                .define('y', Objects.Items.BlockItems.itemBlockFluorite)
                .unlockedBy("has_fluorite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemFluoriteCrystal))
                .save(consumer, createRecipeSaveLoc("armor/fluorite_boots"));

        //rhodonite
        ShapedRecipeBuilder.shaped(Objects.Items.Armor.itemArmorRhodoniteHelmet)
                .pattern("xyx")
                .pattern("x x")
                .define('x', Objects.Items.itemRhodoniteIngot)
                .define('y', Objects.Items.BlockItems.itemBlockRhodonite)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("armor/rhodonite_helmet"));
        ShapedRecipeBuilder.shaped(Objects.Items.Armor.itemArmorRhodoniteChest)
                .pattern("x x")
                .pattern("xyx")
                .pattern("xxx")
                .define('x', Objects.Items.itemRhodoniteIngot)
                .define('y', Objects.Items.BlockItems.itemBlockRhodonite)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("armor/rhodonite_chestplate"));
        ShapedRecipeBuilder.shaped(Objects.Items.Armor.itemArmorRhodoniteLeggings)
                .pattern("xyx")
                .pattern("x x")
                .pattern("x x")
                .define('x', Objects.Items.itemRhodoniteIngot)
                .define('y', Objects.Items.BlockItems.itemBlockRhodonite)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("armor/rhodonite_leggings"));
        ShapedRecipeBuilder.shaped(Objects.Items.Armor.itemArmorRhodoniteBoots)
                .pattern("x x")
                .pattern("y y")
                .define('x', Objects.Items.itemRhodoniteIngot)
                .define('y', Objects.Items.BlockItems.itemBlockRhodonite)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("armor/rhodonite_boots"));
    }

    private void createToolRecipes(Consumer<FinishedRecipe> consumer) {
        //fluorite
        ShapedRecipeBuilder.shaped(Objects.Items.Tools.itemToolFluoriteAxe)
                .pattern("xx")
                .pattern("sx")
                .pattern("s ")
                .define('x', Objects.Items.itemFluoriteCrystal)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_fluorite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemFluoriteCrystal))
                .save(consumer, createRecipeSaveLoc("tools/fluorite_axe"));
        ShapedRecipeBuilder.shaped(Objects.Items.Tools.itemToolFluoritePickaxe)
                .pattern("xbx")
                .pattern(" s ")
                .pattern(" s ")
                .define('x', Objects.Items.itemFluoriteCrystal)
                .define('s', Tags.Items.RODS_WOODEN)
                .define('b', Objects.Items.BlockItems.itemBlockFluorite)
                .unlockedBy("has_fluorite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemFluoriteCrystal))
                .save(consumer, createRecipeSaveLoc("tools/fluorite_pickaxe"));
        ShapedRecipeBuilder.shaped(Objects.Items.Tools.itemToolFluoriteHoe)
                .pattern("xx")
                .pattern("s ")
                .pattern("s ")
                .define('x', Objects.Items.itemFluoriteCrystal)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_fluorite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemFluoriteCrystal))
                .save(consumer, createRecipeSaveLoc("tools/fluorite_hoe"));
        ShapedRecipeBuilder.shaped(Objects.Items.Tools.itemToolFluoriteShovel)
                .pattern("x")
                .pattern("s")
                .pattern("s")
                .define('x', Objects.Items.itemFluoriteCrystal)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_fluorite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemFluoriteCrystal))
                .save(consumer, createRecipeSaveLoc("tools/fluorite_shovel"));
        ShapedRecipeBuilder.shaped(Objects.Items.Tools.itemToolFluoriteSword)
                .pattern("x")
                .pattern("x")
                .pattern("s")
                .define('x', Objects.Items.BlockItems.itemBlockFluorite)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_fluorite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemFluoriteCrystal))
                .save(consumer, createRecipeSaveLoc("tools/fluorite_sword"));

        //rhodonite
        ShapedRecipeBuilder.shaped(Objects.Items.Tools.itemToolRhodoniteAxe)
                .pattern("xx")
                .pattern("sx")
                .pattern("s ")
                .define('x', Objects.Items.itemRhodoniteIngot)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("tools/rhodonite_axe"));
        ShapedRecipeBuilder.shaped(Objects.Items.Tools.itemToolRhodonitePickaxe)
                .pattern("xbx")
                .pattern(" s ")
                .pattern(" s ")
                .define('x', Objects.Items.itemRhodoniteIngot)
                .define('b', Objects.Items.BlockItems.itemBlockRhodonite)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("tools/rhodonite_pickaxe"));
        ShapedRecipeBuilder.shaped(Objects.Items.Tools.itemToolRhodoniteHoe)
                .pattern("xx")
                .pattern("s ")
                .pattern("s ")
                .define('x', Objects.Items.itemRhodoniteIngot)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("tools/rhodonite_hoe"));
        ShapedRecipeBuilder.shaped(Objects.Items.Tools.itemToolRhodoniteShovel)
                .pattern("x")
                .pattern("s")
                .pattern("s")
                .define('x', Objects.Items.itemRhodoniteIngot)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("tools/rhodonite_shovel"));
        ShapedRecipeBuilder.shaped(Objects.Items.Tools.itemToolRhodoniteSword)
                .pattern(" x")
                .pattern("yx")
                .define('x', Objects.Items.itemRhodoniteSharpeningKit)
                .define('y', Objects.Items.Tools.itemToolRhodoniteSwordNoodle)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("tools/rhodonite_sword"));
        ShapedRecipeBuilder.shaped(Objects.Items.Tools.itemToolRhodoniteSwordNoodle)
                .pattern("  x")
                .pattern(" y ")
                .pattern("z  ")
                .define('x', Objects.Items.itemRhodoniteSwordBlade)
                .define('y', Objects.Items.itemRhodoniteCrystalInfused)
                .define('z', Objects.Items.itemRhodoniteSwordHandle)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("tools/rhodonite_sword_noodle"));
    }

    private void createMiscRecipes(Consumer<FinishedRecipe> consumer) {
        //fluorite



        //rhodonite
        ShapedRecipeBuilder.shaped(Objects.Items.itemRhodoniteSwordHandle)
                .pattern(" is")
                .pattern("isi")
                .pattern("si ")
                .define('s', Tags.Items.RODS_WOODEN)
                .define('i', Objects.Items.itemRhodoniteIngot)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("rhodonite_sword_handle"));
        ShapedRecipeBuilder.shaped(Objects.Items.itemRhodoniteSwordBlade)
                .pattern("  i")
                .pattern(" i ")
                .pattern("c  ")
                .define('c', Objects.Items.itemRhodoniteCrystalInfused)
                .define('i', Objects.Items.itemRhodoniteIngot)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("rhodonite_sword_blade"));
        ShapelessRecipeBuilder.shapeless(Objects.Items.itemRhodoniteSharpeningKit)
                .requires(Objects.Items.itemRhodoniteHeart)
                .requires(Objects.Items.itemRhodoniteCrystalInfused)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("rhodonite_sharpening_kit"));
        ShapedRecipeBuilder.shaped(Objects.Items.itemRhodoniteHeart)
                .pattern("n n")
                .pattern("ibi")
                .pattern(" i ")
                .define('n', Objects.Items.itemRhodoniteNugget)
                .define('i', Objects.Items.itemRhodoniteIngot)
                .define('b', Objects.Items.BlockItems.itemBlockRhodonite)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("rhodonite_heart"));
        ShapedRecipeBuilder.shaped(Objects.Items.itemRhodoniteCrystalInfused)
                .pattern("eie")
                .pattern("ici")
                .pattern("eie")
                .define('e', Items.ENDER_EYE)
                .define('i', Objects.Items.itemRhodoniteIngot)
                .define('c', Objects.Items.itemRhodoniteCrystal)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("rhodonite_crystal_infused"));
        ShapedRecipeBuilder.shaped(Objects.Items.itemRhodoniteCrystal)
                .pattern("iii")
                .pattern("ihi")
                .pattern("iii")
                .define('i', Objects.Items.itemRhodoniteIngot)
                .define('h', Objects.Items.itemRhodoniteHeart)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.itemRhodoniteIngot))
                .save(consumer, createRecipeSaveLoc("rhodonite_crystal"));
        ShapedRecipeBuilder.shaped(Objects.Items.Food.itemRhodoniteApple)
                .pattern("eee")
                .pattern("eae")
                .pattern("lbl")
                .define('e', Items.ENDER_PEARL)
                .define('a', Items.APPLE)
                .define('l', Tags.Items.GEMS_LAPIS)
                .define('b', Objects.Items.BlockItems.itemBlockRhodonite)
                .unlockedBy("has_rhodonite", InventoryChangeTrigger.TriggerInstance.hasItems(Objects.Items.BlockItems.itemBlockRhodonite))
                .save(consumer, createRecipeSaveLoc("rhodonite_apple"));
    }

    @Nonnull
    @Override
    public String getName() {
        return "Rhodonite: Recipe Generator";
    }

    private ResourceLocation createRecipeSaveLoc(String id) {
        return new ResourceLocation(modId, id);
    }
}
