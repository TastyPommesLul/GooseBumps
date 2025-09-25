package net.tastypommeslul.goosebumps.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.tastypommeslul.goosebumps.datagen.*;

public class GoosebumpsDataGenerator implements DataGeneratorEntrypoint {


    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider((ModBlockTagProvider.Factory) output -> new ModBlockTagProvider(((FabricDataOutput) output), fabricDataGenerator.getRegistries()));
        pack.addProvider((ModLootTableProvider.Factory) output -> new ModLootTableProvider(((FabricDataOutput) output), fabricDataGenerator.getRegistries()));
        pack.addProvider((ModRecipeProvider.Factory) output -> new ModRecipeProvider(((FabricDataOutput) output), fabricDataGenerator.getRegistries()));
        pack.addProvider((ModItemTagProvider.Factory) output -> new ModItemTagProvider(((FabricDataOutput) output), fabricDataGenerator.getRegistries()));
        pack.addProvider((ModModelProvider.Factory) output -> new ModModelProvider(((FabricDataOutput) output)));
    }
}
