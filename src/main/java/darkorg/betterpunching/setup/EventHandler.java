package darkorg.betterpunching.setup;

import darkorg.betterpunching.event.PunchCactus;
import darkorg.betterpunching.event.PunchGlass;
import darkorg.betterpunching.event.PunchWood;
import darkorg.betterpunching.event.WrongTool;
import net.minecraftforge.eventbus.api.IEventBus;

public class EventHandler {
    public static void init(IEventBus bus) {
        bus.register(new WrongTool());
        bus.register(new PunchWood());
        bus.register(new PunchGlass());
        bus.register(new PunchCactus());
    }
}
