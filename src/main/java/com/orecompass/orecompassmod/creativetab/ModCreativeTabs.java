package com.orecompass.orecompassmod.creativetab;

import com.orecompass.orecompassmod.OreCompassMod;
import com.orecompass.orecompassmod.block.ModBlocks;
import com.orecompass.orecompassmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OreCompassMod.MOD_ID);


    public static final Supplier<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TABS.register("test_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.ROTTEN_FLESH))
                    .title(Component.translatable("creativetabs.templatemod.test_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.IRON_COMPASS);
                        output.accept(ModItems.DIAMOND_COMPASS);
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
