package com.orecompass.orecompassmod.item;

import com.orecompass.orecompassmod.OreCompassMod;
import com.orecompass.orecompassmod.item.Custom.OreCompassClass;
import com.orecompass.orecompassmod.tags.ModTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OreCompassMod.MOD_ID);


    public static final DeferredItem<Item> IRON_COMPASS = ITEMS.registerItem(
            "iron_compass",
            properties -> new OreCompassClass(
                    ModTags.Blocks.IRON_COMPASS_DETECT,
                    new Vec3(20,20,20),
                    properties.durability(10).stacksTo(1).useCooldown(10)
            )
    );

    public static final DeferredItem<Item> DIAMOND_COMPASS = ITEMS.registerItem(
            "diamond_compass",
            properties -> new OreCompassClass(
                    ModTags.Blocks.DIAMOND_COMPASS_DETECT,
                    new Vec3(20,20,20),
                    properties.durability(10).stacksTo(1).useCooldown(10)
            )
    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
