package net.tastypommeslul.goosebumps.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tastypommeslul.goosebumps.Goosebumps;

public class ModItems {





    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Goosebumps.MOD_ID, name), item);
    }
}
