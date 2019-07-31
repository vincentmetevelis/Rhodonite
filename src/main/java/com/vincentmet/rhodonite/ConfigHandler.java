package com.vincentmet.rhodonite;

public class ConfigHandler {
    /*public static boolean heart_crafting_explosion = true;
    public static float heart_crafting_explosion_strength = 5F;
    public static boolean heart_crafting_blockdamage = true;
    public static boolean armor_flight = true;
    public static int heart_explosion_chance = 15;

    public static void readCfg(){
        Configuration cfg = ClientProxy.cfg;
        try{
            cfg.load();
            initCfg(cfg);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cfg.hasChanged()){
                cfg.save();
            }
        }
    }
    private static void initCfg(Configuration cfg){
        heart_crafting_explosion = cfg.getBoolean("Heart explosion enabled", "enabling", heart_crafting_explosion, "");
        heart_crafting_explosion_strength = cfg.getFloat("Heart explosion size", "values", heart_crafting_explosion_strength, 1F, 100F, "");
        heart_crafting_blockdamage = cfg.getBoolean("Block damage for Rhodonite Heart crafting enabled", "enabling", heart_crafting_blockdamage, "");
        armor_flight = cfg.getBoolean("Armor Flight Enabled", "enabling", armor_flight, "");
        heart_explosion_chance = cfg.getInt("Explosion chance on crafting", "values", heart_explosion_chance, 0, 100, "");
    }*/
}