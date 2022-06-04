package com.vincentmet.rhodonite;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class ItemHeartOfRhodonite extends Item {
    public ItemHeartOfRhodonite(Properties properties) {
        super(properties);
    }

    @Override
    public void onCraftedBy(ItemStack itemstack, World world, PlayerEntity entity) {
        if(Config.HEART_CRAFTING_EXPLOSION.get()){
            if(new Random().nextInt(100) <= Config.HEART_CRAFTING_EXPLOSION_CHANCE.get()){
                float var4 = 1.0F;
                int i = (int) (entity.xOld + (entity.getX() - entity.xOld) * var4);
                int j = (int) (entity.yOld + (entity.getY() - entity.yOld) * var4 + 1.62D);
                int k = (int) (entity.zOld + (entity.getZ() - entity.zOld) * var4);

                if(Config.HEART_CRAFTING_BLOCKDAMAGE.get()){
                    Explosion explosion = new Explosion(world, entity, i, j, k, Config.HEART_CRAFTING_EXPLOSION_STRENGTH.get().floatValue(), false, Explosion.Mode.BREAK);
                    explosion.explode();
                    explosion.finalizeExplosion(false);
                }else{
                    world.explode(null, i, j, k, Config.HEART_CRAFTING_EXPLOSION_STRENGTH.get().floatValue(), false, Explosion.Mode.NONE);
                }
            }
        }
    }
}