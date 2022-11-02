package darkorg.betterpunching.data;

import darkorg.betterpunching.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(ModItems.FLINT_DAGGER.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern(" #").pattern("/ ").unlockedBy("has_flint", has(Items.FLINT)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.FLINT_PICK.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern("##").pattern("/ ").unlockedBy("has_flint", has(Items.FLINT)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.FLINT_SPADE.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern("#").pattern("/").unlockedBy("has_flint", has(Items.FLINT)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.FLINT_HATCHET.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern("##").pattern("/#").unlockedBy("has_flint", has(Items.FLINT)).save(pFinishedRecipeConsumer);
    }
}

