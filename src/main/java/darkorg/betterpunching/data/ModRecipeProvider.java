package darkorg.betterpunching.data;

import darkorg.betterpunching.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(ModItems.FLINT_DAGGER.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern(" #").pattern("/ ").unlockedBy("has_flint", has(Items.FLINT)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.FLINT_PICK.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern("##").pattern("/ ").unlockedBy("has_flint", has(Items.FLINT)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.FLINT_SPADE.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern("#").pattern("/").unlockedBy("has_flint", has(Items.FLINT)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.FLINT_HATCHET.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern("##").pattern("/#").unlockedBy("has_flint", has(Items.FLINT)).save(pFinishedRecipeConsumer);
    }
}

