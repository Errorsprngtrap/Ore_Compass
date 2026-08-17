package com.orecompass.orecompassmod.item.Custom;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.LodestoneTracker;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class OreCompassClass extends Item {

    private final TagKey<Block> tagBlockList;
    private final Vec3 vecList;

    public OreCompassClass(TagKey<Block> tagBlockList,Vec3 vecList, Properties properties) {
        super(properties);

        this.tagBlockList = tagBlockList;
        this.vecList = vecList;
    }


    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide()){
            return InteractionResult.SUCCESS;
        }

        ItemStack itemStack = player.getItemInHand(hand);
        itemStack.hurtAndBreak(1, player, hand.asEquipmentSlot());

        BlockPos pos  = player.blockPosition();
        BlockPos currentClosestPos = null;

        for (int xx = - (int) vecList.x; xx <= (int) vecList.x; ++xx) {
            for (int yy = - (int) vecList.y; yy <= (int) vecList.y; ++yy) {
                for (int zz = - (int) vecList.z; zz <= (int) vecList.z; ++zz) {

                    BlockPos blockPos = pos.offset(xx, yy, zz);
                    BlockState blockstate = level.getBlockState(blockPos);

                    if (blockstate.is(tagBlockList)) {
                        if (currentClosestPos == null) {
                            currentClosestPos = blockPos;
                        } else {
                            double dist = pos.distSqr(blockPos);
                            if (pos.distSqr(currentClosestPos) > dist) {
                                currentClosestPos = blockPos;
                            }
                        }
                    }

                }
            }
        }

        if (currentClosestPos != null) {
            LodestoneTracker target = new LodestoneTracker(Optional.of(GlobalPos.of(level.dimension(), currentClosestPos)), true);
            itemStack.set(DataComponents.LODESTONE_TRACKER, target);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }


    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        LodestoneTracker target = itemStack.get(DataComponents.LODESTONE_TRACKER);
        if (target != null && target.target().isPresent()) {
            BlockPos pos = target.target().get().pos();
            builder.accept(Component.translatable("ore_compass_y", pos.getY()));
        }
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}
