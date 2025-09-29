package net.tastypommeslul.goosebumps.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.tastypommeslul.goosebumps.Goosebumps;
import net.tastypommeslul.goosebumps.utils.SettingsUtils;

public class ModItems {
    public static final Item SPEAR = registerItem("spear", new Item(SettingsUtils.itemSettings("spear")
            .sword(ModToolMaterials.SPEAR_MATERIAL, 10 /* +1 Vanilla */, -2.8f)));
    public static final Item SPEAR_HEAD = registerItem("spear_head", new Item(SettingsUtils.itemSettings("spear_head").rarity(Rarity.UNCOMMON).maxCount(1)));


    public static void registerModItems() {
        Goosebumps.LOGGER.info("Registering Mod Items for " + Goosebumps.MOD_ID);

    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Goosebumps.MOD_ID, name), item);
    }
}
