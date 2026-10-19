package com.orecompass.orecompassmod.datagen;

import com.orecompass.orecompassmod.OreCompassMod;
import com.orecompass.orecompassmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, OreCompassMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //do add tag do teh same as block so tag .add ect
        tag(ModTags.Items.RUBY_ITEM)
                .add(TagEntry.optionalElement(Identifier.fromNamespaceAndPath("rubymod","ruby")));
    }
}
