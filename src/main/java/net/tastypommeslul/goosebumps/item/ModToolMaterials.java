package net.tastypommeslul.goosebumps.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.tastypommeslul.goosebumps.utils.SettingsUtils;

public class ModToolMaterials {
    public static final ToolMaterial SPEAR_MATERIAL = toolMaterial(null, 100, 10, 1f, 10, ItemTags.IRON_TOOL_MATERIALS);

    private static ToolMaterial toolMaterial(TagKey<Block> incorrectBlocksForDrops, int durability, int speed, float attackSpeedBonus, int enchantmentValue, TagKey<Item> repaiItems) {
        return new ToolMaterial(incorrectBlocksForDrops, durability, speed, attackSpeedBonus, enchantmentValue, repaiItems);
    }
}
