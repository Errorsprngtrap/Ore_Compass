package com.orecompass.orecompassmod.datagen;

import com.orecompass.orecompassmod.OreCompassMod;
import com.orecompass.orecompassmod.block.ModBlocks;
import com.orecompass.orecompassmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProviders extends ModelProvider {

    public ModModelProviders(PackOutput output) {
        super(output, OreCompassMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        //items
        //itemModels.generateFlatItem(ModItems.IRON_COMPASS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateStandardCompassItem(ModItems.IRON_COMPASS.get());
        itemModels.generateStandardCompassItem(ModItems.DIAMOND_COMPASS.get());
        //blocks
    }
}
