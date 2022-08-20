package darkorg.betterpunching.setup;

import darkorg.betterpunching.effect.ModEffects;
import darkorg.betterpunching.tools.ModTools;
import net.minecraftforge.eventbus.api.IEventBus;

public class RegistryHandler {
    public static void init(IEventBus bus) {
        ModTools.init(bus);
        ModEffects.init(bus);
    }
}
