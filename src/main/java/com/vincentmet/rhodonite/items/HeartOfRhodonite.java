package com.vincentmet.rhodonite.items;

import com.vincentmet.rhodonite.DefaultItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class HeartOfRhodonite extends DefaultItem {
    public HeartOfRhodonite(ResourceLocation resourceLocation, int stacksize, ItemGroup tab) {
        super(resourceLocation, stacksize, tab);
    }


    @Override
    public void onCreated(ItemStack itemstack, World world, PlayerEntity entity) {
        if(true/*ConfigHandler.heart_crafting_explosion*/){
            if(new Random().nextInt(100) <= 15/*ConfigHandler.heart_explosion_chance*/){
                float var4 = 1.0F;
                int i = (int) (entity.prevPosX + (entity.posX - entity.prevPosX) * var4);
                int j = (int) (entity.prevPosY + (entity.posY - entity.prevPosY) * var4 + 1.62D);
                int k = (int) (entity.prevPosZ + (entity.posZ - entity.prevPosZ) * var4);

                if(true/*ConfigHandler.heart_crafting_blockdamage*/){
                    Explosion explosion = new Explosion(world, entity, i, j, k, 5F/*ConfigHandler.heart_crafting_explosion_strength*/, false, Explosion.Mode.BREAK);
                    explosion.doExplosionA();
                    explosion.doExplosionB(false);
                }else{
                    world.createExplosion(null, i, j, k, 5F/*ConfigHandler.heart_crafting_explosion_strength*/, false, Explosion.Mode.NONE);
                }
            }
        }
    }
}