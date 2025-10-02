package net.tastypommeslul.goosebumps.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.tastypommeslul.goosebumps.Goosebumps;
import net.tastypommeslul.goosebumps.item.custom.SpearItem;
import net.tastypommeslul.goosebumps.utils.SettingsUtils;

public class ModItems {
    public static final Item SPEAR = registerItem("spear",
            new SpearItem(SettingsUtils.itemSettings("spear").rarity(Rarity.UNCOMMON)));
    public static final Item SPEAR_HEAD = registerItem("spear_head",
            new Item(SettingsUtils.itemSettings("spear_head").maxCount(1)));


    public static void registerModItems() {
        Goosebumps.LOGGER.info("Registering Mod Items for " + Goosebumps.MOD_ID);

    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Goosebumps.MOD_ID, name), item);
    }


}
