package darkorg.betterpunching;

import darkorg.betterpunching.config.ModConfig;
import darkorg.betterpunching.registry.ModEffects;
import darkorg.betterpunching.registry.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BetterPunching.MOD_ID)
public class BetterPunching {
    public static final String MOD_ID = "betterpunching";
    public static final Logger LOGGER = LogManager.getLogger();

    public BetterPunching() {
        ModConfig.init();
        ModEffects.init();
        ModItems.init();
        MinecraftForge.EVENT_BUS.register(this);
    }
}
