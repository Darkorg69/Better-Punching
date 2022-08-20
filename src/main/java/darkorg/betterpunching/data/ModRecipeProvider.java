package darkorg.betterpunching.data;

import darkorg.betterpunching.tools.ModTools;
import net.minecraft.data.*;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IDataProvider {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(ModTools.FLINT_DAGGER.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern(" #").pattern("/ ").unlockedBy("has_material", has(Items.FLINT)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModTools.FLINT_PICK.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern("##").pattern("/ ").unlockedBy("has_material", has(Items.FLINT)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModTools.FLINT_SPADE.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern("#").pattern("/").unlockedBy("has_material", has(Items.FLINT)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModTools.FLINT_HATCHET.get()).define('#', Items.FLINT).define('/', Items.STICK).pattern("##").pattern("/#").unlockedBy("has_material", has(Items.FLINT)).save(pFinishedRecipeConsumer);
    }
}

