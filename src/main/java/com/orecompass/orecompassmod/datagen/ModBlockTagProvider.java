package com.orecompass.orecompassmod.datagen;

import com.orecompass.orecompassmod.OreCompassMod;
import com.orecompass.orecompassmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, OreCompassMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //here you put tags ect with tag add ect
        tag(ModTags.Blocks.IRON_COMPASS_DETECT)
                .add(Blocks.IRON_BLOCK)
                .add(Blocks.RAW_IRON_BLOCK)
                .add(Blocks.IRON_ORE)
                .add(Blocks.DEEPSLATE_IRON_ORE);

        tag(ModTags.Blocks.DIAMOND_COMPASS_DETECT)
                .add(Blocks.DIAMOND_BLOCK)
                .add(Blocks.DIAMOND_ORE)
                .add(Blocks.DEEPSLATE_DIAMOND_ORE);

        tag(ModTags.Blocks.EMERALD_COMPASS_DETECT)
                .add(Blocks.EMERALD_BLOCK)
                .add(Blocks.EMERALD_ORE)
                .add(Blocks.DEEPSLATE_EMERALD_ORE);

        tag(ModTags.Blocks.GOLD_COMPASS_DETECT)
                .add(Blocks.GOLD_BLOCK)
                .add(Blocks.GOLD_ORE)
                .add(Blocks.DEEPSLATE_GOLD_ORE)
                .add(Blocks.RAW_GOLD_BLOCK);

    }
}
