package com.orecompass.orecompassmod.item.Custom;

import com.orecompass.orecompassmod.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.LodestoneTracker;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class OreCompassClass extends Item {

    public OreCompassClass(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide()){
            return InteractionResult.SUCCESS;
        }

        ItemStack itemStack = player.getItemInHand(hand);
        LodestoneTracker tracker = (LodestoneTracker)itemStack.get(DataComponents.LODESTONE_TRACKER);
        itemStack.hurtAndBreak(1, player, hand.asEquipmentSlot());

        BlockPos pos  = player.blockPosition();
        for (int xx = - 20; xx <= 20; ++xx) {
            for (int yy = - 20; yy <= 20; ++yy) {
                for (int zz = - 20; zz <= 20; ++zz) {
                    System.out.println(xx + " " + yy + " " + zz);
                    BlockPos blockPos = pos.offset(xx, yy, zz);
                    BlockState blockstate = level.getBlockState(blockPos);
                    if (blockstate.is(ModTags.Blocks.IRON_COMPASS_DETECT)) {
                        System.out.println("block found");
                        LodestoneTracker target = new LodestoneTracker(Optional.of(GlobalPos.of(level.dimension(), blockPos)), true);
                        itemStack.set(DataComponents.LODESTONE_TRACKER, target);
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }

        System.out.println("Used");
        return InteractionResult.FAIL;
    }
}
