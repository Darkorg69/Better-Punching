package darkorg.betterpunching.setup;

import darkorg.betterpunching.features.PunchingCactus;
import darkorg.betterpunching.features.PunchingGlass;
import darkorg.betterpunching.features.PunchingWood;
import darkorg.betterpunching.features.WrongTool;
import net.minecraftforge.common.MinecraftForge;

public class Events {
    public static void init() {
        MinecraftForge.EVENT_BUS.register(new WrongTool());
        MinecraftForge.EVENT_BUS.register(new PunchingWood());
        MinecraftForge.EVENT_BUS.register(new PunchingGlass());
        MinecraftForge.EVENT_BUS.register(new PunchingCactus());
    }
}
