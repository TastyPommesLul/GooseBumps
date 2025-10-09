package net.tastypommeslul.goosebumps.utils;

import net.minecraft.block.AbstractBlock;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.tastypommeslul.goosebumps.Goosebumps;

public class SettingsUtils {
    public static AbstractBlock.Settings blockSettings(String identifier) {

        return AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Goosebumps.MOD_ID, identifier)));
    }

    public static Item.Settings itemSettings(String identifier) {
        return new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Goosebumps.MOD_ID, identifier)));
    }
}
