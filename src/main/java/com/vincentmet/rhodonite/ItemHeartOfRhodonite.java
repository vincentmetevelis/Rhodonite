package com.vincentmet.rhodonite;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemHeartOfRhodonite extends Item {
    public ItemHeartOfRhodonite(Item.Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        if (Config.HEART_CRAFTING_EXPLOSION.getAsBoolean()) {
            RandomSource random = level.getRandom();
            if (random.nextInt(100) <= Config.HEART_CRAFTING_EXPLOSION_CHANCE.getAsInt()) {
                float var4 = 1.0F;
                int i = (int) (player.xOld + (player.position().x - player.xOld) * var4);
                int j = (int) (player.yOld + (player.position().y - player.yOld) * var4 + 1.62D);
                int k = (int) (player.zOld + (player.position().z - player.zOld) * var4);

                if (Config.HEART_CRAFTING_BLOCKDAMAGE.getAsBoolean()) {
                    level.explode(player, i, j, k, Config.HEART_CRAFTING_EXPLOSION_STRENGTH.get().floatValue(), Level.ExplosionInteraction.BLOCK);
                } else {
                    level.explode(player, i, j, k, Config.HEART_CRAFTING_EXPLOSION_STRENGTH.get().floatValue(), Level.ExplosionInteraction.NONE);
                }
            }
        }
    }
}
