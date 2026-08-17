package com.orecompass.orecompassmod.item.Custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class OreCompassClass extends Item {

    public OreCompassClass(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        itemStack.hurtAndBreak(1, player, hand.asEquipmentSlot());

        BlockPos pos  = player.blockPosition();
        for (int xx = - 20; xx <= 20; ++xx) {
            for (int yy = - 20; yy <= 20; ++yy) {
                for (int zz = - 20; zz <= 20; ++zz) {
                    System.out.println(xx + " " + yy + " " + zz);
                }
            }
        }

        System.out.println("Used");
        return super.use(level, player, hand);
    }
}
