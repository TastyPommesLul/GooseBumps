package net.tastypommeslul.goosebumps.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.tastypommeslul.goosebumps.Goosebumps;
import net.tastypommeslul.goosebumps.entity.custom.AmongUs;

public class ModEntities {
    private static final Identifier AMONG_US_ID = Identifier.of(Goosebumps.MOD_ID, "among_us");
    private static final RegistryKey<EntityType<?>> AMONG_US_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, AMONG_US_ID);
    public static final EntityType<AmongUs> AMONG_US = EntityType.Builder.create(AmongUs::new, SpawnGroup.CREATURE).dimensions(1f, 1.5f).build(AMONG_US_KEY);


    public static void registerEntities() {
        Goosebumps.LOGGER.info("Registering ModEntities for " + Goosebumps.MOD_ID);
        Registry.register(Registries.ENTITY_TYPE, AMONG_US_KEY, AMONG_US);
    }
}
