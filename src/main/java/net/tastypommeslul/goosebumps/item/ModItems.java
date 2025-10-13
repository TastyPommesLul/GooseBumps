package net.tastypommeslul.goosebumps.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DeathProtectionComponent;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.tastypommeslul.goosebumps.Goosebumps;
import net.tastypommeslul.goosebumps.item.custom.SpearItem;
import net.tastypommeslul.goosebumps.item.custom.ThresherItem;
import net.tastypommeslul.goosebumps.sounds.ModSounds;
import net.tastypommeslul.goosebumps.utils.SettingsUtils;
import net.tastypommeslul.goosebumps.utils.Ticks;

import java.util.List;
import java.util.function.Consumer;

public class ModItems {
    public static final Item SPEAR = registerItem("spear",
            new SpearItem(SettingsUtils.itemSettings("spear").rarity(Rarity.UNCOMMON)));
    public static final Item SPEAR_HEAD = registerItem("spear_head",
            new Item(SettingsUtils.itemSettings("spear_head").maxCount(1)));
    public static final Item THRESHER = registerItem("thresher",
            new ThresherItem(SettingsUtils.itemSettings("thresher").maxCount(1)));
    public static final Item DUCK = registerItem("duck", new Item(SettingsUtils.itemSettings("duck")
            .component(DataComponentTypes.EQUIPPABLE, EquippableComponent.builder(EquipmentSlot.HEAD).build())
            .component(DataComponentTypes.DEATH_PROTECTION, new DeathProtectionComponent(List.of(
                    new ApplyEffectsConsumeEffect(List.of(
                            new StatusEffectInstance(StatusEffects.ABSORPTION, Ticks.fromSeconds(30), 0, false, false, true),
                            new StatusEffectInstance(StatusEffects.RESISTANCE, Ticks.fromSeconds(10), 0, false, false, true),
                            new StatusEffectInstance(StatusEffects.SLOW_FALLING, Ticks.fromSeconds(10), 0, false, false, true),
                            new StatusEffectInstance(StatusEffects.SPEED, Ticks.fromSeconds(15), 1, false, false, true),
                            new StatusEffectInstance(StatusEffects.WATER_BREATHING, Ticks.fromSeconds(10), 0, false, false, true),
                            new StatusEffectInstance(StatusEffects.NIGHT_VISION, Ticks.fromMinutes(5), 0, false, false, true),
                            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, Ticks.fromMinutes(1), 0, false, false, true)
                    ))
            )))
            .useCooldown(0.6f)
            .maxCount(1)) {
        @Override
        public ActionResult use(World world, PlayerEntity user, Hand hand) {
            world.playSound(user, user.getX(), user.getY(), user.getZ(), ModSounds.QUACK, SoundCategory.AMBIENT);
            return ActionResult.CONSUME;
        }

        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("tooltip.goosebumps.duck.tip"));
        }
    });


    public static void registerModItems() {
        Goosebumps.LOGGER.info("Registering Mod Items for " + Goosebumps.MOD_ID);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Goosebumps.MOD_ID, name), item);
    }
}
