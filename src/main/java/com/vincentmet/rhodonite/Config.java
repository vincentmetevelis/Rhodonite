package com.vincentmet.rhodonite;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.nio.file.Path;

@Mod.EventBusSubscriber
public class Config {
    public static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.BooleanValue HEART_CRAFTING_EXPLOSION;
    public static ForgeConfigSpec.IntValue HEART_CRAFTING_EXPLOSION_CHANCE;
    public static ForgeConfigSpec.DoubleValue HEART_CRAFTING_EXPLOSION_STRENGTH;
    public static ForgeConfigSpec.BooleanValue HEART_CRAFTING_BLOCKDAMAGE;
    public static ForgeConfigSpec.BooleanValue RHODONITE_ARMOR_FLIGHT;

    static{
        COMMON_BUILDER.push("heart");
        HEART_CRAFTING_EXPLOSION = COMMON_BUILDER.comment("Rhodonite heart explosion").define("explosion", true);
        HEART_CRAFTING_EXPLOSION_CHANCE = COMMON_BUILDER.comment("Rhodonite heart explosion chance").defineInRange("explosion_chance", 15, 0, 100);
        HEART_CRAFTING_EXPLOSION_STRENGTH = COMMON_BUILDER.comment("Rhodonite heart explosion strength").defineInRange("explosion_strength", 5D, 0D, 100D);
        HEART_CRAFTING_BLOCKDAMAGE = COMMON_BUILDER.comment("Rhodonite heart explosion block damage").define("explosion_blockdamage", true);
        COMMON_BUILDER.pop();
        COMMON_BUILDER.push("armor");
        RHODONITE_ARMOR_FLIGHT = COMMON_BUILDER.comment("Rhodonite armor flight").define("flight", true);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec spec, Path path){
        final CommentedFileConfig config = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        config.load();
        spec.setConfig(config);
    }
}