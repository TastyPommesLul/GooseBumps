package net.tastypommeslul.goosebumps;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.tastypommeslul.goosebumps.block.ModBlocks;
import net.tastypommeslul.goosebumps.entity.ModEntities;
import net.tastypommeslul.goosebumps.entity.custom.AmongUs;
import net.tastypommeslul.goosebumps.item.ModItemGroups;
import net.tastypommeslul.goosebumps.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Goosebumps implements ModInitializer {
    public static final String MOD_ID = "goosebumps";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerModItemGroups();
        ModEntities.registerEntities();


        FabricDefaultAttributeRegistry.register(ModEntities.AMONG_US, AmongUs.createAttributes());

        LOGGER.info("Successfully Started Goosebumps Mod!");
    }
}
