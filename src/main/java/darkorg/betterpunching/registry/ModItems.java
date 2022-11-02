package darkorg.betterpunching.registry;

import darkorg.betterpunching.BetterPunching;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterPunching.MOD_ID);

    public static final RegistryObject<Item> FLINT_DAGGER = ITEMS.register("flint_dagger", () -> new SwordItem(ModItemTier.FLINT, 1, -0.8F, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> FLINT_SPADE = ITEMS.register("flint_spade", () -> new ShovelItem(ModItemTier.FLINT, 1.5F, -3.0F, (new Item.Properties()).tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> FLINT_PICK = ITEMS.register("flint_pick", () -> new PickaxeItem(ModItemTier.FLINT, 1, -2.8F, (new Item.Properties()).tab(ItemGroup.TAB_TOOLS)));
    public static final RegistryObject<Item> FLINT_HATCHET = ITEMS.register("flint_hatchet", () -> new AxeItem(ModItemTier.FLINT, 2.5F, -3.2F, (new Item.Properties()).tab(ItemGroup.TAB_TOOLS)));

    public static void init(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
