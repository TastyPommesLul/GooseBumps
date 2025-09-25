package net.tastypommeslul.goosebumps.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;

public class ModToolMaterials {

    private static ToolMaterial toolMaterial(TagKey<Block> incorrectBlocksForDrops, int durability, int speed, float attackSpeedBonus, int enchantmentValue, TagKey<Item> repaiItems) {
        return new ToolMaterial(incorrectBlocksForDrops, durability, speed, attackSpeedBonus, enchantmentValue, repaiItems);
    }
}
