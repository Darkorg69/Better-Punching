package darkorg.betterpunching.data;

import darkorg.betterpunching.BetterPunching;
import darkorg.betterpunching.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    private final ModelFile handheld = getExistingFile(mcLoc(ITEM_FOLDER + "/handheld"));

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BetterPunching.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemHandheld(ModItems.FLINT_DAGGER);
        itemHandheld(ModItems.FLINT_HATCHET);
        itemHandheld(ModItems.FLINT_PICK);
        itemHandheld(ModItems.FLINT_SPADE);
    }

    private void itemHandheld(RegistryObject<Item> pRegistryObject) {
        buildItemHandheld(pRegistryObject.get());
    }

    private void buildItemHandheld(Item pItem) {
        buildItemModel(pItem.toString(), handheld);
    }

    private void buildItemModel(String pName, ModelFile pModel) {
        getBuilder(pName).parent(pModel).texture("layer0", ITEM_FOLDER + "/" + pName);
    }
}
