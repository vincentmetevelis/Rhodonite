package com.vincentmet.rhodonite;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue HEART_CRAFTING_EXPLOSION;
    public static final ModConfigSpec.IntValue HEART_CRAFTING_EXPLOSION_CHANCE;
    public static final ModConfigSpec.DoubleValue HEART_CRAFTING_EXPLOSION_STRENGTH;
    public static final ModConfigSpec.BooleanValue HEART_CRAFTING_BLOCKDAMAGE;
    public static final ModConfigSpec.BooleanValue RHODONITE_ARMOR_FLIGHT;

    static final ModConfigSpec SPEC;

    static {
        BUILDER.push("heart");
        HEART_CRAFTING_EXPLOSION = BUILDER.comment("Rhodonite heart explosion").define("explosion", true);
        HEART_CRAFTING_EXPLOSION_CHANCE = BUILDER.comment("Rhodonite heart explosion chance").defineInRange("explosion_chance", 15, 0, 100);
        HEART_CRAFTING_EXPLOSION_STRENGTH = BUILDER.comment("Rhodonite heart explosion strength").defineInRange("explosion_strength", 5D, 0D, 100D);
        HEART_CRAFTING_BLOCKDAMAGE = BUILDER.comment("Rhodonite heart explosion block damage").define("explosion_blockdamage", true);
        BUILDER.pop();
        BUILDER.push("armor");
        RHODONITE_ARMOR_FLIGHT = BUILDER.comment("Rhodonite armor flight").define("flight", true);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    private Config() {
    }
}
