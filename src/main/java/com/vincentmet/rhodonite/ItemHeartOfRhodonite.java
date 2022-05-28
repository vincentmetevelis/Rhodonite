package com.vincentmet.rhodonite;

import com.vincentmet.rhodonite.Config;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

import java.util.Random;

public class ItemHeartOfRhodonite extends Item {
    public ItemHeartOfRhodonite(Item.Properties properties) {
        super(properties);
    }
    
    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        if(Config.HEART_CRAFTING_EXPLOSION.get()){
            if(new Random().nextInt(100) <= Config.HEART_CRAFTING_EXPLOSION_CHANCE.get()){
                float var4 = 1.0F;
                int i = (int) (player.xOld + (player.position().x - player.xOld) * var4);
                int j = (int) (player.yOld + (player.position().y - player.yOld) * var4 + 1.62D);
                int k = (int) (player.zOld + (player.position().z - player.zOld) * var4);

                if(Config.HEART_CRAFTING_BLOCKDAMAGE.get()){
                    Explosion explosion = new Explosion(level, player, i, j, k, Config.HEART_CRAFTING_EXPLOSION_STRENGTH.get().floatValue(), false, Explosion.BlockInteraction.BREAK);
                    explosion.explode();
                    explosion.finalizeExplosion(false);
                }else{
                    level.explode(null, i, j, k, Config.HEART_CRAFTING_EXPLOSION_STRENGTH.get().floatValue(), false, Explosion.BlockInteraction.NONE);
                }
            }
        }
    }
}