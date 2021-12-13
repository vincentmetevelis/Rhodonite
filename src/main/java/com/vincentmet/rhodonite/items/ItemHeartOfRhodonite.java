package com.vincentmet.rhodonite.items;

import com.vincentmet.rhodonite.*;
import java.util.Random;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

import javax.annotation.Nonnull;

public class ItemHeartOfRhodonite extends DefaultItem {
    public ItemHeartOfRhodonite(ResourceLocation resourceLocation, int stacksize, CreativeModeTab tab) {
        super(resourceLocation, stacksize, tab);
    }
    
    @Override
    public void onCraftedBy(@Nonnull ItemStack itemstack, @Nonnull Level world, @Nonnull Player entity) {
        if(Config.HEART_CRAFTING_EXPLOSION.get()){
            if(new Random().nextInt(100) <= Config.HEART_CRAFTING_EXPLOSION_CHANCE.get()){
                float var4 = 1.0F;
                int i = (int) (entity.xOld + (entity.position().x - entity.xOld) * var4);
                int j = (int) (entity.yOld + (entity.position().y - entity.yOld) * var4 + 1.62D);
                int k = (int) (entity.zOld + (entity.position().z - entity.zOld) * var4);

                if(Config.HEART_CRAFTING_BLOCKDAMAGE.get()){
                    Explosion explosion = new Explosion(world, entity, i, j, k, Config.HEART_CRAFTING_EXPLOSION_STRENGTH.get().floatValue(), false, Explosion.BlockInteraction.BREAK);
                    explosion.explode();
                    explosion.finalizeExplosion(false);
                }else{
                    world.explode(null, i, j, k, Config.HEART_CRAFTING_EXPLOSION_STRENGTH.get().floatValue(), false, Explosion.BlockInteraction.NONE);
                }
            }
        }
    }
}