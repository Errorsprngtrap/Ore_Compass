package com.orecompass.orecompassmod.item;

import com.orecompass.orecompassmod.Config;
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
                    new Vec3(30,30,30),
                    Config.IRON_COMPASS,
                    properties.durability(40).stacksTo(1).useCooldown(60)
            )
    );

    public static final DeferredItem<Item> DIAMOND_COMPASS = ITEMS.registerItem(
            "diamond_compass",
            properties -> new OreCompassClass(
                    ModTags.Blocks.DIAMOND_COMPASS_DETECT,
                    new Vec3(50,50,50),
                    Config.DIAMOND_COMPASS,
                    properties.durability(25).stacksTo(1).useCooldown(40)
            )
    );

    public static final DeferredItem<Item> GOLD_COMPASS = ITEMS.registerItem(
            "gold_compass",
            properties -> new OreCompassClass(
                    ModTags.Blocks.GOLD_COMPASS_DETECT,
                    new Vec3(60,30,60),
                    Config.GOLD_COMPASS,
                    properties.durability(15).stacksTo(1).useCooldown(25)
            )
    );

    public static final DeferredItem<Item> EMERALD_COMPASS = ITEMS.registerItem(
            "emerald_compass",
            properties -> new OreCompassClass(
                    ModTags.Blocks.EMERALD_COMPASS_DETECT,
                    new Vec3(40,50,40),
                    Config.EMERALD_COMPASS,
                    properties.durability(15).stacksTo(1).useCooldown(40)
            )
    );
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
