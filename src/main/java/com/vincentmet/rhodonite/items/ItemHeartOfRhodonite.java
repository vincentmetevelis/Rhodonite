package com.vincentmet.rhodonite.items;

import com.vincentmet.rhodonite.*;
import java.util.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.*;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class ItemHeartOfRhodonite extends DefaultItem {
    public ItemHeartOfRhodonite(ResourceLocation resourceLocation, int stacksize, ItemGroup tab) {
        super(resourceLocation, stacksize, tab);
    }


    @Override
    public void onCreated(ItemStack itemstack, World world, PlayerEntity entity) {
        if(Config.HEART_CRAFTING_EXPLOSION.get()){
            if(new Random().nextInt(100) <= Config.HEART_CRAFTING_EXPLOSION_CHANCE.get()){
                float var4 = 1.0F;
                int i = (int) (entity.prevPosX + (entity.getPosX() - entity.prevPosX) * var4);
                int j = (int) (entity.prevPosY + (entity.getPosY() - entity.prevPosY) * var4 + 1.62D);
                int k = (int) (entity.prevPosZ + (entity.getPosZ() - entity.prevPosZ) * var4);

                if(Config.HEART_CRAFTING_BLOCKDAMAGE.get()){
                    Explosion explosion = new Explosion(world, entity, i, j, k, Config.HEART_CRAFTING_EXPLOSION_STRENGTH.get().floatValue(), false, Explosion.Mode.BREAK);
                    explosion.doExplosionA();
                    explosion.doExplosionB(false);
                }else{
                    world.createExplosion(null, i, j, k, Config.HEART_CRAFTING_EXPLOSION_STRENGTH.get().floatValue(), false, Explosion.Mode.NONE);
                }
            }
        }
    }
}