package com.orecompass.orecompassmod;

import java.util.List;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.DoubleValue IRON_COMPASS = BUILDER
            .comment("Multiplier for the iron compass range")
            .defineInRange("Iron Compass Range", 1.0D, 0.0, 3.0);

    public static final ModConfigSpec.DoubleValue GOLD_COMPASS = BUILDER
            .comment("Multiplier for the gold compass range")
            .defineInRange("Gold Compass Range", 1.0D, 0.0, 3.0);

    public static final ModConfigSpec.DoubleValue EMERALD_COMPASS = BUILDER
            .comment("Multiplier for the emerald compass range")
            .defineInRange("Emerald Compass Range", 1.0D, 0.0, 3.0);

    public static final ModConfigSpec.DoubleValue DIAMOND_COMPASS = BUILDER
            .comment("Multiplier for the diamond compass range")
            .defineInRange("Diamond Compass Range", 1.0D, 0.0, 3.0);


    static final ModConfigSpec SPEC = BUILDER.build();

    private static boolean validateItemName(final Object obj) {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(Identifier.parse(itemName));
    }
}
