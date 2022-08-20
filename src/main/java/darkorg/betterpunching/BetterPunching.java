package darkorg.betterpunching;

import darkorg.betterpunching.setup.ConfigHandler;
import darkorg.betterpunching.setup.EventHandler;
import darkorg.betterpunching.setup.RegistryHandler;
import darkorg.betterpunching.tools.ModTools;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;

@Mod("betterpunching")
public class BetterPunching {
    public static final String MOD_ID = "betterpunching";

    IEventBus eventBus = MinecraftForge.EVENT_BUS;
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    public BetterPunching() {
        ConfigHandler.init();

        RegistryHandler.init(modEventBus);

        EventHandler.init(eventBus);
        eventBus.register(this);
    }

    public static final CreativeModeTab TAB_BETTER_PUNCHING = new CreativeModeTab("better_punching") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModTools.FLINT_HATCHET.get());
        }
    };
}
