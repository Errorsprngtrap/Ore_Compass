package com.orecompass.orecompassmod.item;

import com.orecompass.orecompassmod.OreCompassMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OreCompassMod.MOD_ID);


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
