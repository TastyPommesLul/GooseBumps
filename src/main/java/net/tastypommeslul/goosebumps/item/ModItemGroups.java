package net.tastypommeslul.goosebumps.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tastypommeslul.goosebumps.Goosebumps;

public class ModItemGroups {
    public static final ItemGroup GOOSEBUMPS_ITEMGROUP =
            Registry.register(Registries.ITEM_GROUP, Identifier.of(Goosebumps.MOD_ID, "goosebumps_itemgroup"),
                    FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.goosebumps.goosebumps_itemgroup"))
                            .icon(() -> new ItemStack(ModItems.SPEAR))
                            .entries((displayContext, entries) -> {
                                entries.add(ModItems.SPEAR);
                            })
                            .build());
//    public static final ItemGroup GOOSEBUMPS_BLOCK_ITEMGROUP =
//            Registry.register(Registries.ITEM_GROUP, Identifier.of(Goosebumps.MOD_ID, "goosebumps_block_itemgroup"),
//                    FabricItemGroup.builder()
//                            .displayName(Text.translatable("itemGroup.goosebumps.goosebumps_block_itemgroup"))
//                            .icon()
//                            .entries((displayContext, entries) -> {
//
//                            })
//                            .build());

    public static void registerModItemGroups() {
        Goosebumps.LOGGER.info("Registering Mod Item Groups for " + Goosebumps.MOD_ID);
    }
}
