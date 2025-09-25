package net.tastypommeslul.goosebumps.block;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tastypommeslul.goosebumps.Goosebumps;
import net.tastypommeslul.goosebumps.utils.SettingsUtils;

public class ModBlocks {




    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Goosebumps.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Goosebumps.MOD_ID, name), new BlockItem(block, SettingsUtils.itemSettings(name)));
    }
}
