package com.orecompass.orecompassmod.item;

import com.orecompass.orecompassmod.OreCompassMod;
import com.orecompass.orecompassmod.item.Custom.OreCompassClass;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OreCompassMod.MOD_ID);


    public static final DeferredItem<Item> IRON_COMPASS = ITEMS.registerItem(
            "iron_compass",
            properties -> new OreCompassClass(
                    properties.durability(10)
            )
    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
