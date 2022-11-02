package darkorg.betterpunching;

import darkorg.betterpunching.config.ServerConfig;
import darkorg.betterpunching.registry.ModEffects;
import darkorg.betterpunching.registry.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BetterPunching.MOD_ID)
public class BetterPunching {
    public static final String MOD_ID = "betterpunching";

    public IEventBus forgeBus = MinecraftForge.EVENT_BUS;
    public IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

    public BetterPunching() {
        ServerConfig.init();

        ModItems.init(modBus);

        ModEffects.init(modBus);

        forgeBus.register(this);
    }
}
