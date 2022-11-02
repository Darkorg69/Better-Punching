package darkorg.betterpunching.data;

import darkorg.betterpunching.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, String modId, ExistingFileHelper existingFileHelper) {
        super(generator, modId, existingFileHelper);
    }

    ModelFile itemHandheld = getExistingFile(mcLoc("item/handheld"));

    @Override
    protected void registerModels() {
        buildHandheldModel(ModItems.FLINT_DAGGER.get().toString(), ModItems.FLINT_DAGGER.get().toString());
        buildHandheldModel(ModItems.FLINT_HATCHET.get().toString(), ModItems.FLINT_HATCHET.get().toString());
        buildHandheldModel(ModItems.FLINT_PICK.get().toString(), ModItems.FLINT_PICK.get().toString());
        buildHandheldModel(ModItems.FLINT_SPADE.get().toString(), ModItems.FLINT_SPADE.get().toString());
    }

    private void buildHandheldModel(String itemName, String textureLocation) {
        buildItemModel(itemName, itemHandheld, textureLocation);
    }

    private void buildItemModel(String itemName, ModelFile modelFile, String textureLocation) {
        getBuilder(itemName).parent(modelFile).texture("layer0", "item/" + textureLocation);
    }
}
