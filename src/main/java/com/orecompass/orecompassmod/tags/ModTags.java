package com.orecompass.orecompassmod.tags;

import com.orecompass.orecompassmod.OreCompassMod;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class  Items{
        //create tag example just below
        //public static final TagKey<Item> IRON_COMPASS_DETECT = createTag("iron_compass_detect");


        //that shit create the tags
        private static TagKey<Item> createTag(String name){
            return ItemTags.create(Identifier.fromNamespaceAndPath(OreCompassMod.MOD_ID,name));
        }
    }

    public static class  Blocks{
        //create tag example just below
        public static final TagKey<Block> IRON_COMPASS_DETECT = createTag("iron_compass_detect");


        //that shit create the tags
        private static TagKey<Block> createTag(String name){
            return BlockTags.create(Identifier.fromNamespaceAndPath(OreCompassMod.MOD_ID,name));
        }
    }
}