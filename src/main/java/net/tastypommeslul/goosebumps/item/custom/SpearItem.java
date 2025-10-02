package net.tastypommeslul.goosebumps.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.tastypommeslul.goosebumps.item.ModToolMaterials;

import java.util.List;

public class SpearItem extends Item {
    private static final float attackSpeed = -3.5f;
    private static final float attackDamage = 12;
    private static final double extraRange = 1.5d;
    private static final String attackDamageText = "" + (SpearItem.attackDamage + 2);
    private static final String attackSpeedText = "" + (4 + SpearItem.attackSpeed);
    public SpearItem(Settings settings) {
        super(applySwordSettings(settings).maxDamage(ModToolMaterials.SPEAR_MATERIAL.durability()));
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!(attacker instanceof PlayerEntity player))
            return;

        if (!player.isCreative()) {
            stack.setDamage(stack.getDamage());
        }
    }

    public static Item.Settings applySwordSettings(Item.Settings settings) {
        RegistryEntryLookup<Block> registryEntryLookup = Registries.createEntryLookup(Registries.BLOCK);
        return settings
                .component(
                        DataComponentTypes.TOOL,
                        new ToolComponent(
                                List.of(
                                        ToolComponent.Rule.ofAlwaysDropping(RegistryEntryList.of(Blocks.COBWEB.getRegistryEntry()), 15.0F),
                                        ToolComponent.Rule.of(registryEntryLookup.getOrThrow(BlockTags.SWORD_INSTANTLY_MINES), Float.MAX_VALUE),
                                        ToolComponent.Rule.of(registryEntryLookup.getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5F)
                                ),
                                1.0F,
                                2,
                                false
                        )
                )
                .attributeModifiers(createSwordAttributeModifiers())
                .component(DataComponentTypes.WEAPON, new WeaponComponent(1));
    }
    private static AttributeModifiersComponent createSwordAttributeModifiers() {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.ATTACK_DAMAGE,
                        new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID, SpearItem.attackDamage + ModToolMaterials.SPEAR_MATERIAL.attackDamageBonus(), EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND,
                        new AttributeModifiersComponent.Display.Override(
                                Text.translatable("tooltip.goosebumps.spear.damage", attackDamageText.replace(".0", ""))
                                        .formatted(Formatting.DARK_GREEN))
                )
                .add(
                        EntityAttributes.ATTACK_SPEED,
                        new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID, SpearItem.attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND,
                        new AttributeModifiersComponent.Display.Override(
                                Text.translatable("tooltip.goosebumps.spear.speed", attackSpeedText.replace(".0", ""))
                                        .formatted(Formatting.DARK_GREEN))
                )
                .add(EntityAttributes.ENTITY_INTERACTION_RANGE,
                        new EntityAttributeModifier(Identifier.of("minecraft", "generic.attack_range"),
                                extraRange, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND,
                        new AttributeModifiersComponent.Display.Override(
                                Text.translatable("tooltip.goosebumps.spear.range", extraRange)
                                        .formatted(Formatting.DARK_GREEN))
                )
                .build();
    }
}
