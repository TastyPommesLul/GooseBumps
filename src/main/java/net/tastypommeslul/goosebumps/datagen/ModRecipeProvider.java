package net.tastypommeslul.goosebumps.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.tastypommeslul.goosebumps.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                ShapedRecipeJsonBuilder.create(Registries.ITEM, RecipeCategory.COMBAT, ModItems.SPEAR)
                        .pattern("  H")
                        .pattern(" S ")
                        .pattern("   ")
                        .input('H', ModItems.SPEAR_HEAD)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.SPEAR_HEAD), conditionsFromItem(ModItems.SPEAR_HEAD))
                        .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(Registries.ITEM, RecipeCategory.COMBAT, ModItems.SPEAR_HEAD)
                        .pattern(" NN")
                        .pattern("  N")
                        .pattern("   ")
                        .input('N', Items.IRON_NUGGET)
                        .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
