package darkorg.betterpunching.data;

import darkorg.betterpunching.BetterPunching;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterPunching.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherDataEvent(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        dataGenerator.addProvider(true, new ModRecipeProvider(dataGenerator));
    }
}
